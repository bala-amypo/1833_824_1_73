// package com.example.demo.service.impl;

// import com.example.demo.model.Role;
// import com.example.demo.model.User;
// import com.example.demo.repository.RoleRepository;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;
// import org.springframework.stereotype.Service;

// import java.util.Set;

// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;
//     private final RoleRepository roleRepository;

//     public UserServiceImpl(UserRepository userRepository,
//                            RoleRepository roleRepository) {
//         this.userRepository = userRepository;
//         this.roleRepository = roleRepository;
//     }

//     @Override
//     public User registerUser(User user, String roleName) {
//         Role role = roleRepository.findByName(roleName)
//                 .orElseThrow(() -> new RuntimeException("Role not found"));
//         user.getRoles().add(role);
//         return userRepository.save(user);
//     }

//     @Override
//     public User findByUsername(String username) {
//         return userRepository.findByUsername(username);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user, String roleName) {
        // Check if username or email already exists
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already taken");
        }

        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Find role
        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        user.getRoles().add(role);

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
