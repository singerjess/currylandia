package com.currylandia.currylandia.controller.domain;

import javax.validation.constraints.NotBlank;

public class UserAuthenticationDTO {

    @NotBlank(message = "user is mandatory")
    private final UserDTO userDTO;
    private final String accessToken;

    public UserAuthenticationDTO(UserDTO userDTO, String accessToken) {
        this.userDTO = userDTO;
        this.accessToken = accessToken;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
