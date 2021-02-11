package pageObjects;


import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.WebDriverUtility;

public class AddToWishListPageObj extends Base{
	public AddToWishListPageObj() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//nav[@id='menu']/div[2]/ul/li[1]/div/div/ul/li")
	private List<WebElement> listOfDesktopItems;
	
	@FindBy(xpath = "//a[@id='wishlist-total']//span")
	private WebElement wishListButton;
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailField;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='button-group']/button[2]")
	private WebElement heartButton;
	
	@FindBy(xpath = "//div/div[contains(text(), 'Success: You have added ')]")
	private WebElement successMessage;
	
	//methods
	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public void login(String email, String password) {
		WebDriverUtility.clickOnElement(emailField);
		emailField.sendKeys(email);
		WebDriverUtility.clickOnElement(passwordField);
		passwordField.sendKeys(password);
	}
	
	public void clickHeartButton() {
		WebDriverUtility.clickOnElement(heartButton);
	}
	
	public String getSuccessMessage() {
		String actualMessage = successMessage.getText();
		return actualMessage;
	}
	
	public void clickWishListButton() {
		wishListButton.click();
	}
	public void clickMac() {
		for(WebElement items : listOfDesktopItems) {
			try {
			if(items.getText().trim().contains("Mac")) {
				WebDriverUtility.moveToElementAction(items);
				WebDriverUtility.wait(3000);
				WebDriverUtility.clickOnElement(items);
				WebDriverUtility.wait(5000);

			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			}
		}
	}
}
