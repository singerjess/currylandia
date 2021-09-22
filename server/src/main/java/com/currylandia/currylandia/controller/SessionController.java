package com.currylandia.currylandia.controller;

import com.currylandia.currylandia.controller.domain.UserAuthenticationDTO;
import com.currylandia.currylandia.controller.domain.UserDTO;
import com.currylandia.currylandia.domain.User;
import com.currylandia.currylandia.mapper.UserMapper;
import com.currylandia.currylandia.service.SessionsService;
import com.currylandia.currylandia.service.UserService;
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
    private final SessionsService sessionsService;
    private final UserMapper userMapper;
    private UserService userService;

    public SessionController(SessionsService sessionsService, UserMapper userMapper, UserService userService) {
        this.sessionsService = sessionsService;
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @PostMapping("/session")
    public ResponseEntity<UserAuthenticationDTO> createSession(@Valid @RequestBody UserDTO user) {
        String accessToken = sessionsService.authenticate(user.getMail(), user.getPassword());
        UserDTO userWithMail = userMapper.mapFromDomain(userService.findByMail(user.getMail()).get());
        UserAuthenticationDTO userAuthenticationDTO = new UserAuthenticationDTO(userWithMail, accessToken);

        String authCookie = ResponseCookie.from(CURRYLANDIA_ACCESS_TOKEN_COOKIE, accessToken)
                .httpOnly(true)
                .maxAge(Duration.ofMinutes(40))
                .build().toString();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, authCookie)
                .body(userAuthenticationDTO);
    }
}
