package regionalMasterPageClass;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webutil.WebUtil;

public class RegionMasterPage {
	
	private WebUtil utilobj ;
	
	public RegionMasterPage(WebUtil utilobj ) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	
	// Name Textbox
	@FindBy(xpath = "//input[@id='txtName']")
	WebElement name ;
	
	
	// Region/Sector Incharge Autosuggest Textbox
	@FindBy(xpath = "//input[@id='txtRegion']")
	WebElement region ;
	
	
	// Display Status Dropdown
	@FindBy(xpath = "//select[@id='ddlLOVStatus']")
	WebElement displayStatus ;
	
	
	// Note Textbox
	@FindBy(xpath = "//textarea[@id='txtNote']")
	WebElement note ;
	
	// Save Button
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement savebtn ;
	
	
	// Modify Button
	@FindBy(xpath = "//button[@id='btnModify']")
	WebElement modifybtn ;
	
	
	// Clear Button
	@FindBy(xpath = "//button[@id='btnClear']")
	WebElement clearbtn ;
	
	
	// Search textbox
	@FindBy(xpath = "//input[@id='txtUnitSearch']")
	WebElement searchBox ;
	
	
	// Search Grid Result(First)
	@FindBy(xpath = "(//img[@src='../../CSImages/accept.png'])[1]")
	WebElement searchGridResult ;
	
	

	
	// Create Region Master Record
	public void createRegionMasterPage(String nameC, String regionC, String displayStatusC, String noteC) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(name, nameC, "Name Textbox");
		utilobj.sendKeys(region, regionC, "Region Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@id, 'ui-id-')]/li/div[text()='" + regionC + "']"))).click();
		utilobj.selectByVisibleText(displayStatus, displayStatusC, "Display Status Dropdown");
		utilobj.sendKeys(note, noteC, "Note Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(savebtn));
		utilobj.clickByAction(savebtn, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Saved successfully.", true);
	}
	
	
	
	// Modify Region Master Record
	public void modifyRegionMasterPage(String search, String searchResultM, String nameM, String regionM, String displayStatusM, String noteM) {
		/*
		Properties pr = utilobj.propertiFile("RegionMasterData.properties");
		String search = pr.getProperty("search");
		String searchResultM =  pr.getProperty("searchresultM");
		String nameM = pr.getProperty("nameM");
		String regionM = pr.getProperty("regionM");
		String displayStatusM = pr.getProperty("displaystatusM");
		String noteM = pr.getProperty("noteM");
		*/
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(searchBox, search, "Search Textbox");
		utilobj.clickByAction(searchGridResult, searchResultM);
		wait.until(ExpectedConditions.visibilityOf(name));
		utilobj.clear(name, "Name Textbox");
		utilobj.sendKeys(name, nameM, "Name Textbox");
		utilobj.clear(region, "Region Textbox");
		utilobj.sendKeys(region, regionM, "Region Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@id, 'ui-id-')]/li/div[text()='" + regionM + "']"))).click();
		utilobj.selectByValue(displayStatus, displayStatusM, "Display Status Dropdown");
		utilobj.clear(note, "Note Textbox");
		utilobj.sendKeys(note, noteM, "Note Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(modifybtn));
		utilobj.click(modifybtn, "Modify Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Modified Successfully.", true);			
	}
	
	
	
	// Clear Region Master Page
	public void clearRegionMasterPage(String search, String searchResultM, String nameC, String regionC, String displayStatusC, String noteC) {	
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(searchBox, search, "Search Textbox");
		utilobj.clickByAction(searchGridResult, searchResultM);
		wait.until(ExpectedConditions.elementToBeClickable(clearbtn));
		utilobj.clickByAction(clearbtn, "Clear Button");
	}
		
		
		
		
		
		/*
		// Modify Region Master Record using TestNG XML parameters
		public void modifyRegionMasterPage(String search, String searchResultM, String nameM, String regionM, String displayStatusM, String noteM) throws Exception {
		    utilobj.sendKeys(searchBox, search, "Search Textbox");
		    utilobj.clickByAction(searchGridResult, searchResultM);
		    utilobj.clear(name, "Name Textbox");
		    utilobj.sendKeys(name, nameM, "Name Textbox");
		    utilobj.clear(region, "Region Textbox");
		    utilobj.sendKeys(region, regionM, "Region Textbox");
		    utilobj.getDriver().findElement(By.xpath("//ul[contains(@id,'ui-id-')]/li/div[text()='" + regionM + "']")).click();
		    utilobj.selectByValue(displayStatus, displayStatusM, "Display Status Dropdown");
		    utilobj.clear(note, "Note Textbox");
		    utilobj.sendKeys(note, noteM, "Note Textbox");
		    utilobj.click(modifybtn, "Modify Button");
		    Thread.sleep(1000);
		    utilobj.validateAlertMessage1("Record Modified Successfully.", true);
		}
		*/
   

	

}
