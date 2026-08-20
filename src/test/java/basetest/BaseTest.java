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

import com.aventstack.extentreports.ExtentTest;

import branch_division.LoginBranchDivision;
import icaffe_homepage.Homepage;
import login.IcaffeLogin;
import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class BaseTest {
	protected static WebUtil utilObj;
	protected static ExtentTest extObj;
    

	@BeforeSuite
	public void generatReport() {
		String reportType = this.getClass().getSimpleName();
		WebUtil.genrateExtentReport(reportType);
	}

	@BeforeMethod
	public void login(Method testName) throws Exception {
		// Login Test Case
		utilObj = new WebUtil();
		String reportType = this.getClass().getSimpleName();
		extObj = utilObj.generateExtentTest(testName.getName(),reportType);
		Properties pr = utilObj.propertiFile("Shivam_browser_url_and_credential.properties");
		String browsername = pr.getProperty("browser");
		String urlName = pr.getProperty("url");
		utilObj.launchBrowser(browsername);
		utilObj.openURL(urlName);

		IcaffeLogin logObj = new IcaffeLogin(utilObj);
		logObj.enterLoginCreadential();
		logObj.clickOnLoginBT();

		
	//  Branch, Division and Financial Year Selection			
		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj);			
		Properties properties = utilObj.propertiFile("Shivam_Branch_Division_Year.properties");			
		String branchName = properties.getProperty("branch");			
		String divisionCheckbox = properties.getProperty("division");			
		String finYear = properties.getProperty("year");			
		logBranchDiv.SelectBranch(branchName);		
		logBranchDiv.SelectDevision(divisionCheckbox);
		logBranchDiv.SelectFinYear(finYear);				
		logBranchDiv.clickOnOKButton();	
		
		Homepage homeObj = new Homepage(utilObj);
		List<String> actualList = homeObj.verifyLoginBranchDivision_OnHomePage();
		List<String> expectedList = Arrays.asList("Shivam220", "(2627)", "DEMO LTD",
				"Ahmedabad (Export Sea)");
		utilObj.validateListOfText_Shivam(actualList, expectedList);
			
	}

	
	@AfterMethod()
	public void takeScreenShot(ITestResult result, Method testName) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {

			String snapShot = utilObj.takeScreenShot(testName.getName());
			String reportType = this.getClass().getSimpleName();
			utilObj.generateExtentTest(snapShot,reportType).addScreenCaptureFromPath(snapShot);
			
		}
		utilObj.flush();
		Thread.sleep(1000);
		
		Homepage homepage = new Homepage(utilObj);
		try {
			homepage.logout();
	        Thread.sleep(5000); 
	        utilObj.getDriver().manage().deleteAllCookies();
	        utilObj.quit();
	        Thread.sleep(3000);
	        
		} catch (Exception e) {
			System.out.println("Logout issue: " + e.getMessage());
			if(utilObj.getDriver() != null) {
				homepage.logout();
				utilObj.getDriver().quit();
		    }
		}
	    
	}
		
		
		

	@AfterSuite
	public void closeBrowser() {
		utilObj.flush();
	}

}
