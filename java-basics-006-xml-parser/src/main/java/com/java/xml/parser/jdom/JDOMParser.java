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

import com.java.xml.parser.helper.FileUtil;


public class JDOMParser {
	
	private static final Logger logger = Logger.getLogger(JDOMParser.class);
	
   public static void main(String[] args) {
      try {
         File inputFile = new File(FileUtil.getFilePath("StudentTest.xml"));

         SAXBuilder saxBuilder = new SAXBuilder();
         Document document = saxBuilder.build(inputFile);

         System.out.println("Root element :" + document.getRootElement().getName());

         Element classElement = document.getRootElement();

         @SuppressWarnings("unchecked")
		List<Element> studentList = classElement.getChildren();
         System.out.println("----------------------------");

         for (int temp = 0; temp < studentList.size(); temp++) {    
            Element student = studentList.get(temp);
            System.out.println("\nCurrent Element :" + student.getName());
            Attribute attribute =  student.getAttribute("rollno");
            System.out.println("Student roll no : " + attribute.getValue() );
            System.out.println("First Name : " + student.getChild("firstname").getText());
            System.out.println("Last Name : "+ student.getChild("lastname").getText());
            System.out.println("Nick Name : "+ student.getChild("nickname").getText());
            System.out.println("Marks : "+ student.getChild("marks").getText());	            		
         }
      }catch(JDOMException e){
         logger.debug(e);
      }catch(IOException ioe){
         logger.debug(ioe);
      }
   }
}