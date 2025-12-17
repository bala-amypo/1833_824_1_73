
package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;




@Entity
public class WorkflowStepConfig{
  @id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;

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
    public Long  gettemplated() {
        return templated;
    }

    public void settemplated(Long templated) {
        this.templated = templated;
    }
    public Integer getlevelNumber() {
        return levelNumber;
    }
    public void setlevelNumber(Integer levelNumber) {
        this.levelNumber = levelNumber;
    }
    public String getapproverRole() {
        return approverRole;
    }
    public void setapproverRole(String approverRole) {
        this.approverRole= approverRole;
    }
    public String getinstructions() {
        return instructions;
    }

    public void setactive(String instructions) {
        this.instructions= instructions;
    }
    public  WorkflowStepConfig (long id, Long templated,Integer levelNumber, String approverRole, String instructions){
      this.id=id;
      this.templated=templated;
      this.levelNumber=levelNumber;
      this.approverRole=approverRole;
      this.instructions=instructions;
    }
    public  WorkflowStepConfig(){
      
    }

}