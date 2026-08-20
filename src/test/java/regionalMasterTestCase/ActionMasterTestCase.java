package regionalMasterTestCase;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import regionalMasterPageClass.ActionMasterPage;
import webutil.ExcelDataSuplier;

public class ActionMasterTestCase extends BaseTest {
	
	
// Test Case - 1 - Action Master Page Title Validation
	@Test(priority = 1)
	public void pageTitleActionMaster() {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToActionMasterPage();
		utilObj.validateGetTitle("Action Master", "valid", " Action Master Page Title");
	}
	
	
	
// Test Case - 2 - Action Master Record Creation (Single or Multiple Record)
	@Test(priority = 2, description = "ActionMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void createActionMaster(String code, String name, String followUpDays, String type, String lovStatus) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToActionMasterPage();
		utilObj.validateGetTitle("Action Master", "valid", " Action Master Page Title");
		ActionMasterPage actionMasterPage = new ActionMasterPage(utilObj);
		actionMasterPage.createActionMasterPage(code, name, followUpDays, type, lovStatus);
	}
	
	
	
// Test Case - 3 - Action Master Record Modification (Single or Multiple)
	@Test(priority = 3, description = "ActionMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyActionMaster(String search, String searchValue, String code, String name, String followUpDays, String type, String lovStatus) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToActionMasterPage();
		utilObj.validateGetTitle("Action Master", "valid", " Action Master Page Title");
		ActionMasterPage actionMasterPage = new ActionMasterPage(utilObj);
		actionMasterPage.modifyActionMasterPage(search, searchValue, code, name, followUpDays, type, lovStatus);
	}
	
	
	
// Test Case - 4 - Action Master Page Clear
	@Test(priority = 4, description = "ActionMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void clearActionMaster(String search, String searchValue, String code, String name, String followUpDays, String type, String lovStatus) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToActionMasterPage();
		utilObj.validateGetTitle("Action Master", "valid", " Action Master Page Title");
		ActionMasterPage actionMasterPage = new ActionMasterPage(utilObj);
		actionMasterPage.clearActionMasterPage(search, searchValue, code, name, followUpDays, type, lovStatus);
	}
	
	
}
