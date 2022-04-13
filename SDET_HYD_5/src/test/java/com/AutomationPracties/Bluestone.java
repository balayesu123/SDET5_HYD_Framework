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

public class Bluestone {
	@Test
	public void bluestone() throws Exception
	{
		// open browser get Bluestone web page
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com/");
		
		// Move cursor to Rings menu
		WebElement ele = driver.findElement(By.xpath("//a[text()='Rings ']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		
		// Select diamond rings and click on it
		driver.findElement(By.xpath("//a[text()='Rings ']/../div/ul/li/div/ul/li[2]/a")).click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,500);");
		
		// Get price list by default
		List<WebElement> web = driver.findElements(By.xpath("//span[@id='bst-discounted-price']"));
		String allPrices ="";
		for(WebElement alp:web)
		{
			allPrices = alp.getText();
			// System.out.println(allPrices);
		}

		// Select sort by and select price low to high
		WebElement ele1 = driver.findElement(By.xpath("//span[text()=' Popular ']"));
		act.moveToElement(ele1).perform();
		driver.findElement(By.xpath(" //span[text()=' Popular ']/../../div/div/div/div[3]/a")).click();
		
		// Get price list low to high
		List<WebElement> web1 = driver.findElements(By.xpath("//span[@id='bst-discounted-price']"));
		String allPrices2 ="";
		for(WebElement alp1:web1)
		{
			allPrices2 = alp1.getText();
			// System.out.println(allPrices2);
		}

		// compare by default price and sorted price
		// Both lists should vary by prices validate here
		if(allPrices.equals(allPrices2))
		{
			System.out.println("Equal");
		}
		else
		{
			System.out.println("Not Equal");	
		}
		
		// close browser
		driver.close();

	}
}
