package logintestcase;

import org.testng.annotations.Test;

import basetest.BaseTestForLogin;
import login.IcaffeLogin;
import webutil.ExcelDataSuplier;



public class LoginTestCase extends BaseTestForLogin {

	// Login with Excel using multiple credentials (VALID & INVALID)
	
	@Test(description = "LoginSheet",dataProvider = "ReadDataFromExcel" ,dataProviderClass = ExcelDataSuplier.class)
	public void validateLoginPageTitleAfterLogin(String username,String password,String type ,String expectedTitle) {
		
		
		IcaffeLogin logObj=	new IcaffeLogin(utilObj);
		logObj.enterLoginCreadentialFromDataProvider(username,password,"Login","Password");
		
		logObj.clickOnLoginBT();
		utilObj.validateGetTitle(expectedTitle,type,"Login");
		 
	}
	
	
	//Login with valid credential and validation
	@Test
	public void validateLoginWithValidCredential() {
		
		
		IcaffeLogin logObj=	new IcaffeLogin(utilObj);
		logObj.enterLoginCreadential("Login","Passowrd");	
		logObj.clickOnLoginBT();
		
		utilObj.validateGetTitle("Login Branch Division","valid","Login");
	}
	
	

	
	
}
