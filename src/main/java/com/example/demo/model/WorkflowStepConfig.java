// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "workflow_step_config")
// public class WorkflowStepConfig {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     // Many steps belong to one workflow template
//     @ManyToOne
//     @JoinColumn(name = "workflow_template_id", nullable = false)
//     private WorkflowTemplate workflowTemplate;

//     // Step order (L1, L2, L3...)
//     @Column(nullable = false)
//     private Integer stepLevel;

//     // Role that can approve this step
//     @Column(nullable = false)
//     private String approverRole;

//     public WorkflowStepConfig() {}

//     public WorkflowStepConfig(WorkflowTemplate workflowTemplate,
//                               Integer stepLevel,
//                               String approverRole) {
//         this.workflowTemplate = workflowTemplate;
//         this.stepLevel = stepLevel;
//         this.approverRole = approverRole;
//     }

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public WorkflowTemplate getWorkflowTemplate() { return workflowTemplate; }
//     public void setWorkflowTemplate(WorkflowTemplate workflowTemplate) {
//         this.workflowTemplate = workflowTemplate;
//     }

//     public Integer getStepLevel() { return stepLevel; }
//     public void setStepLevel(Integer stepLevel) { this.stepLevel = stepLevel; }

//     public String getApproverRole() { return approverRole; }
//     public void setApproverRole(String approverRole) {
//         this.approverRole = approverRole;
//     }
// }
