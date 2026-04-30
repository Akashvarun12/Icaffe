package logintestcase;

import org.testng.annotations.Test;

import basetest.BaseTestForLogin;
import login.IcaffeLogin;
import webutil.ExcelDataSuplier;



public class LoginTestCase extends BaseTestForLogin {

	// Login with Excel using multiple credentials (VALID & INVALID) & Validation
	
	@Test(description = "LoginSheet",dataProvider = "ReadDataFromExcel" ,dataProviderClass = ExcelDataSuplier.class)
	public void validateLoginPageTitleAfterLogin(String username,String password,String type, String expectedTitle) {
		
		
		IcaffeLogin logObj=	new IcaffeLogin(utilObj);
		logObj.enterLoginCreadentialFromDataProvider(username,password,"Username textbox","Password textbox");
		
		logObj.clickOnLoginBT();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		utilObj.validateGetTitle(expectedTitle,type,"page");		 
	}
	
	
	
	
	//Login with valid credential and validation (By Properties Files)
//	@Test
	public void validateLoginWithValidCredential() {
		
		
		IcaffeLogin logObj=	new IcaffeLogin(utilObj);
		logObj.enterLoginCreadential("Login","Passowrd");	
		logObj.clickOnLoginBT();
		
		utilObj.validateGetTitle("Login Branch Division","valid","page");
	}
	
	

	
	
}
