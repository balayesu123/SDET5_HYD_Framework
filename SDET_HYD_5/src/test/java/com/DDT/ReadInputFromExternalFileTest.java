package com.DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.imageio.stream.FileCacheImageInputStream;

import org.testng.annotations.Test;

public class ReadInputFromExternalFileTest {
   @Test
   public void readInputFromExternalFileTest() throws Throwable
   {
	   FileInputStream fil=new FileInputStream("./commanData.PROPERTIES");
	   Properties p=new Properties();
	   p.load(fil);
	   String url=p.getProperty("URL");
	   String username=p.getProperty("UN");
	   String password=p.getProperty("PWD");
	   System.out.println(url);
	   System.out.println(username);
	   System.out.println(password);
	   
   }
}
