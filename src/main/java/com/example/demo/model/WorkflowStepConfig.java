
package com.example.demo.model;
import.jakarta.persistence.Entity;
import.jakarta.persistence.Id;
import.jakarta.persistence.GeneratedValue;
import.jakarta.persistence.GenerationType;




@Entity
public class WorkflowStepConfig{
  @id
  @GeneratedValue(GenerationType.IDENTITY)
  private long id;
  @Column(unique=true)
  private Long templated;
  private Integer levelNumber;
  private String approverRole;
  private String instructions;

  
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String gettemplated() {
        return templated;
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

}