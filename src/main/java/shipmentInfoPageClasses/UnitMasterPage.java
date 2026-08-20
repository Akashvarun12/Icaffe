package shipmentInfoPageClasses;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webutil.WebUtil;

public class UnitMasterPage {


	private WebUtil utilobj ;
	
	// Constructor
	public UnitMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	
	// Code Textbox
	@FindBy(xpath = "//input[@id='txtServiceCode']")
	WebElement code ;
	
	
	// Name Textbox
	@FindBy(xpath = "//input[@id='txtName']")
	WebElement name ; 
	
	
	// Type Textbox
	@FindBy(xpath = "//select[@id='ddlType']")
	WebElement type ;
	
	
	// Save button 
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement saveBtn ;
	
	
	// Modify Button
	@FindBy(xpath = "//button[@id='btnModify']")
	WebElement modifyBtn ;
	
	
	// Clear Button
	@FindBy (xpath = "//button[@id='btnClear']")
	WebElement clearBtn ;
	
	
	// Search Textbox
	@FindBy(xpath = "//input[@id='txtUnitSearch']")
	WebElement searchTextbox ;
	
	
	// Search Grid List 
	@FindBy(xpath =  "(//img[@src='../../CSImages/accept.png'])[1]")
	WebElement searchValueSelected ;
	
	
	
	
	// Creating New Unit Master Record
	public void createUnitMasterRecord(String codeN, String nameN, String typeN) throws Exception {
		/*
		Properties pr = utilobj.propertiFile("UnitMasterData.properties");
		String codeN = pr.getProperty("code");
		String nameN = pr.getProperty("name");
		String typeN = pr.getProperty("type");
		*/
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(code, codeN, "Code Textbox");
		utilobj.sendKeys(name, nameN, "Name Textbox");
		utilobj.selectByValue(type, typeN, "Type Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		utilobj.click(saveBtn, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Saved successfully.", true);	
	}
	
	
	
	// Modifying the Unit Master Record
	public void modifyUnitMasterRecord(String searchM, String searchSelectedM, String codeN, String nameM, String typeM) throws Exception {
		/*
		Properties pr = utilobj.propertiFile("UnitMasterData.properties");
		String searchM = pr.getProperty("search");
		String searchSelectedM = pr.getProperty("selectedValueM");
		String nameM = pr.getProperty("nameM");
		*/
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(searchTextbox, searchM, "Search Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(searchValueSelected));
		utilobj.click(searchValueSelected, searchSelectedM);
		wait.until(ExpectedConditions.visibilityOf(name));
		utilobj.clear(name, "Name Textbox");
		utilobj.sendKeys(name, nameM, "Name Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(modifyBtn));
		utilobj.click(modifyBtn, "Modify Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Modified Successfully.", true);
	}
	
	
	
	// Clear the Unit Master Page
	public void clearUnitMaster(String codeC, String nameC, String typeC) throws Exception {
		/*
		Properties pr = utilobj.propertiFile("UnitMasterData.properties");
		String codeC = pr.getProperty("code"); 
		String nameC = pr.getProperty("name");
		String typeC = pr.getProperty("type2");
		*/
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(code, codeC, "Code Textbox");
		utilobj.sendKeys(name, nameC, "Name Textbox");
		utilobj.selectByValue(type, typeC, "Type Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(clearBtn));
		utilobj.click(clearBtn, "Clear Button");
	}
	
	
}
