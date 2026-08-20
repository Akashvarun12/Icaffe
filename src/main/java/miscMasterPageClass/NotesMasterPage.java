package miscMasterPageClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webutil.WebUtil;

public class NotesMasterPage {
	
	WebUtil utilobj ;
	
	public NotesMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);
	}

	
	// Branch Name Textbox
	@FindBy(xpath = "//input[@id='txtBranchCode']")
	WebElement branchName ;
	
	// Name Textbox
	@FindBy(xpath = "//input[@id='txtName']")
	WebElement name ;
	
	// Status Type Dropdown
	@FindBy(xpath = "//select[@id='txtStatusType']")
	WebElement statusType ;
	
	// Display Status Dropdown 
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
	
	// Search Box
	@FindBy(xpath = "//input[@id='btnQuery']")
	WebElement searchBox ;
	
	// Search Grid Record
	@FindBy(xpath = "((//div[@class='x-grid3-scroller']/div/div)[1]/table/tbody/tr/td)[1]/div/img")
	WebElement searchGridRecord ;
	
	
	
	
	
	// Create Notes Master Record
	public void createNotesMasterPage(String branchNameN, String nameN, String statusTypeN, String displayStatusN) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(branchName));
		utilobj.sendKeys(branchName, branchNameN, "Branch Name Textbox");
		utilobj.getDriver().findElement(By.xpath("(//ul[contains(@id, 'ui-id-')])[1]/li/div[text()='"+branchNameN+"']")).click();
		utilobj.sendKeys(name, nameN, "Name Textbox");
		utilobj.selectByValue(statusType, statusTypeN, "Status Type Dropdown");
		utilobj.selectByValue(displayStatus, displayStatusN, "Display Status Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		utilobj.click(saveBtn, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Saved successfully.", true);
	}
	
	
	
	
	// Modify Notes Master Record
	public void modifyNotesMasterPage(String searchM, String searchGridRecordM, String branchNameM, String nameM, String statusTypeM, String displayStatusM) {

		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		utilobj.sendKeys(searchBox, searchM, "Search Box");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordM);
		wait.until(ExpectedConditions.visibilityOf(name));
		utilobj.clear(name, "Name Textbox");
		utilobj.sendKeys(name, nameM, "Name Textbox");
		wait.until(ExpectedConditions.visibilityOf(statusType));
		utilobj.selectByValue(statusType, statusTypeM, "Status Type Dropdown");
		wait.until(ExpectedConditions.visibilityOf(displayStatus));
		utilobj.selectByValue(displayStatus, displayStatusM, "Display Status Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(modifyBtn));
		utilobj.click(modifyBtn, "Modify Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Modified Successfully.", true);
	}
	
	
	
	
	// Notes Master Page Clear
	public void clearNotesMasterPage(String searchC, String searchGridRecordC, String branchNameC, String nameC, String statusTypeC, String displayStatusC) {

		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		utilobj.sendKeys(searchBox, searchC, "Search Box");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordC);
		wait.until(ExpectedConditions.elementToBeClickable(clearBtn));
		utilobj.click(clearBtn, "Clear Button");
	}
	
	
	
	
}
