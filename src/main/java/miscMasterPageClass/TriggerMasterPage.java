package miscMasterPageClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webutil.WebUtil;

public class TriggerMasterPage {
	
	WebUtil utilobj ;
	
	public TriggerMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	
	// Name Textbox
	@FindBy(xpath = "//input[@id='txtName']")
	WebElement name ;
	
	// Type Dropdown 
	@FindBy(xpath = "//select[@id='txtType']")
	WebElement type ;
	
	// Display Status
	@FindBy(xpath = "//select[@id='txtLovStatus']")
	WebElement displayStatus ;
	
	// Note Textbox
	@FindBy(xpath = "(//textarea[@type='text'])[1]")
	WebElement note ;
	
	// Search Textbox
	@FindBy(xpath = "//input[@id='txtTriggerSearch']")
	WebElement searchBox ;
	
	// Search Grid Record
	@FindBy(xpath = "(((//div[@class='x-grid3-scroller'])[1]/div/div)[1]/table/tbody/tr/td)[1]/div/img")
	WebElement searchGridRecord ;
	
	// Page Grid Record 
	@FindBy(xpath = "(((//div[@class='x-grid3-scroller'])[2]/div/div)[1]/table/tbody/tr/td)[1]/div/img")
	WebElement pageGridRecord ;
	
	// Save Button
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement saveBtn ;
	
	// Modify Button
	@FindBy(xpath = "//button[@id='btnModify']")
	WebElement modifyBtn ;
	
	// Clear Button
	@FindBy(xpath = "//button[@id='btnClear']")
	WebElement clearBtn ;
	
	// From Date Textbox
	@FindBy(xpath = "//input[@id='txtFromDate']")
	WebElement fromDate ;
	
	// To Date Textbox
	@FindBy(xpath = "//input[@id='txtToDate']")
	WebElement toDate ;
	
	// Date Search Button
	@FindBy(xpath = "//button[@id='btnQuery']")
	WebElement dateSearchBtn ;

	
	
	
	
	// Create Trigger Master Record
	public void createTriggerMasterPage(String nameN, String typeN, String displayStatusN, String noteN) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(name));
		utilobj.sendKeys(name, nameN,  "Name Textbox");
		utilobj.getDriver().findElement(By.xpath("(//ul[contains(@id, 'ui-id-')]/li)/div[text()='"+nameN+"']")).click();
		utilobj.selectByValue(type, typeN, "Type Dropdown");
		utilobj.selectByValue(displayStatus, displayStatusN, "Display Status Dropdown");
		utilobj.sendKeys(note, noteN, "Note Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		utilobj.click(saveBtn, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Saved successfully.", true);
	}
	
	
	
	
	// Modify Trigger Master Record
	public void modifyTriggerMasterPage(String searchM, String fromDateM, String toDateM, String searchGridRecordM, String nameM,
			String typeM, String displayStatusM, String noteM) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		utilobj.sendKeys(searchBox, searchM, "Search Textbox");
		
		wait.until(ExpectedConditions.visibilityOf(fromDate));
		utilobj.selectDate(fromDate, fromDateM, "From Date Textbox");
		wait.until(ExpectedConditions.visibilityOf(toDate));
		utilobj.selectDate(toDate, toDateM, "To Date Textbox");
		
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordM);
		wait.until(ExpectedConditions.elementToBeClickable(pageGridRecord));
		utilobj.click(pageGridRecord, "Page Grid Record");
		wait.until(ExpectedConditions.visibilityOf(name));
		utilobj.clear(name, "Name Textobx");
		utilobj.sendKeys(name, nameM, "Name Textbox");
		utilobj.getDriver().findElement(By.xpath("(//ul[contains(@id, 'ui-id-')]/li)/div[text()='"+nameM+"']")).click();
		utilobj.selectByValue(displayStatus, displayStatusM, "Display Status Dropdown");
		wait.until(ExpectedConditions.visibilityOf(note));
		utilobj.clear(note, "Note Textbox");
		utilobj.sendKeys(note, noteM, "Note Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(modifyBtn));
		utilobj.click(modifyBtn, "Modify Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Modified Successfully.", true);
	}
	
	
	
	
	// Trigger Master Page Clear
	public void clearTriggerMasterPage(String searchC, String fromDateC, String toDateC, String searchGridRecordC, String nameC, 
			String typeC, String displayStatusC, String noteC) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		utilobj.sendKeys(searchBox, searchC, "Search Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordC);
		wait.until(ExpectedConditions.elementToBeClickable(pageGridRecord));
		utilobj.click(pageGridRecord, "Page Grid Record");
		wait.until(ExpectedConditions.elementToBeClickable(clearBtn));
		utilobj.click(clearBtn, "Clear Button");
	}
	
	
	
}
