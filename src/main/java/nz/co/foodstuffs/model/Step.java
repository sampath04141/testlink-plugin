package nz.co.foodstuffs.model;

import javax.xml.bind.annotation.XmlElement;

public class Step {

    private String stepNumber;
    private String expectedresults;
    private String executionType;
    private String steps;

    @XmlElement(name="step_number")
    public String getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(String stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getExpectedresults() {
        return expectedresults;
    }

    public void setExpectedresults(String expectedresults) {
        this.expectedresults = expectedresults;
    }


    @XmlElement(name="execution_type")
    public String getExecutionType() {
        return executionType;
    }

    public void setExecutionType(String executionType) {
        this.executionType = executionType;
    }

    @XmlElement(name="actions")
    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
}