package testScripts;

import org.testng.annotations.Test;

public class SampleThreeTest {
  @Test(groups="feature1")
  public void testOne() {
	  System.out.println("Test1 in SampleThree");
  }
  @Test(groups="feature2")
  public void testTwo() {
	  System.out.println("Test2 in SampleThree");
  }
  @Test
  public void testThree() {
	  System.out.println("Test3 in SampleThree");
  }
  @Test
  public void testFour() {
	  System.out.println("Test4 in SampleThree");
  }
}
