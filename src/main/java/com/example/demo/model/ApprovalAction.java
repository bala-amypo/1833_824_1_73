package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;



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
    public String getrequested() {
        return requested;
    }

    public void setrequested(String  requested) {
        this.requested = requested;
    }
    public String getdescription() {
        return description;
    }
    public void setdescription(String discription) {
        this.description = description;
    }
    public Integer gettotalLevels() {
        return totalLevels;
    }
    public void settotalLevels(Integer totalLevels) {
        this.totalLevels = totalLevels;
    }
    public Boolean getactive() {
        return active;
    }

    public void setactive(Boolean active) {
        this.active= active;
    }
    public  WorkflowTemplate(Long id, String templateName, String description,Integer totalLevels, Boolean active){
      this.id=id;
      this.templateName=templateName;
      this.description=description;
      this.totalLevels=totalLevels;
      this.active=active;

    }
    public  WorkflowTemplate(){

    }

}