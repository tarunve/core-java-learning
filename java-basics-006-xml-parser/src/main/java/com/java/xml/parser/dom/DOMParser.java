package com.java.xml.parser.dom;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.java.xml.parser.helper.FileUtil;

/**
 * 	->	This class is used to parse XML document using DOM (Document Object Model) parser.
 */
public class DOMParser {
	private static final Logger logger = Logger.getLogger(DOMParser.class);

	public static void main(String args[]) {
		try {
			// File Path
			String filePath = FileUtil.getFilePath("StudentTest.xml");

			// Read XML file.
			File inputFile = new File(filePath);

			// Create DocumentBuilderFactory object.
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

			// Get DocumentBuilder object.
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			// Parse XML file.
			Document document = dBuilder.parse(inputFile);
			document.getDocumentElement().normalize();

			// Print root element.
			logger.debug("Root element:" + document.getDocumentElement().getNodeName());

			// Get element list.
			NodeList nodeList = document.getElementsByTagName("student");

			// Process element list.
			for (int temp = 0; temp < nodeList.getLength(); temp++) {
				Node nNode = nodeList.item(temp);
				logger.debug("Current Element : " + nNode.getNodeName() + " " + (temp + 1));
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					logger.debug(nNode.getNodeName());
					Element eElement = (Element) nNode;
					System.out.println("Roll no: \t" + eElement.getAttribute("rollno"));
					System.out.println(
							"First Name: \t" + eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name: \t" + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Marks: \t\t" + eElement.getElementsByTagName("marks").item(0).getTextContent());
				}
				System.out.println();
			}
		} catch (Exception e) {
			logger.debug(e);
		}
	}
}
