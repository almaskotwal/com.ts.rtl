package pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import core.Base;
public class MyAccountPageObj extends Base {
	public MyAccountPageObj() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//h2[contains(text(),'My Account')]")
	private WebElement myAccountText;
	@FindBy(xpath = "//h2[contains(text(),'My Orders')]")
	private WebElement myOrdersText;
	@FindBy(xpath = "(//a[text()= 'Logout'])[1]")
	private WebElement logOutButton;
	@FindBy(xpath = "//h1[text()= 'Account Logout']")
	private WebElement LogOutConfirmationText;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'You have been logged off your account. It is now safe to leave the computer.')]")
	private WebElement logoutMessageFirstLine;
	@FindBy(how = How.XPATH, using = "//p[contains(text(), 'Your shopping cart has been saved, the items inside it will be restored whenever you log back into your account.')]")
	private WebElement logoutMessageSecondLine;
	
	
	
	public boolean isMyAccountDisplayed() {
		if (myAccountText.isDisplayed())
			return true;
		else
			return false;
	}
	public boolean isMyOrdersDisplayed() {
		if (myOrdersText.isDisplayed())
			return true;
		else
			return false;
	}
	public void clickOnLogOut() {
		logOutButton.click();
	}
	public boolean isLogOutConfirmationTextDisplayed() {
		if (LogOutConfirmationText.isDisplayed())
			return true;
		else
			return false;
	}
	
	public boolean isLogoutMessageOneDisplayed() {
		if(logoutMessageFirstLine.isDisplayed())
			return true;
		else
			return false;
	}
	
	public boolean isLogoutMessageTwoDisplayed() {
		if(logoutMessageFirstLine.isDisplayed())
			return true;
		else
			return false;
	}
	
}