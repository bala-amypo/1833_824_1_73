package com.example.demo.security;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    public String generateToken(User user) {
        // simple fake token for testing
        return user.getId() + "|" +
               user.getUsername() + "|" +
               user.getRoles().stream()
                   .map(Role::getName)
                   .collect(Collectors.joining(",")) + "|" +
               new Date().getTime();
    }

    public boolean validateToken(String token) {
        return token != null && token.contains("|");
    }

    public Long getUserIdFromToken(String token) {
        try {
            return Long.parseLong(token.split("\\|")[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
