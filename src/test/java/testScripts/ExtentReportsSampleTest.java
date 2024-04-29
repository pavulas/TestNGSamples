package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonUtils.Utility;

public class ExtentReportsSampleTest {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;

	@BeforeTest
	public void initExtent() {
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/SparkReport.html");
		extentReports.attachReporter(spark);
	}
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void javasearchTest() {
		extentTest = extentReports.createTest("javasearchTest");
		driver.get("https://www.google.com/");
//		SoftAssert softassert = new SoftAssert();
//		softassert.assertEquals(driver.getTitle(), "Google Page");
		WebElement searchbox = driver.findElement(By.id("APjFqb"));
		  searchbox.sendKeys("Pranitha Avula");
		  searchbox.sendKeys(Keys.ENTER);
		  Assert.assertEquals(driver.getTitle(), "Pranitha Avula - Google Search");
//		softassert.assertEquals(driver.getTitle(), "Pranitha Avula - Google Search");
		// softassert.assertAll();
	}

	 @Test(retryAnalyzer = RetryAnalyserImpl.class)
	public void seleniumSearchTest() {
		 extentTest = extentReports.createTest("seleniumSearchTest");
		driver.get("https://www.google.com/");
		WebElement searchbox = driver.findElement(By.id("APjFqb"));
		  searchbox.sendKeys("Selenium Tutorial");
		  searchbox.sendKeys(Keys.ENTER);
		  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search Page");

	}

	 @AfterTest
	 public void finishExtent() {
		 extentReports.flush();
	 }
	  @AfterMethod
	public void teardown(ITestResult result) {
		  if(ITestResult.FAILURE == result.getStatus()) {
			  extentTest.log(Status.FAIL, result.getThrowable().getMessage());
			  String strPath = Utility.getScreenshotpath(driver);
			  extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
		  } else if(ITestResult.SKIP == result.getStatus()) {
			  extentTest.log(Status.SKIP, result.getThrowable().getMessage());
			  
		  }
		driver.close();
	}
}