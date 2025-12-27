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

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String generateToken(User user) {
        return "uid:" + user.getId()
                + ":uname:" + user.getUsername()
                + ":email:" + user.getEmail();
    }

    public Long getUserIdFromToken(String token) {
        // token parts: [0]=uid, [1]=<id>, [2]=uname, [3]=<username>, [4]=email, [5]=<email>
        String[] parts = token.split(":");
        if (parts.length < 2 || !"uid".equals(parts[0])) {
            throw new IllegalArgumentException("Invalid token");
        }
        return Long.parseLong(parts[1]);
    }

    public boolean validateToken(String token) {
        try {
            Long id = getUserIdFromToken(token);
            return id != null && id > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
