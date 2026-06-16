package branch_division_financialyear_testcase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import basetest.BaseTest;
import icaffe_branch_division.BranchDivisionFinYear_Page;
import icaffe_homepage.Homepage;
import icaffe_loginpage.IcaffeLogin;
import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class Branch_Division_FinancialYear_TestCase {

	protected static WebUtil utilObj;
	protected static ExtentTest extObj;
	protected static Properties proObj;

	// This annotation runs before every test case. Annotation: @Test

	@BeforeSuite
	public void generatReport() {
		String reportType = this.getClass().getSimpleName();
		WebUtil.genrateExtentReport(reportType);
	}

	@BeforeMethod
	public void login(Method testName) throws InterruptedException {
		utilObj = new WebUtil();
		String reportType = this.getClass().getSimpleName();
		extObj = utilObj.generateExtentTest(testName.getName(),reportType);

		proObj = WebUtil.propertiFile("Akash_CommonSelection_Login_BranchDivisionYear.properties");
		String browsername = proObj.getProperty("browser");
		String urlName = proObj.getProperty("url");

		utilObj.launchBrowser(browsername);
		utilObj.openURL(urlName);

		IcaffeLogin logObj = new IcaffeLogin(utilObj,extObj);
		logObj.enterLoginCreadential();
		logObj.clickOnLoginBT();
	}

	// This annotation runs after every test case. Annotation: @Test

	@AfterMethod
	public void takeScreenShot(ITestResult result, Method testName) {
		if (result.getStatus() == ITestResult.FAILURE) {

			String snapShot = utilObj.takeScreenShot(testName.getName());
			String reportType = this.getClass().getSimpleName();
			utilObj.generateExtentTest(snapShot,reportType).addScreenCaptureFromPath(snapShot);
		}
		utilObj.flush();

		utilObj.quit();

	}

	@AfterSuite
	public void closeBrowser() {
		utilObj.flush();
	}

	// Validate AllBranch_Division_FinYear_with_DataProvider...

	 @Test(priority = 1, dataProvider = "ReadDataFromExcel", dataProviderClass = ExcelDataSuplier.class)
	public void validate_AllBranch_Division_FinYear_with_DataProvider(String branchname, String division,
			String finYear, String exp_ID, String exp_Year, String exp_ENV, String exp_Branch_Division) {

		BranchDivisionFinYear_Page logBranchDiv = new BranchDivisionFinYear_Page(utilObj, extObj);

		logBranchDiv.SelectBranch(branchname);

		logBranchDiv.SelectDevision(division);

		logBranchDiv.SelectFinYear(finYear);

		logBranchDiv.clickOnOKButton();

		List<String> expectedList = Arrays.asList(exp_ID, exp_Year, exp_ENV, exp_Branch_Division);

		Homepage homeObj = new Homepage(utilObj);

		homeObj.getText_LoginBranchDivision_OnHomePage(expectedList);

	}



}
