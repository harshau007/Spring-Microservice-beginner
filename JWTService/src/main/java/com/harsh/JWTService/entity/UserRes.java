package com.harsh.JWTService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRes {
    private Long id;
    private String name;
    private String email;
    private String role;
    private String accessToken;
    private String refreshToken;
}
