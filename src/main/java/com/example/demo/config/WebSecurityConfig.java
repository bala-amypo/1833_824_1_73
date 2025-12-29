
// // // package com.example.demo.config;

// // // import com.example.demo.security.JwtAuthenticationFilter;
// // // import org.springframework.context.annotation.Bean;
// // // import org.springframework.context.annotation.Configuration;
// // // import org.springframework.security.authentication.AuthenticationManager;
// // // import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// // // import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// // // import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // // import org.springframework.security.config.http.SessionCreationPolicy;
// // // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // // import org.springframework.security.crypto.password.PasswordEncoder;
// // // import org.springframework.security.web.SecurityFilterChain;
// // // import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// // // @Configuration
// // // @EnableMethodSecurity
// // // public class WebSecurityConfig {

// // //     private final JwtAuthenticationFilter jwtAuthenticationFilter;

// // //     public WebSecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
// // //         this.jwtAuthenticationFilter = jwtAuthenticationFilter;
// // //     }

// // //     @Bean
// // //     public PasswordEncoder passwordEncoder() {
// // //         return new BCryptPasswordEncoder();
// // //     }

   
// // //     @Bean
// // //     public AuthenticationManager authenticationManager(
// // //             AuthenticationConfiguration configuration
// // //     ) throws Exception {
// // //         return configuration.getAuthenticationManager();
// // //     }

  
// // //     @Bean
// // //     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

// // //         http
// // //             .csrf(csrf -> csrf.disable())
// // //             .sessionManagement(session ->
// // //                     session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
// // //             )
// // //             .authorizeHttpRequests(auth -> auth
// // //                     .requestMatchers(
// // //                             "/api/auth/**",
// // //                             "/swagger-ui/**",
// // //                             "/v3/api-docs/**"
// // //                     ).permitAll()
// // //                     .anyRequest().authenticated()
// // //             )
// // //             .addFilterBefore(
// // //                     jwtAuthenticationFilter,
// // //                     UsernamePasswordAuthenticationFilter.class
// // //             );

// // //         return http.build();
// // //     }
// // // }
// // package com.example.demo.config;

// // import com.example.demo.security.JwtAuthenticationFilter;
// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;
// // import org.springframework.security.authentication.AuthenticationManager;
// // import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// // import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// // import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // import org.springframework.security.config.http.SessionCreationPolicy;
// // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // import org.springframework.security.crypto.password.PasswordEncoder;
// // import org.springframework.security.web.SecurityFilterChain;
// // import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// // @Configuration
// // @EnableMethodSecurity
// // public class WebSecurityConfig {

// //     private final JwtAuthenticationFilter jwtAuthenticationFilter;

// //     public WebSecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
// //         this.jwtAuthenticationFilter = jwtAuthenticationFilter;
// //     }

// //     @Bean
// //     public PasswordEncoder passwordEncoder() {
// //         return new BCryptPasswordEncoder();
// //     }

// //     @Bean
// //     public AuthenticationManager authenticationManager(
// //             AuthenticationConfiguration configuration
// //     ) throws Exception {
// //         return configuration.getAuthenticationManager();
// //     }

// //     @Bean
// //     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

// //         http
// //             .csrf(csrf -> csrf.disable())  // disable CSRF for API requests (Postman/Swagger)
// //             .sessionManagement(session ->
// //                     session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
// //             )
// //             .authorizeHttpRequests(auth -> auth
// //                     .requestMatchers(
// //                             "/api/auth/**",        // allow register/login
// //                             "/swagger-ui/**",
// //                             "/v3/api-docs/**"
// //                     ).permitAll()
// //                     .anyRequest().authenticated()  // protect all other endpoints
// //             )
// //             .addFilterBefore(
// //                     jwtAuthenticationFilter,
// //                     UsernamePasswordAuthenticationFilter.class
// //             );

// //         return http.build();
// //     }
// // }package com.example.demo.config;

// import com.example.demo.security.JwtAuthenticationFilter;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// @EnableMethodSecurity
// public class WebSecurityConfig {

//     private final JwtAuthenticationFilter jwtAuthenticationFilter;

//     public WebSecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
//         this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//     }

//     // 🔐 Password Encoder
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     // 🔐 Authentication Manager
//     @Bean
//     public AuthenticationManager authenticationManager(
//             AuthenticationConfiguration authConfig
//     ) throws Exception {
//         return authConfig.getAuthenticationManager();
//     }

//     // 🔐 Security Filter Chain
//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         http
//                 .csrf(csrf -> csrf.disable())
//                 .sessionManagement(session ->
//                         session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                 )
//                 .authorizeHttpRequests(auth -> auth
//                         .requestMatchers(
//                                 "/auth/**",
//                                 "/swagger-ui/**",
//                                 "/v3/api-docs/**"
//                         ).permitAll()
//                         .anyRequest().authenticated()
//                 );

//         http.addFilterBefore(
//                 jwtAuthenticationFilter,
//                 UsernamePasswordAuthenticationFilter.class
//         );

//         return http.build();
//     }
// }

package com.example.demo.config;

import com.example.demo.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
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

    // 🔐 Password Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 🔐 Authentication Manager (VERSION SAFE)
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManager.class);
    }

    // 🔐 Security Filter Chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/auth/**",
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
