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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAuthenticationDTO that = (UserAuthenticationDTO) o;

        if (userDTO != null ? !userDTO.equals(that.userDTO) : that.userDTO != null) return false;
        return accessToken != null ? accessToken.equals(that.accessToken) : that.accessToken == null;
    }

    @Override
    public int hashCode() {
        int result = userDTO != null ? userDTO.hashCode() : 0;
        result = 31 * result + (accessToken != null ? accessToken.hashCode() : 0);
        return result;
    }
}
