package miscMasterTestCase;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import miscMasterPageClass.SegmentMasterPage;
import webutil.ExcelDataSuplier;

public class SegmentMasterTestCase extends BaseTest {
	
// Test Case - 1 - Segment Master Page Title Validation	
	@Test(priority = 1)
	public void pageTitleSegmentMaster() {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToSegmentMasterPage();
		utilObj.validateGetTitle("Segment Master", "valid", "Segment Master Page Title");
	}
	
	
	
	
// Test Case - 2 - Segment Master Record Creation (single or Multiple)
	@Test(priority = 2, description = "SegmentMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void createSegmentMaster(String segmentType, String name, String transportMode, String importExportMode, String clearance, String displayStatus) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToSegmentMasterPage();
		utilObj.validateGetTitle("Segment Master", "valid", "Segment Master Page Title");
		
		SegmentMasterPage segmentMasterPage = new SegmentMasterPage(utilObj);
		segmentMasterPage.createSegmentMasterPage(segmentType, name, transportMode, importExportMode, clearance, displayStatus);
	}
	
	
	
	
// Test Case - 3 - Segment Master Record Modification	
	@Test(priority = 3, description = "SegmentMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)	
	public void modifySegmentMaster(String search, String searchGridRecord, String segmentType, String name, 
			String transportMode, String importExportMode, String clearance, String displayStatus) {	
		
		Homepage homepage = new Homepage(utilObj);	
		homepage.goToSegmentMasterPage();	
		utilObj.validateGetTitle("Segment Master", "valid", "Segment Master Page Title");
		SegmentMasterPage segmentMasterPage = new SegmentMasterPage(utilObj);	
		segmentMasterPage.modifySegmentMasterPage(search, searchGridRecord, segmentType, name, transportMode, importExportMode, clearance, displayStatus);
		}
	
	
	
	
// Test Case - 4 - Segment Master Page Clear 
		
	@Test(priority = 4, description = "SegmentMaster|Shivam_TestByDataprovider.xlsx", dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)		
	public void clearSegmentMaster(String search, String searchGridRecord, String segmentType, String name, 
				String transportMode, String importExportMode, String clearance, String displayStatus) {	
				
		Homepage homepage = new Homepage(utilObj);		
		homepage.goToSegmentMasterPage();		
		utilObj.validateGetTitle("Segment Master", "valid", "Segment Master Page Title");
		SegmentMasterPage segmentMasterPage = new SegmentMasterPage(utilObj);	
		segmentMasterPage.clearSegmentMasterPage(search, searchGridRecord, segmentType, name, transportMode, importExportMode, clearance, displayStatus);	
	}
	

}
