package com.currylandia.currylandia.infrastructure;

import com.currylandia.currylandia.domain.User;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JwtAuthentication extends AbstractAuthenticationToken {


    private final String credentials;
    private final User user;

    public JwtAuthentication(String credentials) {
        super(null);
        this.credentials = credentials;
        this.user = null;
    }

    public JwtAuthentication(User user) {
        super(null);
        this.credentials = null;
        this.user = user;
        setAuthenticated(true);
    }


    @Override
    public String getCredentials() {
        return credentials;
    }

    @Override
    public User getPrincipal() {
        return null;
    }
}
