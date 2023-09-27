package nz.co.foodstuffs.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Testcases {
    @XmlElement(name="testcase")
    private List<Testcase> testcase = new ArrayList<Testcase>();
    private String name;

    public List<Testcase> getTestcase() {
        return testcase;
    }
    public void setTestcase(List<Testcase> testcase) {
        this.testcase = testcase;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
