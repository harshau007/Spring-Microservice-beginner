package com.harsh.JWTService.controller;

import com.harsh.JWTService.entity.AuthReq;
import com.harsh.JWTService.entity.AuthRes;
import com.harsh.JWTService.entity.UserCred;
import com.harsh.JWTService.entity.UserRes;
import com.harsh.JWTService.service.AuthServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class JwtController {

    @Autowired
    private AuthServiceImpl authService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public UserCred register(@RequestBody UserCred userCred) {
        return authService.register(userCred);
    }

    @PostMapping("/token") // Change to Validate Token
    public AuthRes getToken(@RequestBody AuthReq userCred, @RequestHeader HttpServletRequest request) {
        if (authService.isValidUser(userCred)) {
            return authService.generate(userCred, request);
        } else {
            throw new RuntimeException("Invalid Token");
        }
    }
}
