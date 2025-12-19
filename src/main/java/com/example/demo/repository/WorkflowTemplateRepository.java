package com.example.demo.repository;

import com.example.demo.entity.WorkflowTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkflowTemplateRepository
        extends JpaRepository<WorkflowTemplate, Long> {

    boolean existsByName(String name);
}
