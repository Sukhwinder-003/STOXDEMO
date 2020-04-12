package utils;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static testngConstants.Constants.WAIT_EXPLICIT_SEC;

public class Helper {

	static ConfigFileReader config = new ConfigFileReader();
	public static String myText;
	public static WebDriver driver;

	/*
	 * // This method is to initialize the driver public static void
	 * driverInitialization() {
	 * 
	 * }
	 */

	public static void driverInitializationChrome() {
		System.setProperty("webdriver.chrome.driver", config.getChromeDriverPath());
		driver = new ChromeDriver();

	
	}

	public static void driverInitializationFirefox() {
		System.setProperty("webdriver.gecko.driver", config.getDriverPath());
		driver = new FirefoxDriver();


	}
	
	
	
	public static WebDriver getDriver() {
		if (driver == null) {
			driverInitializationFirefox();
		}
		return driver;
	}

	public static void initializeDriver() {

		getDriver();

		Helper.getDriver().manage().window().maximize();
		Helper.getDriver().get("https://pro.upstox.com/");
		//Helper.getDriver().navigate().refresh();

	}

	public static void clickElement(WebElement webElement) {

		isElementDisplayed(webElement);
		waitForElementToBeClickable(webElement);
		webElement.click();

	}

	public static void clickElementByXPath(By Xpath) {

		waitForElementToBeClickable(Xpath);
		Locators.getWebElement(driver, Xpath).click();

	}

	public static boolean isElementDisplayedByXpath(WebElement webElement) {

		return isElementDisplayed(webElement, WAIT_EXPLICIT_SEC);

	}

	public static boolean isElementPresent(By xpath) {
		try {
			waitForElementToBeClickable(xpath);
			driver.findElement(xpath);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isElementDisplayed(WebElement webElement) {

		return isElementDisplayed(webElement, WAIT_EXPLICIT_SEC);

	}

	public static void waitForElementToBeClickable(By Xpath) {

		WebDriverWait wait = new WebDriverWait(Helper.getDriver(), WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.elementToBeClickable(Xpath));

	}

	public static void waitForElementToBeClickable(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));

	}

	public static boolean isElementDisplayed(WebElement webElement, int timeOut) {

		WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
		wait.until(ExpectedConditions.visibilityOf(webElement));
		return webElement.isDisplayed();

	}

	public static void waitForVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void waitForVisibilityAll(WebElement list) {
		WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.visibilityOfAllElements(list));

	}

	// This method is used to hold the list of elements
	/*
	 * public static void getDataFromList(By List, String Text, WebDriver driver) {
	 * 
	 * waitForElementToBeClickable(Locators.targetOption);
	 * driver.findElement(Locators.targetOption).click();
	 * 
	 * List<WebElement> list = driver.findElements(List);
	 * 
	 * for (int i = 0; i < list.size(); i++)
	 * 
	 * { list.get(0).click();
	 * 
	 * break; } }
	 */

	public static void verifyDataFromList(By List, String Text, WebDriver driver) throws InterruptedException {

		List<WebElement> list = driver.findElements(List);
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getText().contentEquals(Text)) {
				/*
				 * System.out.println(list.get(i).getText());
				 */ Assert.assertEquals(Text, list.get(i).getText());

				break;

			}

		}
	}

	public static void selectDataFromList(By List, String Text, WebDriver driver, By dropdwn) {

		driver.findElement(dropdwn).click();

		List<WebElement> list = driver.findElements(List);

		for (int i = 0; i < list.size(); i++)

		{

			if (list.get(i).getText().contains(Text)) {

				list.get(i).click();

				break;

			}

		}

	}

	public static String getText(By xpath) {

		String text = driver.findElement(xpath).getText();

		return text;

	}

	public static String getTitle(String bringTheTitle) {

		bringTheTitle = driver.getTitle();

		return bringTheTitle;

	}

	public static void assert_element_present(By xpath) {

		if (driver.findElement(xpath) != null) {
			System.out.println("Element is Present");
		} else {
			System.out.println("Element is Absent");
		}

	}

	public static void assert_element_textPresent(String ExpectedText, By xpath) throws InterruptedException {
		{

			Helper.waitForElementToBeClickable(xpath);

			Assert.assertEquals(ExpectedText, driver.findElement(xpath).getText());
			System.out.println(ExpectedText);
			System.out.println(driver.findElement(xpath).getText());
		}

	}

	public static void sendKeys(WebElement webElement, CharSequence... keysToSend) {
		WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.visibilityOf(webElement));
		webElement.clear();
		webElement.sendKeys(keysToSend);
	}

	public static void sendKeysbyXpath(By Xpath, CharSequence... keysToSend) {
		WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Xpath));
		WebElement wl = Locators.getWebElement(driver, Xpath);
		wl.clear();
		wl.sendKeys(keysToSend);
	}


	public static void handleWindow(String copyText, WebDriver driver) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(copyText);
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(tabs.get(0));

	}

	public static void clickByAction(WebDriver driver, By Xpath) {

		WebElement element = Helper.driver.findElement(Xpath);
		Actions actions = new Actions(Helper.driver);
		actions.moveToElement(element).click().perform();

	}

	public static void moveTo(WebElement element) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("window.scrollBy(0,-100);", element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

	}

	public static void closeBrowser() throws InterruptedException {

		if (driver == null) {
			return;
		}
		driver.quit();
		driver = null;

	}

}
