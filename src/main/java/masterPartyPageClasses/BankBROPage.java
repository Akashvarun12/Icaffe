package masterPartyPageClasses;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import webutil.WebUtil;

public class BankBROPage {
	
	private WebUtil utilobj ;
	
	// Constructor
	public BankBROPage(WebUtil webUtil) {
        this.utilobj = webUtil;
        PageFactory.initElements(webUtil.getDriver(), this);
    }
	
	// Bank Name Textbox
	@FindBy(xpath = "//input[@name='Contactperson']")
	 WebElement bankName ;
	
	// Default Address Checkbox
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement defaultAddress ;	
	
	// Contact Person
	@FindBy(xpath = "//input[@name='ContactPerson']")
	WebElement contactPerson ;	
	
	// Branch Name Textbox
	@FindBy(xpath = "//input[@name='BranchName']")
	 WebElement branchName ;	
	
	// Address 1 
	@FindBy(xpath = "//input[@name='Address1']")
	WebElement address1 ;
	
	// Address 2
	@FindBy(xpath = "//input[@name='Address2']")
	WebElement address2 ;
	
	// City
	@FindBy(xpath = "//input[@name='City']")
	WebElement city ;
	
	// State
	@FindBy(xpath = "//input[@name='State']")
	WebElement state ;
	
	// Country
	@FindBy(xpath = "//input[@name='Country']")
	WebElement country ;
	
	// Pin Code 
	@FindBy(xpath = "//input[@name='Pin']")
	WebElement pincode ;
	
	
	// Phone textbox
	@FindBy(xpath = "//input[@name='Phone']")
	WebElement phone ;
	
	
	// Mobile textbox
	@FindBy(xpath = "//input[@name='Mobile']")
	WebElement mobile ;
	
	
	// fax textbox
	@FindBy(xpath = "//input[@id='txtFax1']")
	WebElement fax ;
	
	
	//  Email1 textbox
	@FindBy(xpath = "//input[@name='Email1']")
	WebElement email1 ;
	
	
	//Email2 textbox
	@FindBy(xpath = "//input[@name='Email2']")
	WebElement email2 ;
	
	
	// Website textbox
	@FindBy(xpath = "//input[@name='Website']")
	WebElement website ;
	
	
	// Add Button
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-plus']")
	WebElement addButton ;
	
	
	
	// Save button
	@FindBy(xpath = "(//span[@class='glyphicon glyphicon-save-file'])[1]")
	WebElement saveButton ;
	
	
	// Modify Button
	@FindBy(xpath = "(//span[@class='glyphicon glyphicon-save-file'])[2]")
	WebElement modifybtn ;
	
	
	// Clear button
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-refresh']")
	WebElement clearbtn ;
	
	
	// Search Textbox
	@FindBy(xpath = "//input[@id='txtBankNameSearch']")
	WebElement searchbox ;
	
	
	// Search Result value selection from list
	@FindBy(xpath = "(//img[@src='../../CSImages/accept.png'])[1]")
	WebElement searchresult ;
	

	
//	// Grid Value Selection	
//	public void clickAnyGridValue() {  		
//		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(15)); 
//		// wait for search dropdown to disappear
//		wait.until(ExpectedConditions.invisibilityOfElementLocated( By.xpath("//ul[contains(@class,'ui-autocomplete')]")));
//		// now fetch only visible elements  
//		List<WebElement> elements = wait.until(       
//				ExpectedConditions.visibilityOfAllElementsLocatedBy(     
//						By.xpath("//img[@src='../../CSImages/accept.png']")
//						)
//		    );		    
//		if (!elements.isEmpty()) {		        
//			//  usually grid appears AFTER search list → so take LAST element		       
//			WebElement element = elements.get(elements.size() - 1);		       
////			wait.until(ExpectedConditions.elementToBeClickable(element)).click();		       
//			element.click();		       
//			System.out.println("Clicked grid value");		    
//		} else {		        
//			throw new RuntimeException("No grid values found");		    
//		}
//	}
//	
//	
//	public boolean isAddressGridPresent() {
//	    try {
//	        // Find all visible accept icons
//	        List<WebElement> gridElements = utilobj.getDriver().findElements(
//	                By.xpath("//img[@src='../../CSImages/accept.png']")
//	        );
//	        return gridElements.size() > 1;
//	    } catch (Exception e) {
//	        return false;
//	    }
//	}
	
	
	// Grid Value Selection
	public boolean clickAnyGridValue() {
	    try {
	        WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(15));

	        // Wait for search dropdown to disappear
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(
	                By.xpath("//ul[contains(@class,'ui-autocomplete')]")));

