package regionalMasterTestCase;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import regionalMasterPageClass.PeriodMasterPage;
import webutil.ExcelDataSuplier;

public class PeriodMasterTestCase extends BaseTest {

	
// Test Case - 1 - Period Master Page Title Validation
	@Test(priority = 1)
	public void pageTitlePeriodMaster() {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToPeriodMasterPage();
		utilObj.validateGetTitle("Period Master", "valid", "Period Master Page Title");
	}
	
	
	

// Test Case - 2 - Period Master New Record Creation (Single or Multiple)
	@Test(priority = 2, description = "PeriodMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void createPeriodMaster(String code, String name, String displayStatus) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToPeriodMasterPage();
		utilObj.validateGetTitle("Period Master", "valid", "Period Master Page Title");
		PeriodMasterPage periodMasterPage = new PeriodMasterPage(utilObj);
		periodMasterPage.createPeriodMasterPage(code, name, displayStatus);
	}
	
	
	
	
// Test Case - 3 - Period Master Record Modification
	@Test(priority = 3, description = "PeriodMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyPeriodMaster(String search, String searchRecord, String code, String name, String displayStatus) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToPeriodMasterPage();
		utilObj.validateGetTitle("Period Master", "valid", "Period Master Page Title");
		PeriodMasterPage periodMasterPage = new PeriodMasterPage(utilObj);
		periodMasterPage.modifyPeriodMasterPage(search, searchRecord, code, name, displayStatus);	
	}
	
	
	
	
// Test Case - 4 - Period Master Page Clear
	@Test(priority = 4, description = "PeriodMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void clearPeriodMaster(String search, String searchRecord, String code, String name, String displayStatus) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToPeriodMasterPage();
		utilObj.validateGetTitle("Period Master", "valid", "Period Master Page Title");
		PeriodMasterPage periodMasterPage = new PeriodMasterPage(utilObj);
		periodMasterPage.clearPeriodMasterPage(search, searchRecord, code, name, displayStatus);
	}
	
	
}

