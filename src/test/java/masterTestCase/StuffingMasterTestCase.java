package masterTestCase;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import masterPageClass.StuffingMasterPage;
import webutil.ExcelDataSuplier;

public class StuffingMasterTestCase extends BaseTest {

	
// Test Case - 1 - Stuffing Master Page Title Validation
	@Test(priority = 1)
	public void pageTitleStuffingMaster() {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToStuffingMaster();
		utilObj.validateGetTitle("Stuffing Master", "valid", "Stuffing Master Page Title");
	}
	
	
	
	
// Test Case - 2 - Stuffing Master Record Creation
	@Test(priority = 2, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void createStuffingMaster(String stuffingName, String referTo) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToStuffingMaster();
		utilObj.validateGetTitle("Stuffing Master", "valid", "Stuffing Master Page Title");
		
		StuffingMasterPage stuffingMasterPage = new StuffingMasterPage(utilObj);
		stuffingMasterPage.createStuffingMasterPage(stuffingName, referTo);
	}
	
	
	
	
// Test Case - 3 - Stuffing Master Record Modification
	@Test(priority = 3, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyStuffingMaster(String search, String searchGridRecord, String stuffingName, String referTo) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToStuffingMaster();
		utilObj.validateGetTitle("Stuffing Master", "valid", "Stuffing Master Page Title");
		
		StuffingMasterPage stuffingMasterPage = new StuffingMasterPage(utilObj);
		stuffingMasterPage.modifyStuffingMasterPage(search, searchGridRecord, stuffingName, referTo);
	}
	
	
	
	
// Test Case - 4 - Stuffing Master Record Deletion
	@Test(priority = 4, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void deleteStuffingMaster(String search, String searchGridRecord, String stuffingName, String referTo) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToStuffingMaster();
		utilObj.validateGetTitle("Stuffing Master", "valid", "Stuffing Master Page Title");
		
		StuffingMasterPage stuffingMasterPage = new StuffingMasterPage(utilObj);
		stuffingMasterPage.deleteStuffingMasterPage(search, searchGridRecord, stuffingName, referTo);
	}
	
	
	
	
// Test Case - 5 - Stuffing Master Page Clear
	@Test(priority = 5, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void clearStuffingMaster(String search, String searchGridRecord, String stuffingName, String referTo) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToStuffingMaster();
		utilObj.validateGetTitle("Stuffing Master", "valid", "Stuffing Master Page Title");
		
		StuffingMasterPage stuffingMasterPage = new StuffingMasterPage(utilObj);
		stuffingMasterPage.clearStuffingMasterPage(search, searchGridRecord, stuffingName, referTo);
	}
	
	
	

}
