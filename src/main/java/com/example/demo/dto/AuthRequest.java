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

    // Getter & Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter & Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
