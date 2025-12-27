package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by username
    User findByUsername(String username);

    // Check if username already exists
    boolean existsByUsername(String username);
}
