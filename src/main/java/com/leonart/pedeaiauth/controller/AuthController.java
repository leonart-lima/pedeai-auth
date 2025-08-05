package com.leonart.pedeaiauth.controller;

import com.leonart.pedeaiauth.api.AuthApi;
import com.leonart.pedeaiauth.dto.LoginRequestDTO;
import com.leonart.pedeaiauth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {

    @Autowired
    AuthService authService;

    @Override
    public ResponseEntity<String> authLoginPost(LoginRequestDTO body) {
        return ResponseEntity.ok(authService.authenticate(body.getUsername(), body.getPassword()));
    }
}
