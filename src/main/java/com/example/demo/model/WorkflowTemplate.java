public class WorkflowTemplate{
  private long id;
  private String templateName;
  private String description;
  private Integer totalLevels;
  private Boolean active;

  
    public void setId(Long id) {
        this.id = id;
    }

    public void settemplateName(String  templatename) {
        this.templateName = templateName;
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

    public Long getId() {
        return id;
    }

    public String gettemplateName() {
        return templateName;
    }

    public String getdescription() {
        return description;
    }

    public Integer gettotalLevels() {
        return totalLevels;
    }

    public String getAddress() {
        return address;
    }

}