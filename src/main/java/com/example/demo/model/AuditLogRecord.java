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
    public Long getrequested() {
        return requested;
    }

    public void setrequested(Long  requested) {
        this.requested = requested;
    }
    public String geteventType() {
        return eventType;
    }
    public void seteventType(String eventType) {
        this.eventType =eventType;
    }
    public String getdetails() {
        return details;
    }
    public void setdetails(String details) {
        this.details = details;
    }
   
    public LocalDateTime getloggedAt() {
         return loggedAt;
     }
    public void setactionDate(LocalDateTime loggedAt) {
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