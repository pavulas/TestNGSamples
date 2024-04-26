package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class GooglePgeTestwithAnnotations {
	WebDriver driver;
	
	@BeforeTest
//	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
  @Test
  public void javasearchTest() {
	  driver.get("https://www.google.com/");
	  SoftAssert softassert = new SoftAssert();
	  softassert.assertEquals(driver.getTitle(), "Google Page");
	  WebElement searchbox = driver.findElement(By.id("APjFqb"));
	  searchbox.sendKeys("Pranitha Avula");
	  searchbox.sendKeys(Keys.ENTER);
	  softassert.assertEquals(driver.getTitle(), "Pranitha Avula - Google Search");
	  //softassert.assertAll();
  }
	//  @Test
	  public void seleniumSearchTest() {
		  driver.get("https://www.google.com/");
		  WebElement searchbox = driver.findElement(By.id("APjFqb"));
		  searchbox.sendKeys("Selenium Tutorial");
		  searchbox.sendKeys(Keys.ENTER);
		  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
		  
	  }
	 // @AfterTest
//	  @AfterMethod
	  public void teardown() {
		  driver.close();
	  }
	  

}
