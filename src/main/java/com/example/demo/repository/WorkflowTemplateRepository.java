// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.WorkflowTemplate;

// public interface WorkflowTemplateRepository extends JpaRepository<WorkflowTemplate, Long> {
// }
package com.example.demo.repository;

import com.example.demo.model.WorkflowTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkflowTemplateRepository extends JpaRepository<WorkflowTemplate, Long> {
}
