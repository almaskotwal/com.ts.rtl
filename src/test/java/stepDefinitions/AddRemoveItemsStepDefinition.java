package stepDefinitions;

import org.junit.Assert;

import core.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AddToShoppingCartPageObj;
import pageObjects.CalculateTotalPageObj;
import pageObjects.RemoveItemsFromCartPageObj;
import utilities.WebDriverUtility;

public class AddRemoveItemsStepDefinition extends Base {
	
	AddToShoppingCartPageObj addToCart = new AddToShoppingCartPageObj();
	RemoveItemsFromCartPageObj removeFromCart = new RemoveItemsFromCartPageObj();
	CalculateTotalPageObj calculateTotal = new CalculateTotalPageObj();
	
	// Background methods
	@Given("^User is on Retail page$")
	public void user_is_on_Retail_page() throws Throwable {
		Base.initializeDriver();
		logger.info("Retail page is opened");
		String actualPageTitle = addToCart.getPageTitle();
		String expectedPageTitle = "TEK SCHOOL";
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
		logger.info("Page title  is verified");
		WebDriverUtility.screenShot();
	}

	@When("^User clicks moves mouse to Desktops menue$")
	public void user_clicks_moves_mouse_to_Desktops_menue() throws Throwable {
	    addToCart.hoverOverDesktops();
	    logger.info("Mouse moves over Desktops menu");
	    WebDriverUtility.wait(3000);
	    WebDriverUtility.screenShot();
	}

	@Then("^User clicks on the iMac$")
	public void user_clicks_on_iMac() throws Throwable {
		addToCart.clickMac();
	   logger.info("iMac clicked");
	   WebDriverUtility.screenShot();
	}

	@Then("^User click on Add To Cart button$")
	public void user_click_on_Add_To_Cart_button() throws Throwable {
		addToCart.clickOnAddToCart();
		logger.info("Add To Cart clicked");
	    WebDriverUtility.screenShot();

	}

	// methods belonging to Add to Cart scenario 
	@Then("^Verify Success Message '(.+)'$")
	public void verify_Success_Message_Success_You_have_added_iMac_to_your_shopping_cart(String message) throws Throwable {
	    String expectedMessage = message;
	    String actualMessage = addToCart.getSuccessMessage();
	    Assert.assertTrue(actualMessage.contains(expectedMessage)); // ?
	    logger.info("Verfiy page title");
	    WebDriverUtility.screenShot();
	}

	
	@Then("^verfiy total is calculated correctly$")
	public void verfiy_total_is_calculated_correctly() throws Throwable {
		removeFromCart.clickOnShoppingCart();
		Assert.assertTrue(calculateTotal.isTotalCorrect());
	    logger.info("verfiy total is calculated correctly");
	    WebDriverUtility.screenShot();
	}
	
	//FIX THIS METHOD. iT IS FAILING
	@Then("^verfity coupon text says \"([^\"]*)\"$")
	public void verfity_coupon_text_says(String expectedCouponText) throws Throwable {
		calculateTotal.clickUseCouponHereButton();
		String actualCouponText = calculateTotal.getCouponText();
		Assert.assertEquals(expectedCouponText, actualCouponText);
		logger.info("verifying coupon text");
		WebDriverUtility.screenShot();
	}
	
	// methods belonging to Remove from Cart scenario 
	@Then("^User click on Shopping Cart Button$")
	public void user_click_on_Shopping_Cart_Button() throws Throwable {
	    removeFromCart.clickOnShoppingCart();
	    logger.info("Click on Shopping Cart button");
	    WebDriverUtility.screenShot();

	}

	@Then("^User clicks on Remove Item button$")
	public void user_clicks_on_Remove_Item_button() throws Throwable {
	   removeFromCart.removeMac();
	   logger.info("Click red Remove Item button");
	   WebDriverUtility.screenShot();
	}
	
	// THE FOLLOWING STEP FAILS AND DEFECT NEEDS TO BE RAISED TO DEV TEAM
	@Then("^User confirms removal of item by clicking Yes from dialogue box$")
	public void user_confirms_removal_of_item_by_clicking_Yes_from_dialogue_box() throws Throwable {
	   Assert.assertTrue(removeFromCart.isCartEmptyMessageDisplayed()); 
	   logger.info("Verify whether confirmation dialog box appears");
	}
}
