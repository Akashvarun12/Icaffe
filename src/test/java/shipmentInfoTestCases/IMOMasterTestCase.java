package shipmentInfoTestCases;



import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;

public class IMOMasterTestCase extends BaseTest{
	
	
	@Test
	public void IMOMaster() {
		
		
		Homepage homeObj = new Homepage(utilObj);
		
		List<String> actualList = homeObj.verifyLoginBranchDivision_OnHomePage();
		List<String> expectedList = Arrays.asList("Welcome", "Shivam220", "(2627)", "DEMO LTD",
				"Ahmedabad (Export Sea)");

		utilObj.validateListOfText(actualList, expectedList);

		 homeObj.GoTo_IMOMaster();
		 utilObj.validateGetTitle("IMO Master", "IMO Master", "Page Title");
	}
	

}
