package com.currylandia.currylandia.configuration.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "security.session")
public class SessionConfiguration {

    private String secretKey;
    private CORSConfiguration corsConfiguration;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public CORSConfiguration getCorsConfiguration() {
        return corsConfiguration;
    }

    public void setCorsConfiguration(CORSConfiguration corsConfiguration) {
        this.corsConfiguration = corsConfiguration;
    }
}