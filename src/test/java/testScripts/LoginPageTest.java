package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest {
	
	WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void setup(String strbrowser) {
		if(strbrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if(strbrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
	}
  @Test
  public void validLogin() {
	  
	
		driver.get("https://the-internet.herokuapp.com/login");
//		driver.findElement(By.id("username")).sendKeys("tomsmith");
		
		driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
		
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");
		
		driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
		
//		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		
		driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
		
//		driver.findElement(By.className("radius")).click();
//		driver.findElement(By.linkText("Elemental Selenium")).click();
//		driver.findElement(By.partialLinkText("Elemental")).click();
//		driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
		
		driver.findElement(By.cssSelector(".icon-2x.icon-signout")).click();
		
//		driver.findElement(By.xpath("//i[@class='icon-2x icon-signout']")).click();

  }
}
