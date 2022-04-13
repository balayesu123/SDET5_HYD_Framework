package com.DDT;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadingDataFromXmlTest {
   @Test
   public void readingdataFromxmlfile(XmlTest xml)
   {
     String url=xml.getParameter("URL");
     String un=xml.getParameter("UN");
     String psw=xml.getParameter("PWD");
     System.out.println(url);
     System.out.println(un);
     System.out.println(psw);
	   
   }
}
