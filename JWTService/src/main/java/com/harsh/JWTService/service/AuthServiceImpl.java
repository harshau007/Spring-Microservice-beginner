package com.harsh.JWTService.service;

import com.harsh.JWTService.entity.AuthReq;
import com.harsh.JWTService.entity.AuthRes;
import com.harsh.JWTService.entity.UserCred;
import com.harsh.JWTService.repository.JwtRepository;
import jakarta.servlet.http.HttpServletRequest;
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

    public UserCred register(UserCred userCred) {
//        String newPass = passwordEncoder.encode(userCred.getPassword());
//        userCred.setPassword(newPass);
        return jwtRepository.save(userCred);
    }

    public AuthRes generate(AuthReq userCred, HttpServletRequest request) {
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
