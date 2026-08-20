package regionalMasterPageClass;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webutil.WebUtil;

public class PeriodMasterPage {

	WebUtil utilobj ;

	public PeriodMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	
	// Code Textbox
	@FindBy(xpath = "//input[@id='PeriodmasterCode']")
	WebElement code ;
	
	
	// Name Textbox 
	@FindBy(xpath = "//input[@id='txtName']")
	WebElement name ;
	
	
	// Display Status
	@FindBy(xpath = "//select[@id='LoVStatus']")
	WebElement displayStatus ;
	
	
	// Search Box
	@FindBy(xpath = "//input[@id='txtUnitSearch']")
	WebElement searchBox ;
	
	
	// Search Grid Record
	@FindBy(xpath = "(//img[@src='../../CSImages/accept.png'])[1]")
	WebElement searchRecord ;
	
	
	// Page Grid Record
	@FindBy(xpath = "((//div[@class='x-grid3-scroller'])[2]/div/div/table/tbody/tr/td)[1]/div/img")
	WebElement pageGridRecord ;
	
	
	
	// Save button
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement saveBtn ;
	
	
	// Modify Button
	@FindBy(xpath = "//button[@id='btnModify']")
	WebElement modifyBtn ;
	
	
	// Clear Button
	@FindBy(xpath = "//button[@id='btnClear']")
	WebElement clearBtn ;
	
	
	
	
	// Create Period Master Record
	public void createPeriodMasterPage(String codeN, String nameN, String displayStatusN) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(code, codeN, "Code Textbox");
		utilobj.sendKeys(name, nameN, "Name Textbox");
		utilobj.selectByValue(displayStatus, displayStatusN, "Display Status Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		utilobj.click(saveBtn, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Saved successfully.", true);
	}
	
	
	
	// Modify Period Master Record
	public void modifyPeriodMasterPage(String search, String searchRecordM, String codeM, String nameM, String displayStatusM) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(searchBox, search, "Search Box");
		utilobj.clickByAction(searchRecord, searchRecordM);
		wait.until(ExpectedConditions.elementToBeClickable(pageGridRecord));
		utilobj.click(pageGridRecord, "Page Grid Record");
		wait.until(ExpectedConditions.visibilityOf(name));
		utilobj.clear(name, "Name Textbox");
		utilobj.sendKeys(name, nameM, "Name Textbox");
		utilobj.selectByValue(displayStatus, displayStatusM, "Display Status Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(modifyBtn));
		utilobj.click(modifyBtn, "Modify Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Modified Successfully.", true);
	}
	
	
	// Period Master Page Clear
	public void clearPeriodMasterPage(String searchC, String searchRecordC, String codeC, String nameC, String displayStatusC) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(searchBox, searchC, "Search Box");
		utilobj.clickByAction(searchRecord, searchRecordC);
		utilobj.sendKeys(code, codeC, "Code Textbox");
		utilobj.sendKeys(name, nameC, "Name Textbox");
		utilobj.selectByValue(displayStatus, displayStatusC, "Display Status Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(clearBtn));
		utilobj.click(clearBtn, "Clear Button");
	}
	
	
	
}
