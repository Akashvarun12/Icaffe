package miscMasterTestCase;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import miscMasterPageClass.NotesMasterPage;
import webutil.ExcelDataSuplier;

public class NotesMasterTestCase extends BaseTest {
	
	
// Test Case - 1 - Notes Master Page Title Validation
	@Test(priority = 1)
	public void pageTitleNotesMaster() {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToNotesMaster();
		utilObj.validateGetTitle("Notes Master", "valid", "Notes Master Page Title");
	}
	
	
	
	
// Test Case - 2 - Create Notes Master Record (Single or Multiple)
	@Test(priority = 2, description = "NotesMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void createNotesMaster(String branchName, String name, String statusType, String displayStatus) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToNotesMaster();
		utilObj.validateGetTitle("Notes Master", "valid", "Notes Master Page Title");
		
		NotesMasterPage notesMasterPage = new NotesMasterPage(utilObj);
		notesMasterPage.createNotesMasterPage(branchName, name, statusType, displayStatus);
	}
	
	
	
	
// Test Case - 3 - Notes Master Record Modification
	@Test(priority = 3, description = "NotesMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyNotesMaster(String search, String searchGridRecord, String branchName, String name, String statusType, String displayStatus) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToNotesMaster();
		utilObj.validateGetTitle("Notes Master", "valid", "Notes Master Page Title");
		
		NotesMasterPage notesMasterPage = new NotesMasterPage(utilObj);
		notesMasterPage.modifyNotesMasterPage(search, searchGridRecord, branchName, name, statusType, displayStatus);
	}
	
	
	
	
// Test Case - 4 - Notes Master Page Clear
	@Test(priority = 4, description = "NotesMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void clearNotesMaster(String search, String searchGridRecord, String branchName, String name, String statusType, String displayStatus) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToNotesMaster();
		utilObj.validateGetTitle("Notes Master", "valid", "Notes Master Page Title");
		
		NotesMasterPage notesMasterPage = new NotesMasterPage(utilObj);
		notesMasterPage.clearNotesMasterPage(search, searchGridRecord, branchName, name, statusType, displayStatus);
	}
	
	

}
