package com.example.demo.repository;

import com.example.demo.model.ApprovalAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApprovalActionRepository
        extends JpaRepository<ApprovalAction, Long> {

    // REQUIRED BY TEST
    List<ApprovalAction> findByLevelAndAction(int levelNumber, String action);

    @Query("SELECT a FROM ApprovalAction a WHERE a.approverId = :approverId")
    List<ApprovalAction> findByApproverId(Long approverId);
}
