package miscMasterPageClass;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webutil.WebUtil;

public class PrincipleLineHBLMasterPage {
	
	WebUtil utilobj ;
	
	public PrincipleLineHBLMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	// Code Textbox
	@FindBy(xpath = "//input[@id='txtCode']")
	WebElement code ;
	
	// Name Textbox
	@FindBy(xpath = "//input[@id='txtName']")
	WebElement name ;
	
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
	@FindBy(xpath = "//input[@id='txthBLSearch']")
	WebElement searchBox ;
	
	// Search Grid Record
	@FindBy(xpath = "((//div[@class='x-grid3-scroller'])[1]/div/div)/table/tbody/tr/td/div/img")
	WebElement searchGridRecord ;
	
	// Page Grid Record
	@FindBy(xpath = "((//div[@class='x-grid3-scroller'])[2]/div/div)/table/tbody/tr/td/div/img")
	WebElement pageGridRecord ;
	
	
	
	
	
	// Principle Line HBL Master Record Creation (Single or Multiple)
	public void createPrincipleLineHBLMaster(String codeN, String nameN) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(code));
		utilobj.sendKeys(code, codeN, "Code Textbox");
		utilobj.sendKeys(name, nameN, "Name Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		utilobj.click(saveBtn, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Saved successfully.", true);
	}
	
	
	
	
	
	// Principle Line HBL Master Record Modification
	public void modifyPrincipleLineHBLMaster(String searchM, String searchGridRecordM, String codeM, String nameM) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		utilobj.sendKeys(searchBox, searchM, "Search Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordM);
		wait.until(ExpectedConditions.elementToBeClickable(pageGridRecord));
		utilobj.click(pageGridRecord, "Page Grid Record");
		wait.until(ExpectedConditions.visibilityOf(name));
		utilobj.clear(name, "Name Textbox");
		utilobj.sendKeys(name, nameM, "Name Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(modifyBtn));
		utilobj.click(modifyBtn, "Modify Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Modified Successfully.", true);
	}
	
	
	
	
	
	// Principle Line HBL Master Page Clear
	public void clearPrincipleLineHBLMaster(String searchC, String searchGridRecordC, String codeC, String nameC) {
		
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
