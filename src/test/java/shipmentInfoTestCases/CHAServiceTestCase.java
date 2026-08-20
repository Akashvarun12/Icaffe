package shipmentInfoTestCases;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import shipmentInfoPageClasses.CHAServicePage;
import webutil.ExcelDataSuplier;


public class CHAServiceTestCase extends BaseTest {
	
	
// Test Case - 1 - CHA Service Page Title Validation	
	@Test(priority = 1)
	public void CHAServicePageTitle() {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToCHAServicePage();
		
		// CHA Service Master Page Validation
		utilObj.validateGetTitle("CHA Service Master", "valid", " CHA Service Master Page");	
	}
	

	
	
	
// Test Case - 2 - Create a new CHA Service Record
		@Test(priority = 2, description = "CHAService|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
		public void saveCHAService(String serviceName, 
				String displayStatus, 
				String tradeCode, 
				String charge, 
				String customer, 
				String segment) throws Exception {
			
			Homepage homepage = new Homepage(utilObj);
			homepage.goToCHAServicePage();
			utilObj.validateGetTitle("CHA Service Master", "valid", " CHA Service Master Page");
			
			CHAServicePage chaServicePage = new CHAServicePage(utilObj);
			chaServicePage.createCHAServiceRecord(serviceName, displayStatus, tradeCode, charge, customer, segment);	
		}
		
		
		
		
// Test Case - 3 - Modify CHA Service Record	
		@Test(priority = 3, description = "CHAService|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
		public void modifyCHAService(String search, 
				String selectedValue, 
				String serviceName, 
				String displayStatus, 
				String tradeCode, 
				String charge, 
				String customer, 
				String segment) throws Exception {
			
			Homepage homepage = new Homepage(utilObj);
			homepage.goToCHAServicePage();
			utilObj.validateGetTitle("CHA Service Master", "valid", " CHA Service Master Page");
			
			CHAServicePage chaServicePage = new CHAServicePage(utilObj);
			chaServicePage.modifyCHAServicePage(search, selectedValue, serviceName, displayStatus, tradeCode, charge, customer, segment);
		}
		
		

		
// Test Case - 4 -Clear the CHA Service Page
		@Test(priority = 4, description = "CHAService|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
		public void clearCHAService(String serviceName, 
				String displayStatus, 
				String tradeCode, 
				String charge, 
				String customer, 
				String segment) throws Exception {
			Homepage homepage = new Homepage(utilObj);
			
			// CHA Service Page validation
			homepage.goToCHAServicePage();
			utilObj.validateGetTitle("CHA Service Master", "valid", " CHA Service Master Page");
			
			CHAServicePage chaServicePage = new CHAServicePage(utilObj);
			chaServicePage.clearCHAServicePage(serviceName, displayStatus, tradeCode, charge, customer, segment);							
		}
		
		
		
		
		
		
		

}
