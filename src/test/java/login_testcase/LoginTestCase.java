package login_testcase;

import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;

import icaffe_loginpage.IcaffeLogin;
import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class LoginTestCase {

	// This annotation runs before every test case. Annotation: @Test

	protected WebUtil utilObj;

	@BeforeSuite
	public void generatReport() {
		String reportType = this.getClass().getSimpleName();
		WebUtil.genrateExtentReport(reportType);
	}

	@BeforeMethod
	public void login(Method testName) {
		utilObj = new WebUtil();
		String reportType = this.getClass().getSimpleName();
		utilObj.generateExtentTest(testName.getName(),reportType);

		Properties proObj = WebUtil.propertiFile("Akash_CommonSelection_Login_BranchDivisionYear.properties");
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
	public void validateLoginPageWith_Title(String username, String password, String expectedTitle,String expType) {

		IcaffeLogin logObj = new IcaffeLogin(utilObj);
		logObj.enterLoginCreadential(username, password, "UserName", "Password");

		logObj.clickOnLoginBT();
		utilObj.validateTitleForLoginPages(expectedTitle,expType  );

	}

	// li[contains(text(),'User Already Login.')]

}
