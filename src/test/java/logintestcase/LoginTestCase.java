package logintestcase;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import login.IcaffeLogin;
import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class LoginTestCase {
	
	// This annotation runs before every test case. Annotation: @Test

	protected WebUtil utilObj;

	@BeforeSuite
	public void generatReport() {
		WebUtil.genrateExtentReport();
	}

	@BeforeTest
	public void importFileFromExcel() {

	}

	@BeforeMethod
	public void login(Method testName) {
		utilObj = new WebUtil();
		utilObj.generateExtentTest(testName.getName());

		String browsername = WebUtil.getConfig("browser");
		String urlName = WebUtil.getConfig("url");

		utilObj.launchBrowser(browsername);
		utilObj.openURL(urlName);

	}
	
	// This annotation runs after every test case. Annotation: @Test

	@AfterMethod
	public void takeScreenShot(ITestResult result, Method testName) throws InterruptedException {
		if (result.getStatus() == ITestResult.FAILURE) {

			utilObj.takeScreenShot(testName.getName());
		}
		Thread.sleep(1000);
//		Login_Page logObj = new Login_Page(utilObj);
//		logObj.logOut();
		utilObj.quit();
		utilObj.flush();

	}

	@AfterSuite
	public void closeBrowser() {
		utilObj.flush();
	}

	// Validate Login Page with Title....

	@Test(dataProvider = "ReadDataFromExcel", dataProviderClass = ExcelDataSuplier.class)
	public void validateLoginPageWith_Title(String username, String password, String type, String expectedTitle) {

		IcaffeLogin logObj = new IcaffeLogin(utilObj);
		logObj.enterLoginCreadentialFromDataProvider(username, password, "UserName", "Password");

		logObj.clickOnLoginBT();
		utilObj.validateGetTitle(expectedTitle, type, "Credential");

	}

}
