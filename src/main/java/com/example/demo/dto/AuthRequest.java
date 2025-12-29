// // package com.example.demo.dto;

// // public class AuthRequest {
// //     private String username; // must match your login JSON field
// //     private String password;

// //     // Getters and setters
// //     public String getUsername() { return username; }
// //     public void setUsername(String username) { this.username = username; }

// //     public String getPassword() { return password; }
// //     public void setPassword(String password) { this.password = password; }
// // }
// package com.example.demo.dto;

// public class AuthRequest {
//     private String username;
//     private String password;

//     // Getters and setters
//     public String getUsername() { return username; }
//     public void setUsername(String username) { this.username = username; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }
// }
package com.example.demo.dto;

public class AuthRequest {

    private String username;
    private String password;

    // ✅ EXISTING
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // ✅ ADD THIS (to satisfy test)
    public void setUsernameOrEmail(String usernameOrEmail) {
        this.username = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
