package basetest;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;

import icaffe_branch_division.BranchDivisionFinYear_Page;
import icaffe_loginpage.IcaffeLogin;
import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class BaseTest {
	protected static WebUtil utilObj;
	protected static ExtentTest extObj;
	protected static IcaffeLogin logObj;
	protected Properties proObj;

	@BeforeSuite
	public void generatReport() {
		
		WebUtil.genrateExtentReport();
	}

	@BeforeMethod
	public void login(Method testName) throws InterruptedException {

		utilObj = new WebUtil();
		extObj = utilObj.generateExtentTest(testName.getName());
		proObj = WebUtil.propertiFile("Akash_CommonSelection_Login_BranchDivisionYear.properties");
		String browsername = proObj.getProperty("browser");
		String urlName = proObj.getProperty("url");
		utilObj.launchBrowser(browsername);
		utilObj.openURL(urlName);

		logObj = new IcaffeLogin(utilObj);
		logObj.enterLoginCreadential();
		logObj.clickOnLoginBT();

		BranchDivisionFinYear_Page logBranchDiv = new BranchDivisionFinYear_Page(utilObj, extObj);

		String branchName = proObj.getProperty("branchName");
		String division = proObj.getProperty("division");
		String finYear = proObj.getProperty("finYear");

		logBranchDiv.SelectBranch(branchName);

		logBranchDiv.SelectDevision(division);

		logBranchDiv.SelectFinYear(finYear);

		logBranchDiv.clickOnOKButton();
	}

	@AfterMethod
	public void takeScreenShot(ITestResult result, Method testName) throws InterruptedException {
		if (result.getStatus() == ITestResult.FAILURE) {

			String snapShot = utilObj.takeScreenShot(testName.getName());
			utilObj.generateExtentTest(snapShot).addScreenCaptureFromPath(snapShot);
		}
		utilObj.flush();
		Thread.sleep(1000);
       
		logObj.clickOnLogOut();
		utilObj.quit();

	}

	@AfterSuite
	public void closeBrowser() {
		utilObj.flush();
	}

}
