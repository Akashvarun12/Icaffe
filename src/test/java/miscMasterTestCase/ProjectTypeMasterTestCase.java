package miscMasterTestCase;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import miscMasterPageClass.ProjectTypeMasterPage;
import webutil.ExcelDataSuplier;

public class ProjectTypeMasterTestCase extends BaseTest {
	

// Test Case - 1 - Project Type Master Page Title Validation
		@Test(priority = 1)
		public void pageTitlePrincipleLineHBLMaster() {
			Homepage homepage = new Homepage(utilObj);
			homepage.goToProjectTypeMaster();
			utilObj.validateGetTitle("Project Type Master", "valid", "Project Type Master Page Title");	
		}
		
		
		
	
		
// Test Case - 2 - Project Type Master Page Master Record Creation (Single or Multiple)
		@Test(priority = 2, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
		public void createProjectTypeMaster(String code, String name, String displayStatus, String shipper) {
			Homepage homepage = new Homepage(utilObj);
			homepage.goToProjectTypeMaster();
			utilObj.validateGetTitle("Project Type Master", "valid", "Project Type Master Page Title");	
			
			ProjectTypeMasterPage projectTypeMasterPage = new ProjectTypeMasterPage(utilObj);
			projectTypeMasterPage.createProjectTypeMaster(code, name, displayStatus, shipper);	
		}
		
		
		
		
		
// Test Case - 3 - Project Type Master Record Modification
		@Test(priority = 3, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
		public void modifyProjectTypeMaster(String search, String searchGridRecord, String code, String name, String displayStatus, String shipper) {
			Homepage homepage = new Homepage(utilObj);
			homepage.goToProjectTypeMaster();
			utilObj.validateGetTitle("Project Type Master", "valid", "Project Type Master Page Title");
			
			ProjectTypeMasterPage projectTypeMasterPage = new ProjectTypeMasterPage(utilObj);
			projectTypeMasterPage.modifyProjectTypeMaster(search, searchGridRecord, code, name, displayStatus, shipper);
		}
		
		
		
		
		
// Test Case - 4 - Project Type Master Page Clear
		@Test(priority = 4, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
		public void clearProjectTypeMaster(String search, String searchGridRecord, String code, String name, String displayStatus, String shipper) {
			Homepage homepage = new Homepage(utilObj);
			homepage.goToProjectTypeMaster();
			utilObj.validateGetTitle("Project Type Master", "valid", "Project Type Master Page Title");
			
			ProjectTypeMasterPage projectTypeMasterPage = new ProjectTypeMasterPage(utilObj);
			projectTypeMasterPage.clearProjectTypeMaster(search, searchGridRecord, code, name, displayStatus, shipper);
		}

}
