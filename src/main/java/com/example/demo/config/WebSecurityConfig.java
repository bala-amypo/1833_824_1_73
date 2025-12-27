// // package com.example.demo.config;

// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;
// // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // import org.springframework.security.crypto.password.PasswordEncoder;

// // @Configuration
// // public class SecurityConfig {

// //     @Bean
// //     public PasswordEncoder passwordEncoder() {
// //         return new BCryptPasswordEncoder();
// //     }
// // }
// package com.example.demo.config;

// import com.example.demo.security.CustomUserDetailsService;
// import com.example.demo.security.JwtAuthenticationFilter;
// import com.example.demo.security.JwtTokenProvider;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// @Configuration
// public class WebSecurityConfig {

//     private final JwtTokenProvider jwtTokenProvider;
//     private final CustomUserDetailsService userDetailsService;

//     public WebSecurityConfig(
//             JwtTokenProvider jwtTokenProvider,
//             CustomUserDetailsService userDetailsService
//     ) {
//         this.jwtTokenProvider = jwtTokenProvider;
//         this.userDetailsService = userDetailsService;
//     }

//     @Bean
//     public JwtAuthenticationFilter jwtAuthenticationFilter() {
//         return new JwtAuthenticationFilter(jwtTokenProvider, userDetailsService);
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//         http.csrf(csrf -> csrf.disable())
//             .sessionManagement(session ->
//                 session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/auth/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
//                 .requestMatchers("/api/**").authenticated()
//                 .anyRequest().permitAll()
//             );

//         http.addFilterBefore(
//                 jwtAuthenticationFilter(),
//                 UsernamePasswordAuthenticationFilter.class
//         );

//         return http.build();
//     }

//     @Bean
//     public AuthenticationManager authenticationManager(
//             AuthenticationConfiguration configuration
//     ) throws Exception {
//         return configuration.getAuthenticationManager();
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }
package com.example.demo.config;

import com.example.demo.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public WebSecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    // ✅ Password encoder (used in tests)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // ✅ Authentication manager
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration
    ) throws Exception {
        return configuration.getAuthenticationManager();
    }

    // ✅ Security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers(
                            "/api/auth/**",
                            "/swagger-ui/**",
                            "/v3/api-docs/**"
                    ).permitAll()
                    .anyRequest().authenticated()
            )
            .addFilterBefore(
                    jwtAuthenticationFilter,
                    UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }
}
