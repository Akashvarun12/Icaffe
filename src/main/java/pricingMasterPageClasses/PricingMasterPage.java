package pricingMasterPageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webutil.WebUtil;


public class PricingMasterPage {
	
	WebUtil utilobj ;
	
	public PricingMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	
	// Origin Country Textbox
	@FindBy(xpath = "//input[@id='txtOriginCountry']")
	WebElement originCountry ;
	
	// Origin Port Textbox
	@FindBy(xpath = "//input[@id='txtOriginSeaport']")
	WebElement originPort ;
	
	// Destination Country 
	@FindBy(xpath = "//input[@id='txtDestinationCountry']")
	WebElement destinationCountry ;
	
	// Destination Port 
	@FindBy(xpath = "//input[@id='txtDestinationSeaport']")
	WebElement destinationPort ;
	
	// Charge Name Textbox
	@FindBy(xpath = "//input[@id='txtOriginChargeName']")
	WebElement chargeName ;
	
	// Unit Textbox
	@FindBy(xpath = "//input[@id='txtOriginUnit']")
	WebElement unit ;
	
	// Currency Textbox
	@FindBy(xpath = "//input[@id='txtOriginCurrency']")
	WebElement currency ;
	
	// From Date Textbox
	@FindBy(xpath = "//input[@id='txtOriginFromDate']")
	WebElement fromDate ;
	
	// To Date Textbox
	@FindBy(xpath = "//input[@id='txtOriginToDate']")
	WebElement toDate ;
	
	// Effective Date Textbox
	@FindBy(xpath = "//input[@id='txtOriginEffectiveDate']")
	WebElement effectiveDate ;
	
	// Add Button
	@FindBy(xpath = "(//button[@type='button'])[6]")
	WebElement addBtn ;
	
	// Save Button
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement saveBtn ;
	
	// First Clear Button
	@FindBy(xpath = "//button[@id='btnHeaderClear']")
	WebElement firstClearBtn ;
	
	// Second Clear Button
	@FindBy(xpath = "//button[@id='btnClear']")
	WebElement secondClearBtn ;
	
	
	
	// Create New Pricing Record 
	public void createPricingPage(String originCountryN, String originPortN, String destinationCountryN, String destinationPortN, String chargeNameN,
			String unitN, String currencyN, String fromDateN, String toDateN, String effectiveDateN) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(originCountry));
		utilobj.sendKeys(originCountry, originCountryN, "Origin Country Textbox");
		utilobj.getDriver().findElement(By.xpath("((//ul[contains(@id, 'ui-id-')])[2]/li)/div[text()='"+originCountryN+"']")).click();
		wait.until(ExpectedConditions.visibilityOf(originPort));
		utilobj.sendKeys(originPort, originPortN, "Origin Port Textbox");
		utilobj.getDriver().findElement(By.xpath("((//ul[contains(@id, 'ui-id-')])[4]/li)/div[text()='"+originPortN+"']")).click();
		wait.until(ExpectedConditions.visibilityOf(destinationCountry));
		utilobj.sendKeys(destinationCountry, destinationCountryN, "Destination Country Textbox");
		utilobj.getDriver().findElement(By.xpath("((//ul[contains(@id, 'ui-id-')])[3]/li)/div[text()='"+destinationCountryN+"']")).click();
		wait.until(ExpectedConditions.visibilityOf(destinationPort));
		utilobj.sendKeys(destinationPort, destinationPortN, "Destination Port Textbox");
		utilobj.getDriver().findElement(By.xpath("((//ul[contains(@id, 'ui-id-')])[5]/li)/div[text()='"+destinationPortN+"']")).click();
		wait.until(ExpectedConditions.visibilityOf(chargeName));
		utilobj.sendKeys(chargeName, chargeNameN, "Charge Name Textbox");
		utilobj.getDriver().findElement(By.xpath("(//ul[contains(@id, 'ui-id-')])[8]/li/div[text()='"+chargeNameN+"']")).click();
		wait.until(ExpectedConditions.visibilityOf(unit));
		utilobj.sendKeys(unit, unitN, "Unit textbox");
		utilobj.getDriver().findElement(By.xpath("(//ul[contains(@id, 'ui-id-')])[11]/li/div[text()='"+unitN+"']")).click();
		wait.until(ExpectedConditions.visibilityOf(currency));
		utilobj.sendKeys(currency, currencyN, "Currency Textbox");
		utilobj.getDriver().findElement(By.xpath("//ul[contains(@id, 'ui-id-')][1]/li/div[text()='"+currencyN+"']")).click();
		wait.until(ExpectedConditions.visibilityOf(fromDate));
		utilobj.selectDate(fromDate, fromDateN, "From Data Textbox");
		wait.until(ExpectedConditions.visibilityOf(toDate));
		utilobj.selectDate(toDate, toDateN, "To Date Textbox");
		wait.until(ExpectedConditions.visibilityOf(effectiveDate));
		utilobj.selectDate(effectiveDate, effectiveDateN, "Effective Date Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		utilobj.click(addBtn, "Add Button");
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		utilobj.click(saveBtn, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Saved successfully.", true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
