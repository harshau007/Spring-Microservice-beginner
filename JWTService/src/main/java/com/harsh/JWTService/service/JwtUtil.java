package com.harsh.JWTService.service;

import io.jsonwebtoken.Claims;

import java.util.Date;

public interface JwtUtil {
    Claims getClaims(String token);

    Date getExpirationDate(String token);

    String generate(Long userId, String role, String tokenType);

    private boolean isExpired(String token) {
        return getExpirationDate(token).before(new Date());
    }
}
