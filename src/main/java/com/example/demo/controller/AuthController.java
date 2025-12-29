// // package com.example.demo.controller;

// // import com.example.demo.dto.AuthRequest;
// // import com.example.demo.dto.AuthResponse;
// // import com.example.demo.dto.RegisterRequest;
// // import com.example.demo.model.User;
// // import com.example.demo.security.JwtTokenProvider;
// // import com.example.demo.service.UserService;
// // import org.springframework.security.authentication.AuthenticationManager;
// // import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// // import org.springframework.security.core.Authentication;
// // import org.springframework.security.core.GrantedAuthority;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.List;
// // import java.util.stream.Collectors;

// // @RestController
// // @RequestMapping("/auth")
// // public class AuthController {

// //     private final UserService userService;
// //     private final JwtTokenProvider jwtTokenProvider;
// //     private final AuthenticationManager authenticationManager;

// //     public AuthController(
// //             UserService userService,
// //             JwtTokenProvider jwtTokenProvider,
// //             AuthenticationManager authenticationManager
// //     ) {
// //         this.userService = userService;
// //         this.jwtTokenProvider = jwtTokenProvider;
// //         this.authenticationManager = authenticationManager;
// //     }

// //     @PostMapping("/register")
// //     public User register(@RequestBody RegisterRequest request) {
// //         User user = new User();
// //         user.setUsername(request.getUsername());
// //         user.setEmail(request.getEmail());
// //         user.setPassword(request.getPassword());

// //         return userService.registerUser(user, request.getRole());
// //     }

// //     @PostMapping("/login")
// //     public AuthResponse login(@RequestBody AuthRequest request) {

// //         Authentication authentication = authenticationManager.authenticate(
// //                 new UsernamePasswordAuthenticationToken(
// //                         request.getUsernameOrEmail(),
// //                         request.getPassword()
// //                 )
// //         );

// //         org.springframework.security.core.userdetails.User principal =
// //                 (org.springframework.security.core.userdetails.User) authentication.getPrincipal();

// //         User user = userService.findByUsername(principal.getUsername());

// //         String token = jwtTokenProvider.generateToken(user);

// //         List<String> roles = principal.getAuthorities()
// //                 .stream()
// //                 .map(GrantedAuthority::getAuthority)
// //                 .collect(Collectors.toList());

// //         return new AuthResponse(token, user.getUsername(), roles);
// //     }
// // }
// // package com.example.demo.controller;

// // import com.example.demo.dto.AuthRequest;
// // import com.example.demo.dto.RegisterRequest;
// // import com.example.demo.model.User;
// // import com.example.demo.security.JwtTokenProvider;
// // import com.example.demo.service.UserService;
// // import io.swagger.v3.oas.annotations.Operation;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.security.authentication.AuthenticationManager;
// // import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// // import org.springframework.security.core.AuthenticationException;
// // import org.springframework.security.crypto.password.PasswordEncoder;
// // import org.springframework.web.bind.annotation.*;

// // @RestController
// // @RequestMapping("/auth")
// // public class AuthController {

// //     private final AuthenticationManager authenticationManager;
// //     private final JwtTokenProvider jwtTokenProvider;
// //     private final UserService userService;
// //     private final PasswordEncoder passwordEncoder;

// //     public AuthController(AuthenticationManager authenticationManager,
// //                           JwtTokenProvider jwtTokenProvider,
// //                           UserService userService,
// //                           PasswordEncoder passwordEncoder) {
// //         this.authenticationManager = authenticationManager;
// //         this.jwtTokenProvider = jwtTokenProvider;
// //         this.userService = userService;
// //         this.passwordEncoder = passwordEncoder;
// //     }

// //     @Operation(summary = "Register user", security = {}) // No token required
// //     @PostMapping("/register")
// //     public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
// //         // Convert DTO to User entity
// //         User user = new User();
// //         user.setUsername(request.getUsername());
// //         user.setPassword(passwordEncoder.encode(request.getPassword()));
// //         // Set other fields if needed

// //         // Call UserService (pass role if required)
// //         userService.registerUser(user, request.getRole()); 

// //         return ResponseEntity.ok("User registered successfully");
// //     }

// //     @Operation(summary = "Login user", security = {}) // No token required
// //     @PostMapping("/login")
// //     public ResponseEntity<String> login(@RequestBody AuthRequest request) {
// //         try {
// //             // Authenticate user
// //             authenticationManager.authenticate(
// //                     new UsernamePasswordAuthenticationToken(
// //                             request.getUsername(),
// //                             request.getPassword()
// //                     )
// //             );

// //             // Load user from DB and generate JWT
// //             User user = userService.findByUsername(request.getUsername());
// //             String token = jwtTokenProvider.generateToken(user);

// //             return ResponseEntity.ok(token);
// //         } catch (AuthenticationException e) {
// //             return ResponseEntity.status(401).body("Invalid username/password");
// //         }
// //     }
// // }
// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.model.User;
// import com.example.demo.security.JwtTokenProvider;
// import com.example.demo.service.UserService;
// import io.swagger.v3.oas.annotations.Operation;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final AuthenticationManager authenticationManager;
//     private final JwtTokenProvider jwtTokenProvider;
//     private final UserService userService;
//     private final PasswordEncoder passwordEncoder;

//     public AuthController(AuthenticationManager authenticationManager,
//                           JwtTokenProvider jwtTokenProvider,
//                           UserService userService,
//                           PasswordEncoder passwordEncoder) {
//         this.authenticationManager = authenticationManager;
//         this.jwtTokenProvider = jwtTokenProvider;
//         this.userService = userService;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @Operation(summary = "Register user", security = {}) // No token required
//     @PostMapping("/register")
//     public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
//         // Convert DTO to User entity
//         User user = new User();
//         user.setUsername(request.getUsername());
//         user.setEmail(request.getEmail()); // ⚡ Must set email
//         user.setPassword(passwordEncoder.encode(request.getPassword()));
//         // set other fields if needed

//         // Call UserService (pass role)
//         userService.registerUser(user, request.getRole());

//         return ResponseEntity.ok("User registered successfully");
//     }

//     @Operation(summary = "Login user", security = {}) // No token required
//     @PostMapping("/login")
//     public ResponseEntity<String> login(@RequestBody AuthRequest request) {
//         try {
//             // Authenticate user
//             authenticationManager.authenticate(
//                     new UsernamePasswordAuthenticationToken(
//                             request.getUsername(),
//                             request.getPassword()
//                     )
//             );

//             // Load user and generate JWT
//             User user = userService.findByUsername(request.getUsername());
//             String token = jwtTokenProvider.generateToken(user);

//             return ResponseEntity.ok(token);
//         } catch (AuthenticationException e) {
//             return ResponseEntity.status(401).body("Invalid username/password");
//         }
//     }
// }
// File: java/com/example/demo/controller/JAuthController.java
package com.example.demo.controller;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class JAuthController {

    @Autowired
    private UserService userService; // Use the new service

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        try {
            User registeredUser = userService.registerNewUser(
                registerRequest.getUsername(),
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                registerRequest.getRole() != null ? registerRequest.getRole() : "user" // Default to 'user' role if not specified
            );
            return ResponseEntity.ok("User registered successfully with ID: " + registeredUser.getId());
        } catch (RuntimeException e) {
            // Catches "Role not found" or "User exists" exceptions from the service
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    // Other login/auth methods...
}
