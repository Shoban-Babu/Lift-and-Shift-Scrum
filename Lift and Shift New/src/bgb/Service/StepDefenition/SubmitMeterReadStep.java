package bgb.Service.StepDefenition;

import bgb.CommonProperties.BrowserProperties;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import bgb.Service.Page.LoginPage;
import bgb.Service.Page.SubmitMeterReadPage;

public class SubmitMeterReadStep{
		
	
	@Given("^I launch the application$")
    public void I_launch_the_application() throws Throwable
	{
			System.out.println("i am launching the application");	
			LoginPage login = new LoginPage();
			login.login_verify();		
	}
	
	@Given("^I am login with the credentials") 
	public void I_navigate_to_accountoverview() 
	{
		LoginPage login = new LoginPage();
		login.login_to_account_overview();
	}

	@When("^I should navigate to account summary page$")
	public void I_launch_the_application1() 
	{
		SubmitMeterReadPage smr = new SubmitMeterReadPage();
		smr.Click_SMR_Link();
	 
	}

	@Then("^I should verify the submit meter read landing page$")
	public void I_launch_the_application2()
	
	 {
	    // Write code here that turns the phrase above into concrete actions
		SubmitMeterReadPage smr = new SubmitMeterReadPage();
		smr.verify_SMR_Page();
	}	   
	
		
	
}
