package com.jQuery_Project_Automation;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

public class Interactions {

	public WebDriver driver;

	
@Test
public void callMethodJqury() {
		Interactions jquryinter = new Interactions();
		jquryinter.beforMethod();
		jquryinter.dragable();
		jquryinter.dropable();
		jquryinter.resazable();
		jquryinter.selecable();
		jquryinter.sortable();
		jquryinter.afterMethod();
		
		
}

	 @BeforeMethod (enabled = false)
	public void beforMethod() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\aboba\\eclipse-workspace\\jQuery_Project\\jQuery_Project\\src\\test\\resources\\Browser_Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	 @Test(enabled = false)
	public void test() {

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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 @Test (enabled = false)
	public void dragable() {

		driver.get("https://jqueryui.com/draggable/");
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.xpath("/html/body"));
		action.dragAndDrop(drag, drop).perform();

	}

	@Test (enabled = false)
	public void dropable() {
		try {
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		Actions action1 = new Actions(driver);
		Thread.sleep(5*1000);
		WebElement dragg = driver.findElement(By.id("draggable"));
		WebElement dropp = driver.findElement(By.id("droppable"));
		action1.dragAndDrop(dragg, dropp).perform();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	
	@Test (enabled = false)
	public void resazable() {
		
		driver.get("https://jqueryui.com/resizable/");
		driver.switchTo().frame(0);
		Actions action4 = new Actions(driver);
		
		WebElement resiable = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[2]"));
		WebElement handleresiable = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		action4.dragAndDrop(resiable, handleresiable).perform();

			}

	@Test (enabled = false)
	public void selecable() {

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

	}

	@Test (enabled = false)
	public void sortable () {
		
		try {
			
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
							
		action3.clickAndHold(it5).moveToElement(it1).build().perform();
		Thread.sleep(3 * 1000);
		action3.clickAndHold(it6).moveToElement(it4).build().perform();
		action3.clickAndHold(it2).moveToElement(it7).build().perform();
		
		}catch (Exception e) {
			e.printStackTrace();
     	}
		
	}
	
	
	@AfterMethod (enabled = false)
	public void afterMethod() {

		try {
			Thread.sleep(3 * 3000);

			driver.close();
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
	
	
}
