package com.jQuery_Project_Automation;

import static org.testng.Assert.assertEquals;

import java.awt.RenderingHints.Key;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

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
import org.testng.reporters.jq.Main;

public class JQuery_Project {
	WebDriver driver;

	@Test
	public void call_Methods() {

		JQuery_Project methods = new JQuery_Project();
		methods.beforMethod();
		methods.interactions();
		methods.widgets();
		methods.effect_sideMenu();
		methods.afterMethod();

	}

	@BeforeMethod(enabled = false)
	public void beforMethod() {

		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\Browser_Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(enabled = false)
	public void interactions() {

		try {

			driver.get("https://jquery.com/");

			String WebTitle = driver.getTitle();
			System.out.println("This is the Web Title: " + WebTitle);

			String webSource = driver.getCurrentUrl();
			System.out.println("This is WebSource URL: " + webSource);

			assertEquals(webSource, "https://jquery.com/");

			WebElement nextPage = driver
					.findElement(By.cssSelector("#global-nav > nav > div > ul.projects > li.project.jquery-ui > a"));
			nextPage.click();

			driver.get("https://jqueryui.com/draggable/");
			driver.switchTo().frame(0);
			Actions action = new Actions(driver);
			WebElement drag = driver.findElement(By.id("draggable"));
			WebElement drop = driver.findElement(By.xpath("/html/body"));
			action.clickAndHold(drag).dragAndDrop(drag, drop).perform();

			WebElement drag1 = driver.findElement(By.id("draggable"));
			driver.findElement(By.xpath("/html/body"));
			action.dragAndDrop(drag1, drop).perform();

			driver.get("https://jqueryui.com/droppable/");
			driver.switchTo().frame(0);
			Actions action1 = new Actions(driver);
			WebElement dragg = driver.findElement(By.id("draggable"));
			WebElement dropp = driver.findElement(By.id("droppable"));
			action1.dragAndDrop(dragg, dropp).perform();

			driver.get("https://jqueryui.com/resizable/");
			driver.switchTo().frame(0);
			Actions action4 = new Actions(driver);
			WebElement resiable = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[2]"));
			WebElement handleresiable = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
			action4.dragAndDrop(resiable, handleresiable).perform();

			driver.get("https://jqueryui.com/selectable/");
			driver.switchTo().frame(0);
			WebElement item1 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[1]"));
			item1.click();
			WebElement item2 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[2]"));
			item2.click();
			WebElement item3 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[3]"));
			item3.click();
			WebElement item4 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[4]"));
			item4.click();
			WebElement item5 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[5]"));
			item5.click();
			WebElement item6 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[6]"));
			item6.click();
			WebElement item7 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[7]"));
			item7.click();

			driver.get("https://jqueryui.com/sortable/");
			driver.switchTo().frame(0);

			Actions action3 = new Actions(driver);
			Thread.sleep(3 * 1000);

			WebElement it1 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[1]"));
			WebElement it2 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[2]"));
			WebElement it3 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[3]"));
			WebElement it4 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[2]"));
			WebElement it5 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[5]"));
			WebElement it6 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[6]"));
			WebElement it7 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[7]"));

			action3.clickAndHold(it5).moveToElement(it1).perform();
			Thread.sleep(3 * 1000);
			action3.clickAndHold(it6).moveToElement(it4).perform();
			action3.clickAndHold(it2).moveToElement(it7).perform();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Test(enabled = false)
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

	@Test(enabled = false)
	public void effect_sideMenu() {

		try {

			driver.get("https://jquery.com/");
			String WebTitle = driver.getTitle();
			System.out.println("This is the Web Title: " + WebTitle);
			String webSource = driver.getCurrentUrl();
			System.out.println("This is WebSource URL: " + webSource);
			assertEquals(webSource, "https://jquery.com/");
			WebElement nextPage = driver
					.findElement(By.cssSelector("#global-nav > nav > div > ul.projects > li.project.jquery-ui > a"));
			nextPage.click();

			/// Add Class ///

			driver.findElement(By.partialLinkText("Add Class")).click();
			driver.switchTo().frame(0);
			driver.findElement(By.id("button")).click();
			driver.switchTo().defaultContent();

			/// Color Animation ///
			driver.findElement(By.partialLinkText("Color Animation")).click();
			driver.switchTo().frame(0);
			driver.findElement(By.id("button")).click();
			driver.switchTo().defaultContent();

			/// Easing ///

			driver.findElement(By.partialLinkText("Easing")).click();
			driver.switchTo().frame(0);
			driver.findElement(By.cssSelector("#graphs > div:nth-child(1) > div:nth-child(2)")).click();
			driver.findElement(By.cssSelector("#graphs > div:nth-child(2) > div:nth-child(2)")).click();
			driver.switchTo().defaultContent();

			/// Effect ///

			driver.findElement(By.partialLinkText("Effect")).click();
			driver.switchTo().frame(0);
			WebElement effect = driver.findElement(By.id("effectTypes"));
			effect.click();
			Select fold = new Select(effect);
			fold.selectByVisibleText("Fold");
			driver.findElement(By.id("button")).click();
			driver.switchTo().defaultContent();

			/// Hide ///

			driver.findElement(By.partialLinkText("Hide")).click();
			driver.switchTo().frame(0);
			WebElement bounce = driver.findElement(By.id("effectTypes"));
			bounce.click();
			Select hide = new Select(bounce);
			hide.selectByVisibleText("Bounce");
			driver.findElement(By.id("button")).click();
			driver.switchTo().defaultContent();

			/// Remove Class ///

			driver.findElement(By.partialLinkText("Remove Class")).click();
			driver.switchTo().frame(0);

			driver.findElement(By.id("button")).click();
			driver.switchTo().defaultContent();

			/// Show ///

			driver.findElement(By.partialLinkText("Show")).click();
			driver.switchTo().frame(0);

			WebElement show = driver.findElement(By.id("effectTypes"));
			show.click();
			Select explore = new Select(show);
			explore.selectByVisibleText("Explode");
			driver.findElement(By.id("button")).click();
			driver.switchTo().defaultContent();

			/// Switch Class ///

			driver.findElement(By.partialLinkText("Switch Class")).click();
			driver.switchTo().frame(0);
			driver.findElement(By.id("button")).click();
			driver.switchTo().defaultContent();

			/// Toggle ///

			driver.findElement(By.partialLinkText("Toggle")).click();
			driver.switchTo().frame(0);
			WebElement effectTypes = driver.findElement(By.id("effectTypes"));
			Select shake = new Select(effectTypes);
			shake.selectByVisibleText("Shake");
			driver.findElement(By.id("button")).click();
			driver.switchTo().defaultContent();

			/// Toggle Class ///

			driver.findElement(By.partialLinkText("Toggle Class")).click();
			driver.switchTo().frame(0);
			driver.findElement(By.id("button")).click();
			driver.switchTo().defaultContent();

			/// Position ///

			driver.findElement(By.partialLinkText("Position")).click();
			driver.switchTo().frame(0);

			WebElement right = driver.findElement(By.id("my_horizontal"));
			right.click();
			Select click = new Select(right);
			click.selectByVisibleText("right");

			WebElement vertical = driver.findElement(By.id("my_vertical"));
			vertical.click();
			Select bottom = new Select(vertical);
			bottom.selectByVisibleText("bottom");

			WebElement left = driver.findElement(By.id("at_horizontal"));
			left.click();
			Select left1 = new Select(left);
			left1.selectByVisibleText("left");

			WebElement top1 = driver.findElement(By.id("at_horizontal"));
			top1.click();
			Thread.sleep(2 * 1000);
			Select top2 = new Select(top1);
			top2.selectByVisibleText("center");

			WebElement collision = driver.findElement(By.id("collision_horizontal"));
			collision.click();
			Select collision1 = new Select(collision);
			collision1.selectByVisibleText("fit");

			WebElement collision2 = driver.findElement(By.id("collision_vertical"));
			collision2.click();
			Select collisioin3 = new Select(collision2);
			collisioin3.selectByVisibleText("flip");
			driver.switchTo().defaultContent();

			/// Widget Factory ///

			driver.findElement(By.partialLinkText("Widget Factory")).click();
			driver.switchTo().frame(0);

			driver.findElement(By.cssSelector("#my-widget1 > button")).click();
			driver.findElement(By.cssSelector("#my-widget2 > button")).click();
			driver.findElement(By.cssSelector("#my-widget3 > button")).click();
			driver.findElement(By.id("green")).click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterMethod(enabled = false)
	public void afterMethod() {

		try {
			Thread.sleep(3 * 1000);

			driver.close();
			driver.quit();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
