package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.Base;
import utilities.WebDriverUtility;

public class CanvasLoginPageObj extends Base{
	
	public CanvasLoginPageObj() {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "pseudonym_session_unique_id")
	private WebElement email;
	
	@FindBy(xpath= "//input[@id='pseudonym_session_password']")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"login_form\"]/div[3]/div[2]/button")
	private WebElement loginButton;
	
	@FindBy(how = How.ID, using = "global_nav_profile_link")
	private WebElement accountButton;

	 
	@FindBy(xpath = "(//button[@class='fOyUs_bGBk fOyUs_fKyb fOyUs_cuDs fOyUs_cBHs fOyUs_eWbJ fOyUs_fmDy fOyUs_eeJl fOyUs_cBtr fOyUs_fuTR fOyUs_cnfU fQfxa_bGBk'])[3]")
	private WebElement popUp;
	
	
	@FindBy(xpath = "//button[@class='fOyUs_bGBk eHiXd_bGBk eHiXd_bXiG eHiXd_ycrn eHiXd_bNlk eHiXd_cuTS']")
	private WebElement secondPopup;
	
	//--- class elements
	
	@FindBy(xpath = "//div[contains(text(),'May 2020')]")
	private WebElement currentClassroom;
	
	@FindBy(xpath = "(//ul[@id='section-tabs'])[1]")
	private WebElement homeButton;
	
	@FindBy(xpath = "(//ul[@id='section-tabs']/li)[3]")
	private WebElement fileButton;
	
	@FindBy(xpath = "//ul[@class='treeContents']//li[@id='treenode-21']")
	private WebElement courseImage;
	
	
	//methods

	
	
	public String getPageTitle() {
		String actualPageTitle = driver.getTitle();
		return actualPageTitle;
	}
	
	public void enterCredentials(String user, String pass) {
		email.clear();
		email.sendKeys(user);
		password.clear();
		password.sendKeys(pass);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public boolean verifyDashboard() {
		if(accountButton.isDisplayed())
			return true;
		else
			return false;
	}
	
	public void closPopUp() {
		popUp.click();
	}
	
	public void closeSecondPopUp() {
		WebDriverUtility.clickElementWithJS(secondPopup);
	}
	
	public void clickCurrentClass() {
		currentClassroom.click();
	}
	
	public boolean isHomeButtonDisplayed() {
		if(homeButton.isDisplayed())
			return true;
		else
			return false;
	}
	
	public void clickFile() {
		fileButton.click();
	}
	
	public void clickCourseImage() {
		courseImage.click();
	}
}
