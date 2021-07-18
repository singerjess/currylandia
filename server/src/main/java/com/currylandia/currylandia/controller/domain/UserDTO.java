package com.currylandia.currylandia.controller.domain;

import javax.validation.constraints.NotBlank;

public class UserDTO {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private final String username;

    @NotBlank(message = "Description is mandatory")
    private final String password;
    public UserDTO(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
