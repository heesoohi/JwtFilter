package com.example.jwtfilter.auth.dto;

import lombok.Getter;

@Getter
public class SigninResponse {
    private final String bearerJwt;

    public SigninResponse(String bearerJwt) {
        this.bearerJwt = bearerJwt;
    }
}
