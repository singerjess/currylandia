package com.currylandia.currylandia.infrastructure;

import com.currylandia.currylandia.configuration.security.SessionConfiguration;
import com.currylandia.currylandia.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Component
public class JWTMapper {

    private SessionConfiguration configuration;

    public JWTMapper(SessionConfiguration configuration) {
        this.configuration = configuration;
    }

    public Claims parseAccessToken(String accessToken) {
        return Jwts.parserBuilder()
                .setSigningKey(configuration.getSecretKey().getBytes(StandardCharsets.UTF_8))
                .build()
                .parseClaimsJws(accessToken)
                .getBody();
    }

    public String createAccessToken(User user) {
        Instant now = Instant.now();
        Key key = Keys.hmacShaKeyFor(configuration.getSecretKey().getBytes(StandardCharsets.UTF_8));
        String accessToken = Jwts.builder()
                .setSubject(user.id().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(Duration.ofMinutes(40))))
                .signWith(key)
                .compact();
        return accessToken;
    }
}
