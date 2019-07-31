package mapsynq_automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mapsynq.qa.pageobjects.MapsynqRegisterPage;
import mapsynq.qa.testbase.BaseClass;

public class RegisterForm extends BaseClass {
	
	MapsynqRegisterPage mapRegister;
	
	public RegisterForm() {
		super();
	}

	@BeforeMethod
	public void initilasation() 
	{
		//startTest("MapsynqRegisterPage");
		logger = report.startTest("MapsynqRegisterPage");
		init();		
		mapRegister=new MapsynqRegisterPage();
	}


	@Test
	public void CreateNewProfile() throws InterruptedException
	{
		System.out.println("first test");
		//mapLive.hideAdd();
		//ReuseableComponents.wait(thread, 1);
		hideAdd();
		mapRegister.formFill();
	}
	
	@AfterMethod
	public void close()
	{
		dr.quit();
		report.endTest(logger);
		//endReport();
	}
	
}
