package shipmentInfoTestCases;



import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import basetest.BaseTest;
import branch_division.LoginBranchDivision;
import icaffe_homepage.Homepage;
import shipmentInfoPageClasses.IMOMasterPage;
import webutil.ExcelDataSuplier;

public class IMOMasterTestCase extends BaseTest{
	
	
// Test Case - 1 - IMO Master Page Title Validation
	@Test(priority = 1)
	public void validateIMOMasterPageTitle() {
		Homepage homeObj = new Homepage(utilObj);
		homeObj.goToIMOMasterPage();
		utilObj.validateGetTitle("IMO Master", "valid", " IMO Master Page Title");
	} 
	
	
	
	
	
// Test Case - 2 - Create a New IMO Master Record
	@Test(priority = 2, description = "IMOMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void createIMOMssterRecord(String name, String displayStatus) throws Exception {
		Homepage homeObj = new Homepage(utilObj);
		homeObj.goToIMOMasterPage();
		utilObj.validateGetTitle("IMO Master", "valid", " IMO Master Page Title");
		IMOMasterPage imoMasterPage = new IMOMasterPage(utilObj);
		imoMasterPage.createNewIMOMasterRecord(name, displayStatus);
	}
	
	

	
// Test Case - 3 - Modify IMO Master Record
	@Test(priority = 3, description = "IMOMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyIMOMssterRecord(String search, String searchValue, String name, String displayStatus) throws Exception {
		Homepage homeObj = new Homepage(utilObj);		
		homeObj.goToIMOMasterPage();
		utilObj.validateGetTitle("IMO Master", "valid", " IMO Master Page Title");
		IMOMasterPage imoMasterPage = new IMOMasterPage(utilObj);
		imoMasterPage.modifyIMOMasterRecord(search, searchValue, name, displayStatus);
	}
	

	
// Test Case - 4 - Delete IMO Master Record 
   @Test(priority = 4, description = "IMOMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void deleteIMOMssterRecord(String search, String searchValue, String name, String displayStatus) throws Exception {
		Homepage homeObj = new Homepage(utilObj);		
		homeObj.goToIMOMasterPage();
		utilObj.validateGetTitle("IMO Master", "valid", " IMO Master Page Title");
		IMOMasterPage imoMasterPage = new IMOMasterPage(utilObj);
		imoMasterPage.deleteIMOMasterRecord(search, searchValue, name, displayStatus);
	}
    
	
    
    
// Test Case - 5 - Clear IMO Master Record
   @Test(priority = 5, description = "IMOMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void clearIMOMssterRecord(String name, String displayStatus) throws Exception {
		Homepage homeObj = new Homepage(utilObj);			
		homeObj.goToIMOMasterPage();
		utilObj.validateGetTitle("IMO Master", "valid", " IMO Master Page Title");
		IMOMasterPage imoMasterPage = new IMOMasterPage(utilObj);
		imoMasterPage.clearIMOMasterPage(name, displayStatus);
	}
	

}