package masterPartyTestCase;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import basetest.BaseTest;
import branch_division.LoginBranchDivision;
import icaffe_homepage.Homepage;
import masterPartyPageClasses.BankBROPage;
import webutil.ExcelDataSuplier;

public class BankBROTestCase extends BaseTest{
	
	// Manually Data
//  @Test
//	public void BankBRO_Manually() {
//		Homepage homeObj = new Homepage(utilObj);
//		
//		 homeObj.goToBankBROPage();
//		 // Bank BRO Page Validation
//		 utilObj.validateGetTitle("Bank Master", "valid", "Page Title");
//		 
//		 BankBROPage bankBROPage = new BankBROPage(utilObj);
//		 bankBROPage.send_BankBRO_Data_Manually();			 
//	}
	
		
	
	// BY Using Properties file 
//	@Test
//	public void bankBRO_PropertiesFile() {
//		Homepage homeObj = new Homepage(utilObj);
//		
//		homeObj.goToBankBROPage();
//		
//		utilObj.validateGetTitle("Bank Master", "valid", "Page Title");
//		BankBROPage bankBROPage = new BankBROPage(utilObj);
//		bankBROPage.send_BankBRO_Data_PropertiesFile();	
//	}
	
	

	
// Test Case -1	- Bank BRO Page Title Validation	
	@Test(priority = 1)
	public void bankBROPageValidation() {
		Homepage homeObj = new Homepage(utilObj);
		homeObj.goToBankBROPage();
		utilObj.validateGetTitle("Bank Master", "valid", "Bank Master Page Title");
	}
	
	
	
// Test Case - 2 - Create Bank BRO Record (Single or Multiple)
	@Test(priority = 2, description = "BankBRO|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class) 
	public void createBankBRO(String bankName, String branchName, String city, String state, String country) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToBankBROPage();
		utilObj.validateGetTitle("Bank Master", "valid", " Bank Master Page Title");
		BankBROPage bankBROPage = new BankBROPage(utilObj);
		bankBROPage.createBankBROPage(bankName, branchName, city, state, country);
		

	}
	
	

// Test Case - 3 - Bank BRO Duplicate Record Validation	
	@Test(priority = 3, description = "BankBRO|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void duplicateBankBRO(String bankName, String branchName, String city, String state, String country) throws Exception {

		Homepage homepage = new Homepage(utilObj);		
		homepage.goToBankBROPage();
		utilObj.validateGetTitle("Bank Master", "valid", " Bank Master Page Title");
		BankBROPage bankBROPage = new BankBROPage(utilObj);
		bankBROPage.duplicateBankBROPage(bankName, branchName, city, state, country);
	}
	
	
	
	
// Test Case - 4 - Bank BRO Record Modification
	@Test(priority = 4, description = "BankBRO|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyBankBRO(String search, String searchValue, String bankName, String branchName, String city, String state, String country) throws Exception {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToBankBROPage();
		utilObj.validateGetTitle("Bank Master", "valid", " Bank Master Page Title");
		BankBROPage bankBROPage = new BankBROPage(utilObj);
		bankBROPage.modifyBankBROPage(search, searchValue, bankName, branchName, city, state, country);
	}
	
	
	

// Test Case - 5 Bank BRO Page Clear	
	@Test(priority = 5, description = "BankBRO|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void clearBankBRO(String bankName, String branchName, String city, String state, String country) throws Exception {
		Homepage homeObj = new Homepage(utilObj);
		homeObj.goToBankBROPage();
		utilObj.validateGetTitle("Bank Master", "valid", " Bank Master Page Title");
		BankBROPage bankBROPage = new BankBROPage(utilObj);
		bankBROPage.clearBankBROPage(bankName, branchName, city, state, country);	
	}

	
	

}
