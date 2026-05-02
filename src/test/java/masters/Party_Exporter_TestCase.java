package masters;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.Test;

import basetest.BaseTest;
import branch_division.LoginBranchDivision;
import icaffe_homepage.Homepage;
import webutil.WebUtil;

public class Party_Exporter_TestCase extends BaseTest{

	
	@Test
	public void validate_ShipperPageWith_Title() {

		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj);
//		Properties pr = utilObj.propertiFile("Akash_Branch_Division_Year.properties");
//		String branchName = pr.getProperty("branch");
//		String divisionCheckbox = pr.getProperty("division");
//		String finYear = pr.getProperty("year");
		
		String branchName = WebUtil.getConfig("branch");
		String divisionCheckbox = WebUtil.getConfig("division");
		String finYear = WebUtil.getConfig("year");

		logBranchDiv.SelectBranch(branchName);

		logBranchDiv.SelectDevision(divisionCheckbox);

		logBranchDiv.SelectFinYear(finYear);

		logBranchDiv.clickOnOKButton();

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		
		utilObj.validateGetTitle("Shipper Master", "valid", "Masters Page");
	
	}
	
	
	@Test
	public void validate_NewShipperAccount_CreationWith_MandadatoryField() {

		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj);
//		Properties pr = utilObj.propertiFile("Akash_Branch_Division_Year.properties");
//		String branchName = pr.getProperty("branch");
//		String divisionCheckbox = pr.getProperty("division");
//		String finYear = pr.getProperty("year");

		String branchName = WebUtil.getConfig("branch");
		String divisionCheckbox = WebUtil.getConfig("division");
		String finYear = WebUtil.getConfig("year");
		
		logBranchDiv.SelectBranch(branchName);

		logBranchDiv.SelectDevision(divisionCheckbox);

		logBranchDiv.SelectFinYear(finYear);

		logBranchDiv.clickOnOKButton();

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		
		
	
	}
	
	
}
