package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.model. UserService;

@Service
public interface UserService {
   User registerUser(User user,String roleName);
   User findByUsername(String username);
    
}




