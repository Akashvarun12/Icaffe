package masters;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.Test;

import basetest.BaseTest;
import branch_division.LoginBranchDivision;
import icaffe_homepage.Homepage;

public class Party_Exporter_TestCase extends BaseTest{

	
	@Test
	public void validate_ShipperPageWith_Title() {

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
		homeObj.Goto_Masters_PartyExporter();
		
		utilObj.validateGetTitle("Shipper Master", "valid", "Masters Page");
	
	}
	
	
	@Test
	public void validate_NewShipperAccount_CreationWith_MandadatoryField() {

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
		homeObj.Goto_Masters_PartyExporter();
		
		
	
	}
	
	
}
