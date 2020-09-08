package com.java.xml.parser.stax;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.java.xml.parser.helper.FileUtil;

public class StAXModifyXML {
	
	private static final Logger logger = Logger.getLogger(StAXModifyXML.class);
   public static void main(String[] args) {

      try {
         XMLInputFactory factory = XMLInputFactory.newInstance();
         XMLEventReader eventReader =factory.createXMLEventReader(new FileReader(FileUtil.getFilePath("StudentTest.xml")));
         SAXBuilder saxBuilder = new SAXBuilder();
         Document document = saxBuilder.build(new File(FileUtil.getFilePath("StudentTest.xml")));
         Element rootElement = document.getRootElement();
         @SuppressWarnings("unchecked")
		List<Element> studentElements = rootElement.getChildren("student");
         while(eventReader.hasNext()){
            XMLEvent event = eventReader.nextEvent();
            switch(event.getEventType()){
               case XMLStreamConstants.START_ELEMENT:
               StartElement startElement = event.asStartElement();
               String qName = startElement.getName().getLocalPart();

               if (qName.equalsIgnoreCase("student")) {				        	
                  @SuppressWarnings("unchecked")
				Iterator<Attribute> attributes = startElement.getAttributes();
                  String rollNo = attributes.next().getValue();				           
                  if(rollNo.equalsIgnoreCase("393")){     	 
                     //get the student with roll no 393				                 
                     for(int i=0;i < studentElements.size();i++){
                        Element studentElement = studentElements.get(i);
                        if(studentElement.getAttribute("rollno").getValue().equalsIgnoreCase("393")){
                           studentElement.removeChild("marks");
                           studentElement.addContent(new Element("marks").setText("80"));
                        }
                    }
                  }
               }       
               break;
            }		    
         }
         XMLOutputter xmlOutput = new XMLOutputter();
         // display xml
         xmlOutput.setFormat(Format.getPrettyFormat());
         xmlOutput.output(document, System.out); 
      } catch (FileNotFoundException e) {
         logger.debug(e);
      } catch (XMLStreamException e) {
    	  logger.debug(e);
      } catch (JDOMException e) {
    	  logger.debug(e);
      } catch (IOException e) {
    	  logger.debug(e);
      }
   }
}