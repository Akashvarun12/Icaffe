package branch_division_finyear;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.Test;

import basetest.BaseTest;
import branch_division.LoginBranchDivision;
import icaffe_homepage.Homepage;
import webutil.ExcelDataSuplier;

public class Branch_Division_FinYear_TestCase extends BaseTest {
	
	// Validation Branch_Division_FinYear_with_PropertyFile...

	@Test
	public void validate_Branch_Division_FinYear_with_PropertyFile() {

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
		List<String> expectedList = Arrays.asList("Welcome", "Shivam220", "(2627)", "DEMO LTD", "Ahmedabad (Export Sea)");

		utilObj.validateListOfText(actualList, expectedList);
	}


	// Validate Branch_Division_FinYear_with_ID (DYNAMICALLY)...
	@Test
	public void validateAll_Branch_Division_FinYear_with_ID() {

		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj);

		Map<String, String> testData = ExcelDataSuplier.setExcelFile("BranchSheetWith_ID", "ID-6");
		
		String braname = testData.get("branchname");
		String divi = testData.get("division");
		String year = testData.get("finYear");

		logBranchDiv.SelectBranch(braname);

		logBranchDiv.SelectDevision(divi);

		logBranchDiv.SelectFinYear(year);

		logBranchDiv.clickOnOKButton();

		Homepage homeObj = new Homepage(utilObj);

		List<String> actualList = homeObj.verifyLoginBranchDivision_OnHomePage();
		List<String> expectedList = Arrays.asList("Welcome", "Shivam220", "(2627)", "DEMO LTD", "Ahmedabad (Export Sea)");

		utilObj.validateListOfText(actualList, expectedList);
	}

	// Validate AllBranch_Division_FinYear_with_DataProvider...
	
	@Test(description = "All_BranchSheet",dataProvider = "ReadDataFromExcel", dataProviderClass = ExcelDataSuplier.class)
	public void validate_AllBranch_Division_FinYear_with_DataProvider(String branchname, String division,String finYear) {

		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj);
	

		logBranchDiv.SelectBranch(branchname);

		logBranchDiv.SelectDevision(division);

		logBranchDiv.SelectFinYear(finYear);

		logBranchDiv.clickOnOKButton();

		Homepage homeObj = new Homepage(utilObj);

		List<String> actualList = homeObj.verifyLoginBranchDivision_OnHomePage();

		String expectedBranchDivision =
				logBranchDiv.capitalize(branchname) + " (" + logBranchDiv.getDivisionText(division) + ")";
		List<String> expectedList = Arrays.asList(
		        "Welcome",
		        "Shivam220",
		        logBranchDiv.getFinYearShort(finYear),
		        "DEMO LTD",
		        expectedBranchDivision
		);
	    utilObj.validateListOfText(actualList, expectedList);
	
	}

}
