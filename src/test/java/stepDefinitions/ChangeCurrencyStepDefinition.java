package stepDefinitions;

import org.junit.Assert;
import core.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.ChangeCurrencyPageObj;
import utilities.WebDriverUtility;

public class ChangeCurrencyStepDefinition extends Base {

	ChangeCurrencyPageObj changeCurrency = new ChangeCurrencyPageObj();
	
	@Given("^User is on retail environment home page$")
	public void user_is_on_retail_environment_home_page() throws Throwable {
		Base.initializeDriver();
		logger.info("Retail page is opened");
		String actualPageTitle = changeCurrency.getPageTitle();
		String expectedPageTitle = "TEK SCHOOL";
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
		logger.info("Page title  is verified");
		WebDriverUtility.screenShot();
	}

	@When("^User changes selects a currency$")
	public void user_changes_selects_a_currency() throws Throwable {
		changeCurrency.clickOnCurrency();
		changeCurrency.selectCurrency();
	}
	@Then("^User selects item from Deskops menu$")
	public void user_selects_item_from_Deskops_menu() throws Throwable {
	    changeCurrency.hoverOverDesktops();
	    changeCurrency.clickDesktopsMenu();
	    WebDriverUtility.wait(3000);
	    changeCurrency.clickMac();
	    logger.info("Mac is selected from menu");
	    WebDriverUtility.screenShot();
	}

	@Then("^User verifies price is changed to different currency$")
	public void user_verifies_price_is_changed_to_different_currency() throws Throwable {
	    Assert.assertTrue(changeCurrency.isCurrencySignDisplayed());
	}

	
}
