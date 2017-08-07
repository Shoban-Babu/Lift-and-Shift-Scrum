package bgb.Service.Page;

import java.util.Properties;

import bgb.CommonProperties.BasePage;
import bgb.CommonProperties.PropertyLoader;

public class SubmitMeterReadPage extends BasePage
{
	//private final static String File_Get = "BGB/CommonProperties/Dev.properties";
	//private static Properties pageProperties = new PropertyLoader(File_Get).load();
	
	private final static String File_load = "BGB/Service/Properties/SubmitMeterReadPageProperties";
	private static Properties SMRproperties = new PropertyLoader(File_load).load();

	
	public void Click_SMR_Link()
	{
		browserWait(5000);
		verifyAndClickwithXpath(SMRproperties.getProperty("SMR.Link"),"Submit Meter Read Link");
		
	}
	
	public void verify_SMR_Page()
	{		
		browserWait(5000);
		System.out.println("i in SMR page");
	}
}

