package masterTestCase;

import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import masterPageClass.DocumentPage;
import webutil.ExcelDataSuplier;

public class DocumentTestCase extends BaseTest {
	
	
// Test Case - 1 - Document Page Title Validation
	@Test(priority = 1)
	public void pageTitleDocument() {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToDocument();
		utilObj.validateGetTitle("DOCUMENT", "valid", "DOCUMENT Page Title");
	}
	
	
	
	
// Test Case - 2 - Create New Document Record
	@Test(priority = 2, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void createDocument(String documentName) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToDocument();
		utilObj.validateGetTitle("DOCUMENT", "valid", "DOCUMENT Page Title");
		
		DocumentPage documentPage = new DocumentPage(utilObj);
		documentPage.createDocumentPage(documentName);	
	}
	
	
	
	
// Test Case - 3 - Modify Document Record
	@Test(priority = 3, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void modifyDocument(String shipmentType, String search, String searchGridRecord, String documentName) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToDocument();
		utilObj.validateGetTitle("DOCUMENT", "valid", "DOCUMENT Page Title");
		
		DocumentPage documentPage = new DocumentPage(utilObj);
		documentPage.modifyDocumentPage(shipmentType, search, searchGridRecord, documentName);
	}
	
	
	
	
// Test Case - 4 - Delete Document Record
	@Test(priority = 4, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void deleteDocument(String shipmentType, String search, String searchGridRecord, String documentName) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToDocument();
		utilObj.validateGetTitle("DOCUMENT", "valid", "DOCUMENT Page Title");
		
		DocumentPage documentPage = new DocumentPage(utilObj);
		documentPage.deleteDocumentPage(shipmentType, search, searchGridRecord, documentName);
	}
	
	
	
	
// Test Case - 4 - Clear Document Page
	@Test(priority = 5, dataProvider = "getData", dataProviderClass = ExcelDataSuplier.class)
	public void clearDocument(String shipmentType, String search, String searchGridRecord, String documentName) {
		Homepage homepage = new Homepage(utilObj);
		homepage.goToDocument();
		utilObj.validateGetTitle("DOCUMENT", "valid", "DOCUMENT Page Title");
		
		DocumentPage documentPage = new DocumentPage(utilObj);
		documentPage.clearDocumentPage(shipmentType, search, searchGridRecord, documentName);
	}
	
	
	
}