	        // Get all accept icons (search result + possible grid icons)
	        List<WebElement> elements = wait.until(
	                ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                        By.xpath("//img[@src='../../CSImages/accept.png']")));

	        int totalSize = elements.size();
	        int gridIndex = totalSize - 1;

	        System.out.println("Total accept icons found: " + totalSize);

	        // Verify that actual grid row is present
	        List<WebElement> gridRows = utilobj.getDriver().findElements(
	                By.xpath("(((//div[@class='x-grid3-scroller'])[2]//div)[1]/div/table/tbody/tr/td)[1]/div")
	        );

	        if (gridIndex > 0 && !gridRows.isEmpty()) {

	            // Click the last accept icon, which belongs to the grid
	            WebElement gridElement = elements.get(gridIndex);

	            wait.until(ExpectedConditions.elementToBeClickable(gridElement));
	            gridElement.click();

	            System.out.println("Clicked successfully on grid value");
	            return true;
	        } else {
	            System.out.println("Grid row is not available");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Unable to click grid value: " + e.getMessage());
	        return false;
	    }
	}
	
	/*	
	// Send Data Manually in the Bank BRO page.
	public void send_BankBRO_Data_Manually() {
		utilobj.sendKeys(bankName, "Test Bank Name By SST", "Bank Name");
		utilobj.sendKeys(branchName, "SST Branch Name", "Branch Name");
		utilobj.click(addButton, "Ok button");
		utilobj.click(saveButton, "Save button");
		utilobj.validateAlertMessage1("Bank Details saved successfully", true);
		utilobj.implicitlyWait();	
	}
	*/
	
	/*
	// Send Data By Properties File in the Bank BRO Page
	public void send_BankBRO_Data_PropertiesFile() {
		Properties propertiesfile =  utilobj.propertiFile("Shivam_Bank_BRO_Data.properties");
		String bankNamep =  propertiesfile.getProperty("bankName");
		String branchNamep =  propertiesfile.getProperty("branchName");
		
		utilobj.sendKeys(bankName, bankNamep, "Bank Name");
		utilobj.sendKeys(branchName, branchNamep, "Branch Name");
		utilobj.click(addButton, "OK button");
		utilobj.click(saveButton, "Save button");
		utilobj.validateAlertMessage1("Bank Details saved successfully", true);
		utilobj.implicitlyWait();			
	}
	*/
	
	
	// Create Bank BRO Record
	public void createBankBROPage(String bankNameN, String branchNameN, String cityN, String stateN, String countryN) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(bankName, bankNameN, "Bank Name Textbox");
		utilobj.click(defaultAddress, "Default Address");
		utilobj.sendKeys(branchName, branchNameN, "Branch Name Textbox");
		utilobj.sendKeys(city, cityN, "City Textbox");
		utilobj.sendKeys(state, stateN, "State Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//ul[contains(@class,'ui-autocomplete')]//div[text()='" + stateN + "']"))).click();
		utilobj.sendKeys(country, countryN, "Country Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//ul[contains(@id, 'ui-id-2')]//li/div[text()='" + countryN + "']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		utilobj.click(addButton, "Add Button");
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		utilobj.click(saveButton, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Bank Details saved successfully", true);
	}
	
	
	
	
	 // Bank BRO Duplicate Record Validation
		public void duplicateBankBROPage(String bankNameD, String branchNameD, String cityD, String stateD, String countryD) throws Exception {
			
			WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
			utilobj.sendKeys(bankName, bankNameD, "Bank Name Textbox");
			utilobj.click(defaultAddress, "Default Address");
			utilobj.sendKeys(branchName, branchNameD, "Branch Name Textbox");
			utilobj.sendKeys(city, cityD, "City Textbox");
			utilobj.sendKeys(state, stateD, "State Textbox");
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//ul[contains(@class,'ui-autocomplete')]//div[text()='" + stateD + "']"))).click();
			utilobj.sendKeys(country, countryD, "Country Textbox");
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//ul[contains(@id, 'ui-id-2')]//li/div[text()='" + countryD + "']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(addButton));
			utilobj.click(addButton, "Add Button");
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			utilobj.click(saveButton, "Save Button");
			wait.until(ExpectedConditions.alertIsPresent());
			utilobj.validateAlertMessage1("Name Already Exist", true);
		}
	
	
	
	
	
	// Bank BRO Record Modification
	public void modifyBankBROPage(String searchM, String searchValueM, String bankNameM, String branchNameM, String cityM, String stateM, String countryM) throws Exception {
	    /*
		Properties pr = utilobj.propertiFile("BankBROData.properties");
	    String searchM = pr.getProperty("search");
	    String searchValueM = pr.getProperty("searchlistValue");
	    String banknameM = pr.getProperty("banknameM");
	    String branchnameM = pr.getProperty("branchNameM");
	    */
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(searchbox, searchM, "Search Box");
		utilobj.clickByAction(searchresult, searchValueM);
		utilobj.validateTextValue(searchM, searchValueM);
		if (clickAnyGridValue()) {
			wait.until(ExpectedConditions.visibilityOf(bankName));
			System.out.println("Address grid found.. Modifying Address Details");
			utilobj.clear(bankName, "Bank Name Textbox");
			utilobj.sendKeys(bankName, bankNameM, "Bank Name Textbox");
			utilobj.clear(city, "City Textbox");
			utilobj.sendKeys(city, cityM, "City Textbox");
			utilobj.clear(state, "State Textbox");
			utilobj.sendKeys(state, stateM, "State Textbox");
			WebElement stateDropdown = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//ul[contains(@class,'ui-autocomplete')]//div[text()='" + stateM + "']")));
			stateDropdown.click();		
			wait.until(ExpectedConditions.elementToBeClickable(addButton));
			utilobj.click(addButton, "Add Button");
		} else {
			wait.until(ExpectedConditions.visibilityOf(bankName));
			System.out.println("No address grid found. Modifying only Bank Name");
			utilobj.clear(bankName, "Bank Name");
			utilobj.sendKeys(bankName, bankNameM, "Bank Name Textbox");
		}		
		wait.until(ExpectedConditions.elementToBeClickable(modifybtn));
		utilobj.click(modifybtn, "Modify Button");	
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Data modified successfully.", true);
	}
	
	
	
	// Bank BRO Page Clear
	public void clearBankBROPage(String bankNameC, String branchNameC, String cityC, String stateC, String countryC) throws Exception {
		/*
		Properties propertiesfile =  utilobj.propertiFile("BankBROData.properties");
		String bankNamep =  propertiesfile.getProperty("bankName");
		String branchNamep =  propertiesfile.getProperty("branchName");
		*/
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		utilobj.sendKeys(bankName, bankNameC, "Bank Name Textbox");
		utilobj.click(defaultAddress, "Default Address");
		utilobj.sendKeys(branchName, branchNameC, "Branch Name Textbox");
		utilobj.sendKeys(city, cityC, "City Textbox");
		utilobj.sendKeys(state, stateC, "State Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//ul[contains(@class,'ui-autocomplete')]//div[text()='"+ stateC + "']"))).click();
		utilobj.sendKeys(country, countryC, "Country Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//ul[contains(@id, 'ui-id-2')]//li/div[text()='" + countryC + "']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		utilobj.click(addButton, "Add Button");
		wait.until(ExpectedConditions.elementToBeClickable(clearbtn));
		utilobj.click(clearbtn, "Clear Button");
	}
	
	
	
	
}
