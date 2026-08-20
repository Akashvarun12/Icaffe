
package regionalMasterTestCase;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import regionalMasterPageClass.CostCenterMasterPage;
import webutil.ExcelDataSuplier;




public class CostCenterMasterTestCase extends BaseTest {
	
	/*
// Test Case - 3 - Modify Cost Center Master Recrod (Single or Multiple By using XML file)
	@Test(priority = 3)
	@Parameters({"search", "searchGridResultM", "codeM", "nameM", "displayStatusM"})
	public void modifyCostCenter(String search, String searchGridResultM, String codeM, String nameM, String displayStatusM) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToCostCenterMasterPage();
		utilObj.validateGetTitle("Cost Center Master", "valid", "Cost Center Master Page Title");
		
		CostCenterMasterPage costCenterMasterPage = new CostCenterMasterPage(utilObj);
		costCenterMasterPage.modifyCostCenterPage(search, searchGridResultM, codeM, nameM, displayStatusM);
	}
	*/
	
	
// Test Case - 1 - Validate Cost Center Master Page Title	
	@Test(priority = 1)
	public void pageTitleCostCenter() {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToCostCenterMasterPage();
		utilObj.validateGetTitle("Cost Center Master", "valid", " Cost Center Master Page Title");
	}
	
	

// Test Case - 2 - Create a New Cost Center Master Record
	@Test(priority = 2, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void createCostCenter(String codeC, String nameC, String displayStatusC) throws Exception {
	    Homepage homepage = new Homepage(utilObj);
		homepage.goToCostCenterMasterPage();    
		CostCenterMasterPage CostCenterMasterPage = new CostCenterMasterPage(utilObj);
	    CostCenterMasterPage.createCostCenterPage(codeC, nameC, displayStatusC);
	}

	

	
// Test Case - 3 - Modify the Cost Center Master Record	
	@Test(priority = 3, description = "CostCenterMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyCostCenter(String search, String searchGridResult, String code, String name, String displayStatus) throws Exception {    
		Homepage homepage = new Homepage(utilObj);
		homepage.goToCostCenterMasterPage();    
		CostCenterMasterPage page = new CostCenterMasterPage(utilObj);
		page.modifyCostCenterPage(search, searchGridResult, code, name, displayStatus);
}

	
	
// Test Case - 4 - Clear the Cost Center Master Page		
	@Test(priority = 4, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void clearCostCenter(String search, String searchGridResult, String code, String name, String displayStatus) throws Exception {
	    Homepage homepage = new Homepage(utilObj);
		homepage.goToCostCenterMasterPage();    
		CostCenterMasterPage CostCenterMasterPage = new CostCenterMasterPage(utilObj);
	    CostCenterMasterPage.clearCostCenterPage(search, searchGridResult, code, name, displayStatus);
	}

	
	
	
}
