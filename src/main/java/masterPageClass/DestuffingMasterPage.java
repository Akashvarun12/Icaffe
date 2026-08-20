package masterPageClass;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webutil.WebUtil;

public class DestuffingMasterPage {
	
	WebUtil utilobj ;
	
	public DestuffingMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	
	
	// Destuffing Name Textbox
	@FindBy(xpath = "//input[@name='DestuffingName']")
	WebElement destuffingName ;
	
	// Refer To Textbox
	@FindBy(xpath = "//input[@name='Refer_To']")
	WebElement referTo ;
	
	// Save Button 
	@FindBy(xpath = "//button[@id='AddBtn']")
	WebElement saveBtn ;
	
	// Modify Button
	@FindBy(xpath = "//button[@id='UpdateBtn']")
	WebElement modifyBtn ;
	
	// Delete Button
	@FindBy(xpath = "//button[@id='DeleteBtn']")
	WebElement deleteBtn ;
	
	// Clear Button
	@FindBy(xpath = "//button[@id='ClearBtn']")
	WebElement clearBtn ;
	
	// Search Textbox
	@FindBy(xpath = "//input[@id='txtDestName']")
	WebElement searchBox ;
	
	// Search Grid Record 
	@FindBy(xpath = "((//div[@class='x-grid3-scroller']/div/div)[1]/table/tbody/tr/td)[1]/div/img")
	WebElement searchGridRecord ;
	
	
	// Create Destuffing Master Record
		public void createDestuffingMasterPage(String destuffingNameN, String referToN) {
			
			WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(destuffingName));
			utilobj.sendKeys(destuffingName, destuffingNameN, "Destuffing Name Textbox");
			utilobj.sendKeys(referTo, referToN, "Refer To Textbox");
			wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
			utilobj.click(saveBtn, "Save Button");
			wait.until(ExpectedConditions.alertIsPresent());
			utilobj.validateAlertMessage1("Data Saved successfully!!!", true);		
		}
		
		
		
		// Modifying Destuffing Master Record
		public void modifyDestuffingMasterPage(String searchM, String searchGridRecordM, String destuffingNameM, String referToM) {
			
			WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(searchBox));
			utilobj.sendKeys(searchBox, searchM, "Search Box");
			wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
			utilobj.clickByAction(searchGridRecord, searchGridRecordM);
			wait.until(ExpectedConditions.visibilityOf(referTo));
			utilobj.clear(referTo, "Refer To Textbox");
			utilobj.sendKeys(referTo, referToM, "Refer To Textbox");
			wait.until(ExpectedConditions.elementToBeClickable(modifyBtn));
			utilobj.click(modifyBtn, "Modify Button");
			wait.until(ExpectedConditions.alertIsPresent());
			utilobj.validateAlertMessage1("Data Modified successfully!!!", true);
		}
		
		
		
		
		
		// Deleting Destuffing Master Record
		public void deleteDestuffingMasterPage(String searchD, String searchGridRecordD, String destuffingNameD, String referToD) {
			
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
			utilobj.validateAlertMessage1("Data Deleted successfully!!!", true);
		}
		
		
		
		
		
		
		// Destuffing Master Page Clear
		public void clearStuffingMasterPage(String searchC, String searchGridRecordC, String destuffingNameC, String referToC) {
			
			WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(searchBox));
			utilobj.sendKeys(searchBox, searchC, "Search Box");
			wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
			utilobj.clickByAction(searchGridRecord, searchGridRecordC);
			wait.until(ExpectedConditions.elementToBeClickable(clearBtn));
			utilobj.click(clearBtn, "Clear Button");
		}
	

}
