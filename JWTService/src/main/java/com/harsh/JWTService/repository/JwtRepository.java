package com.harsh.JWTService.repository;

import com.harsh.JWTService.entity.UserCred;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JwtRepository extends JpaRepository<UserCred, Long> {
    Optional<UserCred> findByName(String name);
}
