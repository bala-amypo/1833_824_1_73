package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;



@Entity
public class AuditLogRecord{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(unique=true)
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
        return levelNumber;
    }
    public void setdetails(String details) {
        this.details = details;
    }
   
    public LocalDateTime getloggedAt() {
         return actionDate;
     }
    public void setactionDate(LocalDateTime actionDate) {
         this.actionDate=actionDate;
     }
    
    public  WorkflowTemplate( Long id,Long requested,Long approverld,Integer levelNumber,String action,String comments,LocalDateTime actionDate){
      this.id=id;
      this.templated=templated;
      this. requested= requested;
      this.approverld=approverld;
      this.levelNumber=levelNumber;
      this.action= action;
      this.comments=comments;
      this.actionDate=actionDat;
    }
     public  ApprovalAction(){

    }

}