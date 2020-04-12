package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {

	public static By timeInterval = By.xpath("//span[@class='intervalText ng-binding']");
	public static By listTimeinterval = By.xpath("//div[@class='headerDropdown intervalDD']//div");
//	public static By compareBttn = By.xpath("//span[contains(text(),'COMPARE')]");

	public static By graph = By.xpath("//div[@class='stx-subholder']");
	public static By chartIcon = By
			.xpath("//div[@class='headerInlineTagLabel no-wclick']//*[name()='use' and @*='#upico-chart-candle']");

	public static By listGraph = By.xpath("//div[@class='headerDropdown intervalDD']//div");

	
	public static By signIn = By.xpath("//*[contains(text(),'Sign in')]");
	public static By signInID = By.xpath("//input[@id='login-id']");
	public static By signInPSW = By.xpath("//input[@id='login-password']");
	public static By sumitBttnLogin = By.xpath("//div[@id='login-submit-button']");
	public static By dOB = By.xpath("//input[@id='2fa-password']");

	public static By buyBttn = By.xpath("//button[@class='buy button hover_button']");
	public static By sellBttn = By.xpath("//button[@class='sell button hover_button']");
	
	public static By buyBttnOrderEntry = By.xpath("//button[@class='button hover_button ng-binding green-background']");
	public static By sellBttnOrderEntry = By.xpath("//button[@class='button hover_button ng-binding red-background']");
	public static By closeBttn = By.xpath("//div[@class='oe-close-btn']//*[local-name()='svg']");
	public static By closeBttnPOPUP = By.xpath("//div[contains(@class,'div-ider pholder draggable')]//div[@class='pointer ng-scope']//*[local-name()='svg']");


	
	

	
	
	
	public static WebElement getWebElement(WebDriver driver, By Xpath) {

		WebElement webElement = driver.findElement(Xpath);

		return webElement;
	}

}
