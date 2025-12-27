package com.example.demo.security;

public class SecurityConstants {

    
    public static final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkey12";

    
    public static final long EXPIRATION_TIME =
            24 * 60 * 60 * 1000;

    
    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "Authorization";

    
    public static final String LOGIN_URL = "/api/auth/login";
    public static final String REGISTER_URL = "/api/auth/register";

    private SecurityConstants() {
       
    }
}
