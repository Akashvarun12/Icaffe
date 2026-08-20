package logintestcase;

import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basetest.BaseTestForLogin;
import login.IcaffeLogin;
import webutil.ExcelDataSuplier;
import webutil.WebUtil;



public class LoginTestCase extends BaseTestForLogin {

	// Login with Excel using multiple credentials (VALID & INVALID)
	@Test(description = "LoginSheet|Shivam_TestByDataprovider.xlsx",dataProvider = "ReadDataFromExcel" ,dataProviderClass = ExcelDataSuplier.class)
	public void validateLoginPage(String username,String password,String type ,String expectedTitle) throws Exception {
		
		
		IcaffeLogin logObj=	new IcaffeLogin(utilObj);
		logObj.enterLoginCreadentialFromDataProvider(username,password,"UserName","Password");
		
		logObj.clickOnLoginBT();
		utilObj.implicitlyWait();
		utilObj.validateGetTitle(expectedTitle,type,"Credential");	 
	}
	
	
	
	//Login with valid credential and validation (By Properties Files)
	@Test
	public void validateLoginWithValidCredential() throws Exception {
		IcaffeLogin logObj=	new IcaffeLogin(utilObj);
		logObj.enterLoginCreadential();	
		logObj.clickOnLoginBT();
		utilObj.implicitlyWait();
		utilObj.validateGetTitle("Login Branch Division","valid","Credential");
	}
	
	

	
	
}
