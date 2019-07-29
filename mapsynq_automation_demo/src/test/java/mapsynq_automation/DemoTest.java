package mapsynq_automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mapsynq.qa.testbase.BaseClass;

public class DemoTest extends BaseClass {
	
	public DemoTest() {
		super();
	}
	
	
	@BeforeMethod
	public void initilasation() {
		init();
		
	}
  @Test
  public void f() {
	  System.out.println("first test");
  }
}
