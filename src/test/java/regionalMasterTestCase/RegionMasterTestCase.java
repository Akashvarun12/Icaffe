package regionalMasterTestCase;

import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import regionalMasterPageClass.RegionMasterPage;
import webutil.ExcelDataSuplier;

public class RegionMasterTestCase extends BaseTest {		
	
//  Test Case - 1 - Region Master Page Validation
	@Test(priority = 1)
	public void pageTitleRegionMaster() {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToRegionMasterPage();
		utilObj.validateGetTitle("Region Master", "valid", "Region Master Page Title");
	}
	
	
	
// 	Test Case - 2 - Region Master New Record Creation (Single or Multiple)
	@Test(priority = 2, description = "RegionMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void createRegionMaster(String name, String region, String displayStatus, String note) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToRegionMasterPage();
		utilObj.validateGetTitle("Region Master", "valid", "Region Master Page Title");
		RegionMasterPage regionMasterPage = new RegionMasterPage(utilObj);
		regionMasterPage.createRegionMasterPage(name, region, displayStatus, note);
	}
	
	
// Test Case - 3 - Region Master Record Modification
	@Test(priority = 3, description = "RegionMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyRegionMaster(String search, String searchResult, String name, String region, String displayStatus, String note) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToRegionMasterPage();
		utilObj.validateGetTitle("Region Master", "valid", "Region Master Page Title");
		RegionMasterPage regionMasterPage = new RegionMasterPage(utilObj);
		regionMasterPage.modifyRegionMasterPage(search, searchResult, name, region, displayStatus, note);
	}
	
	
// Test Case - 4 - Region Master Page Clear
	@Test(priority = 4, description = "RegionMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void clearRegionMaster(String search, String searchResult, String name, String region, String displayStatus, String note) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToRegionMasterPage();
		utilObj.validateGetTitle("Region Master", "valid", "Region Master Page Title");
		RegionMasterPage regionMasterPage = new RegionMasterPage(utilObj);
		regionMasterPage.clearRegionMasterPage(search, searchResult, name, region, displayStatus, note);
	}
	
	

	
	/*
	// Modifying Region Master Record By using XML File
	@Test
	@Parameters({"search","searchResultM","nameM","regionM","displayStatusM","noteM"})
	public void modifyRegionMasterByXML(String search,String searchResultM, String nameM,String regionM, String displayStatusM, String noteM) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToRegionMasterPage();
		utilObj.validateGetTitle("Region Master", "valid", "Region Master Page Title");
		RegionMasterPage regionMasterPage = new RegionMasterPage(utilObj);
		regionMasterPage.modifyRegionMasterPage(search, searchResultM, nameM, regionM, displayStatusM, noteM);
	}
	*/
	

}
