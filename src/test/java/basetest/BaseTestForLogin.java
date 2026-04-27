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
	
		
//		@DataProvider()
//		public Object[][] provideLoginData() {
//
//			 List<Map<String,String>> testData = ExcelDataSuplier.setExcelFile("TestSheet");
//			 int dataMapCount=testData.size();
//			 Object[][] allData= new Object[dataMapCount][1];
//			 for(int i=0;i<=dataMapCount-1;i++) {
//				allData[i][0] = testData.get(i);
//			 }
//			 
//		return allData;    
//		}


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
			Properties pr = utilObj.propertiFile("browser_and_url.properties");
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


