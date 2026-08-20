package regionalMasterPageClass;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.This;
import webutil.WebUtil;

public class ZoneMasterPage {
	
	private WebUtil utilobj ;
	 
	public ZoneMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	
	// Code textbox
	@FindBy(xpath = "//input[@id='txtCode']")
	WebElement code ;
	
	
	//Name textbox
	@FindBy(xpath = "//input[@id='txtName']")
	WebElement name ;
	
	
	//Country Code textbox
	@FindBy(xpath = "//input[@id='txtCountry']")
	WebElement countryCode ;
	
	
	// Display Status dropdown
	@FindBy(xpath = "//select[@id='txtLovStatus']")
	WebElement displayStatus ;
	
	
	// Save button
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement savebtn ;
	
	
	// Modify button
	@FindBy(xpath = "//button[@id='btnModify']")
	WebElement modifybtn ;
	
	
	// Clear button
	@FindBy(xpath = "//button[@id='btnClear']")
	WebElement clearbtn ;
	
	
	// Search box
	@FindBy(xpath = "//input[@id='txtZoneSearch']")
	WebElement searchBox ;
	
	
	
	// Search result list
	@FindBy(xpath = "//img[@src='../../CSImages/accept.png']")
	WebElement searchGridRecord ;
	
	
	//Zone Master Grid Value selection (Page grid Record)
	@FindBy(xpath = "((//div[@class='x-grid3-scroller'])[2]/div/div/table/tbody/tr/td)[1]/div/img")
	WebElement zoneMasterGridRecord ;
	
	
	
	
	// Creating new Zone Master Record
	public void createZoneMasterPage(String codeN, String nameN, String countryCodeN, String displayStatusN) throws Exception {
		/*
		Properties pr = utilobj.propertiFile("ZoneMasterData.properties");
		String codeN = pr.getProperty("code");
		String nameN = pr.getProperty("name");
		String countryCodeN = pr.getProperty("countryCode");
		String displayStatusN = pr.getProperty("displayStatus");
		*/
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(code, codeN, "Code Textbox");
		utilobj.sendKeys(name, nameN, "Name Textbox");
		utilobj.sendKeys(countryCode, countryCodeN, "Country Code Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@id,'ui-id')]//li/div[text()='" + countryCodeN + "']"))).click();
		utilobj.selectByValue(displayStatus, displayStatusN, "Display Status Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(savebtn));
		utilobj.click(savebtn, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Saved successfully.", true);
	}
	
	
	
	// Modify Zone Master Record
	public void modifyZoneMasterPage(String searchM, String searchListValueM, String codeM, String nameM, String countryCodeN, String displayStatusM) throws Exception {
		/*
		Properties pr = utilobj.propertiFile("ZoneMasterData.properties");
		String searchM = pr.getProperty("search");
		String searchListValueM = pr.getProperty("searchListValue");
		String nameM = pr.getProperty("nameM");
		String displayStatusM = pr.getProperty("displaystatus");
		*/
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(searchBox, searchM, "Search Textbox");
		utilobj.clickByAction(searchGridRecord, searchListValueM);
		wait.until(ExpectedConditions.elementToBeClickable(zoneMasterGridRecord));
		utilobj.click(zoneMasterGridRecord, "Zone Master Grid Record");
		wait.until(ExpectedConditions.visibilityOf(code));
		utilobj.clear(code, "Code Textbox");
		utilobj.sendKeys(code, codeM, "Code Textbox");
		utilobj.clear(name, "Name Textbox");
		utilobj.sendKeys(name, nameM, "Name Textbox");
		utilobj.clear(countryCode, "Country Code Textbox");
		utilobj.sendKeys(countryCode, countryCodeN, "Country Code Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@id,'ui-id')]//li/div[text()='" + countryCodeN + "']"))).click();
		utilobj.selectByValue(displayStatus, displayStatusM, "Display Status");
		wait.until(ExpectedConditions.elementToBeClickable(modifybtn));
		utilobj.click(modifybtn, "Modify Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Modified Successfully.", true);	
	}
	
	
	
	// Clear Zone Master Page
	public void clearZoneMaster(String searchC, String searchListValueC, String codeC, String nameC, String countryCodeC, String displayStatusC) throws Exception {
		/*
		Properties pr = utilobj.propertiFile("ZoneMasterData.properties");
		String codeN = pr.getProperty("code");
		String nameN = pr.getProperty("name");
		String countryCodeN = pr.getProperty("countryCode");
		String displayStatusN = pr.getProperty("displayStatus");
		*/
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(searchBox, searchC, "Search Textbox");
		utilobj.clickByAction(searchGridRecord, searchListValueC);
		wait.until(ExpectedConditions.visibilityOf(code));
		utilobj.sendKeys(code, codeC, "Code Textbox");
		utilobj.sendKeys(name, nameC, "Name Textbox");
		utilobj.sendKeys(countryCode, countryCodeC, "Country Code Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@id,'ui-id')]//li/div[text()='" + countryCodeC + "']"))).click();
		utilobj.selectByValue(displayStatus, displayStatusC, "Display Status Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(clearbtn));
		utilobj.click(clearbtn, "Clear Button");
	}
	

}
