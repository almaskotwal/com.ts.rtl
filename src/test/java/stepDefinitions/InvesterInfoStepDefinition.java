package stepDefinitions;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import core.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.ViewQ1ReportPageObj;
import utilities.WebDriverUtility;



public class InvesterInfoStepDefinition extends Base {
	
	Set<String> windowHandles;
	Iterator<String> iterator;
	
	ViewQ1ReportPageObj viewReports = new ViewQ1ReportPageObj();
	
	@Given("^user is on AIMCO home page$")
	public void user_is_on_AIMCO_home_page() throws Throwable {
		Base.initializeDriver();
		
	}

	@Then("^user clicks on Investor Info button$")
	public void user_clicks_on_Investor_Info_button() throws Throwable {
		viewReports.clickOnInvestorInfo();
	}

	@And("^user clicks on Filings and Financials dropdown$")
	public void user_clicks_on_Filings_and_Financials_dropdown() throws Throwable {
		
		windowHandles = driver.getWindowHandles();
		iterator = windowHandles.iterator(); 
			String main= iterator.next();
			String investor = iterator.next();
			
				driver.switchTo().window(investor);
				viewReports.moveToFinancialFiling();
	}

	@Then("^user clicks on quarterly earning reports$")
	public void user_clicks_on_quarterly_earning_reports() throws Throwable {
		WebDriverUtility.wait(3000);
		viewReports.clickQuarterlyEarnings();
	}

	@And("^user clicks on the Twenty Twenty earning releases$")
	public void user_clicks_on_the_earning_releases() throws Throwable {		
		
	}

	@Then("^user clicks on first quarter earning report$")
	public void user_clicks_on_first_quarter_earning_report() throws Throwable {
		viewReports.clickFirstQuarter();
		String reportsWindow = iterator.next();
			driver.switchTo().window(reportsWindow);
			WebDriverUtility.wait(5000);
			viewReports.clickDownload();
				
		
	}

	
}
