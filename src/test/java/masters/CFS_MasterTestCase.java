package masters;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import basetest.BaseTest;
import branch_division.LoginBranchDivision;
import icaffe_homepage.Homepage;
import masters_party_pagewise_classes.CFS_Master;
import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class CFS_MasterTestCase extends BaseTest {
	
	

	// Sending CFS Master Data By using Manually
//	@Test
	public void sendCFS_Master_Manually() throws Exception {

		/*
		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj);
		Properties pr = utilObj.propertiFile("Branch_Division_Year.properties");
		String branchName = pr.getProperty("branch");
		String divisionCheckbox = pr.getProperty("division");
		String finYear = pr.getProperty("year");

		logBranchDiv.SelectBranch(branchName);

		logBranchDiv.SelectDevision(divisionCheckbox);

		logBranchDiv.SelectFinYear(finYear);

		logBranchDiv.clickOnOKButton();
		*/

		Homepage homeObj = new Homepage(utilObj);
		
		
		List<String> actualList = homeObj.verifyLoginBranchDivision_OnHomePage();
		List<String> expectedList = Arrays.asList("Welcome", "Shivam220", "(2627)", "DEMO LTD",
				"Ahmedabad (Export Sea)");

		utilObj.validateListOfText(actualList, expectedList);

		 homeObj.Goto_Masters_PartyCFSMaster();
		 utilObj.validateGetTitle("CFS Master", "Page Title", "CFS Title");
		 
		CFS_Master cfs_Master = new CFS_Master(utilObj);
		cfs_Master.CFS_Master_Manually();
		
		 		 
	}
	
	

	
	
	// Sending CFS Master Data By using Properties Files
	
//	@Test
	public void sendCFS_Master_PropertiesFile() {
		/*
		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj);
		Properties pr = utilObj.propertiFile("Branch_Division_Year.properties");
		String branchName = pr.getProperty("branch");
		String divisionCheckbox = pr.getProperty("division");
		String finYear = pr.getProperty("year");

		logBranchDiv.SelectBranch(branchName);

		logBranchDiv.SelectDevision(divisionCheckbox);

		logBranchDiv.SelectFinYear(finYear);

		logBranchDiv.clickOnOKButton();
		*/

		Homepage homeObj = new Homepage(utilObj);
		
		
		List<String> actualList = homeObj.verifyLoginBranchDivision_OnHomePage();
		List<String> expectedList = Arrays.asList("Welcome", "Shivam220", "(2627)", "DEMO LTD",
				"Ahmedabad (Export Sea)");

		utilObj.validateListOfText(actualList, expectedList);

		 homeObj.Goto_Masters_PartyCFSMaster();
		 utilObj.validateGetTitle("CFS Master", "Page Title", "CFS Title");
		 
		 CFS_Master cfs_Master = new CFS_Master(utilObj);
		cfs_Master.CFSMasterDataByPropertiesFile();
		 		 
	}
	

	
	
	
	// Sending Data By using DataProvider (Excel File)
	
	@Test(description = "CFSMasterSheet", dataProvider = "ReadDataFromExcel", dataProviderClass = ExcelDataSuplier.class)
	public void cfsMasterData_ByDataProvider(String name, String portCode, String address, String address1, String address2, String city, String state, String zipcode,
    		String contact, String phone, String fax, String email, String pan, String ediGroupCode, String bondValue) {


		Homepage homeObj = new Homepage(utilObj);
		
		
		List<String> actualList = homeObj.verifyLoginBranchDivision_OnHomePage();
		List<String> expectedList = Arrays.asList("Welcome", "Shivam220", "(2627)", "DEMO LTD",
				"Ahmedabad (Export Sea)");

		utilObj.validateListOfText(actualList, expectedList);

		homeObj.Goto_Masters_PartyCFSMaster();
		utilObj.validateGetTitle("CFS Master", "", "Page"); 
		
		
		CFS_Master cfs_Master = new CFS_Master(utilObj);
		cfs_Master.cfsMasterDataByDataProvider(name, portCode, address, address1, address2, city, state, zipcode, contact, phone, fax,
				email, pan, ediGroupCode, bondValue);
	 
	}

		 
}
	

