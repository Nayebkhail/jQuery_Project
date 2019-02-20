package com.OrangeHRM.ObjectMapProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Library.BasePage;

public class OrangeHRM_Dashboard extends BasePage {
	OrangeHRM_ObjectMap propertiesFile = new OrangeHRM_ObjectMap("ObjectPropertiesFile/objectMap.properties");

	public void verfing_Colors() {

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void assgine_leaves() {

		try {
			myRepository.clickButton(propertiesFile.getLocator("Assign_Leave"));
			myRepository.enterTextField(propertiesFile.getLocator("eNamea"), "Linda Anderson");
			myRepository.selectDropDownVisibleText(propertiesFile.getLocator("Ltype"), "Vacation US");
			myRepository.enterTextField(propertiesFile.getLocator("fDate"), "2019-02-16");
			myRepository.enterTextField(propertiesFile.getLocator("tDate"), "2019-02-18");
			// myRepository.enterTextField(objMap.getLocator("tDate"), "2019-03-16");
			Thread.sleep(3000);
			myRepository.selectDropDownVisibleText(propertiesFile.getLocator("partial_day"), "None");
			myRepository.enterTextField(propertiesFile.getLocator("comments"), "I want to go to Barazil for Voccation");
			myRepository.clickButton(propertiesFile.getLocator("assignBtn"));
			myRepository.clickButton(propertiesFile.getLocator("conform"));
			myRepository.clickButton(propertiesFile.getLocator("Dashboard"));

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void leave_list() {

		try {
			myRepository.clickButton(propertiesFile.getLocator("Leave_List"));
			myRepository.enterTextField(propertiesFile.getLocator("list_From"), "2019-02-01");
			myRepository.enterTextField(propertiesFile.getLocator("List_To"), "2019-02-02");
			Thread.sleep(2000);
			// myRepository.clickButton(objMap.getLocator("list_checkBox"));
			Thread.sleep(2000);
			myRepository.enterTextField(propertiesFile.getLocator("list_employee"), "Russel Hamilton");
			myRepository.selectDropDownVisibleText(propertiesFile.getLocator("list_subUnite"), "IT");
			Thread.sleep(2000);
			// myRepository.clickButton(objMap.getLocator("list_checkBoxA"));
			myRepository.clickButton(propertiesFile.getLocator("list_search"));
		
			WebElement leaveRecords = driver.findElement(By.cssSelector("[colspan]"));
			String leaveRecordGetTxt =leaveRecords.getText();
			System.out.println("This is your Leave record & Your Record shows you have: "+leaveRecordGetTxt);
			myRepository.clickButton(propertiesFile.getLocator("Dashboard"));


		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void timeSheets() {
		try {
			myRepository.clickButton(propertiesFile.getLocator("timesheet"));
			myRepository.enterTextField(propertiesFile.getLocator("Employee_Name"), "Linda Anderson");
			myRepository.clickButton(propertiesFile.getLocator("view"));
			WebElement tSheetResulte = driver.findElement(propertiesFile.getLocator("TimeSheetResulte"));
	        String getTimeshetTxt = tSheetResulte.getText();
	        System.out.println("This is your time sheet:"+getTimeshetTxt);
			myRepository.clickButton(propertiesFile.getLocator("Dashboard"));
			  

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
