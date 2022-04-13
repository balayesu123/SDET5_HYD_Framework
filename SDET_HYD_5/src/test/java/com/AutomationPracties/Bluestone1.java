package com.AutomationPracties;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bluestone1 {
	@Test
	public void bluestone() throws Exception
	{   
		//Open Browser  get Bluestone webpage
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com/");
		
		// Move to cursor to Rings Menu
		WebElement ele = driver.findElement(By.xpath("//a[text()='Rings ']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		
		//select diamond Rings and Click on it
		driver.findElement(By.xpath("//a[text()='Diamond']")).click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,500);");
		
		//Get price list By default
		List<WebElement> defaultPrice = driver.findElements(By.id("bst-discounted-price"));
		String dpc="";
		int newdePc=0;
		for(WebElement apl:defaultPrice)
		{ 
			dpc=apl.getText();
			String newdePrice=dpc.replace(",", "");
			String newdePrice2=newdePrice.replace("RS.", "");
			newdePc=Integer.parseInt(newdePrice2);
		}
		
		//Select sort by and select price low to high
		WebElement ele1 = driver.findElement(By.xpath("//span[text()=' Popular ']"));
		act.moveToElement(ele1).perform();
		driver.findElement(By.xpath("//span[text()=' Popular ']/../../div/div/div/div[3]/a")).click();
		
		//Get price list low to high
		List<WebElement> sortedPrice = driver.findElements(By.id("bst-discounted-price"));
		String pc="";
		int sortedPc=0;
		for(WebElement apl1:sortedPrice)
		{ 
			pc=apl1.getText();
			String newPrice=pc.replace(",", "");
			String newsortedPrice2=newPrice.replace("RS.", "");
			sortedPc=Integer.parseInt(newsortedPrice2);
		}
		Thread.sleep(3000);
		
		//compare Bydefault price and Sorted price
		if(newdePc==sortedPc)
		{
			System.out.println("Equal");
		}
		else
		{
			System.out.println("Not Equal");	
		}
		Thread.sleep(3000);
		
		//Verify sorted Price should in ascending order
		String sortedPrice1 = driver.findElement(By.id("bst-discounted-price")).getText();
		String repc=sortedPrice1.replace(",", "") ; 
		String repc1 = repc.replace("RS.", "");
		int repc2=Integer.parseInt(repc1);
		List<WebElement> ele2 = driver.findElements(By.id("bst-discounted-price"));

		for(WebElement ass:ele2)
		{
			String text =ass.getText();
			String newtexprice=text.replace(",", "");
			String newtextPrice3=newtexprice.replace("RS.", "");
			int textPc=Integer.parseInt(newtextPrice3);
			if(repc2<textPc)
			{
				System.out.println("it is in assending order");
				break;
			}
		}
		
		//close the Browser
		driver.close();
	}
}
