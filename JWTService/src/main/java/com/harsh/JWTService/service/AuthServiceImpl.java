package com.harsh.JWTService.service;

import com.harsh.JWTService.entity.AuthReq;
import com.harsh.JWTService.entity.AuthRes;
import com.harsh.JWTService.entity.UserCred;
import com.harsh.JWTService.entity.UserRes;
import com.harsh.JWTService.repository.JwtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    @Autowired
    private JwtRepository jwtRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtilImpl jwtUtil;

    public UserRes register(UserCred userCred) {
        AuthReq authReq = AuthReq.builder()
                .password(userCred.getPassword())
                .name(userCred.getName())
                .email(userCred.getEmail())
                .build();
        AuthRes authRes = generate(authReq);

        UserRes userRes = UserRes.builder()
                .id(userCred.getId())
                .role(userCred.getRole())
                .name(userCred.getName())
                .email(userCred.getEmail())
                .accessToken(authRes.getAccessToken())
                .refreshToken(authRes.getRefreshToken())
                .build();

        userCred.setPassword(passwordEncoder.encode(userCred.getPassword()));

        jwtRepository.save(userCred);
        return userRes;
    }

    public AuthRes generate(AuthReq userCred) {
        UserCred regUser = jwtRepository.findByName(userCred.getName()).get();

        String accessToken = jwtUtil.generate(regUser.getId(), regUser.getRole(), "ACCESS");
        String refreshToken = jwtUtil.generate(regUser.getId(), regUser.getRole(), "REFRESH");

        return new AuthRes(accessToken, refreshToken);
    }

    public boolean isValidUser(AuthReq authReq) {
        UserCred user = jwtRepository.findByName(authReq.getName()).get();
        boolean isValidUsername = authReq.getName().matches(user.getName());
        boolean isValidPassword = authReq.getPassword().matches(user.getPassword());
        return isValidUsername && isValidPassword;
    }
}
