package shipmentInfoPageClasses;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import webutil.WebUtil;

public class CHAServicePage {
	
	private WebUtil utilobj ;
	
	public CHAServicePage(WebUtil utilobj) {
		this.utilobj = utilobj;
		PageFactory.initElements(utilobj.getDriver(), this);		
	}
	
	
	// Service Name textbox
	@FindBy(xpath = "//input[@id='txtServiceName']")
	WebElement serviceName ;
	
	
	// Display Status dropdown
	@FindBy(xpath = "//select[@id='ddlLOVStatus']")
	WebElement displayStatus ;
	
	
	// Trade Code dropdown
	@FindBy(xpath = "//select[@id='txtTradeCode']")
	WebElement tradeCode ;
	
	
	// Charge Autosuggest textbox
	@FindBy(xpath = "//input[@id='txtCharge']")
	WebElement charge ;
	
	
	// State Autosuggest textbox
	@FindBy(xpath = "//input[@id='txtStage']")
	WebElement state ;
	
	
	// Customer autosuggest textbox
	@FindBy(xpath = "//input[@id='txtCustomer']")
	WebElement customer ;
	
	
	// Segment Autosuggest textbox
	@FindBy(xpath = "//input[@id='txtSegment']")
	WebElement segment ;
	
	
	// Save button
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement savebtn ;
	
	
	// Modify Button
	@FindBy(xpath = "//button[@id='btnModify']")
	WebElement modiftbtn ;
	
	
	// Clear Button
	@FindBy(xpath = "//button[@id='btnClear']")
	WebElement clearbtn ;
	
	
	
	// Search textbox
	@FindBy(xpath = "//input[@id='txtUnitSearch']")
	WebElement searchbox ;
	
	
	// Search Result list 
	@FindBy(xpath = "//img[@src='../../CSImages/accept.png']")
	WebElement searchlist ;
	
	
	
	
	// Creating new CHA Service Record
	public void createCHAServiceRecord(String serviceNameN, String displayStatusN, String tradeCodeN, String chargeN, 
			String customerN,String segmentN) throws Exception {
		/*
		Properties pr = utilobj.propertiFile("CHSServiceData.properties");
		String serviceNameN = pr.getProperty("serviceName");
		String displayStatusN = pr.getProperty("displayStatus");
		String tradeCodeN = pr.getProperty("tradeCode");
		String chargeN = pr.getProperty("charge");
		String customerN = pr.getProperty("customer");
		String segmentN = pr.getProperty("segment");
		*/
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(serviceName, serviceNameN, "Service Name Textbox");
		utilobj.selectByValue(displayStatus, displayStatusN, "Display Status Dropdown");
		utilobj.selectByValue(tradeCode, tradeCodeN, "Trade Code Dropdown");
		utilobj.sendKeys(charge, chargeN, "Charge Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[contains(@id,'ui-id')])[3]//li/div[text()='" + chargeN + "']"))).click();
		utilobj.sendKeys(customer, customerN, "Customer Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[contains(@id,'ui-id')])[2]//li/div[text()='" + customerN + "']"))).click();
		utilobj.sendKeys(segment, segmentN, "Segment Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[contains(@id,'ui-id')])[1]//li/div[text()='" + segmentN + "']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(savebtn));
		utilobj.click(savebtn, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Saved successfully.", true);	
	}
	
	
	// Modifying Existing CHA Service Record
	public void modifyCHAServicePage(String searchM, String selectedValueM, String serviceNameM, String displayStatusM, String tradeCodeM, 
			String chargeM, String customerM, String segmentM) throws Exception {
		/*
		Properties pr = utilobj.propertiFile("CHSServiceData.properties");
		String searchM = pr.getProperty("searchM");
		String selectedValueM = pr.getProperty("selectedValueM");
		String serviceNameM = pr.getProperty("serviceNameM");
		String displayStatusM = pr.getProperty("displayStatusM");
		String tradeCodeM = pr.getProperty("tradeCodeM");
		String chargeM = pr.getProperty("chargeM");
		String customerM = pr.getProperty("customerM");
		String segmentM = pr.getProperty("segmentM");
		*/
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(searchbox, searchM, "Search Textbox");
		utilobj.clickByAction(searchlist, selectedValueM);
		wait.until(ExpectedConditions.visibilityOf(serviceName));
		utilobj.clear(serviceName, "Service Name Textbox");
		utilobj.sendKeys(serviceName, serviceNameM, "Service Name Textbox");
		utilobj.selectByValue(displayStatus, displayStatusM, "Display Status Dropdown");
		utilobj.selectByValue(tradeCode, tradeCodeM, "Trade Code Dropdown");
		utilobj.clear(charge, "Charge Textbox");
		utilobj.sendKeys(charge, chargeM, "Charge Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[contains(@id,'ui-id')])[3]//li/div[text()='" + chargeM + "']"))).click();
		utilobj.clear(customer, "Customer Textbox");
		utilobj.sendKeys(customer, customerM, "Customer Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[contains(@id,'ui-id')])[2]//li/div[text()='" + customerM + "']"))).click();
		utilobj.clear(segment, "Segment Textbox");
		utilobj.sendKeys(segment, segmentM, "Segment Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[contains(@id,'ui-id')])[1]//li/div[text()='"+ segmentM + "']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(modiftbtn));
		utilobj.click(modiftbtn, "Modify Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Update Successfully", true);
	}
	
	
	
	// Clear CHA Service Master Page
	public void clearCHAServicePage(String serviceNameC, String displayStatusC, String tradeCodeC, String chargeC, 
			String customerC, String segmentC) throws Exception {
		/*
		Properties pr = utilobj.propertiFile("CHSServiceData.properties");
		String serviceNameC = pr.getProperty("serviceName");
		String displayStatusC = pr.getProperty("displayStatus");
		String tradeCodeC = pr.getProperty("tradeCode");
		String chargeC = pr.getProperty("charge");
		String customerC = pr.getProperty("customer");
		String segmentC = pr.getProperty("segment");
		*/
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(serviceName, serviceNameC, "Service Name Textbox");
		utilobj.selectByValue(displayStatus, displayStatusC, "Display Status Dropdown");
		utilobj.selectByValue(tradeCode, tradeCodeC, "Trade Code Dropdown");
		utilobj.sendKeys(charge, chargeC, "Charge Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[contains(@id,'ui-id')])[3]//li/div[text()='" + chargeC + "']"))).click();
		utilobj.sendKeys(customer, customerC, "Customer Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[contains(@id,'ui-id')])[2]//li/div[text()='" + customerC + "']"))).click();
		utilobj.sendKeys(segment, segmentC, "Segment Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[contains(@id,'ui-id')])[1]//li/div[text()='" + segmentC + "']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(clearbtn));
		utilobj.click(clearbtn, "Clear Button");
	}
	
	

}
