package com.java.xml.parser.dom4j;
import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.java.xml.parser.helper.FileUtil;

public class DOM4JParser {
	private static final Logger logger = Logger.getLogger(DOM4JParser.class);
   public static void main(String[] args) {
      try {
         File inputFile = new File(FileUtil.getFilePath("StudentTest.xml"));
         SAXReader reader = new SAXReader();
         Document document = reader.read( inputFile );

         //Get Root Element from document
         Element classElement = document.getRootElement();
         System.out.println("Root element :"+ classElement.getName());

         @SuppressWarnings("unchecked")
		List<Node> nodes = document.selectNodes("/class/student[@rollno=493]" );
         System.out.println("----------------------------");
         for (Node node : nodes) {
            System.out.println("\nCurrent Element :"+ node.getName());
            System.out.println("Student roll no : " + node.valueOf("@rollno") );
            System.out.println("First Name : " + node.selectSingleNode("firstname").getText());
            System.out.println("Last Name : " + node.selectSingleNode("lastname").getText());
            System.out.println("First Name : " + node.selectSingleNode("nickname").getText());
            System.out.println("Marks : " + node.selectSingleNode("marks").getText());
         }
      } catch (DocumentException e) {
         logger.debug(e);
      }
   }
}