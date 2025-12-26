package com.example.demo.security;

public class SecurityConstants {

    // JWT secret key (must be same everywhere)
    public static final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkey12";

    // Token validity: 1 day
    public static final long EXPIRATION_TIME =
            24 * 60 * 60 * 1000;

    // Token prefix
    public static final String TOKEN_PREFIX = "Bearer ";

    // Header name
    public static final String HEADER_STRING = "Authorization";

    // Public endpoints (no authentication)
    public static final String LOGIN_URL = "/api/auth/login";
    public static final String REGISTER_URL = "/api/auth/register";

    private SecurityConstants() {
        // prevent object creation
    }
}
