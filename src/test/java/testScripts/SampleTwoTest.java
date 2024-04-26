package testScripts;

import org.testng.annotations.Test;

public class SampleTwoTest {
  @Test(groups="feature1")
  public void testOne() {
	  System.out.println("TestOne in SampleTwo");
  }
  @Test(groups="feature2")
  public void testTwo() {
	  System.out.println("TestTwo in SampleTwo");
  }
  @Test(groups="feature3")
  public void testThree() {
	  System.out.println("TestThree in SampleTwo");
  }
  @Test
  public void testFour() {
	  System.out.println("TestFour in SampleTwo");
  }
}
