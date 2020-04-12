package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.Helper;
import utils.Locators;

public class FirstTC {

	@Test
	public void TestCase_1() throws InterruptedException {

		Helper.initializeDriver();

		Helper.waitForElementToBeClickable(Locators.graph);
		Helper.clickElementByXPath(Locators.signIn);
		Helper.sendKeysbyXpath(Locators.signInID, "420311");
		Helper.sendKeysbyXpath(Locators.signInPSW, "Qwerty@321");
		Helper.clickElementByXPath(Locators.sumitBttnLogin);
		Helper.sendKeysbyXpath(Locators.dOB, "1986");
		Helper.waitForElementToBeClickable(Locators.graph);
		Helper.getDriver().navigate().refresh();
		Helper.waitForElementToBeClickable(Locators.graph);

		Actions actions = new Actions(Helper.getDriver());
		WebElement btnElement = Helper.getDriver().findElement(By.xpath("//div[@class='stx-subholder']"));
		actions.contextClick(btnElement).perform();
		WebElement elementOpen = Helper.getDriver().findElement(By.xpath("//a[contains(text(),'DETAILS')]"));
		elementOpen.click();
		
		Helper.clickElementByXPath(Locators.buyBttn);
		Helper.assert_element_textPresent("BUY",Locators.buyBttnOrderEntry);
		Helper.clickElementByXPath(Locators.closeBttn);
		Helper.clickElementByXPath(Locators.sellBttn);
		Helper.assert_element_textPresent("SELL",Locators.sellBttnOrderEntry);
		Helper.clickElementByXPath(Locators.closeBttn);
		Helper.clickElementByXPath(Locators.closeBttnPOPUP);
		Helper.closeBrowser();
		
		
		
		
		/*
		 * Helper.selectDataFromList(Locators.listTimeinterval, "5 Minutes",
		 * Helper.getDriver(), Locators.timeInterval);
		 */

		/*
		 * . Click on dropdown 1 min / 3 min / 1 hr / 1 day / 1 week / 1 month and
		 * capture/verify array of x-axis interval of chart
		 */

	}

	/*
	 * @Test public void TestCase_2() {
	 * 
	 * Helper.initializeDriver();
	 * Helper.waitForElementToBeClickable(Locators.graph);
	 * Helper.selectDataFromList(Locators.listGraph, "LINE",
	 * Helper.getDriver(),Locators.chartIcon);
	 * 
	 * }
	 */

	/*
	 * @Test public void TestCase_3() {
	 * 
	 * Helper.initializeDriver();
	 * Helper.waitForElementToBeClickable(Locators.graph);
	 * 
	 * Helper.selectDataFromList(Locators.listGraph, "LINE", Helper.getDriver(),
	 * Locators.chartIcon);
	 * 
	 * }
	 */

}
