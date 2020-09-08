package com.java.xml.parser.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.java.xml.parser.helper.FileUtil;

public class DOMModifyXmlFile {

	private static final Logger logger = Logger.getLogger(DOMModifyXmlFile.class);

public static void main(String argv[]) {

   try {
      File inputFile = new File(FileUtil.getFilePath("cars.xml")); 	    	
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
      Document doc = docBuilder.parse(inputFile);
      Node cars = doc.getFirstChild();
      Node supercar = doc.getElementsByTagName("supercars").item(0);
      
      // update supercar attribute
      NamedNodeMap attr = supercar.getAttributes();
      Node nodeAttr = attr.getNamedItem("company");
      nodeAttr.setTextContent("Lamborigini");

      // loop the supercar child node
      NodeList list = supercar.getChildNodes();
      for (int temp = 0; temp < list.getLength(); temp++) {
         Node node = list.item(temp);
         if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) node;
            if ("carname".equals(eElement.getNodeName())){
               if("Ferrari 101".equals(eElement.getTextContent())){
                  eElement.setTextContent("Lamborigini 001");
               }
            if("Ferrari 202".equals(eElement.getTextContent()))
               eElement.setTextContent("Lamborigini 002");
            }
         }
      }
     
      NodeList childNodes = cars.getChildNodes();
      for(int count = 0; count < childNodes.getLength(); count++){
         Node node = childNodes.item(count);
         if("luxurycars".equals(node.getNodeName()))
            cars.removeChild(node);
      }
         // write the content on console
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         logger.debug("-----------Modified File-----------");
         StreamResult consoleResult = new StreamResult(System.out);
         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
         transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC,"yes");
         transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
         transformer.transform(source, consoleResult);
      } catch (Exception e) {
         logger.debug(e);
      }
   }
}