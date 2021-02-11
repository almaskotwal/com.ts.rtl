package stepDefinitions;

import org.junit.Assert;

import core.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.CanvasLoginPageObj;
import utilities.WebDriverUtility;

public class CanvasLoginStepDefinition extends Base {

	CanvasLoginPageObj canvasLoginPageObj = new CanvasLoginPageObj();
	
	@Given("^User is on the canvas website$")
	public void user_is_on_the_canvas_website() throws Throwable {
		Base.initializeDriver();
		logger.info("Canvas login page is opened");
		String actualPageTitle = canvasLoginPageObj.getPageTitle();
		String expectedPageTitle = "Log In to Canvas";
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
		logger.info("Page title  is verified");
		WebDriverUtility.screenShot();
	}
	@And("^User enters username '(.+)' and password '(.+)'$")
	public void user_enters_username_and_password(String userName, String password) throws Throwable {
		canvasLoginPageObj.enterCredentials(userName, password);
		logger.info("verify user enters credentials");
		WebDriverUtility.screenShot();
	}

	@And("^User clicks on submit button$")
	public void user_clicks_on_submit_button() throws Throwable {
		canvasLoginPageObj.clickLogin();
		logger.info("user clicks login");
		WebDriverUtility.screenShot();
	}

	@Then("^User should be on canvas dashboard$")
	public void user_should_be_on_canvas_dashboard() throws Throwable {
		canvasLoginPageObj.verifyDashboard();
		canvasLoginPageObj.closPopUp();
		WebDriverUtility.wait(5000);
		canvasLoginPageObj.closeSecondPopUp();
	}
	
	@Given("^User is dashboard$")
	public void user_is_dashboard() throws Throwable {
		canvasLoginPageObj.verifyDashboard();
		logger.info("verfiy dashboard");
	    canvasLoginPageObj.closPopUp();
		WebDriverUtility.wait(5000);
		canvasLoginPageObj.closeSecondPopUp();
	}

	@And("^User clicks on a current class$")
	public void user_clicks_on_a_current_class() throws Throwable {
	    canvasLoginPageObj.clickCurrentClass();
	    logger.info("Click on class");
	    WebDriverUtility.screenShot();
	}

	@Then("^Verify user is inside the current class$")
	public void verify_user_is_inside_the_current_class() throws Throwable {
		canvasLoginPageObj.isHomeButtonDisplayed();
	    logger.info("verfiy home button exists");
	    WebDriverUtility.screenShot();
	}
	
	@And("^User clicks on file$")
	public void user_clicks_on_file() throws Throwable { 
		canvasLoginPageObj.clickFile();
	}
	
	@Then("^User clicks on course image$") 
	public void user_clicks_on_courseImage() throws Throwable {
		canvasLoginPageObj.clickCourseImage();
	}
}
