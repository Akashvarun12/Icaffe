package regionalMasterPageClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webutil.WebUtil;

public class FFPortMasterPage {
	
	WebUtil utilobj ;
	
	public FFPortMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);	
	}
	
	
	// Country Textbox
	@FindBy(xpath = "//input[@id='txtCountry']")
	WebElement country ;
	
	// Port Code Textbox
	@FindBy(xpath = "//input[@id='txtPortCode']")
	WebElement portCode ;
	
	// Port Name Textbox
	@FindBy(xpath = "//input[@id='txtPortName']")
	WebElement portName ;
	
	// Search Country Textbox 
	@FindBy(xpath = "//input[@id='txtSeaSearch']")
	WebElement selectCountry ;
	
	// Select Port Name
	@FindBy(xpath = "//input[@id='txtSearchPortName']")
	WebElement selectPortName ;
	
	// Search Grid Record
	@FindBy(xpath = "((//div[@class='x-grid3-scroller'])[1]/div/div/table/tbody/tr/td)[1]/div/img")
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
	
	
	
	
	// Create FF Port Master Record
	public void createFFPortMasterPage(String countryN, String portCodeN, String portNameN) {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(country));
		utilobj.sendKeys(country, countryN, "Country Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[contains(@id,'ui-id')])[1]/li/div[text()='"+countryN+"']"))).click();
		utilobj.sendKeys(portCode, portCodeN, "Port Code Textbox");
		utilobj.sendKeys(portName, portNameN, "Port Name Textbox");
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		utilobj.click(saveBtn, "Save Button");
		wait.until(ExpectedConditions.alertIsPresent());
		utilobj.validateAlertMessage1("Record Saved successfully.", true);
	}
	
	
	
	// Duplicate FF Port Master Record
		public void duplicateFFPortMasterPage(String countryN, String portCodeN, String portNameN) {
			
			WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(country));
			utilobj.sendKeys(country, countryN, "Country Textbox");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[contains(@id,'ui-id')])[1]/li/div[text()='"+countryN+"']"))).click();
			utilobj.sendKeys(portCode, portCodeN, "Port Code Textbox");
			utilobj.sendKeys(portName, portNameN, "Port Name Textbox");
			wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
			utilobj.click(saveBtn, "Save Button");
			wait.until(ExpectedConditions.alertIsPresent());
			utilobj.validateAlertMessage1("This Port code has already been used.", true);
		}
	

	

	
	// Modify FF Port Master Record
	public void modifyFFPortMasterPage(String selectCountryM, String selectPortNameM, String countryM, String portCodeM, String portNameM) throws Exception {
	    
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(selectCountry));
	    utilobj.sendKeys(selectCountry, selectCountryM, "Select Country Textbox");
	    utilobj.getDriver().findElement(By.xpath("((//ul[contains(@id, 'ui-id')])[2]/li)/div[text()='" + selectCountryM + "']")).click();
	    wait.until(ExpectedConditions.visibilityOf(selectPortName));
	    utilobj.sendKeys(selectPortName, selectPortNameM, "Select Port Name Textbox");
	    utilobj.getDriver().findElement(By.xpath("(//ul[contains(@id, 'ui-id-')])[3]/li/div[text()='"+selectPortNameM+"']")).click();    
	    // Waiting for page grid reload	
	    Thread.sleep(2000);		
	    // Select Record From Grid
	    By gridRowBy = By.xpath("((//div[@class='x-grid3-scroller'])[2]/div/div/table/tbody/tr/td)[1]/div/img");
	    WebElement gridRow = wait.until(ExpectedConditions.visibilityOfElementLocated(gridRowBy));
	    Actions act = new Actions(utilobj.getDriver());
	    act.doubleClick(gridRow).perform();	  
	    wait.until(ExpectedConditions.attributeToBeNotEmpty(portName, "value"));
	    utilobj.clear(portName, "Port Name Textbox");
	    utilobj.sendKeys(portName, portNameM, "Port Name Textbox");
	    wait.until(ExpectedConditions.elementToBeClickable(modifyBtn));
	    utilobj.click(modifyBtn, "Modify Button");
	    wait.until(ExpectedConditions.alertIsPresent());
	    utilobj.validateAlertMessage1("Record Modified Successfully.", true);
	}
	
	
	
	// FF Port Master Page Clear
	public void clearFFPortMasterPage(String selectCountryC, String selectPortNameC, String countryC, String portCodeC, String portNameC) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(selectCountry));
	    utilobj.sendKeys(selectCountry, selectCountryC, "Select Country Textbox");
	    utilobj.getDriver().findElement(By.xpath("((//ul[contains(@id, 'ui-id')])[2]/li)/div[text()='" +selectCountryC+ "']")).click();
	    wait.until(ExpectedConditions.visibilityOf(selectPortName));
	    utilobj.sendKeys(selectPortName, selectPortNameC, "Select Port Name Textbox");
	    utilobj.getDriver().findElement(By.xpath("(//ul[contains(@id, 'ui-id-')])[3]/li/div[text()='"+selectPortNameC+"']")).click();    
	    // Waiting for page grid reload	
	    Thread.sleep(2000);		
	    // Select Record From Grid
	    By gridRowBy = By.xpath("((//div[@class='x-grid3-scroller'])[2]/div/div/table/tbody/tr/td)[1]/div/img");
	    WebElement gridRow = wait.until(ExpectedConditions.visibilityOfElementLocated(gridRowBy));
	    Actions act = new Actions(utilobj.getDriver());
	    act.doubleClick(gridRow).perform();
	    wait.until(ExpectedConditions.elementToBeClickable(clearBtn));
	    utilobj.click(clearBtn, "Clear Button");
	}
	
	
	
	

}
