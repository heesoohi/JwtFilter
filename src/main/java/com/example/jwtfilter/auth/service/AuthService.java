package com.example.jwtfilter.auth.service;

import com.example.jwtfilter.auth.dto.SigninRequest;
import com.example.jwtfilter.auth.dto.SigninResponse;
import com.example.jwtfilter.auth.dto.SignupRequest;
import com.example.jwtfilter.auth.dto.SignupResponse;
import com.example.jwtfilter.config.JwtUtil;
import com.example.jwtfilter.user.dto.UserResponse;
import com.example.jwtfilter.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil; // 회원가입할 때 JWT 만들어줘야 하니까..!
    private final UserService userService;

    @Transactional
    public SignupResponse signup(SignupRequest request) {
        UserResponse saveResult = userService.save(request.getEmail());

        // JWT 만들어줌~
        String bearerJwt = jwtUtil.createToken(saveResult.getId(), saveResult.getEmail());
        return new SignupResponse(bearerJwt);
    }

    @Transactional(readOnly = true)
    public SigninResponse signin(SigninRequest request) {
        UserResponse userResult = userService.findByEmail(request.getEmail());

        String bearerJwt = jwtUtil.createToken(userResult.getId(), userResult.getEmail());
        return new SigninResponse(bearerJwt);
    }
}
