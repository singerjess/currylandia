package com.currylandia.currylandia.controller;

import com.currylandia.currylandia.controller.domain.UserAuthenticationDTO;
import com.currylandia.currylandia.controller.domain.UserDTO;
import com.currylandia.currylandia.mapper.UserMapper;
import com.currylandia.currylandia.service.SessionsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.Duration;
import java.util.stream.Stream;

@RestController
public class SessionController {


    public static final String CURRYLANDIA_ACCESS_TOKEN_COOKIE = "currylandia.access_token";
    private final SessionsService sessionsService;
    private final UserMapper userMapper;

    public SessionController(SessionsService sessionsService, UserMapper userMapper) {
        this.sessionsService = sessionsService;
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthenticationDTO> login(@Valid @RequestBody UserDTO user) {
        String accessToken = sessionsService.authenticate(user.getMail(), user.getPassword());
        UserAuthenticationDTO userAuthenticationDTO = new UserAuthenticationDTO(user, accessToken);

        String authCookie = ResponseCookie.from(CURRYLANDIA_ACCESS_TOKEN_COOKIE, accessToken)
                .httpOnly(true)
                .maxAge(Duration.ofMinutes(40))
                .build().toString();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, authCookie)
                .body(userAuthenticationDTO);
    }

    @PostMapping("/register")
    public UserDTO register(@Valid @RequestBody UserDTO newUser) {
        return Stream.of(newUser)
                .map(userMapper::mapToDomain)
                .map(sessionsService::createUser)
                .map(userMapper::mapFromDomain)
                .findFirst().get();
    }
}
