package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.time.LocalDateTime;



@Entity
public class ApprovalAction{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(unique=true)
  private Long requested;
  private Long approverld;
  private Integer levelNumber;
  private String action;
  private String comments;
  private LocalDateTime actionDate;
  
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
    public Long getapproverld() {
        return approverld;
    }
    public void setapproverld(Long approverld) {
        this.approverld =approverld;
    }
    public Integer getlevelNumber() {
        return levelNumber;
    }
    public void setlevelNumber(Integer levelNumber) {
        this.levelNumber = levelNumber;
    }
    public String getaction() {
        return action;
    }

    public void setaction(String action) {
        this.action= action;
    }
    public String getcomments() {
        return comments;
    }

    public void setcomments(String comments) {
        this.comments= comments;
    }
    public LocalDateTime getactionDate() {
         return actionDate;
     }
    public void setactionDate(LocalDateTime actionDate) {
         this.actionDate=actionDate;
     }
    
    public   ApprovalAction( Long id,Long requested,Long approverld,Integer levelNumber,String action,String comments,LocalDateTime actionDate){
      this.id=id;
      this.templated=templated;
      this. requested= requested;
      this.approverld=approverld;
      this.levelNumber=levelNumber;
      this.action= action;
      this.comments=comments;
      this.actionDate=actionDate;
    }
     public  ApprovalAction(){

    }

}