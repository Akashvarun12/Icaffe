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
	
	

	/*
	@Test
	public void validateBranch_Division_FinYear() {

		
		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj);
		Properties pr = utilObj.propertiFile("Branch_Division_Year.properties");
		String branchName = pr.getProperty("branch");
		String divisionCheckbox = pr.getProperty("division");
		String finYear = pr.getProperty("year");

		logBranchDiv.SelectBranch(branchName);

		logBranchDiv.SelectDevision(divisionCheckbox);

		logBranchDiv.SelectFinYear(finYear);

		logBranchDiv.clickOnOKButton();

		Homepage homeObj = new Homepage(utilObj);
		
		
		List<String> actualList = homeObj.verifyLoginBranchDivision_OnHomePage();
		List<String> expectedList = Arrays.asList("Welcome", "Shivam220", "(2627)", "DEMO LTD",
				"Ahmedabad (Export Sea)");

		utilObj.validateListOfText(actualList, expectedList);

		 homeObj.Goto_Masters_PartyCFSMaster();
		 utilObj.validateGetTitle("CFS Master");
		 

		 //CFS Master  sending data manual
		 CFS_Master cfs_Master = new CFS_Master(utilObj);
		 try {
			 // send CFS Master Data Manually
//			cfs_Master.save_CFS_Master();
			
//			 Send CFS Master Data By using Properties file
			cfs_Master.enterCFSMasterDataByPropertiesFile();
			utilObj.validateAlertMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 		 
	}
	
	*/
	
	
	
	@Test(dataProvider = "ReadDataFromExcel", dataProviderClass = ExcelDataSuplier.class)
	public void cfsMasterData(String name, String portCode) {


		Homepage homeObj = new Homepage(utilObj);
		
		
		List<String> actualList = homeObj.verifyLoginBranchDivision_OnHomePage();
		List<String> expectedList = Arrays.asList("Welcome", "Shivam220", "(2627)", "DEMO LTD",
				"Ahmedabad (Export Sea)");

		utilObj.validateListOfText(actualList, expectedList);

		homeObj.Goto_Masters_PartyCFSMaster();
		utilObj.validateGetTitle("CFS Master"); 
		
		CFS_Master cfs_Master = new CFS_Master(utilObj);
		cfs_Master.cfsMasterDataByDataProvider(name, portCode);
		utilObj.validateAlertMessage();

		
		
		 
		 
	}

		 
}
	

