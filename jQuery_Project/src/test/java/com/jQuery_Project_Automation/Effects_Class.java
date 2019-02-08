package com.jQuery_Project_Automation;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Effects_Class {

	WebDriver driver;

	@BeforeMethod(enabled = true)
	public void beforMethod() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\aboba\\eclipse-workspace\\jQuery_Project\\jQuery_Project\\src\\test\\resources\\Browser_Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
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

	@AfterMethod
	public void after_Method() {
		try {
			Thread.sleep(2 * 1000);
			driver.close();
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
