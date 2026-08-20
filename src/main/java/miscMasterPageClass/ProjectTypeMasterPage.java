package miscMasterPageClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webutil.WebUtil;

public class ProjectTypeMasterPage {
	
	WebUtil utilobj ;
	
	public ProjectTypeMasterPage(WebUtil utilobj ) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	
	// Code Textbox
	@FindBy(xpath = "//input[@id='txtCode']")
	WebElement code ;
	
	// Name Textbox
	@FindBy(xpath = "//input[@id='txtName']")
	WebElement name ;
	
	// Display Status Dropdown
	@FindBy(xpath = "//select[@id='txtLovStatus']")
	WebElement displayStatus ;
	
	// Shipper Textbox
	@FindBy(xpath = "//input[@id='txtShipper']")
	WebElement shipper ;
	
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
	@FindBy(xpath = "//input[@id='txtProjectSearch']")
	WebElement searchBox ;
	
	// Search Grid Record
	@FindBy(xpath = "(((//div[@class='x-grid3-scroller'])[1]/div/div)[1]/table/tbody/tr/td)[1]/div/img")
	WebElement searchGridRecord ;
	
	// Page Grid Record
	@FindBy(xpath = "((//div[@class='x-grid3-scroller'])[2]/div/div/table/tbody/tr/td)[1]/div/img")
	WebElement pageGridRecord ;
	
	
	
	
	
	// Create Project Type Master Record
	public void createProjectTypeMaster(String codeN, String nameN, String displayStatusN, String shipperN) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(code));
		utilobj.sendKeys(code, codeN, "Code Textbox");
		utilobj.sendKeys(name, nameN, "Name Textbox");
		utilobj.selectByValue(displayStatus, displayStatusN, "Display Status Dropdown");
		wait.until(ExpectedConditions.visibilityOf(shipper));
		utilobj.sendKeys(shipper, shipperN, "Shipper Textbox");
		utilobj.getDriver().findElement(By.xpath("//ul[contains(@id, 'ui-id-')]/li/div[text()='"+shipperN+"']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		utilobj.click(saveBtn, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Saved successfully.", true);
	}
	
	
	
	
	
	

	// Modify Project Type Master Record
	public void modifyProjectTypeMaster(String searchM, String searchGridRecordM, String codeM, String nameM, String displayStatusM, String shipperM) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		utilobj.sendKeys(searchBox, searchM, "Search Box");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordM);
		wait.until(ExpectedConditions.elementToBeClickable(pageGridRecord));
		utilobj.click(pageGridRecord, "Page Grid Record");
		wait.until(ExpectedConditions.visibilityOf(name));
		utilobj.clear(name, "Name Textob");
		utilobj.sendKeys(name, nameM, "Name Textbox");
		wait.until(ExpectedConditions.visibilityOf(displayStatus));
		utilobj.selectByValue(displayStatus, displayStatusM, "Display Status Dropdown");
		wait.until(ExpectedConditions.visibilityOf(shipper));
		utilobj.clear(shipper, "Shiper Textbox");
		utilobj.sendKeys(shipper, shipperM, "Shipper Textbox");
		utilobj.getDriver().findElement(By.xpath("//ul[contains(@id, 'ui-id-')]/li/div[text()='"+shipperM+"']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(modifyBtn));
		utilobj.click(modifyBtn, "Modify Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Modified Successfully.", true);
	}
	
	
	
	
	
	
	
	// Project Type Master Page Clear
	public void clearProjectTypeMaster(String searchC, String searchGridRecordC, String codeC, String nameC, String displayStatusC, String shipperC) {
	
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		utilobj.sendKeys(searchBox, searchC, "Search Box");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordC);
		wait.until(ExpectedConditions.elementToBeClickable(pageGridRecord));
		utilobj.click(pageGridRecord, "Page Grid Record");
		wait.until(ExpectedConditions.elementToBeClickable(clearBtn));
		utilobj.click(clearBtn, "Clear Button");	
	}

	
	
	

}
