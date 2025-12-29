// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "audit_log_records")
// public class AuditLogRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long requestId;

//     private String eventType;

//     private String details;

//     private LocalDateTime loggedAt = LocalDateTime.now();

//     public AuditLogRecord() {}

//     public Long getId() {
//         return id;
//     }

//     public Long getRequestId() {
//         return requestId;
//     }

//     public void setRequestId(Long requestId) {
//         this.requestId = requestId;
//     }

//     public String getEventType() {
//         return eventType;
//     }

//     public void setEventType(String eventType) {
//         this.eventType = eventType;
//     }

//     public String getDetails() {
//         return details;
//     }

//     public void setDetails(String details) {
//         this.details = details;
//     }

//     public LocalDateTime getLoggedAt() {
//         return loggedAt;
//     }

   
//     public void setLoggedAt(LocalDateTime loggedAt) {
//         this.loggedAt = loggedAt;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AuditLogRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // fields inferred from tests
    private Long requestId;

    private String eventType;

    private String details;

    private Long userId;

    private String action;

    private LocalDateTime createdAt;

    public AuditLogRecord() {
    }

    public AuditLogRecord(Long userId, String action) {
        this.userId = userId;
        this.action = action;
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
