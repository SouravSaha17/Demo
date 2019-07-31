package mapsynq.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.common.base.Verify;


import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.ReuseableComponents;

public class MapsynqLiveIncidents extends BaseClass {

	/*@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement passWord;*/
	
	
	
	@FindBy(xpath="//*[@id='news_menu']/div[1]/label[1]/span/h2")
	WebElement incident_btn;
	
	@FindBy(xpath="//*[@id='Incidents0']/div/div[2]")
	WebElement incident;
	
	@FindBy(xpath="//*[@id='Incidents0']/div/div[2]")
	WebElement incident_value;
	
	@FindBy(xpath="//*[@id='Incidents0']/div/div[2]")
	WebElement incident_value_map;
	
//	@FindBy(xpath="//*[@id='ad_toggle']")
//	WebElement add_move;
	
	public void clickIncident()
	{	
		
		//ReuseableComponents.waitForElement(dr,incident_btn,10);
		//logs.info("Entered user name=" +name);
		//ReuseableComponents.clearElementandEnterText(dr, userName, name);
		ReuseableComponents.clickElement(incident_btn, "Click incident button");
		ReuseableComponents.clickElement(incident, "Click incident");
		String expectedvalue = ReuseableComponents.getTextValue(incident_value, "Get incident text value");		
		String actualvalue = ReuseableComponents.getTextValue(incident_value_map, "Get incident text value from map");
		Assert.assertEquals(expectedvalue, actualvalue);
	}
	
//	public void hideAdd()
//	{	
//		ReuseableComponents.clickElement(add_move);
//		
//	}
	
	public  MapsynqLiveIncidents()
	{
		PageFactory.initElements(dr, this);
	}


}

