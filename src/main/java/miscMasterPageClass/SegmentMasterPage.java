package miscMasterPageClass;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.This;
import webutil.WebUtil;

public class SegmentMasterPage {
	
	WebUtil utilobj ;
	
	public SegmentMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	
	// Segment Type Dropdown
	@FindBy(xpath = "//select[@id='ddlSegmentType']")
	WebElement segmentType ;
	
	// Name Textbox
	@FindBy(xpath = "//input[@id='txtName']")
	WebElement name ;
	
	// Transport Mode Dropdown
	@FindBy(xpath = "//select[@id='ddlTransportMode']")
	WebElement transportMode ;
	
	// Import Export Mode
	@FindBy(xpath = "//select[@id='ddlImportMode']")
	WebElement importExportMode ;
	
	// Clearance Dropdown
	@FindBy(xpath = "//select[@id='ddlClearance']")
	WebElement clearance ;
	
	// Display Status
	@FindBy(xpath = "//select[@id='ddlLOVStatus']")
	WebElement displayStatus ;
	
	// Save Button 
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement saveBtn ;
	
	// Modify Button
	@FindBy(xpath = "//button[@id='btnModify']")
	WebElement modifyBtn ;
	
	// Clear Button
	@FindBy(xpath = "//button[@id='btnClear']")
	WebElement clearBtn ;
	
	// Search Textbox
	@FindBy(xpath = "//input[@id='txtUnitSearch']")
	WebElement searchBox ;
	
	// Search Grid Record
	@FindBy(xpath = "((//div[@class='x-grid3-scroller']/div/div)[1]/table/tbody/tr/td)[1]/div/img")
	WebElement searchGridRecord ;
	
	
	
	// Create segment Master Record
	public void createSegmentMasterPage(String segmentTypeN, String nameN, String transportModeN, String importExportModeN, String clearanceN, String displayStatusN) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(segmentType));
		utilobj.selectByValue(segmentType, segmentTypeN, "Segment Type Dropdown");
		utilobj.sendKeys(name, nameN, "Name Textbox");
		utilobj.selectByValue(transportMode, transportModeN, "Transport Mode Dropdown");
		utilobj.selectByValue(importExportMode, importExportModeN, "Import Export Mode Dropdown");
		utilobj.selectByValue(clearance, clearanceN, "Clearance Dropdown");
		utilobj.selectByValue(displayStatus, displayStatusN, "Display Status Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		utilobj.click(saveBtn, "Save Button");
		utilobj.validateAlertMessage1("Record Saved Successfully.", true);	
	}
	
	
	
	// Modify segment Master Record
	public void modifySegmentMasterPage(String searchM, String searchGridRecordM, String segmentTypeM, String nameM, 
			String transportModeM, String importExportModeM, String clearanceM, String displayStatusM) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		utilobj.sendKeys(searchBox, searchM, "Search Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordM);
		wait.until(ExpectedConditions.visibilityOf(name));
		utilobj.clear(name, "Name Textbox");
		utilobj.sendKeys(name, nameM, "Name Textbox");
		utilobj.selectByValue(displayStatus, displayStatusM, "Display Status Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(modifyBtn));
		utilobj.click(modifyBtn, "Modify Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Modified Successfully.", true);
	}
	
	
	
	// Clear Segment Master Page
	public void clearSegmentMasterPage(String searchC, String searchGridRecordC, String segmentTypeC, String nameC, 
			String transportModeC, String importExportModeC, String clearanceC, String displayStatusC) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		utilobj.sendKeys(searchBox, searchC, "Search Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordC);
		wait.until(ExpectedConditions.elementToBeClickable(clearBtn));
		utilobj.click(clearBtn, "Clear Button");	
	}
	

	
	
}
