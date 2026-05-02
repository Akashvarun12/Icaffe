package logintestcase;

import org.testng.annotations.Test;

import basetest.BaseTestForLogin;
import login.IcaffeLogin;
import webutil.ExcelDataSuplier;



public class LoginTestCase extends BaseTestForLogin {

	// Login with Excel using multiple credentials (VALID & INVALID)
	
	//@Test(description = "LoginSheet|Akash_TestByDataprovider.xlsx",dataProvider = "ReadDataFromExcel" ,dataProviderClass = ExcelDataSuplier.class)
	public void validateLoginPage(String username,String password,String type ,String expectedTitle) {
		
		
		IcaffeLogin logObj=	new IcaffeLogin(utilObj);
		logObj.enterLoginCreadentialFromDataProvider(username,password,"UserName","Password");
		
		logObj.clickOnLoginBT();
		utilObj.validateGetTitle(expectedTitle,type,"Credential");
		 
	}
	
	
	//Login with valid credential and validation
	@Test
	public void validateLoginWithValidCredential() {
		
		
		IcaffeLogin logObj=	new IcaffeLogin(utilObj);
		logObj.enterLoginCreadential();	
		logObj.clickOnLoginBT();
		
		utilObj.validateGetTitle("Login Branch Division","valid","Credential");
	}
	
	

	
	
}
