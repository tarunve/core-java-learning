package com.java.xml.parser.jdom;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.java.xml.parser.helper.FileUtil;

public class JDOMModifyXMLFile {
	
	private static final Logger logger = Logger.getLogger(JDOMModifyXMLFile.class);
	
   public static void main(String[] args) {
      try {
         File inputFile = new File(FileUtil.getFilePath("cars.xml"));
         SAXBuilder saxBuilder = new SAXBuilder();
         Document document = saxBuilder.build(inputFile);
         Element rootElement = document.getRootElement();

         //get first supercar
         Element supercarElement = rootElement.getChild("supercars");

         // update supercar attribute
         Attribute attribute = supercarElement.getAttribute("company");
         attribute.setValue("Lamborigini");

         // loop the supercar child node
         @SuppressWarnings("unchecked")
		List<Element> list = supercarElement.getChildren();
         for (int temp = 0; temp < list.size(); temp++) {
            Element carElement = list.get(temp);
            if("Ferrari 101".equals(carElement.getText())){
               carElement.setText("Lamborigini 001");
            }
            if("Ferrari 202".equals(carElement.getText())){
               carElement.setText("Lamborigini 002");
            }
         }

         //get all supercars element
         @SuppressWarnings("unchecked")
		List<Element> supercarslist = rootElement.getChildren();
         for (int temp = 0; temp < supercarslist.size(); temp++) {
            Element tempElement = supercarslist.get(temp);
            if("luxurycars".equals(tempElement.getName())){
               rootElement.removeContent(tempElement);
            }        	 
         }

         XMLOutputter xmlOutput = new XMLOutputter();
   
         // display xml
         xmlOutput.setFormat(Format.getPrettyFormat());
         xmlOutput.output(document, System.out); 
      } catch (JDOMException e) {
         logger.debug(e);
      } catch (IOException e) {
         logger.debug(e);
      }
   }
}