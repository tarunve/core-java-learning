package com.java.xml.parser.dom4j;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.java.xml.parser.helper.FileUtil;

public class DOM4jModifyXML {
	public static void main(String[] args) {
		try {
			File inputFile = new File(FileUtil.getFilePath("StudentTest.xml"));
			SAXReader reader = new SAXReader();
			Document document = reader.read(inputFile);

			// Element classElement = document.getRootElement();

			@SuppressWarnings("unchecked")
			List<Node> nodes = document.selectNodes("/class/student[@rollno='493']");
			for (Node node : nodes) {
				Element element = (Element) node;
				@SuppressWarnings("unchecked")
				Iterator<Element> iterator = element.elementIterator("marks");
				while (iterator.hasNext()) {
					Element marksElement = (Element) iterator.next();
					marksElement.setText("80");
				}
			}
			// Pretty print the document to System.out
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter writer = new XMLWriter(System.out, format);
			writer.write(document);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}