

// package com.example.demo.service;

// import com.example.demo.model.Role;
// import com.example.demo.model.User;
// import com.example.demo.repository.RoleRepository;
// import com.example.demo.repository.UserRepository;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;
//     private final RoleRepository roleRepository;
//     private final PasswordEncoder passwordEncoder;

//     public UserServiceImpl(
//             UserRepository userRepository,
//             RoleRepository roleRepository,
//             PasswordEncoder passwordEncoder
//     ) {
//         this.userRepository = userRepository;
//         this.roleRepository = roleRepository;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @Override
//     public User registerUser(User user, String roleName) {

//         Role role = roleRepository.findByName(roleName)
//                 .orElseGet(() -> {
//                     Role r = new Role();
//                     r.setName(roleName);
//                     return roleRepository.save(r);
//                 });

//         user.setPassword(passwordEncoder.encode(user.getPassword()));
//         user.getRoles().add(role);

//         return userRepository.save(user);
//     }

//     @Override
//     public User findByUsername(String username) {
//         return userRepository.findByUsername(username).orElseThrow();
//     }
// }
package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ REQUIRED BY TESTS
    @Override
    public User registerUser(User user, String roleName) {

        if (user.getRoles() == null) {
            user.setRoles(new HashSet<>());
        }

        // ✅ Default role fallback
        String finalRole = (roleName == null || roleName.isBlank())
                ? "ROLE_USER"
                : roleName;

        // ✅ Ensure role exists BEFORE assigning
        Role role = roleRepository.findByName(finalRole)
                .orElseGet(() -> {
                    Role r = new Role();
                    r.setName(finalRole);
                    return roleRepository.save(r);
                });

        // ✅ Encode password once
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // ✅ Assign role
        user.getRoles().add(role);

        return userRepository.save(user);
    }

    // ✅ DO NOT THROW NoSuchElementException
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
