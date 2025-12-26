package com.example.demo.security;

public class JwtTokenProvider {

    public JwtTokenProvider() {
        // Default constructor
    }

    // Dummy method to simulate token generation
    public String generateToken(String username) {
        return "dummy-token-for-" + username;
    }

    // Dummy method to simulate token validation
    public boolean validateToken(String token) {
        return token != null && token.startsWith("dummy-token-for-");
    }

    // Dummy method to simulate getting username from token
    public String getUsernameFromToken(String token) {
        if (validateToken(token)) {
            return token.replace("dummy-token-for-", "");
        }
        return null;
    }
}
