package com.currylandia.currylandia.controller;

import com.currylandia.currylandia.controller.domain.UserDTO;
import com.currylandia.currylandia.mapper.UserMapper;
import com.currylandia.currylandia.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Stream;

@RestController
public class UserController {


    private UserMapper userMapper;
    private UserService userService;

    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @PostMapping("/user")
    public UserDTO createUser(@Valid @RequestBody UserDTO newUser) {
        return Stream.of(newUser)
                .map(userMapper::mapToDomain)
                .map(userService::createUser)
                .map(userMapper::mapFromDomain)
                .findFirst().get();
    }
}
