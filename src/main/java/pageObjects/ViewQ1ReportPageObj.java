package pageObjects;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.WebDriverUtility;

public class ViewQ1ReportPageObj extends Base{
	
	public ViewQ1ReportPageObj() {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='button arrow-right']")
	private WebElement investorInfoButton;
	
	@FindBy(xpath = "(//ul[@id='main-menu-ir']/li)[2]")
	private WebElement filingsAndFinancials;
	
	@FindBy(xpath = "(//ul[@id='main-menu-ir']/li)[2]/ul/li")
	private List<WebElement> filingMenuContent;
	
	@FindBy(xpath = "//span[text()='2020 Earnings Releases']")
	private WebElement TwentyTwentyEarnings;
	
	@FindBy(xpath = "//a[contains(text(),'First Quarter 2020 Earnings Release')]")
	private WebElement firstQuarterPDF;
	
	@FindBy(xpath = "//*[@id=\"icon\"]/iron-icon")
	private WebElement downloadButton;
	
	
	//methods
	
	public void clickOnInvestorInfo() {
		investorInfoButton.click();
	}
	
	public void moveToFinancialFiling() {
		WebDriverUtility.moveToElementAction(filingsAndFinancials);
		filingsAndFinancials.click();
	}
	
	public void clickQuarterlyEarnings() {
		for(WebElement items : filingMenuContent) {
			try {
			if(items.getText().trim().contains("Quarterly Earning")) {
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
	
	public void clickTwentyTwentyReport() {
		TwentyTwentyEarnings.click();
	}
	
	public void clickFirstQuarter() {
		firstQuarterPDF.click();
	}
	
	public void clickDownload() {
		WebDriverUtility.moveToElementAction(downloadButton);
		WebDriverUtility.clickElementWithJS(downloadButton);
	}
}
