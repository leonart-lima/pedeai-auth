package com.leonart.pedeaiauth.controller;

import com.leonart.pedeaiauth.api.AuthApi;
import com.leonart.pedeaiauth.dto.LoginRequestDTO;
import org.springframework.http.ResponseEntity;

public class AuthController implements AuthApi {

    @Override
    public ResponseEntity<String> authLoginPost(LoginRequestDTO body) {
        return AuthApi.super.authLoginPost(body);
    }
}
