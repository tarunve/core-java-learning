package com.java.xml.parser.jdom;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class JDOMCreateXmlFile {
	
	private static final Logger logger = Logger.getLogger(JDOMCreateXmlFile.class);
	
   public static void main(String[] args) {

      try{
         //root element
         Element carsElement = new Element("cars");
         Document doc = new Document(carsElement);			

         //supercars element
         Element supercarElement = new Element("supercars");
         supercarElement.setAttribute(new Attribute("company","Ferrari"));

         //supercars element
         Element carElement1 = new Element("carname");
         carElement1.setAttribute(new Attribute("type","formula one"));
         carElement1.setText("Ferrari 101");

         Element carElement2 = new Element("carname");
         carElement2.setAttribute(new Attribute("type","sports"));
         carElement2.setText("Ferrari 202");

         supercarElement.addContent(carElement1);
         supercarElement.addContent(carElement2);

         doc.getRootElement().addContent(supercarElement);

         XMLOutputter xmlOutput = new XMLOutputter();

         // display xml
         xmlOutput.setFormat(Format.getPrettyFormat());
         xmlOutput.output(doc, System.out);  
      }catch(IOException e){
         logger.debug(e);
      }		
   }
}