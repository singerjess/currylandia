package com.currylandia.currylandia.infrastructure;

import com.currylandia.currylandia.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private JWTMapper jwtMapper;

    JwtAuthenticationProvider(JWTMapper jwtMapper) {
        this.jwtMapper = jwtMapper;
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String accessToken = (String) authentication.getCredentials();

        Claims claims = null;

        try {
            claims = jwtMapper.parseAccessToken(accessToken);
        } catch (JwtException e) {
            throw new BadCredentialsException(e.getMessage(), e);
        }

        return new JwtAuthentication(claims.getSubject()); //TODO: quizas deberi buscar el usuario
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthentication.class.isAssignableFrom(authentication);
    }
}
