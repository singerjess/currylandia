package com.currylandia.currylandia.controller.domain;

import javax.validation.constraints.NotBlank;

public class UserDTO {
    private Long id;

    @NotBlank(message = "Mail is mandatory")
    private final String mail;

    @NotBlank(message = "Password is mandatory")
    private final String password;
    public UserDTO(Long id, String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }
}
