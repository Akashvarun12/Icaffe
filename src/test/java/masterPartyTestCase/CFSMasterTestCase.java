package masterPartyTestCase;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import basetest.BaseTest;
import branch_division.LoginBranchDivision;
import icaffe_homepage.Homepage;
import masterPartyPageClasses.CFSMasterPage;
import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class CFSMasterTestCase extends BaseTest {
	
// Test Case - -- Sending CFS Master Data By using Manually
	
//	@Test
//	public void sendCFS_Master_Manually() throws Exception {
//		Homepage homeObj = new Homepage(utilObj);
//		 homeObj.goToCFSMasterPage();
//		 utilObj.validateGetTitle("CFS Master", "valid", "CFS Master");
//		 
//		CFSMasterPage cfsMasterPage = new CFSMasterPage(utilObj);
//		cfsMasterPage.CFS_Master_Manually();	 		 
//	}
	

// Test Case -- Sending CFS Master Data By using Properties Files
	
//	@Test
//	public void sendCFS_Master_PropertiesFile() throws Exception {
//		Homepage homeObj = new Homepage(utilObj);
//		 homeObj.goToCFSMasterPage();
//		 utilObj.validateGetTitle("CFS Master", "valid", "CFS Master");
//		 
//		 CFSMasterPage cfsMasterPage = new CFSMasterPage(utilObj);
//		 cfsMasterPage.CFSMasterDataPropertiesFile();		 		 
//	}
//	

	

	
//  Test Case - 1 -- CFS Master Page Title Validation Test Case
	@Test(priority = 1)
	public void validateCFSMasterPageTitle() {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToCFSMasterPage();
		utilObj.validateGetTitle("CFS Master", "valid", "CFS Master Page Title");
	}
	

	
	
//  Test Case -2 - Creating New CFS Master Record (Single & Multiple) -- Sending Data By using DataProvider(Excel File)
	@Test(priority = 2, description = "CFSMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void createCFSMaster(String name, String portCode, String address, String city, String state, String contact, String email, String pan) throws Exception {

		Homepage homeObj = new Homepage(utilObj);	
		homeObj.goToCFSMasterPage();
		utilObj.validateGetTitle("CFS Master", "valid", "CFS Master Page Title"); 
		CFSMasterPage cfsMasterPage = new CFSMasterPage(utilObj);
		cfsMasterPage.createCFSMasterPage(name, portCode, address, city, state, contact, email, pan);
	}


	
	
//  Test Case - 3 -- CFS Master Record Modification Test Case
	@Test(priority = 3, description = "CFSMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyCFSMaster(String search, String searchGridRecord, String name, String portCode, String address, String city, String state,
			String contact, String email, String pan) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToCFSMasterPage();
		utilObj.validateGetTitle("CFS Master", "valid", "CFS Master Page Title");
		
		CFSMasterPage cfsMasterPage = new CFSMasterPage(utilObj);
		cfsMasterPage.modifyCFSMasterPage(search, searchGridRecord, name, portCode, address, city, state, contact, email, pan);
	}
	
	
	
//  Test Case - 4 -- CFS Master Page Clear Test Case
	@Test(priority = 4, description = "CFSMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void clearCFSMaster(String name, String portCode, String address, String city, String state, String contact, String email, String pan) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToCFSMasterPage();
		utilObj.validateGetTitle("CFS Master", "valid", "CFS Master Page Title");
		
		CFSMasterPage cfsMasterPage = new CFSMasterPage(utilObj);
		cfsMasterPage.cleasrCFSMasterPage(name, portCode, address, city, state, contact, email, pan);
	}
	
	

}
