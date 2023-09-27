package nz.co.foodstuffs;


import nz.co.foodstuffs.model.Step;
import nz.co.foodstuffs.model.Steps;
import nz.co.foodstuffs.model.Testcase;
import nz.co.foodstuffs.model.Testcases;
import nz.co.foodstuffs.support.JAXBXMLHandler;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

public class XlsOperation extends ReadProperty {
    Testcases testcasesRoot;

    public void read() {
        try {

            FileInputStream excelFile = new FileInputStream(new File(getFile()));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            testcasesRoot = new Testcases();
            ArrayList<Testcase> testcaseList = new ArrayList<>();


            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                if (currentRow.getRowNum() == 0) {
                    System.out.println(currentRow.getCell(0) + " : " + currentRow.getCell(1)
                            + " : " + currentRow.getCell(2) + " : " + currentRow.getCell(3)
                            + " : " + currentRow.getCell(4) + " : " + currentRow.getCell(5));
                    System.out.println("================================================");

                } else {

                    Testcase testcase = new Testcase();
                    Steps steps = new Steps();
                    boolean isStepFound = false;
                    Step step = new Step();

                    for (Testcase tc : testcaseList) {

                        if (tc.getName().equalsIgnoreCase(currentRow.getCell(0).toString()) &&
                                tc.getSummary().equalsIgnoreCase(getVal(currentRow.getCell(1).toString()))) {
                            isStepFound = true;

                            Step step1 = new Step();
                            step1.setStepNumber(String.valueOf(currentRow.getCell(3)));
                            step1.setSteps(getVal(String.valueOf(currentRow.getCell(4))));
                            step1.setExpectedresults(getVal(String.valueOf(currentRow.getCell(5))));
                            step1.setExecutionType(String.valueOf(currentRow.getCell(6)));

                            tc.getSteps().getstep().add(step1);

                            break;
                        }
                    }
                    if (isStepFound == false) {

                        ArrayList<Step> testStepList = new ArrayList<>();
                        step.setStepNumber(String.valueOf(currentRow.getCell(3)));
                        step.setSteps(getVal(String.valueOf(currentRow.getCell(4))));
                        step.setExpectedresults(getVal(String.valueOf(currentRow.getCell(5))));
                        step.setExecutionType(String.valueOf(currentRow.getCell(6)));
                        testStepList.add(step);
                        steps.setstep(testStepList);

                        testcase.setName(String.valueOf(currentRow.getCell(0)));
                        testcase.setSummary(getVal(String.valueOf(currentRow.getCell(1))));
                        testcase.setPreconditions(getVal(String.valueOf(currentRow.getCell(2))));
                        testcase.setExecutionType(String.valueOf(currentRow.getCell(6)));
                        testcase.setImportance(String.valueOf(currentRow.getCell(7)));
                        testcase.setEstimatedExecDuration(Double.valueOf(currentRow.getCell(8).toString()));
                        testcase.setStatus(Double.valueOf(currentRow.getCell(9).toString()));

                        testcase.setSteps(steps);

                        testcaseList.add(testcase);
                    }
                }
                System.out.println();
            }
            testcasesRoot.setTestcase(testcaseList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getVal(String val) {
        String[] lines = val.split("\r\n|\r|\n");
        String value = "";
        for (int i = 0; i < lines.length; i++) {
            value = value + "<p>" + lines[i] + "<\u002Fp>";
        }
        return value;
    }

    public void writeXml() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        try {
            //Marshalling: Writing Java object to XML file
            JAXBXMLHandler.marshal(testcasesRoot, new File(fileLocation +"XML-TestCases-"+ LocalDateTime.now().format(format) + ".xml"));
            System.out.println("File write-->"+fileLocation + LocalDateTime.now().format(format) + ".xml");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

}

