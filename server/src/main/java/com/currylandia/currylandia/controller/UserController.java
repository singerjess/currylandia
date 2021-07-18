package com.currylandia.currylandia.controller;

import com.currylandia.currylandia.controller.domain.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @PostMapping("/login")
    public UserDTO add(@RequestBody UserDTO userDTO) {
        return userDTO;
    }
}
