package nz.co.foodstuffs.support;

import nz.co.foodstuffs.model.Testcases;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JAXBXMLHandler {

    public static void marshal(Testcases book, File selectedFile)
            throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(selectedFile));
            context = JAXBContext.newInstance(Testcases.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(book, writer);
        } finally {
            try {
                writer.close();
            } catch (IOException io) { /* ignore */
            }
        }
    }

}