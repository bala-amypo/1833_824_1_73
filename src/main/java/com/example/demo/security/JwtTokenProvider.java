// package com.example.demo.security;

// import com.example.demo.model.User;
// import io.jsonwebtoken.*;
// import org.springframework.stereotype.Component;

// import java.util.Date;
// import java.util.stream.Collectors;

// @Component
// public class JwtTokenProvider {

//     private final String jwtSecret = "amypo-secret-key";
//     private final long jwtExpirationMs = 3600000; // 1 hour

//     public String generateToken(User user) {

//         return Jwts.builder()
//                 .setSubject(user.getUsername())
//                 .claim("userId", user.getId())
//                 .claim("email", user.getEmail())
//                 .claim(
//                     "roles",
//                     user.getRoles()
//                         .stream()
//                         .map(Role -> Role.getName())
//                         .collect(Collectors.toList())
//                 )
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
//                 .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                 .compact();
//     }

//     public String getUsernameFromToken(String token) {
//         return parseClaims(token).getSubject();
//     }

   
//     public Long getUserIdFromToken(String token) {
//         Object value = parseClaims(token).get("userId");
//         return value == null ? null : Long.valueOf(value.toString());
//     }

//     public boolean validateToken(String token) {
//         try {
//             parseClaims(token);
//             return true;
//         } catch (JwtException | IllegalArgumentException e) {
//             return false;
//         }
//     }

//     private Claims parseClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(jwtSecret)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }
package com.example.demo.security;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    public String generateToken(User user) {
        Set<String> roles = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        String raw = user.getId() + "|" + user.getEmail() + "|" + String.join(",", roles);
        return Base64.getEncoder().encodeToString(raw.getBytes(StandardCharsets.UTF_8));
    }

    public Long getUserIdFromToken(String token) {
        String decoded = new String(Base64.getDecoder().decode(token), StandardCharsets.UTF_8);
        String[] parts = decoded.split("\\|");
        return Long.parseLong(parts[0]);
    }

    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
