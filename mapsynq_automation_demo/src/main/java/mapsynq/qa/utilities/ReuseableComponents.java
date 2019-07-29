package mapsynq.qa.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mapsynq.qa.testbase.BaseClass;

public class ReuseableComponents extends BaseClass {
	
	public static void clickElement(WebDriver driver, WebElement element)
	{
		element.click();
	}
	
	public static void clearElementandEnterText(WebDriver driver, WebElement element,String text) 
	{
		element.clear();
		element.sendKeys(text);
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


