package mapsynq.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseClass {

	static Properties prop;
	static WebDriver dr;
	
	public BaseClass()
	{
		prop = new Properties();
		FileInputStream file=null;
		try {
			file = new FileInputStream(".//src/test/resources/application.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void init()
	{
		try

        {
		String Browser = prop.getProperty("Browser_Name");
		
		switch(Browser)
		{
		case "IEBrowser":

        {

                        System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\IEDriverServer.exe");



                        DesiredCapabilities caps = new DesiredCapabilities();

                        caps.setCapability(

    InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,

    true);

    

                        caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,

    true);



                        dr = new InternetExplorerDriver(caps);
                        dr.manage().window().maximize();
                        dr.manage().deleteAllCookies();

                       break;

        }  
        
		case "Chrome":
		
		{

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");
                       

                        

                   // dr = new ChromeDriver();

                    ChromeOptions options = new ChromeOptions();

                          options.addArguments("disable-extensions");

                       

                          options.addArguments("start-maximized");

                       

                         

                          options.addArguments("--disable-popup-blocking");

                          options.addArguments("--disable-default-apps");

                         // options.addArguments("--headless","--disable-gpu");

                         

                       

                          options.addArguments("disable-infobars");

                          

                          //DesiredCapabilities caps = DesiredCapabilities.chrome();

                          //caps.setCapability(ChromeOptions.CAPABILITY, options);

                          dr = new ChromeDriver(options);

                          //driver = new RemoteWebDriver(new URL(Node), caps);
			break;

        }
		
		
	}
		dr.get(prop.getProperty("URL"));
        }
		
		catch(Exception e)
		{
			
		}

}
}
