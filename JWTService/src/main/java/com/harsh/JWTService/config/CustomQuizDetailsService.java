package com.harsh.JWTService.config;

import com.harsh.JWTService.entity.UserCred;
import com.harsh.JWTService.repository.JwtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomQuizDetailsService implements UserDetailsService {

    @Autowired
    private JwtRepository jwtRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCred> cred = jwtRepository.findByName(username);
        return cred.map(CustomQuizDetails::new).orElseThrow(()-> new UsernameNotFoundException("User not found with name: " + username));
    }
}
