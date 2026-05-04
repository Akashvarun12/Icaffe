package branch_division_finyear;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import basetest.BaseTest;
import branch_division.LoginBranchDivision;
import icaffe_homepage.Homepage;
import login.IcaffeLogin;
import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class Branch_Division_FinYear_TestCase {

	protected static WebUtil utilObj;
	protected static ExtentTest extObj;

	// This annotation runs before every test case. Annotation: @Test

	@BeforeSuite
	public void generatReport() {
		WebUtil.genrateExtentReport();
	}

	@BeforeMethod
	public void login(Method testName) throws InterruptedException {

		utilObj = new WebUtil();
		extObj=	utilObj.generateExtentTest(testName.getName());

		String browsername = WebUtil.getConfig("browser");
		String urlName = WebUtil.getConfig("url");
		utilObj.launchBrowser(browsername);
		utilObj.openURL(urlName);
		WebUtil.getConfig("username");
		WebUtil.getConfig("password");

		IcaffeLogin logObj = new IcaffeLogin(utilObj);
		logObj.enterLoginCreadential();
		logObj.clickOnLoginBT();
	}

	// This annotation runs after every test case. Annotation: @Test

	@AfterMethod
	public void takeScreenShot(ITestResult result, Method testName) {
		if (result.getStatus() == ITestResult.FAILURE) {

			String snapShot = utilObj.takeScreenShot(testName.getName());
			utilObj.generateExtentTest(snapShot).addScreenCaptureFromPath(snapShot);
		}
		utilObj.flush();
		

		utilObj.quit();

	}

	@AfterSuite
	public void closeBrowser() {
		utilObj.flush();
	}


	// Validate Branch_Division_FinYear_with_ID from Excel sheet (DYNAMICALLY)...
	
	@Test
	public void validateAll_Branch_Division_FinYear_with_ID() {

		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj,extObj);

		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel("A-3");

		String braname = testData.get("branchname");
		String divi = testData.get("division");
		String year = testData.get("finYear");

		logBranchDiv.SelectBranch(braname);

		logBranchDiv.SelectDevision(divi);

		logBranchDiv.SelectFinYear(year);

		logBranchDiv.clickOnOKButton();

		Homepage homeObj = new Homepage(utilObj);

		List<String> expectedList = Arrays.asList("Akash12", "(2627)", "DEMO LTD", "Ahmedabad (Import Air)");
		homeObj.getText_LoginBranchDivision_OnHomePage(expectedList);

	}

	// Validate AllBranch_Division_FinYear_with_DataProvider...

	@Test(dataProvider = "ReadDataFromExcel", dataProviderClass = ExcelDataSuplier.class)
	public void validate_AllBranch_Division_FinYear_with_DataProvider(String branchname, String division,
			String finYear, String exp_1, String exp_2, String exp_3, String exp_4) {

		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj,extObj);

		logBranchDiv.SelectBranch(branchname);

		logBranchDiv.SelectDevision(division);

		logBranchDiv.SelectFinYear(finYear);

		logBranchDiv.clickOnOKButton();

		List<String> expectedList = Arrays.asList(exp_1, exp_2, exp_3, exp_4);

		Homepage homeObj = new Homepage(utilObj);

		homeObj.getText_LoginBranchDivision_OnHomePage(expectedList);

	}

}
