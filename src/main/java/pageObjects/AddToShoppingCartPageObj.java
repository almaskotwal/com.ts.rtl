package pageObjects;

import java.util.List;


import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.WebDriverUtility;

public class AddToShoppingCartPageObj extends Base {

	public AddToShoppingCartPageObj() {
		
		PageFactory.initElements(driver, this);
	}
	
	//elements 
	
	@FindBy(xpath = "//a[text()='Desktops']")
	private WebElement desktopsDropdown;
	
	@FindBy(xpath = "//nav[@id='menu']/div[2]/ul/li[1]/div/div/ul/li")
	private List<WebElement> listOfDesktopItems;
	
	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//a[contains(text(),'iMac')]")
	private WebElement iMacLink;
	
	@FindBy(xpath = "//a[contains(text(),'shopping cart')]")
	private WebElement shoppingCartLink;
	
	@FindBy(xpath = "//div/div[contains(text(), 'Success: You have added ')]")
	private WebElement successMessage;
	
	
	//methods
	
	public void hoverOverDesktops() {
		WebDriverUtility.moveToElementAction(desktopsDropdown);
	}
	
	public void clickDesktopsMenu() {
		WebDriverUtility.clickOnElement(desktopsDropdown);
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
	
	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public void moveMouseToDesktops() {
		WebDriverUtility.moveToElementAction(desktopsDropdown);
	}
	
	public void clickOnAddToCart() {
		WebDriverUtility.clickElementWithJS(addToCartButton);
	}
	
	public boolean checkiMacLink() {
		if(iMacLink.isDisplayed())
			return true;
		else
			return false;
	}
	
	public boolean checkShoppingCartLink() {
		if(iMacLink.isDisplayed())
			return true;
		else
			return false;
	}
	
	public String getSuccessMessage() {
		String actualMessage = successMessage.getText();
		return actualMessage;
	}
	
	
}