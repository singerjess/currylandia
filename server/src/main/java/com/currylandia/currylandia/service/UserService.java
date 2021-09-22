package com.currylandia.currylandia.service;

import com.currylandia.currylandia.domain.User;
import com.currylandia.currylandia.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return null;
    }

    @Transactional(readOnly = true)
    public Optional<User> findByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Transactional(readOnly = true)
    public boolean existsByMail(String mail) {
        return findByMail(mail).isPresent();
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    @Transactional
    public User createUser(User newUser) {
        if (existsByMail(newUser.mail())) {
            throw new RuntimeException("Username already exists");
        }
        User userWithEncodedPassword = new User(newUser.username(), passwordEncoder.encode(newUser.password()), newUser.mail());
        return save(userWithEncodedPassword);
    }
}
