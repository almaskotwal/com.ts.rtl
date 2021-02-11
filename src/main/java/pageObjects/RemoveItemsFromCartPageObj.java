package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class RemoveItemsFromCartPageObj extends Base{

public RemoveItemsFromCartPageObj() {
		
		PageFactory.initElements(driver, this);
	}
	
	//elements 
	
	@FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle'] ")
	private WebElement itemsButton;
	
	@FindBy(xpath = "//strong[text()=' View Cart']] ")
	private WebElement viewCartButton;
	
	@FindBy(xpath = "//table[@class='table table-bordered']//td/a/text()")
	private WebElement iMacInCart;
	
	@FindBy(xpath = "//table[@class='table table-bordered']//tr/td//button[2]")
	private WebElement removeItemButton;
	
	@FindBy(xpath = "//span[text()='Shopping Cart']")
	private WebElement shoppingCartButton;
	
	@FindBy(xpath = "//div[@id='content']//p")
	private WebElement cartIsEmptyMessage;
	
	
	//Methods
	
	public void clickOnShoppingCart() {
		shoppingCartButton.click();
	}
	public boolean clickOnItemsButton() {
		if(viewCartButton.isDisplayed())
			return true;
		else
			return false;	
		}
	
	public void clickOnViewCart() {
		viewCartButton.click();
	}
	
	public boolean isIMacInCart() {
		if(iMacInCart.isDisplayed())
			return true;
		else
			return false;
	}
	public void removeMac() {
		removeItemButton.click();
	}
	
	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public boolean isCartEmptyMessageDisplayed() {
		if(cartIsEmptyMessage.isDisplayed())
			return true;
		else
			return false;
	}
	
}
