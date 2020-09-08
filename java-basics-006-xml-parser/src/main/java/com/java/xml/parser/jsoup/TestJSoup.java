package com.java.xml.parser.jsoup;


import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestJSoup {
	
	//private static Document site;
	private static final Logger logger = Logger.getLogger(TestJSoup.class);
	public static void main(String [] args)
	{
		//This below code is used for HTML parsing from String using Jsoup.
		String htmlString = "<html><head><title>Jsoup String HTML Test</title></head><body><p>Parsed HTML from String.</p></body></html>";
		
		Document document = Jsoup.parse(htmlString); 
		String title = document.title();
		logger.info("Title: " + title);
		
		//The below code is for Creating file object using HTML file. 
		File inputFile = new File("C:\\Users\\tarunve\\OneDrive - AMDOCS\\Backup Folders\\Desktop\\htmlParse.html"); 
		Document document1; 
		try { 
			//Get Document object after parsing the html file. 
			document1 = Jsoup.parse(inputFile, "UTF-8");   
			
			//Get title from document object. 
			String title1 = document1.title();   
			
			//Print title. 
			logger.info("Title: " + title1); 
		} catch (IOException e) { 
			logger.info(e);
		}	
		
		//This class is used for HTML parsing from URL using Jsoup 
		Document document2; try { 
			//Get Document object after parsing the html from given url. 
			document2 = Jsoup.connect("http://tutorialspointexamples.com/").get();   
			
			//Get title from document object. 
			String title2 = document2.title();   
			
			//Print title. 
			logger.info("Title: " + title2); 
			} catch (IOException e) { 
				logger.trace(e);
		}
		
		//Get Document object after parsing the html from given url. Getting the links from URL
		Document document3; 
		try { 
		
			 document3 = Jsoup.connect("http://tutorialspointexamples.com/").get();   
			 
			 //Get links from document object. 
			 Elements links = document3.select("a[href]");   
			 
			 //Iterate links and print link attributes. 
			 for (Element link : links) { 
				 logger.info("Link: " + link.attr("href")); 
				 logger.info("Text: " + link.text()); 
				 logger.info(""); 
			 }   
		}catch (IOException e) { 
			logger.trace(e);
		}	
		
		
		//This class is used get images from HTML using Jsoup. 
		Document document4; 
		try { 
			//Get Document object after parsing the html from given url. 
			document4 = Jsoup.connect("http://tutorialspointexamples.com/").get();   
			
			//Get images from document object. 
			Elements images = document4.select("img[src~=(?i)\\.(png|jpe?g|gif)]");   
			
			//Iterate images and print image attributes. 
			for (Element image : images) { 
				logger.info("Image Source: " + image.attr("src")); 
				logger.info("Image Height: " + image.attr("height")); 
				logger.info("Image Width: " + image.attr("width")); 
				logger.info("Image Alt Text: " + image.attr("alt")); 
				logger.info(""); 
			}	
			
		} catch (IOException e) { 
			logger.trace(e); 
		} 
		
		
		//This class is used get meta data from HTML using Jsoup. 
		Document document5; 
		try { 
			//Get Document object after parsing the html from given url. 
			document5 = Jsoup.connect( "http://tutorialspointexamples.com/jsoup-get-images-from-html-example/") .get();   
			
			//Get description from document object. 
			String description = document5.select("meta[name=description]").get(0) .attr("content"); 
			
			//Print description. 
			logger.info("Meta Description: " + description);   
			
			//Get keywords from document object. 
			String keywords = document.select("meta[name=keywords]").first() .attr("content"); 
			
			//Print keywords. 
			logger.info("Meta Keyword : " + keywords);   
			
		} catch (IOException e) { 
			logger.trace(e);	
		}
		
		
		//This class is used get meta data from HTML using Jsoup. 
		Document document6; 
		try { 
			//Get Document object after parsing the html file. 
			document6=Jsoup.parse( new File("C:\\Users\\tarunve\\OneDrive - AMDOCS\\Backup Folders\\Desktop\\bookmark.htm"),"utf-8");   
			
			//Get the form by id. 
			Element testForm = document6.getElementById("testForm");   
			
			//Get input parameters of the form. 
			Elements inputElements = testForm.getElementsByTag("input");   
			
			//Iterate parameters and print name and value. 
			for (Element inputElement : inputElements) { 
				String key = inputElement.attr("name"); 
				String value = inputElement.attr("value"); 
				logger.info("Parameter Name: " + key); 
				logger.info("Parameter Value: " + value); 
				logger.info("");	
			}
		} catch (IOException e) { 
			logger.trace(e);
		} 
		
		
		/*try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			site = Jsoup.connect(reader.readLine()).timeout(0).get();
			
			Elements tags = site.select("a");
			
			for(int i = 0 ; i<tags.size() ; i++){
				logger.trace(tags.get(i).outerHtml());
			}
			
		}catch(Exception e){
			logger.trace(e);
			
		}*/
		
	}
}
