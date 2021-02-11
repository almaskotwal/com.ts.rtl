package stepDefinitions;

import org.junit.Assert;

import core.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AddToShoppingCartPageObj;
import pageObjects.AddToWishListPageObj;
import pageObjects.LoginPageObj;
import pageObjects.RemoveFromWishlistPageObj;
import utilities.WebDriverUtility;

public class AddRemoveFromWishListStepDefinition extends Base{
	
	LoginPageObj loginPageObj = new LoginPageObj();
	AddToWishListPageObj addToWishList = new AddToWishListPageObj();
	AddToShoppingCartPageObj addToCart = new AddToShoppingCartPageObj();
	RemoveFromWishlistPageObj removeFromWishlist = new RemoveFromWishlistPageObj();
	
	@Given("^User is on Retail Page$")
	public void user_is_on_Retail_Page() throws Throwable {
		Base.initializeDriver();
		logger.info("Retail page is opened");
		String actualPageTitle = addToWishList.getPageTitle();
		String expectedPageTitle = "TEK SCHOOL";
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
		logger.info("Page title  is verified");
		WebDriverUtility.screenShot();
	}

	@And("^User logs in with '(.+)' and '(.+)'$")
	public void user_logs_in(String email, String password) throws Throwable {
		
		loginPageObj.clickOnMyAccount();
		loginPageObj.clickonLoginButton();
		addToWishList.login(email, password);
		loginPageObj.clickOnLogin();
		logger.info("User logs in");
		WebDriverUtility.screenShot();
		//WebDriverUtility.acceptAlert();
}		
	@And("^User clicks moves mouse over Desktops menu$")
	public void user_clicks_moves_mouse_over_Desktops_menu() throws Throwable {
		addToCart.hoverOverDesktops();
	    logger.info("Mouse moves over Desktops menu");
	    WebDriverUtility.wait(3000);
	    WebDriverUtility.screenShot();
	}
	
	@Then("^User clicks on iMac?")
	public void user_clicks_on_iMac() throws Throwable{
		addToWishList.clickMac();
		logger.info("click on iMac");
		WebDriverUtility.screenShot();
	}
	
	@When("^User clicks on the heart icon$")
	public void user_clicks_on_the_heart_icon() throws Throwable {
		addToWishList.clickHeartButton();
		logger.info("click on heart button");
		WebDriverUtility.screenShot();
		WebDriverUtility.wait(3000);
	}
	
	@Then("^User should see the message '(.+)'$")
	public void user_should_see_the_message_Success(String message) throws Throwable {
		 	String expectedMessage = message;
		    String actualMessage = addToWishList.getSuccessMessage();
		    Assert.assertTrue(actualMessage.contains(expectedMessage)); 
		    logger.info("Verfiy page title");
		    WebDriverUtility.screenShot();
	}
	
	@When("^User clicks on the Wish List button$")
	public void user_clicks_on_the_Wish_List_button() throws Throwable {
	    addToWishList.clickWishListButton();
	    WebDriverUtility.screenShot();
	    WebDriverUtility.wait(2000);
	}
	
	@When("^User sees iMac listed there$")
	public void user_sees_iMac_listed_there() throws Throwable {
		Assert.assertTrue(removeFromWishlist.isiMacLinkDisplayed());
		logger.info("Verifying if iMac link exists in Wishlist");
		WebDriverUtility.screenShot();
	}
	
	@Then("^User clicks on the red X button$")
	public void user_clicks_on_the_red_X_button() throws Throwable {
		removeFromWishlist.clickOnRemoveButton();
		logger.info("Clicking remove from Wishlist");
		Thread.sleep(3000);
		WebDriverUtility.screenShot();
	}
	
	@Then("^User clicks yes in the confirmation box$")
	public void user_clicks_yes_in_the_confirmation_box() throws Throwable {
		   Assert.assertTrue(removeFromWishlist.isWishListEmpty());
			WebDriverUtility.screenShot();

	}
	}
