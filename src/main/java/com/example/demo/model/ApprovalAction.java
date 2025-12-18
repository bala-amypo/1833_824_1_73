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
  private String templateName;
  private String description;
  private Integer totalLevels;
  private Boolean active;

  
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String gettemplateName() {
        return templateName;
    }

    public void settemplateName(String  templatename) {
        this.templateName = templateName;
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