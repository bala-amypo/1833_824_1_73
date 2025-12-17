package com.example.demo.model;
import.jakarta.persistence.Entity;
import.jakarta.persistence.Id;
import.jakarta.persistence.GeneratedValue;
import.jakarta.persistence.GenerationType;

@Entity
public class ApprovalRequest{
    @id
  @GeneratedValue(GenerationType.IDENTITY)
  private long id;
  
  private Long templated;
  private String requestTitle;
  private String requestPayloadJson;
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

}
