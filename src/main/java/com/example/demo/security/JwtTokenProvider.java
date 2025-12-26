package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // You can set this secret in application.properties
    @Value("${jwt.secret}")
    private String secretKey;

    // Token validity in milliseconds (e.g., 1 hour)
    @Value("${jwt.expirationMs}")
    private long validityInMilliseconds;

    private Key key;

    @PostConstruct
    protected void init() {
        // Use the secret key to generate a signing key for HS256
        key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // Generate token for username (you can add claims as needed)
    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Validate token (checks signature and expiration)
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            // Token invalid, expired, or malformed
            return false;
        }
    }

    // Extract username (subject) from token
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                            .setSigningKey(key)
                            .build()
                            .parseClaimsJws(token)
                            .getBody();
        return claims.getSubject();
    }
}
