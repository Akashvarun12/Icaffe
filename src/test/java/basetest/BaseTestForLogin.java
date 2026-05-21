package basetest;

import java.lang.reflect.Method;

import java.util.Properties;

import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import webutil.WebUtil;

public class BaseTestForLogin {

	protected WebUtil utilObj;

	@BeforeSuite
	public void generatReport() {
		String reportType = this.getClass().getSimpleName();
		WebUtil.genrateExtentReport(reportType);
	}

	@BeforeTest
	public void importFileFromExcel() {

	}

	@BeforeMethod
	public void login(Method testName) {
		utilObj = new WebUtil();
		String reportType = this.getClass().getSimpleName();
		utilObj.generateExtentTest(testName.getName(),reportType);
		Properties proObj = utilObj.propertiFile("Akash_CommonSelection_Login_BranchDivisionYear.properties");
		String browsername = proObj.getProperty("browser");
		String urlName = proObj.getProperty("url");

		utilObj.launchBrowser(browsername);
		utilObj.openURL(urlName);

	}

	@AfterMethod
	public void takeScreenShot(ITestResult result, Method testName) throws InterruptedException {
		if (result.getStatus() == ITestResult.FAILURE) {

			utilObj.takeScreenShot(testName.getName());
		}
		Thread.sleep(1000);
//			Login_Page logObj = new Login_Page(utilObj);
//			logObj.logOut();
		utilObj.quit();
		utilObj.flush();

	}

	@AfterSuite
	public void closeBrowser() {
		utilObj.flush();
	}

}
