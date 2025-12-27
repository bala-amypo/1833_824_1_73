// package com.example.demo.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import java.time.LocalDateTime;

// @Entity
// public class AuditLogRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     // KEEP ORIGINAL SPELLING
//     private Long requested;

//     private String eventType;
//     private String details;
//     private LocalDateTime loggedAt;

//     // --------------------
//     // REQUIRED BY TEST
//     // --------------------
//     // Test calls setRequestId(long)
//     public void setRequestId(long requestId) {
//         this.requested = requestId;
//     }

//     // --------------------
//     // EXISTING METHODS
//     // --------------------
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Long getRequested() {
//         return requested;
//     }

//     public void setRequested(Long requested) {
//         this.requested = requested;
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

//     // --------------------
//     // CONSTRUCTORS
//     // --------------------
//     public AuditLogRecord(
//             Long id,
//             Long requested,
//             String eventType,
//             String details,
//             LocalDateTime loggedAt
//     ) {
//         this.id = id;
//         this.requested = requested;
//         this.eventType = eventType;
//         this.details = details;
//         this.loggedAt = loggedAt;
//     }

//     public AuditLogRecord() {
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "audit_log_record")
public class AuditLogRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long requestId;

    private String eventType;

    @Lob
    private String details;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getRequestId() { return requestId; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}
