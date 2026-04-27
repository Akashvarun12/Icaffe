package branch_division_finyear;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.Test;

import basetest.BaseTest;
import branch_division.LoginBranchDivision;
import icaffe_homepage.Homepage;
import webutil.ExcelDataSuplier;

public class Branch_Division_FinYear_TestCase extends BaseTest {

	@Test
	public void validateBranch_Ahmedabad_Division_ExportAir_FinYear_2025_26() {

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
		List<String> expectedList = Arrays.asList("Welcome", "Akash12", "(2526)", "DEMO LTD", "Ahmedabad (Export Air)");

		utilObj.validateListOfText(actualList, expectedList);
	}

	
	
	@Test(dataProvider = "ReadDataFromExcel", dataProviderClass = ExcelDataSuplier.class)
	public void validateAllBranch_Division_FinYear_fromDataProvider_002(String branchname, String division,
			String finYear) {

		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj);

		logBranchDiv.SelectBranch(branchname);

		logBranchDiv.SelectDevision(division);

		logBranchDiv.SelectFinYear(finYear);

		logBranchDiv.clickOnOKButton();

		Homepage homeObj = new Homepage(utilObj);

		List<String> actualList = homeObj.verifyLoginBranchDivision_OnHomePage();
		List<String> expectedList_M1 = Arrays.asList("Welcome", "Akash12", "(2627)", "DEMO LTD", "Mumbai (Export Air)");
		List<String> expectedList_M2 = Arrays.asList("Welcome", "Akash12", "(2627)", "DEMO LTD", "Mumbai (Export Sea)");
		List<String> expectedList_M3 = Arrays.asList("Welcome", "Akash12", "(2627)", "DEMO LTD", "Mumbai (Import Air)");
		List<String> expectedList_M4 = Arrays.asList("Welcome", "Akash12", "(2627)", "DEMO LTD", "Mumbai (Import Sea)");
		List<String> expectedList_A1 = Arrays.asList("Welcome", "Akash12", "(2627)", "DEMO LTD", "Ahmedabad (Export Air)");
		List<String> expectedList_A2 = Arrays.asList("Welcome", "Akash12", "(2627)", "DEMO LTD", "Ahmedabad (Export Sea)");
		List<String> expectedList_A3 = Arrays.asList("Welcome", "Akash12", "(2627)", "DEMO LTD", "Ahmedabad (Import Air)");
		List<String> expectedList_A4 = Arrays.asList("Welcome", "Akash12", "(2627)", "DEMO LTD", "Ahmedabad (Import Sea)");
		if(actualList.equals(expectedList_M1)) {
			System.out.println(actualList +" Matches To "+expectedList_M1);
		}else if(actualList.equals(expectedList_M2)) {
			System.out.println(actualList +" Matches To "+expectedList_M2);
		}else if(actualList.equals(expectedList_M3)) {
			System.out.println(actualList +" Matches To "+expectedList_M3);
		}else if(actualList.equals(expectedList_M4)) {
			System.out.println(actualList +" Matches To "+expectedList_M4);
		}
	
		

		

	}

	@Test
	public void validateAllBranch_Division_FinYear_003() {

		LoginBranchDivision logBranchDiv = new LoginBranchDivision(utilObj);

		Map<String, String> testData = ExcelDataSuplier.setExcelFile("BranchSheet", "ID-7");
		
		String braname = testData.get("branchname");
		String divi = testData.get("division");
		String year = testData.get("finYear");

		logBranchDiv.SelectBranch(braname);

		logBranchDiv.SelectDevision(divi);

		logBranchDiv.SelectFinYear(year);

		logBranchDiv.clickOnOKButton();

		Homepage homeObj = new Homepage(utilObj);

		List<String> actualList = homeObj.verifyLoginBranchDivision_OnHomePage();
		List<String> expectedList = Arrays.asList("Welcome", "Akash12", "(2425)", "DEMO LTD", "Ahmedabad (Import Air)");

		utilObj.validateListOfText(actualList, expectedList);
	}

}
