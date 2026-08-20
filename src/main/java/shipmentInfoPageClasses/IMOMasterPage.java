package shipmentInfoPageClasses;

import java.util.List;
import java.util.Properties;

import javax.xml.xpath.XPath;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import java.time.Duration;


import webutil.WebUtil;

public class IMOMasterPage {
	
	private WebUtil utilobj ;
	
	// Constructor
	public IMOMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	
	// Name textbox
	@FindBy(xpath = "//input[@id='txtName']")
	WebElement name ;
	
	
	// Display Status
	@FindBy (xpath =  "//select[@id='txtLovStatus']")
	WebElement displayStatus ;
	
	
	// Notes Textbox
	@FindBy(xpath = "//textarea[@id='txtNotes']")
	WebElement notes ;
	
	//Save button
	@FindBy(xpath = "(//span[@class='glyphicon glyphicon-save-file'])[1]")
	WebElement savebutton ;


	// Search Textbox
	@FindBy(xpath = "//input[@id='txtIMOSearch']")
	WebElement search ;
	
	
	// Search Value 
	@FindBy(xpath = "(//img[@src='../../CSImages/accept.png'])")
	WebElement searchValue ;
	
	
	// grid Value
	@FindBy(xpath = "(((//div[@class='x-grid3-scroller'])[2]//div)[1]/div/table/tbody/tr/td)[1]/div/img")
	WebElement imoMasterGridRecord ;
	
	
	// Grid Value Selection
//	public void clickAnyGridValue() {
//	    WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(15));
//	    // wait for search dropdown to disappear
//	    wait.until(ExpectedConditions.invisibilityOfElementLocated( By.xpath("//ul[contains(@class,'ui-autocomplete')]")));
//	    // now fetch only visible elements
//	    List<WebElement> elements = wait.until(
//	            ExpectedConditions.visibilityOfAllElementsLocatedBy(
//	                   By.xpath("//img[@src='../../CSImages/accept.png']")
//	            )
//	    );
//	    if (!elements.isEmpty()) {
//	        //  usually grid appears AFTER search list → so take LAST element
//	        WebElement element = elements.get(elements.size() - 1);
//	        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
//	        element.click();
//	        System.out.println("Clicked grid value");
//	    } else {
//	        throw new RuntimeException("No grid values found");
//	    }
//	}
	
	
	// Modify Button
	@FindBy(xpath = "//button[@id='btnModify']")
	WebElement modifybtn ;
	
	
	// Delete button
	@FindBy(xpath = "(//span[@class='glyphicon glyphicon-save-file'])[3]")
	WebElement deletebtn ;
	
	
	// Clear button
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-refresh']")
	WebElement clear ;
	
	
	
	// Creating new IMO Master Record
	public void createNewIMOMasterRecord(String nameS, String displayStatusS) throws Exception {
		/*
		Properties pr = utilobj.propertiFile("IMOMasterData.properties");
		String nameS = pr.getProperty("name");
		String displayStatusS = pr.getProperty("displaystatus");
		String notesS =  pr.getProperty("notes");
		*/
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(name, nameS, "Name Textbox");
		utilobj.selectByValue(displayStatus, displayStatusS, "Display Status Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(savebutton));
		utilobj.click(savebutton, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Saved successfully.", true);
	}
		
	
	
	// Modifying IMO Master Record
	public void modifyIMOMasterRecord(String searchM, String searchValueM, String nameM, String displayStatusM) throws Exception {
		/*
		Properties pr = utilobj.propertiFile("IMOMasterData.properties");
		String searchM = pr.getProperty("searchM");
		String searchValueM =   pr.getProperty("searchValueM");
		String NotesModifyValueM = pr.getProperty("notesM");
		*/		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(search, searchM, "Search Textbox");
		utilobj.clickByAction(searchValue, searchValueM);
		utilobj.validateTextValue(searchM, searchValueM);
		wait.until(ExpectedConditions.elementToBeClickable(imoMasterGridRecord));
		utilobj.click(imoMasterGridRecord, "IMO Master Grid Record");
		wait.until(ExpectedConditions.visibilityOf(name));
		utilobj.clear(name, "Name Textbox");
		utilobj.sendKeys(name, nameM, "Name Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(modifybtn));
		utilobj.click(modifybtn, "Modify Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Modified Successfully.", true);						
	}
		
	
	
	// Deleting IMO Master Page
	public void deleteIMOMasterRecord(String searchD, String searchValueD, String nameD, String displayStatusD) throws Exception {
		/*
		Properties pr = utilobj.propertiFile("IMOMasterData.properties");
		String searchD = pr.getProperty("searchM");
		String searchValueD =   pr.getProperty("searchValueM");
		*/	
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.clear(search, "Search Box");
		utilobj.sendKeys(search, searchD, "Search Textbox");
		utilobj.clickByAction(searchValue, searchValueD);
		utilobj.validateTextValue(searchD, searchValueD);
		wait.until(ExpectedConditions.elementToBeClickable(imoMasterGridRecord));
		utilobj.click(imoMasterGridRecord, "IMO Master Grid Record");
		wait.until(ExpectedConditions.elementToBeClickable(deletebtn));
		utilobj.click(deletebtn, "Delete Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Are you sure you want to delete this record?", false);
		wait.until(ExpectedConditions.elementToBeClickable(deletebtn));
		utilobj.click(deletebtn, "Delete Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Are you sure you want to delete this record?", true);
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record deleted successfully.", true);
	}
		
		
	
	// Clearing IMO Master Page
	public void clearIMOMasterPage(String nameC, String displayStatusC) throws Exception {
		/*
		Properties pr = utilobj.propertiFile("Shivam_IMO_Master.properties");
		String nameC = pr.getProperty("name");
		String notesC = pr.getProperty("notes");
		*/
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.clear(name, "Name Textbox");
		utilobj.sendKeys(name, nameC, "Name Textbox");
		utilobj.selectByValue(displayStatus, displayStatusC, "Display Status Dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(clear));
		utilobj.click(clear, "Clear Button");	
	}
	

		
		
}		
	


