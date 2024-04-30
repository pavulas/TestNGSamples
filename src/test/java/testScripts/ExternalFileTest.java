package testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExternalFileTest {
	WebDriver driver;
	Properties prop;
	
	@BeforeTest
	public void initSetup() throws IOException {
		prop = new Properties();
		String path = System.getProperty("user.dir") + "//src//test//resources//configFiles//config.properties";
		FileInputStream fin = new FileInputStream(path);
		prop.load(fin);
		fin.close();
	}

	@BeforeMethod
	public void setup() {
		String strbrowser = prop.getProperty("browser");
		System.out.println("Browser name:" +strbrowser);
		if (strbrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (strbrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
	}

	

	@Test
	public void validLogin() {
		

		driver.get(prop.getProperty("URL"));
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
