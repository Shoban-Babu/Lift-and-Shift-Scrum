package CucumberProperties;

import java.io.File;
import java.util.Properties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import Listener.Reporter;
import bgb.CommonProperties.BrowserProperties;
import bgb.CommonProperties.PropertyLoader;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Feature_File/SubmitMeterRead.feature",
                  glue={"bgb/Service/StepDefenition"},
                  plugin={//"pretty","html:D:/Automation WorkSpace/Lift and Shift New/Lift and Shift New/Cucmber Results/cucumber-json.json",
                         "Listener.ExtentCucumberFormatter:D:/Automation WorkSpace/Lift and Shift New/Lift and Shift New/test-output/Cucmber-ExtendReport/reportdate.html"},
                  tags = {"@Errorscenario" }
                   )       		
public class CucumberRunner {
	
	private final static String CONFIG_FILE_NAME = "BGB/CommonProperties/Dev.properties";;
	private static Properties pageProperties = new PropertyLoader(CONFIG_FILE_NAME).load();
	
	@BeforeClass
	public static void startbowser()
	{
		
		BrowserProperties bp = new BrowserProperties();
		bp.getWebdriver();
				
	}
	@AfterClass
	public static void reportsetup()
	
		{
		Reporter.loadXMLConfig(new File("src/CucumberProperties/extent-config.xml"));
		System.out.println("I am in For picking User Details");
		
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("Directory",System.getProperty("user.dir"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("OS", "Windows OS");
        Reporter.setSystemInfo("Browser", pageProperties.getProperty("Common.browser"));
        Reporter.setSystemInfo("JAVA", "1.8.0_131");
        Reporter.setSystemInfo("Frame Work", "Cucmber With Junit");       
        Reporter.setTestRunnerOutput("Sample test runner output message");
	}
	
}
