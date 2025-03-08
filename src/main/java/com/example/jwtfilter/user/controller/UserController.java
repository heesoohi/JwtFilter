package com.example.jwtfilter.user.controller;

import com.example.jwtfilter.auth.annotation.Auth;
import com.example.jwtfilter.auth.dto.AuthUser;
import com.example.jwtfilter.user.dto.UserResponse;
import com.example.jwtfilter.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 로그인 한 유저만 전체 유저 조회 가능한 API
    @GetMapping("/users")
    public List<UserResponse> getUsers(@Auth AuthUser authUser) {
        return userService.findAll();
    }

    // 본인 정보 수정
//    @PutMapping("/users")
//    public void updateUser(@Auth AuthUser authUser, UserUpdateRequest request) {
//        userService.updateUser(authUser, request);
//    }
}
