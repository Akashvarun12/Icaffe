
package regionalMasterTestCase;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import regionalMasterPageClass.CountryMasterPage;
import webutil.ExcelDataSuplier;


public class CountryMasterTestCase extends BaseTest {	
		

// Test Case - 1 - Country Master Page Validation
	@Test
	public void PageTitleCountryMaster() {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToCountryMasterPage();
		utilObj.validateGetTitle("Country Master", "valid", "Country Master Page Title");	
	}
	

	
	
// Test Case - 2 - Country Master Record Creation	
	@Test(priority = 2, description = "CountryMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)	
	public void createCountryMaster(String countryCode, String countryName, String displayStatus) throws Exception {    			
		Homepage homepage = new Homepage(utilObj);			
		homepage.goToCountryMasterPage();    			
		
		CountryMasterPage countryMasterPage = new CountryMasterPage(utilObj);		
		countryMasterPage.createCountryMasterPage(countryCode, countryName, displayStatus);
	}
	
	
	

// Test Case - 3 - Country Master Record Modification
	@Test(priority = 3, description = "CountryMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyCountryMaster(String search, String searchGridRecord, String countryCode, String countryName, String displayStatus) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToCountryMasterPage();
		utilObj.validateGetTitle("Country Master", "valid", "Country Master Page Title");
		
		CountryMasterPage countryMasterPage = new CountryMasterPage(utilObj);
		countryMasterPage.modifyCountryMasterPage(search, searchGridRecord, countryCode, countryName, displayStatus);	
	}
	
	
	
	
// Test Case - 4 - Country Master Record Deletion
	@Test(priority = 4, description = "CountryMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void deleteCountryMaster(String search, String searchGridRecord, String countryCode, String countryName, String displayStatus) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToCountryMasterPage();
		utilObj.validateGetTitle("Country Master", "valid", "Country Master Page Title");
		
		CountryMasterPage countryMasterPage = new CountryMasterPage(utilObj);
		countryMasterPage.deleteCountryMasterPage(search, searchGridRecord, countryCode, countryName, displayStatus);	
	}
	
	
		
	
// Test Case - 4 - Country Master Page Clear
	@Test(priority = 5, description = "CountryMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void clearCountryMaster(String search, String searchGridRecord, String countryCode, String countryName, String displayStatus) {		
		Homepage homepage = new Homepage(utilObj);		
		homepage.goToCountryMasterPage();		
		utilObj.validateGetTitle("Country Master", "valid", "Country Master Page Title");
					
		CountryMasterPage countryMasterPage = new CountryMasterPage(utilObj);	
		countryMasterPage.clearCountryMasterPage(search, searchGridRecord, countryCode, countryName, displayStatus);	
		}
	
	
}
