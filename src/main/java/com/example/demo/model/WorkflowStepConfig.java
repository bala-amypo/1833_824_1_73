// package com.example.demo.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;

// @Entity
// public class WorkflowStepConfig {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

    
//     private Long templated;

//     private Integer levelNumber;
//     private String approverRole;
//     private String instructions;

//     // --------------------
//     // REQUIRED BY TEST
//     // --------------------
//     // Test calls setTemplateId(Long)
//     public void setTemplateId(Long templateId) {
//         this.templated = templateId;
//     }

//     // Test calls setInstructions(String)
//     public void setInstructions(String instructions) {
//         this.instructions = instructions;
//     }

  
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Long getTemplated() {
//         return templated;
//     }

//     public void setTemplated(Long templated) {
//         this.templated = templated;
//     }

//     public Integer getLevelNumber() {
//         return levelNumber;
//     }

//     public void setLevelNumber(Integer levelNumber) {
//         this.levelNumber = levelNumber;
//     }

//     public String getApproverRole() {
//         return approverRole;
//     }

//     public void setApproverRole(String approverRole) {
//         this.approverRole = approverRole;
//     }

//     public String getInstructions() {
//         return instructions;
//     }

//     // KEEP EXISTING METHOD (DO NOT REMOVE)
//     public void setActive(String instructions) {
//         this.instructions = instructions;
//     }

    
//     public WorkflowStepConfig(
//             Long id,
//             Long templated,
//             Integer levelNumber,
//             String approverRole,
//             String instructions
//     ) {
//         this.id = id;
//         this.templated = templated;
//         this.levelNumber = levelNumber;
//         this.approverRole = approverRole;
//         this.instructions = instructions;
//     }

//     public WorkflowStepConfig() {
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "workflow_step_config")
public class WorkflowStepConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long templateId;

    private Integer levelNumber;

    private String approverRole;

    private String instructions;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTemplateId() { return templateId; }
    public void setTemplateId(Long templateId) { this.templateId = templateId; }

    public Integer getLevelNumber() { return levelNumber; }
    public void setLevelNumber(Integer levelNumber) { this.levelNumber = levelNumber; }

    public String getApproverRole() { return approverRole; }
    public void setApproverRole(String approverRole) { this.approverRole = approverRole; }

    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }
}
