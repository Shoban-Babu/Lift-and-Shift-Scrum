package bgb.CommonProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import bgb.CommonProperties.PropertyLoader;
import bgb.CommonProperties.BasePage;

public class BrowserProperties extends BasePage{

	private final static String CONFIG_FILE_NAME = "BGB/CommonProperties/Dev.properties";;
	private static Properties pageProperties = new PropertyLoader(CONFIG_FILE_NAME).load();

	@BeforeClass
	public void getWebdriver()
	{
		if(browser==null)
			System.out.println(pageProperties.getProperty("Common.browser"));
		{
			if(pageProperties.getProperty("Common.browser").equalsIgnoreCase("firefox"))
			{
				System.out.println("I am in For Webdriver Firefox");
				browser =new FirefoxDriver();
				browser_operations();
				browser.get(pageProperties.getProperty("Common.BGBURL"));
			}
			
			else if(pageProperties.getProperty("Common.browser").equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "D://FireFox - Selenium Add -Ons//chromedriver.exe");
				browser =new ChromeDriver();
				browser_operations();
				browser.get(pageProperties.getProperty("Common.BGBURL"));
			}
			
			else if(pageProperties.getProperty("Common.browser").equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver", "D://FireFox - Selenium Add -Ons//chromedriver.exe");
				browser =new InternetExplorerDriver();
				browser_operations();
				browser.get(pageProperties.getProperty("Common.BGBURL"));
			}
		}
	}
	
	public static void browser_operations()
	{
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}
}
