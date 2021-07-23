package com.currylandia.currylandia.mapper;

import com.currylandia.currylandia.controller.domain.UserDTO;
import com.currylandia.currylandia.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToDomain(UserDTO userDTO) {
        return new User(userDTO.getMail(), userDTO.getMail(), userDTO.getPassword()); //TODO: change username
    }

    public UserDTO mapFromDomain(User user) {
        return new UserDTO(user.id(), user.mail(), user.password());
    }
}
