package masters;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import masters_party_pagewise_classes.BankBRO_Page;
import webutil.ExcelDataSuplier;

public class BankBRO_TestCase extends BaseTest{
	
	// Manually Data
 //  @Test
	public void BankBRO_Manually() {
		
		Homepage homeObj = new Homepage(utilObj);
		
		List<String> actualList = homeObj.verifyLoginBranchDivision_OnHomePage();
		List<String> expectedList = Arrays.asList("Welcome", "Shivam220", "(2627)", "DEMO LTD",
				"Ahmedabad (Export Sea)");

		utilObj.validateListOfText(actualList, expectedList);

		 homeObj.Go_To_Master_BankBRO();
		 utilObj.validateGetTitle("Bank Master", "Bank BRO", "Page Title");
		 
		 
		 BankBRO_Page bankBRO_Page = new BankBRO_Page(utilObj);
		 bankBRO_Page.send_BankBRO_Data_Manually();			 
	}
	
	
	
	
	// BY Using Properties file 
//	@Test
	public void bankBRO_PropertiesFile() {
		
		Homepage homeObj = new Homepage(utilObj);
		
		List<String> actualList = homeObj.verifyLoginBranchDivision_OnHomePage();
		List<String> expectedList = Arrays.asList("Welcome", "Shivam220", "(2627)", "DEMO LTD",
				"Ahmedabad (Export Sea)");
		
		utilObj.validateListOfText(actualList, expectedList);
		
		homeObj.Go_To_Master_BankBRO();
		utilObj.validateGetTitle("Bank Master", "", "Page Title");
		
		BankBRO_Page bankBRO_Page = new BankBRO_Page(utilObj);
		bankBRO_Page.send_BankBRO_Data_PropertiesFile();	
	}
	
	

	 
	@Test(description = "BankBROSheet", dataProvider = "ReadDataFromExcel", dataProviderClass = ExcelDataSuplier.class)
	public void bankBRO_ExcelFile(String bankName, String branchName) {
	
		Homepage homepage = new Homepage(utilObj);
		
		List<String> actualList = homepage.verifyLoginBranchDivision_OnHomePage();
		List<String> expectedList = Arrays.asList("Welcome", "Shivam220", "(2627)", "DEMO LTD",
				"Ahmedabad (Export Sea)");
		
		utilObj.validateListOfText(actualList, expectedList);
		
		
		homepage.Go_To_Master_BankBRO();
		utilObj.validateGetTitle("Bank Master", "Bank BRO", "Page Title");
		
		BankBRO_Page bankBRO_Page = new BankBRO_Page(utilObj);
		bankBRO_Page.send_BankBRO_Data_Excel(bankName, branchName);
	
	}
	
	
	
	
	
	
	
	 

}
