package masterPartyPageClasses;

import java.time.Duration;
import java.util.Properties;
import java.util.jar.Attributes.Name;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webutil.WebUtil;

public class CFSMasterPage {
	
	private WebUtil utilobj;

    public CFSMasterPage(WebUtil webUtil) {
        this.utilobj = webUtil;
        PageFactory.initElements(webUtil.getDriver(), this);
    }
   
    // Name Field
    @FindBy(id = "txtName")
    private WebElement name;

    //Port Code Field
    @FindBy(xpath = "//input[@id='txtPortCode']")
    private WebElement portCode;
    
    //Address Field
    @FindBy(xpath = "//input[@id='txtAddress']")
    private WebElement address ;

    // Address1Field
    @FindBy(xpath =  "//input[@id='txtAddress1']")
    private WebElement address1 ;
    

    //Display Status Field
    @FindBy(xpath = "//option[@value='Display']")
    private WebElement displayStatus;

    
    // Address2 Field
    @FindBy(xpath = "//input[@id='txtAddress2']")
    private WebElement address2 ; 
    
    
    // City Field
    @FindBy(xpath = "//input[@id='txtCity']")
    private WebElement city ;
    
    
    //State Field
    @FindBy(xpath = "//input[@id='txtState']")
    private WebElement state;
    
    
    // Zip Code Field
    @FindBy(xpath =  "//input[@id='txtZipCode']")
    private WebElement zipCode ;
    
    
    // Contact Field
    @FindBy(xpath = "//input[@id='txtContact']")
    private WebElement contact ; 
    
    
    // Phone Field
    @FindBy(xpath = "//input[@id='txtPhone']")
    private WebElement phone ;
    
    
    // Fax Field
    @FindBy(xpath =  "//input[@id='txtFax']")
    private WebElement fax ;
    
    
    // Email Field 
    @FindBy (xpath =  "//input[@id='txtEmail']")
    private WebElement email ;
    
    
    // PAN Field
    @FindBy(xpath =  "//input[@id='txtPan']")
    private WebElement pan ;
    
    
    // EDI Group Code Field
    @FindBy(xpath =  "//input[@id='txtEDIGroupCode']")
    private WebElement eDIGroupCode ;
    
    
    // Bond Value Field
    @FindBy (xpath = "//input[@id='txtBondValue']")
    private WebElement bondValue ; 
    
    
    // Rail Transhipper Bond Code Field
    @FindBy(xpath = "//input[@id='txtRailTraBondCode']")
    private WebElement  railTranshipperBondCode ;
    
    
    //Transhipper Bond No Field
    @FindBy(xpath = "//input[@id='txtTranshipperBondNo']")
    private WebElement transhipperBondNo ;
    
    
    // Transhipper Bond Code Field
    @FindBy(xpath = "//input[@id='txtTraBondCode']")
    private WebElement transhipperBondCode ;
    
    
    //Road Transhipper Bond Code Field
    @FindBy(xpath = "//input[@id='txtRoadTraBondCode']")
    private WebElement roadTranshipperBondCode ;
    
    
    // Delivery Hours Text Field
    @FindBy(xpath = "//input[@id='txtDeliveryHoursText']")
    private WebElement deliveryHoursText ;
    
    
    // Segment Group Code Field
    @FindBy(xpath =  "//input[@id='txtSegmentGroupCode']")
    private WebElement segmentGroupCode ;

    
    // Save Button Field
    @FindBy(xpath = "(//button[@type='button'])[4]")
    private WebElement saveBtn;
    
    
    // Modify button
    @FindBy(xpath = "//button[@id='btnModify']")
    WebElement modifybtn ;
    
    
    // Clear Button
    @FindBy(xpath = "//button[@id='btnClear']")
    WebElement clearbtn ;
    
    
    // Search textbox
    @FindBy(xpath = "//input[@id='txtCFSSearch']")
    WebElement searchbox ;
    
    
    // Search Grid Result
    @FindBy(xpath = "(//img[@src='../../CSImages/accept.png'])[1]")
    WebElement searchresultrecord ;
    
    
    // CFS Master Grid Record 
    @FindBy(xpath = "((//div[@class='x-grid3-scroller'])[2]/div/div/table/tbody/tr/td)[1]/div/img")
    WebElement cfsGridRecord ;
    


    
    // Send CFS Master Data manually
    public void CFS_Master_Manually() throws Exception   {
    	utilobj.sendKeys(name, "CFS Master Testing By Automation 10","Name Textbox" );
        Thread.sleep(1000);
        utilobj.sendKeys(portCode, "ZAZDV", "Port Code Textbox");
        utilobj.getDriver().findElement(By.xpath("((//ul[contains(@id,'ui-id-')])[2]/li)/div[text()='ZAZDV']")).click();	
        Thread.sleep(1000);      
        utilobj.sendKeys(address, "D-105", "Address Textbox");
        Thread.sleep(1000); 
        utilobj.sendKeys(address1, "Noida Sector-63", "Address1 Textbox" );
        Thread.sleep(1000);        
        utilobj.click(displayStatus, "Display Status Dropdown");
        Thread.sleep(1000);           
        utilobj.sendKeys(address2, "Uttar Pradesh", "Address2 Textbox");
        Thread.sleep(1000);     
        utilobj.sendKeys(city, "Noida", "City Textbox"); 
        Thread.sleep(1000);
        utilobj.sendKeys(state, "Uttar Pradesh", "State Textbox");
        utilobj.getDriver().findElement(By.xpath("((//ul[contains(@id,'ui-id-')])[1]/li)/div[text()='Uttar Pradesh']")).click();
        Thread.sleep(1000);
        utilobj.sendKeys(zipCode, "201301", "Zip Code Textbox");
        Thread.sleep(1000);
        utilobj.sendKeys(contact, "1230456789", "Contact Textbox");
        Thread.sleep(1000);
        utilobj.sendKeys(phone, "123-456789", "Phone Textbox");
        Thread.sleep(1000);
        utilobj.sendKeys(fax, "1234567890", "Fax Textbox");
        Thread.sleep(1000);
        utilobj.sendKeys(email, "Test12@gmail.com", "Email Textbox");
        Thread.sleep(1000);
        utilobj.sendKeys(pan, "ABCDE1234F", "Pan Textbox");
        Thread.sleep(1000);
        utilobj.sendKeys(eDIGroupCode, "ABCD12345", "EDI Group Code Textbox");
        Thread.sleep(1000);
        utilobj.sendKeys(bondValue, "12345", "Bond Value Textbox");
        Thread.sleep(1000);
        utilobj.sendKeys(railTranshipperBondCode, "Rail123", "Rail Transhipper Bond Code Textbox");
        Thread.sleep(1000);       
        utilobj.sendKeys(transhipperBondNo, "123456", "Transhipper Bond No Textbox");
        Thread.sleep(1000);     
        utilobj.sendKeys(transhipperBondCode, "XYZ123", "Transhipper Bond Code Textbox");
        Thread.sleep(1000);      
        utilobj.sendKeys(roadTranshipperBondCode, "ABCD1234", "Road Transhipper Bond Code Textbox");
        Thread.sleep(1000);
        utilobj.sendKeys(deliveryHoursText, "12", "Delivery Hours Text");
        Thread.sleep(1000);
        utilobj.sendKeys(segmentGroupCode, "XYZ1235", "Segment Group Code Textbox");
        Thread.sleep(1000);       
        // Save button
 //       utilobj.click(saveBtn, "Save Button");
  //      utilobj.implicitlyWait();
        // Validating Alert
 //       utilobj.validateAlertMessage1("Record Saved successfully.", true);
    }
    
    
    
