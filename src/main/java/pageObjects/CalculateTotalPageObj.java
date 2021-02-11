package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class CalculateTotalPageObj extends Base{
	
	
	public CalculateTotalPageObj () {
		PageFactory.initElements(driver, this);
	}
	
	//element pool
	
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr[1]/td[5]")
	private WebElement unitPrice;
	
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr[1]/td[6]")
	private WebElement totalPrice;
	
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr[1]/td[4]//input")
	private WebElement quantity;
	
	@FindBy(xpath = "//div[@class='panel-heading']//a[contains(text(),'Use Coupon Code ')]")
	private WebElement useCouponCode;
	
	@FindBy(xpath = "//label[contains(text(),'Enter your coupon here')]")
	private WebElement enterCouponHere;
	
	@FindBy(xpath = "//input[@id='button-coupon']")
	private WebElement applyCouponButton;
	
	@FindBy(xpath = "//h4[@class='panel-title']/a[@class='accordion-toggle']")
	private WebElement useCouponHereButton;
	//methods
	
	public boolean isTotalCorrect() {
		
		double price = Double.parseDouble(unitPrice.getText().substring(1));
		double total = Double.parseDouble(totalPrice.getText().substring(1));
		int quantityOfItems = Integer.parseInt(quantity.getAttribute("value"));
		
		
		if(quantityOfItems*price==total)
			return true;
		else
			return false;
		}
		
	
	public boolean verifyCouponInfo() {
		if(useCouponCode.isDisplayed() &&
			enterCouponHere.isDisplayed() &&
			applyCouponButton.isDisplayed())
			return true;
		else
			return false;
	}
		
	public void clickUseCouponHereButton() {
		useCouponHereButton.click();
		
	}
	public String getCouponText() {
		String getText= enterCouponHere.getText();
		return getText;
	}
		
		
}
	


