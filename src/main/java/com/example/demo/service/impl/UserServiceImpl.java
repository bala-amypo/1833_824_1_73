
// // package com.example.demo.service.impl;

// // import com.example.demo.model.Role;
// // import com.example.demo.model.User;
// // import com.example.demo.repository.RoleRepository;
// // import com.example.demo.repository.UserRepository;
// // import com.example.demo.service.UserService;
// // import org.springframework.security.crypto.password.PasswordEncoder;
// // import org.springframework.stereotype.Service;

// // @Service
// // public class UserServiceImpl implements UserService {

// //     private final UserRepository userRepository;
// //     private final RoleRepository roleRepository;
// //     private final PasswordEncoder passwordEncoder;

// //     public UserServiceImpl(
// //             UserRepository userRepository,
// //             RoleRepository roleRepository,
// //             PasswordEncoder passwordEncoder
// //     ) {
// //         this.userRepository = userRepository;
// //         this.roleRepository = roleRepository;
// //         this.passwordEncoder = passwordEncoder;
// //     }

// //     @Override
// //     public User registerUser(User user, String roleName) {

      
// //         user.setPassword(passwordEncoder.encode(user.getPassword()));

        
// //         Role role = roleRepository.findByName(roleName)
// //                 .orElseGet(() -> {
// //                     Role r = new Role();
// //                     r.setName(roleName);
// //                     return roleRepository.save(r);
// //                 });

// //         if (user.getRoles() == null) {
// //             user.setRoles(new java.util.HashSet<>());
// //         }

// //         user.getRoles().add(role);

// //         return userRepository.save(user);
// //     }

// //     @Override
// //     public User findByUsername(String username) {
// //         return userRepository.findByUsername(username)
// //                 .orElseThrow(() -> new RuntimeException("User not found: " + username));
// //     }
// // }
// package com.example.demo.service;

// import com.example.demo.model.User;

// public interface UserService {
//     User registerUser(User user, String roleName);
//     User findByUsername(String username);
// }
package com.example.demo.service.impl;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        Role role = roleRepository.findByName(roleName)
                .orElseGet(() -> {
                    Role r = new Role();
                    r.setName(roleName);
                    return roleRepository.save(r);
                });

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        boolean alreadyHasRole = user.getRoles().stream()
                .anyMatch(r -> r.getName().equals(role.getName()));
        if (!alreadyHasRole) {
            user.getRoles().add(role);
        }

        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }
}
