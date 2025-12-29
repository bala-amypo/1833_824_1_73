package com.example.demo.dto;

import java.util.List;

public class AuthResponse {

    private String token;
    private String username;
    private List<String> roles;

    public AuthResponse() {
    }

    public AuthResponse(String token, String username, List<String> roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {   // required by controller
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {   // required by controller
        this.roles = roles;
    }
}
