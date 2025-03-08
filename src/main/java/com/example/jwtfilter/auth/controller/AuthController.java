package com.example.jwtfilter.auth.controller;

import com.example.jwtfilter.auth.dto.SignupRequest;
import com.example.jwtfilter.auth.dto.SignupResponse;
import com.example.jwtfilter.auth.service.AuthService;
import com.example.jwtfilter.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }
}
