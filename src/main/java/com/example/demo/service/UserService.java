
// package com.example.demo.service;

// import com.example.demo.model.User;

// public interface UserService {

//     User registerUser(User user, String roleName);

//     User findByUsername(String username);
// }
// File: java/com/example/demo/service/UserService.java
package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // Assuming you have a PasswordEncoder bean configured elsewhere
    @Autowired
    private PasswordEncoder passwordEncoder; 

    @Transactional // Ensures both user and role assignments succeed or fail together
    public User registerNewUser(String username, String email, String rawPassword, String roleName) {
        if (userRepository.findByUsername(username).isPresent() || userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Username or Email already exists.");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(rawPassword));

        // Find the role entity in DB
        Role userRole = roleRepository.findByName(roleName)
                                      .orElseThrow(() -> new RuntimeException("Error: Role '" + roleName + "' not found."));

        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);

        // Save the user FIRST. JPA handles the join table insert automatically after this.
        return userRepository.save(user);
    }
}
