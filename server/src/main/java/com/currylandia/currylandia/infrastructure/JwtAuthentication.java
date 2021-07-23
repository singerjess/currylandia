package com.currylandia.currylandia.infrastructure;

import com.currylandia.currylandia.domain.User;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JwtAuthentication extends AbstractAuthenticationToken {


    private final String credentials;

    public JwtAuthentication(String credentials) {
        super(null);
        this.credentials = credentials;
    }

    @Override
    public String getCredentials() {
        return credentials;
    }

    @Override
    public User getPrincipal() {
        return new User("sample", "sample", "samples");
    }
}
