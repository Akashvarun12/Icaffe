package logintestcase;

import org.testng.annotations.Test;

import basetest.BaseTestForLogin;
import login.IcaffeLogin;
import webutil.ExcelDataSuplier;



public class LoginTestCase extends BaseTestForLogin {

	// Login with Excel using multiple credentials
	
	@Test(dataProvider =  "ReadDataFromExcel", dataProviderClass = ExcelDataSuplier.class)
	public void validateLoginCredential_001(String username,String password) {
		
		
		IcaffeLogin logObj=	new IcaffeLogin(utilObj);
		logObj.enterLoginCreadentialFromDataProvider(username,password);
		
		logObj.clickOnLoginBT();
		
		utilObj.validateGetTitle("Login Branch Division");
	}
	
	
	//Login with valid credential and validation
	@Test
	public void validateLoginWithValidCredential_002() {
		
		
		IcaffeLogin logObj=	new IcaffeLogin(utilObj);
		logObj.enterLoginCreadential();	
		logObj.clickOnLoginBT();
		
		utilObj.validateGetTitle("Login Branch Division");
	}
	
	

	
	
}
