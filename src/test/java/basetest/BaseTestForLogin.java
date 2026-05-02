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


		protected WebUtil utilObj ;
	



		@BeforeSuite
		public void generatReport() {
			WebUtil.genrateExtentReport();
		}

		@BeforeTest
		public void importFileFromExcel() {

		}


		@BeforeMethod
		public void login( Method testName) {
			utilObj = new WebUtil();
			utilObj.generateExtentTest(testName.getName());
//			Properties pr = utilObj.propertiFile("Akash_browser_url_and_credential.properties");
//			String browsername = pr.getProperty("browser");
//			String urlName = pr.getProperty("url");
			
			String browsername = WebUtil.getConfig("browser");
			String urlName = WebUtil.getConfig("url");
			
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


