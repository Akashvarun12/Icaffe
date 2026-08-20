package masterTestCase;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import masterPageClass.DestuffingMasterPage;
import webutil.ExcelDataSuplier;

public class DestuffingMasterTestCase extends BaseTest {	
		
// Test Case - 1 - Destuffing Page Title Validation	
	@Test(priority = 1)
	public void pageTitleDestuffingMaster() {	
		Homepage homepage = new Homepage(utilObj);	
		homepage.goToDestuffing();	
		utilObj.validateGetTitle("Destuffing master", "valid", " Destuffing Master  Page Title");	
	}
		
		
		
		
// Test Case - 2 - Destuffing Master Record Creation	
	@Test(priority = 2, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)	
	public void createDestuffingMaster(String destuffingName, String referTo) {	
		Homepage homepage = new Homepage(utilObj);	
		homepage.goToDestuffing();
		utilObj.validateGetTitle("Destuffing master", "valid", " Destuffing Master  Page Title");
			
		DestuffingMasterPage destuffingMasterPage = new DestuffingMasterPage(utilObj);
		destuffingMasterPage.createDestuffingMasterPage(destuffingName, referTo);
		}
		
		
		
		
	// Test Case - 3 - Destuffing Master Record Modification
		@Test(priority = 3, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
		public void modifyDestuffingMaster(String search, String searchGridRecord, String destuffingName, String referTo) {
			Homepage homepage = new Homepage(utilObj);
			homepage.goToDestuffing();
			utilObj.validateGetTitle("Destuffing master", "valid", " Destuffing Master  Page Title");
			
			DestuffingMasterPage destuffingMasterPage = new DestuffingMasterPage(utilObj);
			destuffingMasterPage.modifyDestuffingMasterPage(search, searchGridRecord, destuffingName, referTo);
		}
		
		
		
		
	// Test Case - 4 - Destuffing Master Record Deletion
		@Test(priority = 4, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
		public void deleteDestuffingMaster(String search, String searchGridRecord, String destuffingName, String referTo) {
			Homepage homepage = new Homepage(utilObj);
			homepage.goToDestuffing();
			utilObj.validateGetTitle("Destuffing master", "valid", " Destuffing Master  Page Title");
			
			DestuffingMasterPage destuffingMasterPage = new DestuffingMasterPage(utilObj);
			destuffingMasterPage.deleteDestuffingMasterPage(search, searchGridRecord, destuffingName, referTo);
		}
		
		
		
		
	// Test Case - 5 - Destuffing Master Page Clear
		@Test(priority = 5, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
		public void clearDestuffingMaster(String search, String searchGridRecord, String destuffingName, String referTo) {
			Homepage homepage = new Homepage(utilObj);
			homepage.goToDestuffing();
			utilObj.validateGetTitle("Destuffing master", "valid", " Destuffing Master  Page Title");
			
			DestuffingMasterPage destuffingMasterPage = new DestuffingMasterPage(utilObj);
			destuffingMasterPage.clearStuffingMasterPage(search, searchGridRecord, destuffingName, referTo);
		}
		

}
