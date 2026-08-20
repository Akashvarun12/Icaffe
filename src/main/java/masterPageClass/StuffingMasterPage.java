package masterPageClass;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webutil.WebUtil;

public class StuffingMasterPage {

	WebUtil utilobj ;
	
	public StuffingMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	
	// Stuffing Name Textbox
	@FindBy(xpath = "//input[@id='txtStuffingName']")
	WebElement stuffingName ;
	
	// Refer To Textbox
	@FindBy(xpath = "//input[@id='txtRefer']")
	WebElement referTo ;
	
	// Save Button 
	@FindBy(xpath = "//button[@id='AddBtn']")
	WebElement saveBtn ;
	
	// Modify Button
	@FindBy(xpath = "//button[@id='btnModify']")
	WebElement modifyBtn ;
	
	// Delete Button
	@FindBy(xpath = "//button[@id='DeleteBtn']")
	WebElement deleteBtn ;
	
	// Clear Button
	@FindBy(xpath = "//button[@id='ClearBtn']")
	WebElement clearBtn ;
	
	// Search Textbox
	@FindBy(xpath = "//input[@id='txtStuffName']")
	WebElement searchBox ;
	
	// Search Grid Record 
	@FindBy(xpath = "((//div[@class='x-grid3-scroller']/div/div)[1]/table/tbody/tr/td)[1]/div/img")
	WebElement searchGridRecord ;
	
	
	
	
	
	
	// Create Stuffing Master Record
	public void createStuffingMasterPage(String stuffingNameN, String referToN) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(stuffingName));
		utilobj.sendKeys(stuffingName, stuffingNameN, "Stuffing Name Textbox");
		utilobj.sendKeys(referTo, referToN, "Refer To Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		utilobj.click(saveBtn, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Saved successfully.", true);		
	}
	
	
	
	// Modifying Stuffing Master Record
	public void modifyStuffingMasterPage(String searchM, String searchGridRecordM, String stuffingNameM, String referToM) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		utilobj.sendKeys(searchBox, searchM, "Search Box");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordM);
		wait.until(ExpectedConditions.visibilityOf(stuffingName));
		utilobj.clear(stuffingName, "Stuffing Name Textbox");
		utilobj.sendKeys(stuffingName, stuffingNameM, "Stuffing Name Textbox");
		wait.until(ExpectedConditions.visibilityOf(referTo));
		utilobj.clear(referTo, "Refer To Textbox");
		utilobj.sendKeys(referTo, referToM, "Refer To Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(modifyBtn));
		utilobj.click(modifyBtn, "Modify Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Modified Successfully.", true);
	}
	
	
	
	
	
	// Deleting Stuffing Master Record
	public void deleteStuffingMasterPage(String searchD, String searchGridRecordD, String stuffingNameD, String referToD) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		utilobj.sendKeys(searchBox, searchD, "Search Box");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordD);
		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
		utilobj.click(deleteBtn, "Delete Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Are you sure you want to Delete?", false);
		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
		utilobj.click(deleteBtn, "Delete Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Are you sure you want to Delete?", true);
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Delete Successfully.", true);
	}
	
	
	
	
	
	
	// Stuffing Master Page Clear Test Case
	public void clearStuffingMasterPage(String searchC, String searchGridRecordC, String stuffingNameC, String referToC) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		utilobj.sendKeys(searchBox, searchC, "Search Box");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordC);
		wait.until(ExpectedConditions.elementToBeClickable(clearBtn));
		utilobj.click(clearBtn, "Clear Button");
	}

	
}
