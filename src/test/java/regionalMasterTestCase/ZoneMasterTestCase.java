package regionalMasterTestCase;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import regionalMasterPageClass.ZoneMasterPage;
import webutil.ExcelDataSuplier;


public class ZoneMasterTestCase extends BaseTest {
	
	
// Test Case - 1 - Zone Master Page Validation
	@Test(priority = 1)
	public void ZoneMasterPageTitle() {
		
		Homepage homepage = new Homepage(utilObj);				
		homepage.goToZoneMasterPage();
		utilObj.validateGetTitle("Zone Master", "valid", "Zone Master Page Title");	
	}
	
	
	
	
	
// Test Case - 2 - Zone Master new Record creation
	@Test(priority = 2, description = "ZoneMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void createZoneMaster(String code, String name, String countryCode, String displayStatus) throws Exception {
		
		Homepage homepage = new Homepage(utilObj);		
		homepage.goToZoneMasterPage();
		utilObj.validateGetTitle("Zone Master", "valid", "Zone Master Page Title");
		ZoneMasterPage zoneMasterPage = new ZoneMasterPage(utilObj);
		zoneMasterPage.createZoneMasterPage(code, name, countryCode, displayStatus);	
	}

	
	
	
// Test Case - 3 - Zone Master Record Modification
	@Test(priority = 3, description = "ZoneMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyZoneMaster(String search, String searchListValue, String code, String name, String countryCode, String displayStatus) throws Exception {
		Homepage homepage = new Homepage(utilObj);		
		homepage.goToZoneMasterPage();
		utilObj.validateGetTitle("Zone Master", "valid", "Zone Master Page Title");
		ZoneMasterPage zoneMasterPage = new ZoneMasterPage(utilObj);
		zoneMasterPage.modifyZoneMasterPage(search, searchListValue, code, name, countryCode, displayStatus);	
	}
	
	
	

// Test Case - 4 - Zone Master Page Clear
	@Test(priority = 4, description = "ZoneMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void clearZoneMaster(String search, String searchListValue, String code, String name, String countryCode, String displayStatus) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToZoneMasterPage();
		utilObj.validateGetTitle("Zone Master", "valid", "Zone Master Page Title");
		ZoneMasterPage zoneMasterPage = new ZoneMasterPage(utilObj);
		zoneMasterPage.clearZoneMaster(search, searchListValue, code, name, countryCode, displayStatus);
	}
	
}
