package miscMasterTestCase;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import miscMasterPageClass.TriggerMasterPage;
import webutil.ExcelDataSuplier;

public class TriggerMasterTestCase extends BaseTest {


// Test Case - 1 - Trigger Master Page Title Validation 
	@Test(priority = 1)
	public void pageTitleTriggerMaster() {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToTriggerMasterPage();
		utilObj.validateGetTitle("Trigger Master", "valid", "Trigger Master Page title");
	}
	
	
	
	
// Test Case - 2 - Trigger Master New Record Creation (Single or Multiple)
	@Test(priority = 2, description = "TriggerMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void createTriggerMaster(String name, String type, String displayStatus, String note) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToTriggerMasterPage();
		utilObj.validateGetTitle("Trigger Master", "valid", "Trigger Master Page title");
		
		TriggerMasterPage triggerMasterPage = new TriggerMasterPage(utilObj);
		triggerMasterPage.createTriggerMasterPage(name, type, displayStatus, note);
	}
	
	
	
	
// Test Case - 3 - Trigger Master Record Modification
	@Test(priority = 3, description = "TriggerMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyTriggerMaster(String search, String fromDate, String toDate, String searchGridRecord, String name, 
			String type, String displayStatus, String note){
		
		Homepage homepage = new Homepage(utilObj);
		homepage.goToTriggerMasterPage();
		utilObj.validateGetTitle("Trigger Master", "valid", "Trigger Master Page Title");
		
		TriggerMasterPage triggerMasterPage = new TriggerMasterPage(utilObj);
		triggerMasterPage.modifyTriggerMasterPage(search, fromDate, toDate, searchGridRecord, name, name, displayStatus, note);		
	}
	
	
	
	
// Test Case - 4 - Trigger Master Page Clear
	@Test(priority = 4, description = "TriggerMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void clearTriggerMaster(String search, String fromDate, String toDate, String searchGridRecord, String name, 
			String type, String displayStatus, String note) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToTriggerMasterPage();
		utilObj.validateGetTitle("Trigger Master", "valid", "Trigger Master Page Title");
		
		TriggerMasterPage triggerMasterPage = new TriggerMasterPage(utilObj);
		triggerMasterPage.clearTriggerMasterPage(search, fromDate, toDate, searchGridRecord, name, name, displayStatus, note);
	}
}
