package com.example.demo.security;

public class SecurityConstants {
    public static final String JWT_SECRET = "change-me-very-long-secret-key-change-me";
    public static final long JWT_EXPIRATION_MS = 86400000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
