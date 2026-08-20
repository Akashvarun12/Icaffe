package miscMasterTestCase;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import miscMasterPageClass.PrincipleLineHBLMasterPage;
import webutil.ExcelDataSuplier;


public class PrincipleLineHBLMasterTestCase extends BaseTest {
	
	
// Test Case - 1 - Principle Line HBL Master Page Title Validation
	@Test(priority = 1)
	public void pageTitlePrincipleLineHBLMaster() {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToPrincipleLineHBLMaster();
		utilObj.validateGetTitle("Principle Line HBL Master", "valid", "Principle Line HBL Master Page Title");	
	}
	
	
	
	
	
// Test Case - 2 - Principle Line HBL Master Record Creation (Single or Multiple)
	@Test(priority = 2, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void createPrincipleLineHBLMaster(String code, String name) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToPrincipleLineHBLMaster();
		utilObj.validateGetTitle("Principle Line HBL Master", "valid", "Principle Line HBL Master Page Title");
		
		PrincipleLineHBLMasterPage principleLineHBLMasterPage = new PrincipleLineHBLMasterPage(utilObj);
		principleLineHBLMasterPage.createPrincipleLineHBLMaster(code, name);
	}
	
	
	
	
	
// Test Case - 3 - Principle Line HBL Master Record Modification
	@Test(priority = 3, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyPrincipleLineHBLMaster(String search, String searchGridRecord, String code, String name) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToPrincipleLineHBLMaster();
		utilObj.validateGetTitle("Principle Line HBL Master", "valid", "Principle Line HBL Master Page Title");
		
		PrincipleLineHBLMasterPage principleLineHBLMasterPage = new PrincipleLineHBLMasterPage(utilObj);
		principleLineHBLMasterPage.modifyPrincipleLineHBLMaster(search, searchGridRecord, code, name);
	}
	
	

	
	
// Test Case - 4 - Principle Line HBL Master Page Clear
	@Test(priority = 4, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void clearPrincipleLineHBLMaster(String search, String searchGridRecord, String code, String name) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToPrincipleLineHBLMaster();
		utilObj.validateGetTitle("Principle Line HBL Master", "valid", "Principle Line HBL Master Page Title");
		
		PrincipleLineHBLMasterPage principleLineHBLMasterPage = new PrincipleLineHBLMasterPage(utilObj);
		principleLineHBLMasterPage.clearPrincipleLineHBLMaster(search, searchGridRecord, code, name);
	}

	
}

