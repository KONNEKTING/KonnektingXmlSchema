package de.konnekting.xmlschema;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import de.konnekting.xml.schema.konnekting.KONNEKTING;
import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author achristian
 */
public class KonnektingXmlService {

    private static <T> T unmarshal(String xsdSchema, String xmlDatei, Class<T> clss)
        throws JAXBException, SAXException {
        // Schema und JAXBContext sind multithreadingsicher ("thread safe"):
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(KonnektingXmlService.class.getResource("/META-INF/xsd/Konnekting.xsd"));
        JAXBContext jaxbContext = JAXBContext.newInstance(clss.getPackage().getName());
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(schema);
        return clss.cast(unmarshaller.unmarshal(new File(xmlDatei)));

    }

    private static void marshal(String xsdSchema, String xmlDatei, Object jaxbElement)
        throws JAXBException, SAXException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(KonnektingXmlService.class.getResource("/META-INF/xsd/Konnekting.xsd"));
        JAXBContext jaxbContext = JAXBContext.newInstance(jaxbElement.getClass().getPackage().getName());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setSchema(schema);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(jaxbElement, new File(xmlDatei));
    }

    public static KONNEKTING readConfiguration(File f) throws JAXBException, SAXException {
        KONNEKTING konnekting = unmarshal(null, f.getAbsolutePath(), KONNEKTING.class);
        return konnekting;
    }

}
