package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;


public class RemoveFromWishlistPageObj extends Base {
public RemoveFromWishlistPageObj() {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr//td[2]")
	private WebElement iMacLink;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody//td[6]/a")
	private WebElement removeButton;
	
	@FindBy(xpath = "//p[contains(text(),'Your wish list is empty.')]")
	private WebElement wishListEmptyMessage;
	
	
	//methods
	
	public boolean isiMacLinkDisplayed() {
		if(iMacLink.isDisplayed())
			return true;
		else
			return false;
	}
	
	public void clickOnRemoveButton() {
		removeButton.click();
	}
	
	public boolean isWishListEmpty() {
		if(wishListEmptyMessage.isDisplayed())
			return true;
		else
			return false;
	}
	
}
