package mapsynq_automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mapsynq.qa.pageobjects.MapsynqLandingPage;
import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.ReuseableComponents;

public class LandingPage extends BaseClass {
	
	MapsynqLandingPage mapLanding;
	String thread;
	
	public LandingPage()
	{
		super();
	}
	
//	@BeforeTest
//	public void start() 
//	{
//		startTest("MapsynqLandingPage");
//	}
	
	@BeforeMethod
	public void initilasation() {
		startTest("MapsynqLandingPage");
		//logger = report.startTest("MapsynqLandingPage");
		init();
		
		mapLanding = new MapsynqLandingPage();		
	}
	
	@Test
	public void GetElementAndValidate()
	{
		//ReuseableComponents.wait(thread, 1);
		hideAdd();
		mapLanding.getElement();
	}
	
	@AfterMethod
	public void close()
	{
		dr.quit();
		report.endTest(logger);
		endReport();
	}
	
//	@AfterTest
//	public void end() 
//	{
//		endReport();
//	}
	
}
