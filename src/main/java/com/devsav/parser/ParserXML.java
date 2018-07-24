package com.devsav.parser;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ParserXML {
    private static final Logger LOGGER = LogManager.getLogger(ParserXML.class);

    public static void parseToXml(String fileName, Object objectName, Class className) {
        File file = new File(fileName);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(className);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(objectName, file);
            marshaller.marshal(objectName, System.out);
        } catch (JAXBException e) {
            LOGGER.error("JAXB marshaller " + e.getMessage());
        }
    }

    public static Object parseFromXML(File file, Class className) {
        Object object = null;
        try {
            JAXBContext context = JAXBContext.newInstance(className);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            object = unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            LOGGER.error("JAXB unmarshaller " + e.getMessage());
        }
        return object;
    }

}
