package com.currylandia.currylandia.infrastructure;

import com.currylandia.currylandia.controller.SessionController;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationManager authenticationManager;
    private final AntPathRequestMatcher allowedEndpointMatcher;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, String allowedEndpointMatcher) {
        this.authenticationManager = authenticationManager;
        this.allowedEndpointMatcher = new AntPathRequestMatcher(allowedEndpointMatcher);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String accessToken = null;
        if (hasAccessTokenCookie(request)) {
            accessToken = Arrays.stream(request.getCookies())
                    .filter(cookie -> SessionController.CURRYLANDIA_ACCESS_TOKEN_COOKIE.equals(cookie.getName()))
                    .map(Cookie::getValue)
                    .findFirst()
                    .get();
        } else {
            accessToken = request.getHeader("Authorization").split(" ")[1];
        }

        Authentication authentication = authenticationManager.authenticate(new JwtAuthentication(accessToken));

        if (authentication == null) {
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }


    private boolean hasAccessTokenCookie(HttpServletRequest request) {
        return request.getCookies() != null &&
                Arrays.stream(request.getCookies())
                        .map(Cookie::getName)
                        .anyMatch(SessionController.CURRYLANDIA_ACCESS_TOKEN_COOKIE::equals);
    }

    @Override
    protected boolean shouldNotFilter(@NonNull HttpServletRequest request) throws ServletException {
        return allowedEndpointMatcher.matches(request) || hasNoAuthentication(request);
    }

    private boolean hasNoAuthentication(HttpServletRequest request) {
        return !(hasAccessTokenCookie(request) || hasAuthorizationHeader(request));
    }

    private boolean hasAuthorizationHeader(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        return authorizationHeader != null && authorizationHeader.startsWith("Bearer ");
    }


}
