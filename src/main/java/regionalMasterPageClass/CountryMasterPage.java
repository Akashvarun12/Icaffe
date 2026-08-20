package regionalMasterPageClass;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webutil.WebUtil;


public class CountryMasterPage {

	WebUtil utilobj ;
	
	public CountryMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);	
	}
	
	// Country Code Textbox
	@FindBy(xpath = "//input[@id='txtCode']")
	WebElement countryCode ;
	
	// Country Name Textbox
	@FindBy(xpath = "//input[@id='txtName']")
	WebElement countryName ;
	
	// Display Status Dropdown
	@FindBy(xpath = "//select[@id='txtLovStatus']")
	WebElement displayStatus ;
	
	// Search Textbox
	@FindBy(xpath = "//input[@id='txtListCountryName']")
	WebElement searchBox ;
	
	//  Search Grid Record
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
	
	// Delete Button
	@FindBy(xpath = "//button[@id='btnDelete']")
	WebElement deleteBtn ;
	
	// Clear Button
	@FindBy(xpath = "//button[@id='btnClear']")
	WebElement clearBtn ;
	
	
	
	
	
	// Country Record Creation
	public void createCountryMasterPage(String countryCodeN, String countryNameN, String displayStatusN) {
		
		try {
			WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
			utilobj.sendKeys(countryCode, countryCodeN, "Country Code Textbox");
			countryName.click();
			try {
				Alert alert = wait.until(ExpectedConditions.alertIsPresent());
				String alertMsg = alert.getText();
				if (alertMsg.contains("Country Code already exists")) {
					System.out.println("Duplicate Country Code Found");
					alert.accept();
					wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
					utilobj.clear(countryCode, "Country Code Textbox");
					utilobj.sendKeys(countryCode, "XZ", "Country Code Textbox");
					countryName.click();
				}
			} catch (Exception e) {
				System.out.println("No Country Code Alert Present");
			}
			// Enter Country Name
			utilobj.sendKeys(countryName, countryNameN, "Country Name Textbox");
			displayStatus.click();
			try {
				Alert alert = wait.until(ExpectedConditions.alertIsPresent());
				String alertMsg = alert.getText();
				if (alertMsg.contains("Country Name already exists")) {
					System.out.println("Duplicate Country Name Found");
					alert.accept();
					wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
					utilobj.clear(countryName, "Country Name Textbox");
					utilobj.sendKeys(countryName, "Pendora", "Country Name Textbox");
				}
			} catch (Exception e) {
				System.out.println("No Country Name Alert Present");
			}
			utilobj.selectByValue(displayStatus, displayStatusN, "Display Status Dropdown");
			wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
			utilobj.click(saveBtn, "Save Button");
			wait.until(ExpectedConditions.alertIsPresent());
			utilobj.validateAlertMessage1("Record Saved successfully.", true);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	
	
	// Country Record Modification
	public void modifyCountryMasterPage(String searchM, String searchGridRecordM, String countryCodeM, String countryNameM, String displayStatusM) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10)) ;
		utilobj.sendKeys(searchBox, searchM, "Search Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordM);
		wait.until(ExpectedConditions.elementToBeClickable(pageGridRecord));
		utilobj.click(pageGridRecord, "Page Grid Record");
		wait.until(ExpectedConditions.visibilityOf(displayStatus));
		utilobj.selectByValue(displayStatus, displayStatusM, "Display Status Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(modifyBtn));
		utilobj.click(modifyBtn, "Modify Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record update successfully.", true);		
	}
	
	
	
	
	// Country Record Deletion
	public void deleteCountryMasterPage(String searchD, String searchGridRecordD, String countryCodeD, String countryNameD, String displayStatusD) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(searchBox, searchD, "Search Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordD);
		wait.until(ExpectedConditions.elementToBeClickable(pageGridRecord));
		utilobj.click(pageGridRecord, "Page Grid Record");
		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
		utilobj.click(deleteBtn, "Delete Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Are you sure! Do you want to delete this record?", true);
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Country deleted successfully.", true);
	}
	
	
	
	// Country Master Page Clear
	public void clearCountryMasterPage(String searchC, String searchGridRecordC, String countryCodeC, String countryNameC, String displayStatusC) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(searchBox, searchC, "Search Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(searchGridRecord));
		utilobj.clickByAction(searchGridRecord, searchGridRecordC);
		wait.until(ExpectedConditions.elementToBeClickable(pageGridRecord));
		utilobj.click(pageGridRecord, "Page Grid Record");
		wait.until(ExpectedConditions.elementToBeClickable(clearBtn));
		utilobj.click(clearBtn, "Clear Button");	
	}
	
	
	
	
	
}
