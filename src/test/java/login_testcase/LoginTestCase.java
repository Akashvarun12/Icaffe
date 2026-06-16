package login_testcase;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import icaffe_loginpage.IcaffeLogin;
import pojo.ExporterTestData;
import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class LoginTestCase {

	// This annotation runs before every test case. Annotation: @Test

	protected WebUtil utilObj;
	protected static ExtentTest extObj;
	protected Properties proObj = null;

	@BeforeSuite
	public void generatReport() {
		String reportType = this.getClass().getSimpleName();
		WebUtil.genrateExtentReport(reportType);
	}

	@BeforeMethod
	public void login(Method testName) {
		utilObj = new WebUtil();
		String reportType = this.getClass().getSimpleName();
		extObj=utilObj.generateExtentTest(testName.getName(), reportType);

		proObj = WebUtil.propertiFile("Akash_CommonSelection_Login_BranchDivisionYear.properties");
		String browsername = proObj.getProperty("browser");
		String urlName = proObj.getProperty("url");

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
		utilObj.quit();
		utilObj.flush();

	}

	@AfterSuite
	public void closeBrowser() {
		utilObj.flush();
	}

	// Validate Login Page with Title....

	@Test(priority = 1, dataProvider = "ReadDataFromExcel", dataProviderClass = ExcelDataSuplier.class)
	public void validateLoginPageWith_Title(String username, String password, String expectedTitle, String expType) {

		IcaffeLogin logObj = new IcaffeLogin(utilObj,extObj);
		logObj.enterLoginCreadentialwithDataProvider(username, password, "UserName", "Password");

		logObj.clickOnLoginBT();
		utilObj.validateTitleForLoginPages(expectedTitle, expType);

	}

//	// Validate User Already Login ....
//
//	@Test(priority = 2)
//	public void validateUserAlreadyLoggedIn(ITestContext context) {
//
//		IcaffeLogin logObj = new IcaffeLogin(utilObj,extObj);
//
//		// First Login
//		logObj.enterLoginCreadential();
//		logObj.clickOnLoginBT();
//
//		// Second Login with same user
//		String browsername = proObj.getProperty("browser");
//		String urlName = proObj.getProperty("url");
//		String userName = proObj.getProperty("userName");
//		String password = proObj.getProperty("password");
//		utilObj.launchBrowser(browsername);
//		utilObj.openURL(urlName);
//		utilObj.getDriver().findElement(By.id("UserName")).sendKeys(userName);
//		utilObj.getDriver().findElement(By.id("Password")).sendKeys(password);
//		utilObj.getDriver().findElement(By.id("LoginButton")).click();
//		logObj.validateAlreadyLoginAlert();
//		utilObj.quit();
//	}


}
