package regionalMasterPageClass;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webutil.WebUtil;

public class CostCenterMasterPage {

	WebUtil utilobj ;
	
	public CostCenterMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	// Code Textbox
	@FindBy(xpath = "//input[@id='CostCenterCode']")
	WebElement code ;
	
	
	// Name Textbox
	@FindBy(xpath = "//input[@id='txtName']")
	WebElement name ;
	
	
	// Display Status Dropdown
	@FindBy(xpath = "//select[@id='CostCenterLOVStatus']")
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
	@FindBy(xpath = "//input[@id='txtUnitSearch']")
	WebElement searchBox ;
	
	
	// Search Grid Record
	@FindBy(xpath = "(//img[@src='../../CSImages/accept.png'])[1]")
	WebElement searchGridRecord ;
	
	
	// Cost Center Grid Record
	@FindBy(xpath = "((//div[@class='x-grid3-scroller'])[2]/div/div/table/tbody/tr/td)[1]/div/img")
	WebElement pageGridRecod ;
	
	
	
	
	/*
	// Create a New Cost Center Master Record
	public void createCostCenterPage(String codeC, String nameC, String displayStatusC) throws Exception {
		utilobj.sendKeys(code, codeC, "Code Textbox");
		utilobj.sendKeys(name, nameC, "Name Textbox");
		utilobj.selectByValue(displayStatus, displayStatusC, "Display Status Dropdown");
		utilobj.click(saveBtn, "Save Button");
		Thread.sleep(1000);
		utilobj.validateAlertMessage1("Record Saved successfully.", true);
		
	}
		
	
	// Modify Cost Center Master Record By using XML 
	public void modifyCostCenterPage(String search, String searchGridResultM, String codeM, String nameM, String displayStatusM) throws Exception {
		utilobj.sendKeys(searchBox, search, "Search Textbox");
		utilobj.clickByAction(searchGridRecord, searchGridResultM);
		utilobj.click(pageGridRecod, "Page Grid Record");
		utilobj.clear(code, "Code Textbox");
		utilobj.sendKeys(code, codeM, "Code Textbox");
		utilobj.clear(name, "Name Textbox");
		utilobj.sendKeys(name, nameM, "Name Textbox");
		utilobj.selectByValue(displayStatus, displayStatusM, "Display Status Dropdown");
		utilobj.click(modifyBtn, "Modify Button");
		Thread.sleep(1000);
		utilobj.validateAlertMessage1("Record Modified Successfully.", true);
	}
	*/
	
	
	
	 // Create Record
    public void createCostCenterPage(String codeN, String nameN, String displayStatusN) throws Exception {
    	
    	WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
    	utilobj.sendKeys(code, codeN, "Code Textbox");
    	utilobj.sendKeys(name, nameN, "Name Textbox");
    	utilobj.selectByValue(displayStatus, displayStatusN, "Display Status Dropdown");
    	wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
    	utilobj.click(saveBtn, "Save Button");
    	wait.until(ExpectedConditions.alertIsPresent());
    	utilobj.validateAlertMessage1("Record Saved successfully.", true);
    }
    

    // Modify Record
    public void modifyCostCenterPage(String search, String searchGridRecordM, String codeM, String nameM, String displayStatusM) throws Exception {
    	
    	WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
    	utilobj.sendKeys(searchBox, search, "Search Textbox");
    	utilobj.clickByAction(searchGridRecord, searchGridRecordM);
    	wait.until(ExpectedConditions.elementToBeClickable(pageGridRecod));
    	utilobj.click(pageGridRecod, "Page Grid Value");
    	wait.until(ExpectedConditions.visibilityOf(code));
    	utilobj.clear(code, "Code Textbox");
    	utilobj.sendKeys(code, codeM, "Code Textbox");
    	utilobj.clear(name, "Name Textbox");
    	utilobj.sendKeys(name, nameM, "Name Textbox");
    	utilobj.selectByValue(displayStatus, displayStatusM, "Display Status Dropdown");
    	wait.until(ExpectedConditions.elementToBeClickable(modifyBtn));
    	utilobj.clickByAction(modifyBtn, "Modify Button");
    	wait.until(ExpectedConditions.alertIsPresent());
    	utilobj.validateAlertMessage1("Record Modified Successfully.", true);   
    }
    
    
    
    // Clear Page
    public void clearCostCenterPage(String search, String searchGridRecordM, String codeN, String nameN, String displayStatusN) throws Exception {
    	
    	WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
    	utilobj.sendKeys(searchBox, search, "Search Textbox");
    	utilobj.clickByAction(searchGridRecord, searchGridRecordM);
    	wait.until(ExpectedConditions.visibilityOf(code));
    	utilobj.sendKeys(code, codeN, "Code Textbox");
    	utilobj.sendKeys(name, nameN, "Name Textbox");
    	utilobj.selectByValue(displayStatus, displayStatusN, "Display Status Dropdown");
    	wait.until(ExpectedConditions.elementToBeClickable(clearBtn));
    	utilobj.click(clearBtn, "Clear Button");
    }

   

	
	
}
