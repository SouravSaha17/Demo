package mapsynq.qa.utilities;

import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import mapsynq.qa.testbase.BaseClass;



public class ReuseableComponents extends BaseClass {
	
	public static void clickElement(WebElement element, String desc)
	{
		element.click();
		logger.log(LogStatus.PASS, desc);
	}
	
	public static void clearElementandEnterText(WebElement element,String text, String desc) 
	{
		element.clear();
		element.sendKeys(text);
		logger.log(LogStatus.PASS, desc);
	}
	
	public static String getTextValue(WebElement element, String desc)
	{
		String Value;
		Value = element.getText();
		System.out.println(Value);
		logger.log(LogStatus.PASS, desc);
		return Value;
		
	}
	
	public static String getAttributeValue(WebElement element, String name, String desc)
	{
		String Value;
		Value = element.getAttribute(name);
		System.out.println(Value);
		logger.log(LogStatus.PASS, desc);
		return Value;
	}
	
	public static void wait(String type, int time)
	{
		try
		{
			//System.out.println("inside"+param3);
			//String S = value;
			//System.out.println(S);
			//long time = (long)Double.parseDouble(S);
			//System.out.println(num);
			WebDriverWait wait = new WebDriverWait(dr, time);
			switch(type)
			{
			case"thread": Thread.sleep(time*1000); 
						  break;
							
			case"implicitwait": dr.manage().timeouts().implicitlyWait(time*100, TimeUnit.SECONDS);
								break;
								
//			case"explicitwaitxpath": wait.until(ExpectedConditions.presenceOfElementLocated(element);
//							    break;
//							    
//			case"explicitwait1": int count = dr.getWindowHandles().size() + 1;
//								  wait.until(ExpectedConditions.numberOfWindowsToBe(count));
//								  break;
//								  
//			case"explicitwaitname": wait.until(ExpectedConditions.presenceOfElementLocated(By.name(OR.getProperty(param2))));
//		    						break;
//		    						
//			case"explicitwaitid": wait.until(ExpectedConditions.presenceOfElementLocated(By.id(OR.getProperty(param2))));
//									break;
//								  
//			case"explicitwaitlinktext": wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(OR.getProperty(param2))));
//										 break;
			}
			
			//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			
		}
		catch(Exception e)
		{
//			String Snapshot = Take_screenshot.capturescreen(driver, param5);
//			String image = logger.addScreenCapture(Snapshot);
//			logger.log(LogStatus.FAIL, param5, image);
		}
	}
	
	
	public static void dropdown(WebElement element, String type, String dropdown_value, String desc)
	{
		try
		{
			switch(type)
			{
			case"value":
				Select obj = new Select(element);
				obj.selectByValue(dropdown_value);
				break;

			case"visibletext":
				Select obj1 = new Select(element);
				obj1.selectByVisibleText(dropdown_value);
				break;

			case"index":
				int index = Integer.parseInt(dropdown_value);
				Select obj2 = new Select(element);
				obj2.selectByIndex(index);
				break;

			}
			//Select obj = new Select(driver.findElement(By.name(OR.getProperty(param2))));
			//obj.selectByValue(OR.getProperty(param3));

			logger.log(LogStatus.PASS, desc);
		}
		catch(Exception e)
		{
			
		}
	}
	
	public static void dateSelector(String date_value)
	{
			//System.out.println("test");
			List<WebElement> Col1 = dr.findElements(By.tagName("td"));
			//System.out.println(Col1);
			//System.out.println("test1");
			for(WebElement cell2 : Col1)
			{
				// System.out.println(cell2.getText());
				//System.out.println("test2");
				//String date = OR.getProperty(param3);
				if(cell2.getText().equals(date_value))
				{
					//System.out.println(cell2.getText());
					//System.out.println("test3");
					cell2.click();
					//System.out.println("test4");
					break;
				}

			}			
		}
	
	
	public static String capturescreen(WebDriver driver, String screenshotname)

    {

    try

    {

                    TakesScreenshot scr = (TakesScreenshot) driver;

                    File source = scr.getScreenshotAs(OutputType.FILE);

                    String destin = "P:\\CMT\\Screenshots\\" + screenshotname + ".png";

                    File destination = new File(destin);

                    FileUtils.copyFile(source, destination);

                    System.out.println("Screenshot taken" +screenshotname );

                   

                    return destin;

    }

    catch(Exception e)

    {

                    System.out.println("Error message" + e.getMessage());

    }

    return "";

    }

}


