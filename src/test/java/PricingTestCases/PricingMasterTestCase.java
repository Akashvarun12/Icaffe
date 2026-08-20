package PricingTestCases;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import pricingMasterPageClasses.PricingMasterPage;
import webutil.ExcelDataSuplier;

public class PricingMasterTestCase extends BaseTest {
	

	
// Test Case - 1 - Notes Master Page Title Validation	
	@Test(priority = 1)	
	public void pageTitlePricingMaster() {	
		Homepage homepage = new Homepage(utilObj);	
		homepage.goToNotesMaster();
		utilObj.validateGetTitle("Pricing Master", "valid", "Pricing Master Page Title");
	}
	
	
	
	
	
	
// Test Case - 2 - Create a new Pricing Master Record
	@Test(priority = 2, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void createPricingMaster(String originCountry, String originPort, String destinationCountry, String destinationPort, String chargeName,
			String unit, String currency, String fromDate, String toDate, String effectiveDate) {
		Homepage homepage = new Homepage(utilObj);	
		homepage.goToNotesMaster();
		utilObj.validateGetTitle("Pricing Master", "valid", "Pricing Master Page Title");
		
		PricingMasterPage pricingMasterPage = new PricingMasterPage(utilObj);
		pricingMasterPage.createPricingPage(originCountry, originPort, destinationCountry, destinationPort, chargeName, unit, currency, fromDate,
				toDate, effectiveDate);	
	}
	
	
	
	
	

}
