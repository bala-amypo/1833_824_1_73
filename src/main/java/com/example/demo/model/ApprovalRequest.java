package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
public class ApprovalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private Long templated;
    private Long requesterlid;

    private String requestTitle;
    private String requestPayloadJson;
    private String status;
    private Integer currentLevel;
    private LocalDateTime createdAt;

    
    public void setTemplateId(Long templateId) {
        this.templated = templateId;
    }

    // Test expects setRequesterId(long)
    public void setRequesterId(long requesterlid) {
        this.requesterlid = requesterlid;
    }

    // --------------------
    // GETTERS & SETTERS
    // --------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTemplated() {
        return templated;
    }

    public void setTemplated(Long templated) {
        this.templated = templated;
    }

    public Long getRequesterlid() {
        return requesterlid;
    }

    public void setRequesterlid(Long requesterlid) {
        this.requesterlid = requesterlid;
    }

    public String getRequestTitle() {
        return requestTitle;
    }

    public void setRequestTitle(String requestTitle) {
        this.requestTitle = requestTitle;
    }

    public String getRequestPayloadJson() {
        return requestPayloadJson;
    }

    public void setRequestPayloadJson(String requestPayloadJson) {
        this.requestPayloadJson = requestPayloadJson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Integer currentLevel) {
        this.currentLevel = currentLevel;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // --------------------
    // CONSTRUCTORS
    // --------------------
    public ApprovalRequest(
            Long id,
            Long templated,
            Long requesterlid,
            String requestTitle,
            String requestPayloadJson,
            String status,
            Integer currentLevel,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.templated = templated;
        this.requesterlid = requesterlid;
        this.requestTitle = requestTitle;
        this.requestPayloadJson = requestPayloadJson;
        this.status = status;
        this.currentLevel = currentLevel;
        this.createdAt = createdAt;
    }

    public ApprovalRequest() {
        this.status = "PENDING";
    }
}
