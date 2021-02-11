package pageObjects;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.WebDriverUtility;

public class ChangeCurrencyPageObj extends Base {
	
	public ChangeCurrencyPageObj() {
		
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(how = How.XPATH, using = "//button[@class='btn btn-link dropdown-toggle']")
		private WebElement currencyMenu;
		
		@FindBy(xpath = "//ul[@class='dropdown-menu']/li")
		private List<WebElement> listOfCurrencies;
		
		@FindBy(xpath = "//a[text()='Desktops']")
		private WebElement desktopsDropdown;
		
		@FindBy(xpath = "//nav[@id='menu']/div[2]/ul/li[1]/div/div/ul/li")
		private List<WebElement> listOfDesktopItems;
		
		@FindBy(xpath = "//div[@class='caption']//p[2]")
		private WebElement currencySign;
		
		
		
		//methods
		
		
		public void clickOnCurrency() {
			currencyMenu.click();
		}
		
		public void selectCurrency() {
			for(WebElement currency : listOfCurrencies) {
				try {
				if(currency.getText().trim().contains("Pound Sterling")) {
					WebDriverUtility.moveToElementAction(currency);
					WebDriverUtility.wait(3000);
					WebDriverUtility.clickOnElement(currency);
					WebDriverUtility.wait(3000);

				}
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
				}
			}
		}
		
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
		
		public boolean isCurrencySignDisplayed() {
			if(currencySign.getText().contains("£"))
				return true;
			else
				return false;
		}
		
		public String getPageTitle() {
			String pageTitle = driver.getTitle();
			return pageTitle;
		}
		
		public String displayPriceFormat() {
			String priceFormat = currencySign.getText();
			return priceFormat;
		}
		
	}


