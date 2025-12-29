package com.example.demo.security;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    private final String JWT_SECRET = "secret-key-demo";
    private final long JWT_EXPIRATION = 86400000; // 1 day

    // Generate token
    public String generateToken(User user) {

        Set<String> roles = user.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("userId", user.getId())
                .claim("email", user.getEmail())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .compact();
    }

    // Validate token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // Username from token
    public String getUsernameFromToken(String token) {
        return getClaims(token).getSubject();
    }

    // UserId from token
    public Long getUserIdFromToken(String token) {
        return getClaims(token).get("userId", Long.class);
    }

    // Roles from token
    public Set<String> getRolesFromToken(String token) {
        return getClaims(token).get("roles", Set.class);
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
