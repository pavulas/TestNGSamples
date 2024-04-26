package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PriorityOrderTest {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
  @Test(alwaysRun = true,dependsOnMethods = "SeleniumSearchTest")
  public void javaSearchTest() {
	  driver.get("https://www.google.com/");
	  WebElement searchbox = driver.findElement(By.id("APjFqb"));
	  searchbox.sendKeys("Java Tutorial");
	  searchbox.sendKeys(Keys.ENTER);
	  Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	  
  }
  @Test
  public void SeleniumSearchTest() {
	  driver.get("https://www.google.com/");
	  WebElement searchbox = driver.findElement(By.id("APjFqb"));
	  searchbox.sendKeys("Selenium Tutorial");
	  searchbox.sendKeys(Keys.ENTER);
	  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search Page");
	  
  }
  //@Test
  public void CucumberSearchTest() {
	  driver.get("https://www.google.com/");
	  WebElement searchbox = driver.findElement(By.id("APjFqb"));
	  searchbox.sendKeys("Cucumber Tutorial");
	  searchbox.sendKeys(Keys.ENTER);
	  Assert.assertEquals(driver.getTitle(), "Cucumber Tutorial - Google Search");
	  
  }
  //@Test(enabled=false)
  public void AppiumSearchTest() {
	  driver.get("https://www.google.com/");
	  WebElement searchbox = driver.findElement(By.id("APjFqb"));
	  searchbox.sendKeys("Appium Tutorial");
	  searchbox.sendKeys(Keys.ENTER);
	  Assert.assertEquals(driver.getTitle(), "Appium Tutorial - Google Search");
	  
  }
  @AfterMethod
  public void teardown() {
	  driver.close();
  }
}
