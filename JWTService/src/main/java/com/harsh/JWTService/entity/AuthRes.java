package com.harsh.JWTService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AuthRes {
    private String accessToken;
    private String refreshToken;

    public AuthRes(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
