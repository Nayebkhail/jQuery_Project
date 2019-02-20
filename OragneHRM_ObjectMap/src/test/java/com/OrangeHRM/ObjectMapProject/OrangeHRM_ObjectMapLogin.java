package com.OrangeHRM.ObjectMapProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Library.BasePage;

public class OrangeHRM_ObjectMapLogin extends BasePage {
	
	OrangeHRM_ObjectMap propertisFile = new OrangeHRM_ObjectMap("ObjectPropertiesFile/objectMap.properties");

	public void orangeHRM_Login() {

		try {
			driver.get("https://opensource-demo.orangehrmlive.com/");
			System.out.println(driver.getTitle());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			myRepository.enterTextField(propertisFile.getLocator("User_field"), "Admin");
			myRepository.enterTextField(propertisFile.getLocator("pass_field"), "admin123");
			driver.findElement(propertisFile.getLocator("login_button")).click();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void verfiyingMainPage() {

		try {

			myRepository.clickButtonWithNavigatBack(propertisFile.getLocator("Admin"));
			myRepository.clickButtonWithNavigatBack(propertisFile.getLocator("PIM"));
			myRepository.clickButtonWithNavigatBack(propertisFile.getLocator("Leave"));
			myRepository.clickButtonWithNavigatBack(propertisFile.getLocator("Time"));
			myRepository.clickButtonWithNavigatBack(propertisFile.getLocator("Recruitment"));
			driver.findElement(propertisFile.getLocator("Performance")).click();
			myRepository.clickButtonWithNavigatBack(propertisFile.getLocator("Directory"));
			myRepository.clickButtonWithNavigatBack(propertisFile.getLocator("Maintenance"));

			Actions action = new Actions(driver);
			WebElement Mhover = driver.findElement(propertisFile.getLocator("Admin"));
			action.moveToElement(Mhover).build().perform();

			WebElement Mhover1 = driver.findElement(propertisFile.getLocator("User_Management"));
			action.moveToElement(Mhover1).build().perform();
			Mhover1.click();
			Thread.sleep(3000);
			WebElement users = driver.findElement(propertisFile.getLocator("Users"));
			users.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addNew_user() {

		try {

			driver.findElement(propertisFile.getLocator("Add")).click();
			myRepository.selectDropDownVisibleText(propertisFile.getLocator("uRole"), "Admin");
			myRepository.enterTextField(propertisFile.getLocator("eName"), "Robert Craig");
			myRepository.enterTextField(propertisFile.getLocator("uName"), "Basir1");
			myRepository.enterTextField(propertisFile.getLocator("pass"), "Baseer123");
			myRepository.enterTextField(propertisFile.getLocator("confirmPassword"), "Baseer123");
			myRepository.clickButtonWithNavigatBack(propertisFile.getLocator("save"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
