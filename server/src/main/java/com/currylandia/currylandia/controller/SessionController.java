package com.currylandia.currylandia.controller;

import com.currylandia.currylandia.controller.domain.UserAuthenticationDTO;
import com.currylandia.currylandia.controller.domain.UserDTO;
import com.currylandia.currylandia.service.SessionsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.Duration;

@RestController
public class SessionController {


    public static final String CURRYLANDIA_ACCESS_TOKEN_COOKIE = "currylandia.access_token";
    private SessionsService sessionsService;

    public SessionController(SessionsService sessionsService) {
        this.sessionsService = sessionsService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthenticationDTO> login(@Valid @RequestBody UserDTO userDTO) {
        String accessToken = sessionsService.authenticate(userDTO.getMail(), userDTO.getPassword());
        UserAuthenticationDTO userAuthenticationDTO = new UserAuthenticationDTO(userDTO, accessToken);

        String authCookie = ResponseCookie.from(CURRYLANDIA_ACCESS_TOKEN_COOKIE, accessToken)
                .httpOnly(true)
                .maxAge(Duration.ofMinutes(40))
                .build().toString();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, authCookie)
                .body(userAuthenticationDTO);
    }

    @PostMapping("/register")
    public UserDTO register(@RequestBody UserDTO userDTO) {
        return userDTO;
    }
}
