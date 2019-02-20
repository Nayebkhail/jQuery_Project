package com.Library;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.sql.Driver;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.OrangeHRM.ObjectMapProject.OrangeHRM_ObjectMap;
import com.google.common.io.Files;

public class seleniumRepository extends BasePage {
	OrangeHRM_ObjectMap objMap = new OrangeHRM_ObjectMap("ObjectPropertiesFile/objectMap.properties");
	private WebDriver driver;
	final static Logger logger = Logger.getLogger(seleniumRepository.class);

	public WebDriver startChromeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Browsers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public seleniumRepository(WebDriver _driver) {

		driver = _driver;

	}

	public void enterTextField(By by) {

		WebElement varibileName = driver.findElement(by);
		varibileName.click();

	}

	public void enterTextFieldwithRaw(By by) {

		WebElement varibileName = driver.findElement(by);
		varibileName.click();
		varibileName.sendKeys(Keys.ARROW_DOWN);
		varibileName.sendKeys(Keys.ARROW_DOWN);
		varibileName.click();

	}

	public void enterTextField(By by, String value) {

		WebElement variableName = driver.findElement(by);
		variableName.clear();
		variableName.sendKeys(value);

	}

	public void clickButtonWithNavigatBack(By by) {

		WebElement click = driver.findElement(by);
		click.click();
		driver.navigate().back();

	}

	public void clickButton(By by) {

		try {
			WebElement click = driver.findElement(by);
			click.click();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	public WebElement fluentWait(final By by) {
		WebElement targetElem = null;
		try {
			@SuppressWarnings("deprecation")
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
					.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

			targetElem = wait.until(new Function<WebDriver, WebElement>() {

				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);
				}
			});
		} catch (Exception e) {
		}
		return targetElem;
	}

	public WebElement windowHandle() {
		WebElement handle = null;

		driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		return handle;

	}

	public void selectDropDownVisibleText(By by, String visibleTextValue) {

		WebElement dropDownElement = driver.findElement(by);
		Select DropDown = new Select(dropDownElement);
		DropDown.selectByVisibleText(visibleTextValue);

	}

	public void selectDropDownbyIndex(By by, int index) {

		WebElement dropDownElement = driver.findElement(by);
		Select DropDown = new Select(dropDownElement);
		DropDown.selectByIndex(index);

	}

	public void handlePopups() {

		Set<String> windowId = driver.getWindowHandles(); // get window id of current window
		Iterator<String> itererator = windowId.iterator();

		String mainWinID = itererator.next();
		String newAdwinID = itererator.next();

		driver.switchTo().window(newAdwinID);
		System.out.println(driver.getTitle());

		driver.close();

		driver.switchTo().window(mainWinID);
		System.out.println(driver.getTitle());

	}

	public void handleAlerts() {

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public void declineAlerts() {

		Alert decline = driver.switchTo().alert();
		decline.dismiss();

	}

	public Alert isAlertPresent() {
		Alert alert = null;

		try {
			alert = driver.switchTo().alert();

		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);

		}
		return alert;
	}

	public void actionClass(WebElement findElement, Keys arrowDown) {

		Actions actions = new Actions(driver);
		actions.moveToElement(findElement);
		actions.click();
		actions.sendKeys(arrowDown);
		actions.build().perform();

	}

	public void screenShot() {
		try {
			File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(srcfile, new File("target/screenshots.png/"));
		} catch (Exception e) {
			e.printStackTrace();
			// assertTrue(false);
		}
	}

	public void navigateToPerviosepage() {

		driver.navigate().back();

	}

	public void scrollToWebElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);

		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}

	public void scrollByOffsetVertical(String verticalPixel) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(0," + verticalPixel + ")"); // "scroll(0,200)"
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}

	public WebElement waitForElementVisibility(By by) {
		WebElement element = null;
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}

}
