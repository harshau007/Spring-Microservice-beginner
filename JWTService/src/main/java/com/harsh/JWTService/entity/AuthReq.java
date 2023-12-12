package com.harsh.JWTService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AuthReq {
    private String email;
    private String password;
    private String name;
}
