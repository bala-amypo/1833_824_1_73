// package com.example.demo.security;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.*;
// import org.springframework.stereotype.Service;

// import java.util.stream.Collectors;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     private final UserRepository userRepository;

//     public CustomUserDetailsService(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String usernameOrEmail)
//             throws UsernameNotFoundException {

//         User user = userRepository.findByUsername(usernameOrEmail)
//                 .orElseThrow(() -> new UsernameNotFoundException("User not found"));

//         return new org.springframework.security.core.userdetails.User(
//                 user.getUsername(),
//                 user.getPassword(),
//                 user.getRoles()
//                         .stream()
//                         .map(role -> new SimpleGrantedAuthority(role.getName()))
//                         .collect(Collectors.toSet())
//         );
//     }
// }
package com.example.demo.security;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String idAsString) throws UsernameNotFoundException {
        Long id = Long.parseLong(idAsString);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // map to Spring Security UserDetails
        return org.springframework.security.core.userdetails.User
                .withUsername(String.valueOf(user.getId()))
                .password(user.getPassword())
                .authorities(
                        user.getRoles().stream()
                                .map(r -> "ROLE_" + r.getName())
                                .toArray(String[]::new)
                )
                .accountLocked(false)
                .disabled(false)
                .build();
    }
}
