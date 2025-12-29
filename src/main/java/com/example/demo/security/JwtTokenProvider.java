package com.example.demo.security;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    public String generateToken(User user) {
        Set<String> roles = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        String raw = user.getId() + "|" + user.getEmail() + "|" + String.join(",", roles);
        return Base64.getEncoder().encodeToString(raw.getBytes(StandardCharsets.UTF_8));
    }

    public Long getUserIdFromToken(String token) {
        String decoded = new String(Base64.getDecoder().decode(token), StandardCharsets.UTF_8);
        String[] parts = decoded.split("\\|");
        return Long.parseLong(parts[0]);
    }

    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
