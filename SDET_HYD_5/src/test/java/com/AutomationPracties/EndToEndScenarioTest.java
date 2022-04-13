package com.AutomationPracties;

import java.awt.Window;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndToEndScenarioTest {
  @Test
  public void endToEnd() throws Throwable
  {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://automationpractice.com/index.php");
	  driver.findElement(By.className("login")).click();
	  driver.findElement(By.id("email")).sendKeys("yesu@gmail.com",Keys.TAB,"123456",Keys.ENTER);
	  driver.findElement(By.id("search_query_top")).sendKeys("Printed Dress");
	  driver.findElement(By.name("submit_search")).click();
	   JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,500);");
		Thread.sleep(3000);
		WebElement ele=driver.findElement(By.cssSelector("img[title='Printed Dress']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("(//span[text()='Add to cart'])[2]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Proceed to checkout']")).click();

	  
  }
}
