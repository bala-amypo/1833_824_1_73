package com.example.demo.repository;

import com.example.demo.model.ApprovalAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovalActionRepository extends JpaRepository<ApprovalAction, Long> {

    // Use the correct field name from the entity: levelNumber
    List<ApprovalAction> findByLevelNumberAndAction(Integer levelNumber, String action);

}
