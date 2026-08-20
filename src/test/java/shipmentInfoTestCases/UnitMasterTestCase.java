package shipmentInfoTestCases;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import shipmentInfoPageClasses.UnitMasterPage;
import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class UnitMasterTestCase extends BaseTest {
	
	
	
// Test Case - 1 - Unit Master Page Title Validation
	@Test(priority =  1)
	public void UnitMasterPageTitle() {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToUnitMasterPage();
		// Unit Master Page Validation
		utilObj.validateGetTitle("Unit Master", "valid", " Unit Master Page Title");
	}
	
	
	
	
// Test Case - 2 - Create a new Unit Master Record	
	@Test(priority = 2, description = "UnitMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void saveUnitMaster(String code, String name, String type) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToUnitMasterPage();
		// Unit Master Page Validation
		utilObj.validateGetTitle("Unit Master", "valid", " Unit Master Page Title");
		UnitMasterPage unitMasterPage = new UnitMasterPage(utilObj);
		unitMasterPage.createUnitMasterRecord(code, name, type);	
	}
	
	
	
// Test Case - 3 - Modify the Unit Master Record
	@Test(priority = 3, description = "UnitMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyUnitMaster(String search, String searchSelected, String code, String name, String type) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToUnitMasterPage();
		// Unit Master Page Validation
		utilObj.validateGetTitle("Unit Master", "valid", " Unit Master Page Title");
		UnitMasterPage unitMasterPage = new UnitMasterPage(utilObj);
		unitMasterPage.modifyUnitMasterRecord(search, searchSelected, code, name, type);
	}
	
	
	
// Test Case - 4 - Clear the Unit Master Page	
		@Test(priority = 4, description = "UnitMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
		public void clearUnitMaster(String code, String name, String type) throws Exception {
			Homepage homepage = new Homepage(utilObj);
			homepage.goToUnitMasterPage();
			// Unit Master Page Validation
			utilObj.validateGetTitle("Unit Master", "valid", " Unit Master Page Title");
			UnitMasterPage unitMasterPage = new UnitMasterPage(utilObj);
			unitMasterPage.clearUnitMaster(code, name, type);
		}

}