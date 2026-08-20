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

import com.aventstack.extentreports.ExtentTest;

import icaffe_homepage.Homepage;
import webutil.WebUtil;

public class BaseTestForLogin {


		protected WebUtil utilObj ;
		protected static ExtentTest extObj;

		@BeforeSuite
		public void generatReport() {
			String reportType = this.getClass().getSimpleName();
			WebUtil.genrateExtentReport(reportType);
		}

		@BeforeTest
		public void importFileFromExcel() {

		}


		@BeforeMethod
		public void login( Method testName) {
			utilObj = new WebUtil();
			String reportType = this.getClass().getSimpleName();
			extObj = utilObj.generateExtentTest(testName.getName(),reportType);
			Properties pr = utilObj.propertiFile("Shivam_browser_url_and_credential.properties");
			String browsername = pr.getProperty("browser");
			String urlName = pr.getProperty("url");
			
			
			utilObj.launchBrowser(browsername);
			utilObj.openURL(urlName);

		}

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

	}


