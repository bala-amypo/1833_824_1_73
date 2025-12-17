package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
@Entity
public class ApprovalRequest{
    @id
  @GeneratedValue(GenerationType.IDENTITY)
  private long id;
  private Long templated;
   private Long requesterlid;
  private String requestTitle;
  private String requestPayloadJson;
  private String status;
  private Integer currentLevel;
  private LocalDateTime createdAt;

  
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
    public Long  getrequesterlid() {
        return requesterlid;
    }

    public void settemplated(Long templated) {
        this.templated = templated;
    }
    public String getrequestTitle() {
        return requestTitle;
    }
    public void setrequestTitle(String requestTitle) {
        this.requestTitle = requestTitle;
    }
    public String getrequestPayloadJson() {
        return requestPayloadJson;
    }
    public void setrequestPayloadJson(String requestPayloadJson) {
        this.requestPayloadJson= requestPayloadJson;
    }
    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status= status;
    }
    public Integer getcurrentLevel() {
        return currentLevel;
    }

    public void setcurrentLevel(Integer currentLevel) {
        this.currentLevel=currentLevel;
    }
     public LocalDateTime getcreatedAt() {
        return createdAt;
    }

    public void setcreatedAt(LocalDateTime createdAt) {
        this.createdAt=createdAt;
    }
    public ApprovalRequest(long id, Long templated,String requestTitle,String requestPayloadJson,String status, Integer currentLevel,LocalDateTime createdAt){
        this.id=id;
        this.templated=templated;
        this.requesterlid
    }

}
