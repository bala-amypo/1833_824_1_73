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

    public void (String email) {
        this.email = email;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhno() {
        return phno;
    }

    public String getAddress() {
        return address;
    }

}