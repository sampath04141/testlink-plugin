package nz.co.foodstuffs.model;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Testcase {

    private String summary;
    //private String nodeOrder;
    //private Integer isOpen;

    private String preconditions;
    private String name;
    private String importance;

   // private Integer active;
    private String executionType;
    //private String version;
    private Steps steps;
    private double estimatedExecDuration;
    private double status;


    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {

        this.summary = summary;
    }
  /*  public String getNodeOrder() {
        return nodeOrder;
    }
    public void setNodeOrder(String nodeOrder) {
        this.nodeOrder = nodeOrder;
    }
    public Integer getIsOpen() {
        return isOpen;
    }
    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }*/
    public String getPreconditions() {
        return preconditions;
    }
    public void setPreconditions(String preconditions) {
        this.preconditions = preconditions;
    }
    public String getImportance() {
        return importance;
    }
    public void setImportance(String importance) {
        this.importance = importance;
    }

   /* public Integer getActive() {
        return active;
    }
    public void setActive(Integer active) {
        this.active = active;
    }*/
    public String getExecutionType() {
        return executionType;
    }
    public void setExecutionType(String executionType) {
        this.executionType = executionType;
    }
   /* public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }*/
    public Steps getSteps() {
        return steps;
    }
    public void setSteps(Steps steps) {
        this.steps = steps;
    }

    @XmlElement(name="estimated_exec_duration")
    public double getEstimatedExecDuration() {
        return estimatedExecDuration;
    }
    public void setEstimatedExecDuration(double estimatedExecDuration) {
        this.estimatedExecDuration = estimatedExecDuration;
    }
    public double getStatus() {
        return status;
    }
    public void setStatus(double status) {
        this.status = status;
    }

    @XmlAttribute
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}