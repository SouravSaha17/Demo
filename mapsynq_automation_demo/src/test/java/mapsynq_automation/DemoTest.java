package mapsynq_automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mapsynq.qa.pageobjects.MapsynqLiveIncidents;
import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.ReuseableComponents;

public class DemoTest extends BaseClass {
	MapsynqLiveIncidents mapLive;
	String thread;
	
	public DemoTest() {
		super();
	}
	
	
//	@BeforeTest
//	public void start() 
//	{
//		startTest("MapsynqLiveIncidents");
//	}


	@BeforeMethod
	public void initilasation() 
	{
		startTest("MapsynqLiveIncidents");
		init();		
		mapLive=new MapsynqLiveIncidents();
	}


	@Test
	public void ClickandValidateIncident()
	{
		System.out.println("first test");
		//mapLive.hideAdd();
		ReuseableComponents.wait(thread, 1);
		hideAdd();
		mapLive.clickIncident();
	}
	
	@AfterMethod
	public void close()
	{
		dr.quit();
		endReport();
	}
	
//	@AfterTest
//	public void end() 
//	{
//		endReport();
//	}
}