    // Sending CFS Master Data by using properties file
    public void CFSMasterDataPropertiesFile() throws Exception {
   
		Properties pr = utilobj.propertiFile("CFSMasterData.properties");
		String nameP = pr.getProperty("name");
		String portCodeP = pr.getProperty("portCode");
		String addressP = pr.getProperty("address");
		String address1P = pr.getProperty("address1");
		//String displayStatus = pr.getProperty("displayStatus");
		String address2P = pr.getProperty("address2");
		String cityP = pr.getProperty("city");
		String stateP = pr.getProperty("state");
		String zipCodeP = pr.getProperty("zipCode");
		String contactP = pr.getProperty("contact");
		String phoneP =  pr.getProperty("phone");
		String faxP = pr.getProperty("fax");
		String emailP = pr.getProperty("email");
		String panNumberP = pr.getProperty("pan");
		String ediGroupCodeP = pr.getProperty("ediGroupCode");
		String bondValueP = pr.getProperty("bondValue");
		String railTranshipperBondCodeValueP = pr.getProperty("railTranshipperBondCode");
		String transhipperBondNoValueP = pr.getProperty("transhipperBondNo");
		String transhipperBondCodeValueP = pr.getProperty("transhipperBondCode");
		String roadTranshipperBondCodeValueP = pr.getProperty("roadTranshipperBondCode");
		String deliveryHoursTextValueP = pr.getProperty("deliveryHoursText");
		String segmentGroupCodeValueP = pr.getProperty("segmentGroupCode");
		
//****************************************************************	
		
		utilobj.clear(name, "Name Textbox");
		utilobj.sendKeys(name, nameP, "Name Textbox");
		utilobj.click(portCode, "Port Code Textbox");
		utilobj.sendKeys(portCode, portCodeP, "Port Code Textbox");	
		utilobj.getDriver().findElement(By.xpath("((//ul[contains(@id,'ui-id-')])[2]/li)/div[text()='"+portCodeP+"']")).click();
		utilobj.sendKeys(address, addressP, "Address Textbox");
		utilobj.sendKeys(address1, address1P, "Address1 Textbox");		
		utilobj.sendKeys(address2, address2P, "Address2 Textbox");
		utilobj.sendKeys(city, cityP, "City Textbox");
		utilobj.sendKeys(state, stateP, "State Textbox");
		utilobj.getDriver().findElement(By.xpath("((//ul[contains(@id,'ui-id-')])[1]/li)/div[text()='"+stateP+"']")).click();
		utilobj.sendKeys(zipCode, zipCodeP, "Zip Code Textbox");
		utilobj.sendKeys(contact, contactP, "Contact Textbox");
		utilobj.sendKeys(phone, phoneP, "Phone Textbox");
		utilobj.sendKeys(fax, faxP, "Fax Textbox");
		utilobj.sendKeys(email, emailP, "Email Textbox");
		utilobj.sendKeys(pan, panNumberP, "Pan Number Textbox");
		utilobj.sendKeys(eDIGroupCode, ediGroupCodeP, "EDI Group Code Textbox");
		utilobj.sendKeys(bondValue, bondValueP, "Bond Value Textbox");
		utilobj.sendKeys(railTranshipperBondCode, railTranshipperBondCodeValueP, "Rail Transhipper Bond Code Textbox");
		utilobj.sendKeys(transhipperBondNo, transhipperBondNoValueP, "Transhipper Bond No Textbox");
		utilobj.sendKeys(transhipperBondCode, transhipperBondCodeValueP, "Transhipper Bond Code Textbox");
		utilobj.sendKeys(roadTranshipperBondCode, roadTranshipperBondCodeValueP, "Transhipper Bond Code Textbox");
		utilobj.sendKeys(deliveryHoursText, deliveryHoursTextValueP, "Delivery Hours Text Textbox");
		utilobj.sendKeys(segmentGroupCode, segmentGroupCodeValueP, "Segment Group Code Textbox");

		
//		utilobj.click(saveBtn, "Save Button");
//		Thread.sleep(1000);
//		utilobj.implicitlyWait();
//        utilobj.validateAlertMessage1("Record Saved successfully.", true);
	}
     
    
    
   
    // sending CFS Master (Single & Multiple Record) Data By using DataProvider(Excel)
    public void createCFSMasterPage(String nameN, String portCodeN, String addressN, String cityN, String stateN, String contactN, 
    		String emailN, String panN) throws Exception {
 
    	WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
    	utilobj.sendKeys(name, nameN, "Name Textbox");
    	utilobj.sendKeys(portCode, portCodeN, "Port Code Textbox");
    	wait.until(ExpectedConditions.elementToBeClickable(
    			By.xpath("((//ul[contains(@id,'ui-id-')])[2]/li)/div[text()='" + portCodeN + "']"))).click();
    	utilobj.sendKeys(address, addressN, "Address Textbox");
    	utilobj.sendKeys(city, cityN, "City Textbox");
    	utilobj.sendKeys(state, stateN, "State Textbox");
    	wait.until(ExpectedConditions.elementToBeClickable(
    			By.xpath("((//ul[contains(@id,'ui-id-')])[1]/li)/div[text()='" + stateN + "']"))).click();
    	utilobj.sendKeys(contact, contactN, "Contact Textbox");
    	utilobj.sendKeys(email, emailN, "Email Textbox");
    	utilobj.sendKeys(pan, panN, "PAN Textbox");
    	wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
    	utilobj.click(saveBtn, "Save Button");
    	wait.until(ExpectedConditions.alertIsPresent());
    	utilobj.validateAlertMessage1("Record Saved successfully.", true);   	
    }
	
   
    
    
    // Modify CFS Master Record
    public void modifyCFSMasterPage(String searchM, String searchGridRecordM, String nameM, String portCodeM, String addressM, String cityM, 
    		String stateM, String contactM, String emailM, String panM) throws Exception {
    
    	WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
    	utilobj.sendKeys(searchbox, searchM, "Search Textbox");
    	utilobj.clickByAction(searchresultrecord, searchGridRecordM);
    	utilobj.validateTextValue(searchM, searchGridRecordM);
    	wait.until(ExpectedConditions.elementToBeClickable(cfsGridRecord));
    	utilobj.click(cfsGridRecord, "CFS Master Grid Record");
    	wait.until(ExpectedConditions.visibilityOf(name));
    	utilobj.clear(name, "Name Textbox");
    	utilobj.sendKeys(name, nameM, "Name Textbox");
    	utilobj.clear(portCode, "Port Code Textbox");
    	utilobj.sendKeys(portCode, portCodeM, "Port Code Textbox");
    	wait.until(ExpectedConditions.elementToBeClickable(
    			By.xpath("((//ul[contains(@id,'ui-id-')])[2]/li)/div[text()='" + portCodeM + "']"))).click();
    	
    	utilobj.clear(address, "Address Textbox");
    	utilobj.sendKeys(address, addressM, "Address Textbox");
    	utilobj.clear(city, "City Textbox");
    	utilobj.sendKeys(city, cityM, "City Textbox");
    	utilobj.clear(state, "State Textbox");
    	utilobj.sendKeys(state, stateM, "State Textbox");
    	wait.until(ExpectedConditions.elementToBeClickable(
    			By.xpath("((//ul[contains(@id,'ui-id-')])[1]/li)/div[text()='" + stateM + "']"))).click();

    	wait.until(ExpectedConditions.elementToBeClickable(modifybtn));
    	utilobj.click(modifybtn, "Modify Button");
    	wait.until(ExpectedConditions.alertIsPresent());
    	utilobj.validateAlertMessage1("Record Modified Successfully.", true);
    }
    
    
    
 // CFS Master Page Clear 
    public void cleasrCFSMasterPage(String nameC, String portCodeC, String addressC, String cityC, String stateC, String contactC,
    		String emailC, String panC) throws Exception {
    	
    	WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
    	utilobj.sendKeys(name, nameC, "Name Textbox");
    	utilobj.sendKeys(portCode, portCodeC, "Port Code Textbox");
    	wait.until(ExpectedConditions.elementToBeClickable(
    			By.xpath("((//ul[contains(@id,'ui-id-')])[2]/li)/div[text()='" + portCodeC + "']"))).click();
    	utilobj.sendKeys(address, addressC, "Address Textbox");
    	utilobj.sendKeys(city, cityC, "City Textbox");
    	utilobj.sendKeys(state, stateC, "State Textbox");
    	wait.until(ExpectedConditions.elementToBeClickable(
    			By.xpath("((//ul[contains(@id,'ui-id-')])[1]/li)/div[text()='" + stateC + "']"))).click();
    	utilobj.sendKeys(contact, contactC, "Contact Textbox");
    	wait.until(ExpectedConditions.elementToBeClickable(clearbtn));
    	utilobj.click(clearbtn, "Clear Button");			
	}
    
    
    

}
