package testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderJSONTest {
	WebDriver driver;
	Properties prop;

	@BeforeTest
	public void initSetup() throws IOException {
		prop = new Properties();
		String path = System.getProperty("user.dir") + "//src//test//resources////configFiles//config.properties";
		FileInputStream fin = new FileInputStream(path);
		prop.load(fin);
		fin.close();
	}

	@BeforeMethod
	public void setup() {
		String strbrowser = prop.getProperty("browser");
		System.out.println("Browser name:" + strbrowser);
		if (strbrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (strbrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();

	}

	@Test(dataProvider = "loginData")
	public void validLoginTest(String strUser, String strPwd) {

		driver.get(prop.getProperty("URL"));
		driver.findElement(By.cssSelector("#username")).sendKeys(strUser);
		driver.findElement(By.cssSelector("#password")).sendKeys(strPwd);
		driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
//		driver.findElement(By.cssSelector(".icon-2x.icon-signout")).click();

	}
  @DataProvider(name = "loginData")
  public String[][] getData() throws IOException, ParseException {
	  String path = System.getProperty("user.dir") + "//src//test//resources//testData//loginData.json";
	  FileReader reader = new FileReader(path);
	  JSONParser parser = new JSONParser();
	  Object obj = parser.parse(reader);
	  JSONObject jsonObj = (JSONObject) obj;
	  JSONArray userArray = (JSONArray)jsonObj.get("userLogins");
	  String arr[][] = new String[userArray.size()][];
	  for(int i=0;i<userArray.size();i++) {
		  JSONObject user = (JSONObject)userArray.get(i);
		  String strUser = (String)user.get("username");
		  String strPwd = (String)user.get("password");
		  String record[] = {strUser , strPwd};
		  arr[i] = record;
	  }
	return arr;
	  
  }
}
