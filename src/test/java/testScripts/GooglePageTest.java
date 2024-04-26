package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GooglePageTest {
  @Test
  public void javaSearchTest() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com/");
	  WebElement searchbox = driver.findElement(By.id("APjFqb"));
	  searchbox.sendKeys("Pranitha Avula");
	  searchbox.sendKeys(Keys.ENTER);
	  Assert.assertEquals(driver.getTitle(), "Pranitha Avula - Google Search");
	  
  }
  @Test
  public void seleniumSearchTest() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com/");
	  WebElement searchbox = driver.findElement(By.id("APjFqb"));
	  searchbox.sendKeys("Selenium Tutorial");
	  searchbox.sendKeys(Keys.ENTER);
	  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
	  
  }
}
