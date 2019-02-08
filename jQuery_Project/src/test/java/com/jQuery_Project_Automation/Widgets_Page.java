package com.jQuery_Project_Automation;

import static org.testng.Assert.assertNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Widgets_Page {

	public WebDriver driver;

	@BeforeMethod
	public void beforMethod() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\aboba\\eclipse-workspace\\jQuery_Project\\jQuery_Project\\src\\test\\resources\\Browser_Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void widgets() {

		try {
			driver.get("https://jqueryui.com/");
			driver.findElement(By.partialLinkText("Accordion")).click();

			// driver.get("https://jqueryui.com/accordion/");
			driver.switchTo().frame(0);

			driver.findElement(By.id("ui-id-1")).click();
			driver.findElement(By.id("ui-id-3")).click();
			driver.findElement(By.id("ui-id-5")).click();
			driver.findElement(By.id("ui-id-7")).click();
			driver.navigate().back();

			driver.findElement(By.partialLinkText("Autocomplete")).click();
			driver.switchTo().frame(0);

			WebElement search = driver.findElement(By.id("tags"));
			search.sendKeys("Java");
			search.sendKeys(Keys.ARROW_DOWN);
			search.sendKeys(Keys.ARROW_DOWN);
			search.click();
			driver.navigate().back();
			Thread.sleep(2 * 1000);

			/// Button///
			driver.findElement(By.partialLinkText("Button")).click();
			driver.switchTo().frame(0);
			driver.findElement(By.cssSelector("body > div > button")).click();
			driver.findElement(By.cssSelector("body > div > input")).click();
			driver.findElement(By.partialLinkText("An anchor")).click();
			driver.findElement(By.cssSelector("body > button")).click();
			driver.findElement(By.cssSelector("body > input")).click();
			driver.findElement(By.partialLinkText("An anchor")).click();
			driver.switchTo().defaultContent();
			driver.navigate().back();

			/// Checkboxradio//
			driver.findElement(By.partialLinkText("Checkboxradio")).click();
			driver.switchTo().frame(0);
			driver.findElement(By.cssSelector("body > div > fieldset:nth-child(3) > label:nth-child(4)")).click();
			driver.findElement(By.cssSelector("body > div > fieldset:nth-child(5) > label:nth-child(8)")).click();
			driver.findElement(By.cssSelector("body > div > fieldset:nth-child(7) > label:nth-child(3)")).click();
			driver.switchTo().defaultContent();
			driver.navigate().back();

			// Controlgroup//

			driver.findElement(By.partialLinkText("Controlgroup")).click();
			driver.switchTo().frame(0);
			WebElement carType = driver.findElement(By.id("car-type-button"));
			carType.click();
			carType.sendKeys(Keys.ARROW_DOWN);
			carType.sendKeys(Keys.ARROW_DOWN);
			carType.sendKeys(Keys.ARROW_DOWN);
			carType.sendKeys(Keys.ARROW_DOWN);
			carType.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2 * 1000);
			carType.click();
			driver.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/label[1]")).click();
			driver.findElement(By.xpath("/html//div[@class='widget']/fieldset[1]/div[@role='toolbar']/label[3]"))
					.click();
			WebElement carNumbers = driver.findElement(By.id("horizontal-spinner"));
			carNumbers.sendKeys("3");
			driver.findElement(By.cssSelector("body > div.widget > fieldset:nth-child(2) > div > button")).click();
			WebElement selectCars = driver.findElement(By.id("ui-id-8-button"));
			selectCars.click();
			selectCars.sendKeys(Keys.ARROW_DOWN);
			selectCars.sendKeys(Keys.ARROW_DOWN);
			selectCars.sendKeys(Keys.ARROW_DOWN);
			selectCars.sendKeys(Keys.ARROW_DOWN);
			selectCars.sendKeys(Keys.ARROW_DOWN);
			selectCars.click();

			driver.findElement(By.cssSelector("body > div.widget > fieldset:nth-child(4) > div > label:nth-child(5)"))
					.click();
			driver.findElement(By.cssSelector("body > div.widget > fieldset:nth-child(4) > div > label:nth-child(7)"))
					.click();
			WebElement carsNumber = driver.findElement(By.id("vertical-spinner"));
			carsNumber.sendKeys("3");
			driver.switchTo().defaultContent();
			driver.navigate().back();

			/// Datepicker ///

			driver.findElement(By.partialLinkText("Datepicker")).click();
			driver.switchTo().frame(0);
			driver.findElement(By.id("datepicker")).click();
			driver.findElement(By.partialLinkText("Next")).click();
			driver.findElement(By.partialLinkText("21")).click();
			driver.switchTo().defaultContent();
			driver.navigate().back();

			/// Dialog///

			driver.findElement(By.partialLinkText("Dialog")).click();
			driver.switchTo().frame(0);
            Thread.sleep(3*1000);
			Actions action = new Actions(driver);
			WebElement clickBox = driver.findElement(By.cssSelector("body > div"));
			WebElement clickbody = driver.findElement(By.cssSelector("body"));
			action.click(clickBox).dragAndDropBy(clickbody, 400, 300).build().perform(); // should check
			driver.findElement(By.cssSelector(
					"body > div > div.ui-dialog-titlebar.ui-corner-all.ui-widget-header.ui-helper-clearfix.ui-draggable-handle > button"))
					.click();
			driver.switchTo().defaultContent();

			/// Menu///
			driver.findElement(By.partialLinkText("Menu")).click();
			driver.switchTo().frame(0);
			driver.findElement(By.id("ui-id-2")).click();
			driver.findElement(By.id("ui-id-3")).click();
			Actions action3 = new Actions(driver);
			WebElement elictonic = driver.findElement(By.id("ui-id-4"));
			WebElement utilites = driver.findElement(By.id("ui-id-7"));
			action3.moveToElement(elictonic).build().perform();
			utilites.click();
			driver.findElement(By.id("ui-id-8")).click();
			WebElement music = driver.findElement(By.id("ui-id-9"));
			WebElement jazz = driver.findElement(By.id("ui-id-13"));
			action3.moveToElement(music).build().perform();
			jazz.click();

			WebElement modren = driver.findElement(By.id("ui-id-16"));
			action3.moveToElement(jazz).build().perform();
			modren.click();
			driver.switchTo().defaultContent();

			/// Progressbar //
			driver.findElement(By.partialLinkText("Progressbar")).click();

			/// Selectmenu///
			driver.findElement(By.partialLinkText("Selectmenu")).click();
			driver.switchTo().frame(0);

			driver.findElement(By.id("speed-button")).click();
			driver.findElement(By.id("ui-id-5")).click();

			driver.findElement(By.id("files-button")).click();
			driver.findElement(By.id("ui-id-9")).click();

			driver.findElement(By.id("number-button")).click();
			driver.findElement(By.id("ui-id-14")).click();

			driver.findElement(By.id("salutation-button")).click();
			driver.findElement(By.id("ui-id-30")).click();
			driver.switchTo().defaultContent();

			/// Slider ///

			driver.findElement(By.partialLinkText("Slider")).click();
			driver.switchTo().frame(0);
			Actions action4 = new Actions(driver);
			WebElement hanel = driver.findElement(By.cssSelector("#slider > span"));
			WebElement slider = driver.findElement(By.id("slider"));
			action4.dragAndDrop(hanel, slider).build().perform();
			driver.switchTo().defaultContent();

			/// Spinner//
			driver.findElement(By.partialLinkText("Spinner")).click();
			driver.switchTo().frame(0);
			WebElement spanir = driver.findElement(By.id("spinner"));
			spanir.sendKeys("11");
			driver.findElement(By.id("disable")).click();
			driver.findElement(By.id("destroy")).click();
			driver.switchTo().defaultContent();

			/// Tabs///

			driver.findElement(By.partialLinkText("Tabs")).click();
			driver.switchTo().frame(0);
			driver.findElement(By.cssSelector(
					"#tabs > ul > li.ui-tabs-tab.ui-corner-top.ui-state-default.ui-tab.ui-tabs-active.ui-state-active"))
					.click();
			driver.findElement(By.xpath("//*[@id=\"tabs\"]/ul/li[2]")).click();
			driver.findElement(By.partialLinkText("Aenean lacinia")).click();
			driver.switchTo().defaultContent();

			/// Tooltip///

			driver.findElement(By.partialLinkText("Tooltip")).click();
			driver.switchTo().frame(0);
			driver.findElement(By.partialLinkText("Tooltips")).click();
			driver.findElement(By.xpath("/html/body/p[2]/a")).click();
			WebElement age = driver.findElement(By.id("age"));
			age.sendKeys("31");
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@AfterMethod
	public void after_Mehod() {
		try {
			Thread.sleep(3 * 1000);
			driver.close();
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			

		}
	}
	
	
	
	

}
