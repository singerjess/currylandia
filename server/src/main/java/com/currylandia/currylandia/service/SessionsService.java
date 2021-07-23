package com.currylandia.currylandia.service;

import com.currylandia.currylandia.domain.User;
import com.currylandia.currylandia.infrastructure.JWTMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SessionsService {

    private  UserService userService;
    private  PasswordEncoder passwordEncoder;
    private JWTMapper jwtMapper;

    SessionsService(UserService userService, PasswordEncoder passwordEncoder, JWTMapper jwtMapper) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtMapper = jwtMapper;
    }

    @Transactional
    public String authenticate(String mail, String password) {
        User user = userService.findByMail(mail)
                .orElseThrow(() -> new UsernameNotFoundException("Mail not found"));

        if (!passwordEncoder.matches(password, user.password())) {
            throw new BadCredentialsException("Wrong password");
        }

        return jwtMapper.createAccessToken(user);
    }

    @Transactional
    public User createUser(User newUser) {
        if (userService.existsByMail(newUser.mail())) {
            throw new RuntimeException("Username already exists");
        }

        return userService.save(newUser);
    }
}
