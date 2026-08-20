package masterPageClass;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webutil.WebUtil;

public class DocumentPage {
	
	WebUtil utilobj ;
	
	public DocumentPage(WebUtil utilobj) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	
	// Document Name Textbox 
	@FindBy(xpath = "//input[@id='txtDocumentName']")
	WebElement documentName ;
	
	// Post Shipment Radio Button
	@FindBy(xpath = "//input[@id='rbtnPostShipment']")
	WebElement postShipmentRadioBtn ;
	
	// Pre Shipment Radio Button
	@FindBy(xpath = "//input[@id='rbtnPreShipment']")
	WebElement preShipmentRadioBtn ;
	
	// Both Radio Button
	@FindBy(xpath = "//input[@id='rbtnBoth']")
	WebElement bothRadioBtn ;
	
	// General Radio Button
	@FindBy(xpath = "//input[@id='rbtnGeneral']")
	WebElement generalRadioBtn ;
	
	// Save Button
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement saveBtn ;
	
	// Modify Button
	@FindBy(xpath = "//button[@id='btnModify']")
	WebElement modifyBtn ;
	
	// Delete Button
	@FindBy(xpath = "//button[@id='btnDelete']")
	WebElement deleteBtn ;
	
	// Clear Button
	@FindBy(xpath = "//button[@id='btnClear']")
	WebElement clearBtn ;

	// Shipment Type Dropdown
	@FindBy(xpath = "//select[@id='ddlDocType']")
	WebElement shipmentType ;
	
	// Search Box
	@FindBy(xpath = "//input[@id='txtListDocumentName']")
	WebElement searchBox ;
	
	// Search Grid Record
	@FindBy(xpath = "((//div[@class='x-grid3-scroller']/div/div)[1]/table/tbody/tr/td)[1]/div/img")
	WebElement searchGridRecord ;
	
	
	
	
	// Create Document Record
	public void createDocumentPage(String documentNameN){
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(documentName));
		utilobj.sendKeys(documentName, documentNameN, "Document Name Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(postShipmentRadioBtn));
		utilobj.click(postShipmentRadioBtn, "Post Shipment Radio Button");
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		utilobj.click(saveBtn, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Saved successfully.", true);
	}
	
	
	
	
	// Modify Document Record
	public void modifyDocumentPage(String shipmentTypeM, String searchM, String searchGridRecordM, String documentNameM) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(shipmentType));
		utilobj.selectByValue(shipmentType, shipmentTypeM, "Shipment Type Dropdown");
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		utilobj.sendKeys(searchBox, searchM, "Search Box");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordM);
		wait.until(ExpectedConditions.visibilityOf(documentName));
		utilobj.clear(documentName, "Document Name Textbox");
		utilobj.sendKeys(documentName, documentNameM, "Document Name Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(preShipmentRadioBtn));
		utilobj.click(preShipmentRadioBtn, "Pre Shipment Radio Button");
		wait.until(ExpectedConditions.elementToBeClickable(modifyBtn));
		utilobj.click(modifyBtn, "Modify Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Modified  successfully.", true);
	}
	
	
		
	
	
	// Delete Document Record
	public void deleteDocumentPage(String shipmentTypeD, String searchD, String searchGridRecordD, String documentNameD) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(shipmentType));
		utilobj.selectByValue(shipmentType, shipmentTypeD, "Shipment Type Dropdown");
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		utilobj.sendKeys(searchBox, searchD, "Search Box");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordD);
		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
		utilobj.click(deleteBtn, "Delete Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Are you sure! Do you want to  Delete?", true);
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Deleted", true);	
	}
	
	
	
	
	
	// Document Page Clear
	public void clearDocumentPage(String shipmentTypeC, String searchC, String searchGridRecordC, String documentNameC) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(shipmentType));
		utilobj.selectByValue(shipmentType, shipmentTypeC, "Shipment Type Dropdown");
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		utilobj.sendKeys(searchBox, searchC, "Search Box");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordC);
		wait.until(ExpectedConditions.elementToBeClickable(clearBtn));
		utilobj.click(clearBtn, "Clear Button");
	}
	
	
	
}
