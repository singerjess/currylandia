package com.currylandia.currylandia.service;

import com.currylandia.currylandia.domain.User;
import com.currylandia.currylandia.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
