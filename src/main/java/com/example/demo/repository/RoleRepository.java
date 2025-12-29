// // package com.example.demo.repository;

// // import org.springframework.data.jpa.repository.JpaRepository;
// // import com.example.demo.model.Role;
// // import java.util.Optional;

// // public interface RoleRepository extends JpaRepository<Role, Long> {

// //     Optional<Role> findByName(String name);
// // }
// package com.example.demo.repository;

// import com.example.demo.model.Role;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.Optional;

// public interface RoleRepository extends JpaRepository<Role, Long> {
//     Optional<Role> findByName(String name);
// }
package com.example.demo.repository;

import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
