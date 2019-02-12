package com.OrangeHRM.ObjectMapProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Library.Base;

public class OrangeHRM_ObjectMapLogin extends Base {

	@Test
	public void OrangeHRM_Login() {

		try {
			driver.get("https://opensource-demo.orangehrmlive.com/");
			System.out.println(driver.getTitle());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			OrangeHRM_ObjectMap objMap = new OrangeHRM_ObjectMap("ObjectPropertiesFile\\objectMap.properties");
			
			WebElement username = driver.findElement(objMap.getLocator("User_field"));
			username.sendKeys("Admin");
			
			WebElement password = driver.findElement(objMap.getLocator("pass_field"));
			password.sendKeys("admin123");
			Thread.sleep(3000);
			
			WebElement login =driver.findElement(objMap.getLocator("login_button"));
			login.click();
			
			Actions action =new Actions(driver);
			WebElement Mhover = driver.findElement(objMap.getLocator("Admin"));
			WebElement Mhover1 =driver.findElement(objMap.getLocator("User_Management"));			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
