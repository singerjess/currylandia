package com.currylandia.currylandia.controller;

import com.currylandia.currylandia.controller.domain.UserAuthenticationDTO;
import com.currylandia.currylandia.controller.domain.UserDTO;
import com.currylandia.currylandia.mapper.UserMapper;
import com.currylandia.currylandia.service.SessionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SessionControllerTest {

    public static final String MAIL = "pepe@gmail.com";
    public static final String PASSWORD = "secret";
    public static final String TOKEN = "my_token";
    private SessionController sessionController;
    private SessionsService sessionsService;

    @BeforeEach
    public void setUp() {
        sessionsService = mock(SessionsService.class);
        UserMapper userMapper = mock(UserMapper.class);
        sessionController = new SessionController(sessionsService, userMapper, userService);
    }
    @Test
    void loggingWithCorrectCredentialsShouldRetrieveUserAuthenticationDTO() {
        when(sessionsService.authenticate(MAIL, PASSWORD)).thenReturn(TOKEN);
        UserDTO userDTO = new UserDTO(1L, MAIL, "pepe", PASSWORD);
        UserAuthenticationDTO userAuthenticationDTO = new UserAuthenticationDTO(userDTO, TOKEN);

        ResponseEntity<UserAuthenticationDTO> response = sessionController.createSession(userDTO);

        assertEquals(userAuthenticationDTO, response.getBody());
    }
}