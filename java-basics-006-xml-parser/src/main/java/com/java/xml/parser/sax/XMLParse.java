package com.java.xml.parser.sax;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;

public class XMLParse {

    public static void main(String[] args) throws JAXBException, XMLStreamException {
        JAXBContext context = JAXBContext.newInstance(Company.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        XMLInputFactory factory = XMLInputFactory.newFactory();

        String xml =    "<?xml version=\"1.0\"?><company><name>Amdocs</name></company>";

        XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(xml));
        JAXBElement<Company> element = unmarshaller.unmarshal(reader, Company.class);
        Company book = element.getValue();

        System.out.println(book);
    }

    @XmlRootElement(name = "company")
    public static class Company {
        @XmlElement
        private String name;

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Company{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
