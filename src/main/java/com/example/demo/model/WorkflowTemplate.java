package com.example.demo.model;
import.jakarta.persistence.Entity;
import.jakarta.persistence.Id;
import.jakarta.persistence.GeneratedValue;
import.jakarta.persistence.GenerationType;



@Entity
public class WorkflowTemplate{
    @id
    @GeneratedValue(GenerationType.IDENTITY)
  private long id;
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

    public void settotalLevels(Integer totalLevels) {
        this.totalLevels = totalLevels;
    }

    public void setactive(Boolean active) {
        this.active= active;
    }

    

    

    

    public Integer gettotalLevels() {
        return totalLevels;
    }

    public Boolean getactive() {
        return active;
    }

}