package com.OrangeHRM.ObjectMapProject;

import org.testng.annotations.Test;


import com.Library.BasePage;

public class OrangeHRM_CallMethodPage extends BasePage {
	
	
	OrangeHRM_ObjectMapLogin login=new OrangeHRM_ObjectMapLogin();
	OrangeHRM_Dashboard dashBoard = new OrangeHRM_Dashboard();
	
	@Test
	public void callMethods() {
		login.orangeHRM_Login();
		login.verfiyingMainPage();
		login.addNew_user();
		dashBoard.assgine_leaves();
		dashBoard.leave_list();
		dashBoard.timeSheets();
		
		
		
		
		
		
		
	}
	
	
	
	

}
