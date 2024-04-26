package parallelScripts;

import org.testng.annotations.Test;

public class SampleThreeTest {
	@Test
	  public void testOne() {
		long id = Thread.currentThread().getId();
		  System.out.println("Test31 in SampleThree..."+id);
	  }
	  @Test
	  public void testTwo() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test32 in SampleThree..."+id);
	  }
	  @Test
	  public void testThree() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test33 in SampleThree..."+id);
	  }
	  @Test
	  public void testFour() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test34 in SampleThree..."+id);
	  }
}
