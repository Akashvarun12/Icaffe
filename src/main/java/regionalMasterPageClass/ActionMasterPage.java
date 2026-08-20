package regionalMasterPageClass;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.This;
import webutil.WebUtil;

public class ActionMasterPage {
	
	WebUtil utilobj ;
	
	public ActionMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	
	// Code Textbox
	@FindBy(xpath = "//input[@id='ActionmasterCode']")
	WebElement code ;
	
	// Name Textbox
	@FindBy(xpath = "//input[@id='txtName']")
	WebElement name ;
	
	// Follow Up Days
	@FindBy(xpath = "//input[@id='FollowDay']")
	WebElement followUpDays ;
	
	// Type Textbox
	@FindBy(xpath = "//input[@id='ActionType']")
	WebElement type ;
	
	//LOV Status
	@FindBy(xpath = "//select[@id='LoVStatus']")
	WebElement lovStatus ;
	
	// Search box 
	@FindBy(xpath = "//input[@id='txtUnitSearch']")
	WebElement searchBox ;
	
	// Search Grid Record Value
	@FindBy(xpath = "(//img[@src='../../CSImages/accept.png'])[1]")
	WebElement searchGridRecord ;
	
	// Page Grid Record
	@FindBy(xpath = "((//div[@class='x-grid3-scroller'])[2]/div/div/table/tbody/tr/td)[1]/div/img")
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
	
	
	
	// Create Action Master Record
	public void createActionMasterPage(String codeN, String nameN, String followUpDaysN, String typeN, String lovStatusN) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(code, codeN, "Code Textbox");
		utilobj.sendKeys(name, nameN, "Name Textbox");
		utilobj.sendKeys(followUpDays, followUpDaysN, "Follow Up Days");
		utilobj.sendKeys(type, typeN, "Type Textbox");
		utilobj.selectByValue(lovStatus, lovStatusN, "LOV Status Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		utilobj.click(saveBtn, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Saved successfully.", true);
	}
	
	
	
	// Modify Action Master Record
	public void modifyActionMasterPage(String searchM, String searchValueM, String codeM, String nameM, String followUpDaysM, String typeM, String lovStatusM) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(searchBox, searchM, "Search Box");
		utilobj.clickByAction(searchGridRecord, searchValueM);
		wait.until(ExpectedConditions.elementToBeClickable(pageGridRecord));
		utilobj.click(pageGridRecord, "Page Grid Record");
		wait.until(ExpectedConditions.visibilityOf(name));
		utilobj.clear(name, "Name Textbox");
		utilobj.sendKeys(name, nameM, "Name Textbox");
		utilobj.clear(followUpDays, "Follow Up Days Textbox");
		utilobj.sendKeys(followUpDays, followUpDaysM, "Follow Up Days Textbox");
		utilobj.clear(type, "Type Textbox");
		utilobj.sendKeys(type, typeM, "Type Textbox");
		utilobj.selectByValue(lovStatus, lovStatusM, "LOV Status Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(modifyBtn));
		utilobj.click(modifyBtn, "Modify Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Modified Successfully.", true);	
	}
	
	
	
	// Clear Action Master Page
	public void clearActionMasterPage(String searchC, String searchValueC, String codeC, String nameC, String followUpDaysC, String typeC, String lovStatusC) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(searchBox, searchC, "Search Box");
		utilobj.clickByAction(searchGridRecord, searchValueC);
		utilobj.sendKeys(code, codeC, "Code Textbox");
		utilobj.sendKeys(name, nameC, "Name Textbox");
		utilobj.sendKeys(followUpDays, followUpDaysC, "Follow Up Days");
		utilobj.sendKeys(type, typeC, "Type Textbox");
		utilobj.selectByValue(lovStatus, lovStatusC, "LOV Status Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(clearBtn));
		utilobj.click(clearBtn, "Clear Button");
	}

	
}
