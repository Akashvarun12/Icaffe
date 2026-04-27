package basetest;

import java.lang.reflect.Method;
import java.util.Arrays;
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

import branch_division.LoginBranchDivision;
import icaffe_homepage.Homepage;
import login.IcaffeLogin;
import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class BaseTest {
	protected static WebUtil utilObj;


	@BeforeSuite
	public void generatReport() {
		WebUtil.genrateExtentReport();
	}

	@BeforeMethod
	public void login(Method testName) throws InterruptedException {

		utilObj = new WebUtil();
		utilObj.generateExtentTest(testName.getName());
		Properties pr = utilObj.propertiFile("browser_url_and_credential.properties");
		String browsername = pr.getProperty("browser");
		String urlName = pr.getProperty("url");
		utilObj.launchBrowser(browsername);
		utilObj.openURL(urlName);

		IcaffeLogin logObj = new IcaffeLogin(utilObj);
		logObj.enterLoginCreadential();
		logObj.clickOnLoginBT();
		
		
		
		
		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj);
		Properties properties = utilObj.propertiFile("Branch_Division_Year.properties");
		String branchName = properties.getProperty("branch");
		String divisionCheckbox = properties.getProperty("division");
		String finYear = properties.getProperty("year");

		logBranchDiv.SelectBranch(branchName);

		logBranchDiv.SelectDevision(divisionCheckbox);

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

		utilObj.quit();

	}

	@AfterSuite
	public void closeBrowser() {
		utilObj.flush();
	}

}
