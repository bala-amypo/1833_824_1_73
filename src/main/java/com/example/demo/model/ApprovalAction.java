package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class ApprovalAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long requested;
    private Long approverId;
    private Integer levelNumber;
    private String action;
    private String comments;
    private LocalDateTime actionDate;

    public ApprovalAction() {}

    public ApprovalAction(Long id, Long requested, Long approverId,
                          Integer levelNumber, String action,
                          String comments, LocalDateTime actionDate) {
        this.id = id;
        this.requested = requested;
        this.approverId = approverId;
        this.levelNumber = levelNumber;
        this.action = action;
        this.comments = comments;
        this.actionDate = actionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRequested() {
        return requested;
    }

    public void setRequested(Long requested) {
        this.requested = requested;
    }

    public Long getApproverId() {
        return approverId;
    }

    public void setApproverId(Long approverId) {
        this.approverId = approverId;
    }

    public Integer getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(Integer levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDateTime actionDate) {
        this.actionDate = actionDate;
    }
}
