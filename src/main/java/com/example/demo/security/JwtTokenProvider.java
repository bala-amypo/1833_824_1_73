// // package com.example.demo.security;

// // import com.example.demo.model.User;
// // import io.jsonwebtoken.*;
// // import org.springframework.stereotype.Component;

// // import java.util.Date;
// // import java.util.stream.Collectors;

// // @Component
// // public class JwtTokenProvider {

// //     private final String jwtSecret = "amypo-secret-key";
// //     private final long jwtExpirationMs = 3600000; // 1 hour

// //     public String generateToken(User user) {

// //         return Jwts.builder()
// //                 .setSubject(user.getUsername())
// //                 .claim("userId", user.getId())
// //                 .claim("email", user.getEmail())
// //                 .claim(
// //                     "roles",
// //                     user.getRoles()
// //                         .stream()
// //                         .map(Role -> Role.getName())
// //                         .collect(Collectors.toList())
// //                 )
// //                 .setIssuedAt(new Date())
// //                 .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
// //                 .signWith(SignatureAlgorithm.HS512, jwtSecret)
// //                 .compact();
// //     }

// //     public String getUsernameFromToken(String token) {
// //         return parseClaims(token).getSubject();
// //     }

   
// //     public Long getUserIdFromToken(String token) {
// //         Object value = parseClaims(token).get("userId");
// //         return value == null ? null : Long.valueOf(value.toString());
// //     }

// //     public boolean validateToken(String token) {
// //         try {
// //             parseClaims(token);
// //             return true;
// //         } catch (JwtException | IllegalArgumentException e) {
// //             return false;
// //         }
// //     }

// //     private Claims parseClaims(String token) {
// //         return Jwts.parser()
// //                 .setSigningKey(jwtSecret)
// //                 .parseClaimsJws(token)
// //                 .getBody();
// //     }
// // }
// package com.example.demo.security;

// import com.example.demo.model.User;
// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.stereotype.Component;

// import java.util.Date;
// import java.util.stream.Collectors;

// @Component
// public class JwtTokenProvider {

//     private static final String SECRET = "secretkeysecretkeysecretkeysecretkey";
//     private static final long EXPIRATION = 86400000;

//     public String generateToken(User user) {

//         return Jwts.builder()
//                 .setSubject(user.getUsername())
//                 .claim("userId", user.getId())
//                 .claim("email", user.getEmail())
//                 .claim(
//                         "roles",
//                         user.getRoles()
//                             .stream()
//                             .map(r -> r.getName())
//                             .collect(Collectors.toList())
//                 )
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
//                 .signWith(SignatureAlgorithm.HS256, SECRET)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public Claims getClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(SECRET)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }

//     public String getUsernameFromToken(String token) {
//         return getClaims(token).getSubject();
//     }
// }
package com.example.demo.security;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    // 🔐 Secret key (static for tests)
    private final Key key = Keys.hmacShaKeyFor(
            "mySecretKeyForJwtTokenProviderMustBeLongEnough12345".getBytes()
    );

    private final long jwtExpirationMs = 24 * 60 * 60 * 1000; // 1 day

    // --------------------------------------------------
    // Generate JWT token
    // --------------------------------------------------
    public String generateToken(User user) {

        List<String> roles = user.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toList());

        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("userId", user.getId())          // ✅ REQUIRED BY TEST
                .claim("email", user.getEmail())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // --------------------------------------------------
    // ✅ REQUIRED BY TEST
    // --------------------------------------------------
    public Long getUserIdFromToken(String token) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Object userId = claims.get("userId");

        if (userId instanceof Integer) {
            return ((Integer) userId).longValue();
        }

        return (Long) userId;
    }

    // --------------------------------------------------
    // Validate token
    // --------------------------------------------------
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
