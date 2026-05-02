package branch_division_finyear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.Test;

import basetest.BaseTest;
import branch_division.LoginBranchDivision;
import icaffe_homepage.Homepage;
import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class Branch_Division_FinYear_TestCase extends BaseTest {

	// Validation Branch_Division_FinYear_with_PropertyFile...

	@Test
	public void validate_Branch_Division_FinYear_with_PropertyFile() {

		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj);
//		Properties pr = utilObj.propertiFile("Akash_Branch_Division_Year.propertie");
//		
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

		List<String> expectedList = Arrays.asList("Akash12", "(2627)", "DEMO LTD", "Ahmedabad (Export Sea)");
		homeObj.getText_LoginBranchDivision_OnHomePage(expectedList);
	}

	// Validate Branch_Division_FinYear_with_ID from Excel sheet (DYNAMICALLY)...
//	@Test
	public void validateAll_Branch_Division_FinYear_with_ID() {

		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj);

		Map<String, String> testData = ExcelDataSuplier.setExcelFile("BranchSheetWith_ID", "ID-7");

		String braname = testData.get("branchname");
		String divi = testData.get("division");
		String year = testData.get("finYear");

		logBranchDiv.SelectBranch(braname);

		logBranchDiv.SelectDevision(divi);

		logBranchDiv.SelectFinYear(year);

		logBranchDiv.clickOnOKButton();

		Homepage homeObj = new Homepage(utilObj);

		List<String> expectedList = Arrays.asList("Akash12", "(2627)", "DEMO LTD", "Ahmedabad (Import Air)");
		homeObj.getText_LoginBranchDivision_OnHomePage(expectedList);

	}

	// Validate AllBranch_Division_FinYear_with_DataProvider...

//	@Test(description = "All_BranchSheet|Akash_TestByDataprovider.xlsx", dataProvider = "ReadDataFromExcel", dataProviderClass = ExcelDataSuplier.class)
	public void validate_AllBranch_Division_FinYear_with_DataProvider(String branchname, String division,
			String finYear, String exp_1, String exp_2, String exp_3, String exp_4) {

		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj);

		logBranchDiv.SelectBranch(branchname);

		logBranchDiv.SelectDevision(division);

		logBranchDiv.SelectFinYear(finYear);

		logBranchDiv.clickOnOKButton();

		List<String> expectedList = Arrays.asList(exp_1, exp_2, exp_3, exp_4);

		Homepage homeObj = new Homepage(utilObj);

		homeObj.getText_LoginBranchDivision_OnHomePage(expectedList);

	}

}
