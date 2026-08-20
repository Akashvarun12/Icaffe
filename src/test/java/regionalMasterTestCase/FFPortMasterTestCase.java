package regionalMasterTestCase;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import regionalMasterPageClass.FFPortMasterPage;
import webutil.ExcelDataSuplier;

public class FFPortMasterTestCase extends BaseTest {
	
	
// Test Case - 1 - FF Port Master Page Title Validation
	@Test(priority = 1)
	public void pageTitleFFPortMaster() {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToFFPortMasterPage();
		utilObj.validateGetTitle("SEA PORT", "valid", "SEA PORT Page Title");
	}
	
	
	

// Test Case - 2 - FF Port Master Record Creation (Single or Multiple)
	@Test(priority = 2, description = "FFPortMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void createFFPortMaster(String country, String portCode, String portName) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToFFPortMasterPage();
		utilObj.validateGetTitle("SEA PORT", "valid", "SEA PORT Page Title");
		
		FFPortMasterPage ffPortMasterPage = new FFPortMasterPage(utilObj);
		ffPortMasterPage.createFFPortMasterPage(country, portCode, portName);
	}
	
	
	
	
// Test Case - 2 - FF Port Master Record Creation (Single or Multiple)
		
	@Test(priority = 3, description = "FFPortMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)	
	public void duplicateFFPortMaster(String country, String portCode, String portName) {
			
		Homepage homepage = new Homepage(utilObj);	
		homepage.goToFFPortMasterPage();	
		utilObj.validateGetTitle("SEA PORT", "valid", "SEA PORT Page Title");
			
		FFPortMasterPage ffPortMasterPage = new FFPortMasterPage(utilObj);	
		ffPortMasterPage.duplicateFFPortMasterPage(country, portCode, portName);
		}
	
	
	
	
// Test Case - 3 - FF Port Master Record Modification
	@Test(priority = 4, description = "FFPortMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyFFPortMaster(String selectCountry, String selectPortName, String country, String portCode, String portName) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToFFPortMasterPage();
		utilObj.validateGetTitle("SEA PORT", "valid", "SEA PORT Page Title");
		
		FFPortMasterPage ffPortMasterPage = new FFPortMasterPage(utilObj);
		ffPortMasterPage.modifyFFPortMasterPage(selectCountry, selectPortName, country, portCode, portName);	
	}
	
	
	
	
	
// Test Case - 4 - FF Port Master Page Clear
	@Test(priority = 5, description = "FFPortMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void clearFFPortMaster(String selectCountry, String selectPortName, String country, String portCode, String portName) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToFFPortMasterPage();
		utilObj.validateGetTitle("SEA PORT", "valid", "SEA PORT Page Title");
		
		FFPortMasterPage ffPortMasterPage = new FFPortMasterPage(utilObj);
		ffPortMasterPage.clearFFPortMasterPage(selectCountry, selectPortName, country, portCode, portName);
	}

}
