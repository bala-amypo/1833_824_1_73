package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;


@Entity
public class AuditLogRecord{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private Long requested;
  private String eventType;
  private String details;
  private LocalDateTime loggedAt;
  
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getRequested() {
        return requested;
    }

    public void setRequested(Long  requested) {
        this.requested = requested;
    }
    public String getEventType() {
        return eventType;
    }
    public void setEventType(String eventType) {
        this.eventType =eventType;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
   
    public LocalDateTime getLoggedAt() {
         return loggedAt;
     }
    public void setLoggedAt(LocalDateTime loggedAt) {
         this.loggedAt=loggedAt;
     }
    
    public AuditLogRecord(  Long id,Long requested,String eventType,String details, LocalDateTime loggedAt){
      this.id=id;
      this.requested=requested;
      this.eventType=eventType;
      this.details=details;
      this.loggedAt=loggedAt;
    }
     public  AuditLogRecord(){

    }

}


