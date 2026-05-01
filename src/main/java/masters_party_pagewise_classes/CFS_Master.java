package masters_party_pagewise_classes;

import java.util.Properties;
import java.util.jar.Attributes.Name;

import javax.lang.model.element.Element;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webutil.WebUtil;

public class CFS_Master {
	
	private WebUtil utilobj;

    public CFS_Master(WebUtil webUtil) {
        this.utilobj = webUtil;
        PageFactory.initElements(webUtil.getDriver(), this);
    }
   
    // Name Field
    @FindBy(id = "txtName")
    private WebElement enterName;

    //Port Code Field
    @FindBy(id = "txtPortCode")
    private WebElement enterPortCode;
    
    //Address Field
    @FindBy(xpath = "//input[@id='txtAddress']")
    private WebElement enterAddress ;

    // Address1Field
    @FindBy(xpath =  "//input[@id='txtAddress1']")
    private WebElement enterAddress1 ;
    

    //Display Status Field
    @FindBy(xpath = "//option[@value='Display']")
    private WebElement selectDisplayStatus;

    
    // Address2 Field
    @FindBy(xpath = "//input[@id='txtAddress2']")
    private WebElement enterAddress2 ; 
    
    
    // City Field
    @FindBy(xpath = "//input[@id='txtCity']")
    private WebElement enterCity ;
    
    
    //State Field
    @FindBy(xpath = "//input[@class='form-control input-sm-EDI input-sm-Auto ui-autocomplete-input']")
//    @FindBy(xpath = "//input[@id='txtState']")
    private WebElement selectState;
    
    
    // Zip Code Field
    @FindBy(xpath =  "//input[@id='txtZipCode']")
    private WebElement enterZipCode ;
    
    
    // Contact Field
    @FindBy(xpath = "//input[@id='txtContact']")
    private WebElement enterContact ; 
    
    
    // Phone Field
    @FindBy(xpath = "//input[@id='txtPhone']")
    private WebElement enterPhone ;
    
    
    // Fax Field
    @FindBy(xpath =  "//input[@id='txtFax']")
    private WebElement enterFax ;
    
    
    // Email Field 
    @FindBy (xpath =  "//input[@id='txtEmail']")
    private WebElement enterEmail ;
    
    
    // PAN Field
    @FindBy(xpath =  "//input[@id='txtPan']")
    private WebElement enterPan ;
    
    
    // EDI Group Code Field
    @FindBy(xpath =  "//input[@id='txtEDIGroupCode']")
    private WebElement enterEDIGroupCode ;
    
    
    // Bond Value Field
    @FindBy (xpath = "//input[@id='txtBondValue']")
    private WebElement enterBondValue ; 
    
    
    // Rail Transhipper Bond Code Field
    @FindBy(xpath = "//input[@id='txtRailTraBondCode']")
    private WebElement  railTranshipperBondCode ;
    
    
    //Transhipper Bond No Field
    @FindBy(xpath = "//input[@id='txtTranshipperBondNo']")
    private WebElement enterTranshipperBondNo ;
    
    
    // Transhipper Bond Code Field
    @FindBy(xpath = "//input[@id='txtTraBondCode']")
    private WebElement enterTranshipperBondCode ;
    
    
    //Road Transhipper Bond Code Field
    @FindBy(xpath = "//input[@id='txtRoadTraBondCode']")
    private WebElement roadTranshipperBondCode ;
    
    
    // Delivery Hours Text Field
    @FindBy(xpath = "//input[@id='txtDeliveryHoursText']")
    private WebElement enterDeliveryHoursText ;
    
    
    // Segment Group Code Field
    @FindBy(xpath =  "//input[@id='txtSegmentGroupCode']")
    private WebElement enterSegmentGroupCode ;

    
    // Save Button Field
    @FindBy(xpath = "(//button[@type='button'])[4]")
    private WebElement enterSaveBtn;


    
    // Send CFS Master Data manually
    public void CFS_Master_Manually() throws Exception   {

        // Name Field Value
    	utilobj.sendKeys(enterName, "CFS Master Testing By Automation 10","Name" );
        Thread.sleep(2000);
        
        // PORT CODE Auto-suggest
        utilobj.selectAutoSuggest(enterPortCode, "CZLOB", "CZLOB"); 
        Thread.sleep(2000);
       
        // Address Filed Value
        utilobj.sendKeys(enterAddress, "D-105", "Address");
        Thread.sleep(2000);
        
        //Address1 Field Value
        utilobj.sendKeys(enterAddress1, "Noida Sector-63", "Address1" );
        Thread.sleep(2000);
        
        // Display Status Value
        utilobj.click(selectDisplayStatus, "Display Status");
        Thread.sleep(2000);
        
        
        // Address2 Field Value
        utilobj.sendKeys(enterAddress2, "Uttar Pradesh", "Address2");
        Thread.sleep(2000);
        
        // City Field Value
        utilobj.sendKeys(enterCity, "Noida", "City"); 
        Thread.sleep(2000);

        // State Field Value
        selectState.click();
        selectState.sendKeys("UTTAR PRADESH"); 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
        selectState.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        
        System.out.println("Selected State: " + selectState.getAttribute("value"));   
        
        // Zip Code Field Value
        utilobj.sendKeys(enterZipCode, "201301", "Zip Code");
        Thread.sleep(2000);
        
        // Contact Field Value
        utilobj.sendKeys(enterContact, "1230456789", "Contact");
        Thread.sleep(2000);
        
        // Phone Field Value
        utilobj.sendKeys(enterPhone, "123-456789", "Phone");
        Thread.sleep(2000);
        
        // Fax Field Value
        utilobj.sendKeys(enterFax, "1234567890", "Fax");
        Thread.sleep(2000);
        
        // Email Field Value
        utilobj.sendKeys(enterEmail, "Test12@gmail.com", "Email");
        Thread.sleep(2000);
        
        // Pan Field Value
        utilobj.sendKeys(enterPan, "ABCDE1234F", "Pan");
        Thread.sleep(2000);
        
        // EDI Group Code Field Value
        utilobj.sendKeys(enterEDIGroupCode, "ABCD12345", "EDI Group Code");
        Thread.sleep(2000);
        
        // Bond Value Field Value
        utilobj.sendKeys(enterBondValue, "12345", "Bond Value");
        Thread.sleep(2000);
        
        // Rail Transhipper Bond Code Field Value
        utilobj.sendKeys(railTranshipperBondCode, "Rail123", "Rail Transhipper Bond Code");
        Thread.sleep(2000);

        
        // Transhipper Bond No Field Value
        utilobj.sendKeys(enterTranshipperBondNo, "123456", "Transhipper Bond No");
        Thread.sleep(2000);
        
        // Transhipper Bond Code Field Value
        utilobj.sendKeys(enterTranshipperBondCode, "XYZ123", "Transhipper Bond Code");
        Thread.sleep(2000);
        
        // Road Transhipper Bond Code
        utilobj.sendKeys(roadTranshipperBondCode, "ABCD1234", "Road Transhipper Bond Code");
        Thread.sleep(2000);
        
        // Delivery Hours Text Field Value
        utilobj.sendKeys(enterDeliveryHoursText, "12", "Delivery Hours Text");
        Thread.sleep(2000);
        
        // Segment Group Code Field Value
        utilobj.sendKeys(enterSegmentGroupCode, "XYZ1235", "Segment Group Code");
        Thread.sleep(2000);
        
        
        // Save button
        utilobj.click(enterSaveBtn, "Save button");
        utilobj.implicitlyWait();
        // Validating Alert
        utilobj.validateAlertMessage("Record Saved successfully.");
      
    }
    
    
    
    // Sending CFS Master Data by using properties file
    public void CFSMasterDataByPropertiesFile() {
    	
		Properties pr = utilobj.propertiFile("CFS_Master_data.properties");
		String name = pr.getProperty("name");
		String PortCode = pr.getProperty("portCode");
		String address = pr.getProperty("address");
		String address1 = pr.getProperty("address1");
		//String displayStatus = pr.getProperty("displayStatus");
		String address2 = pr.getProperty("address2");
		String city = pr.getProperty("city");
		String State = pr.getProperty("state");
		String zipCode = pr.getProperty("zipCode");
		String contact = pr.getProperty("contact");
		String phone =  pr.getProperty("phone");
		String fax = pr.getProperty("fax");
		String email = pr.getProperty("email");
		String panNumber = pr.getProperty("pan");
		String ediGroupCode = pr.getProperty("ediGroupCode");
		String bondValue = pr.getProperty("bondValue");
		String railTranshipperBondCodeValue = pr.getProperty("railTranshipperBondCode");
		String enterTranshipperBondNoValue = pr.getProperty("transhipperBondNo");
		String enterTranshipperBondCodeValue = pr.getProperty("transhipperBondCode");
		String roadTranshipperBondCodeValue = pr.getProperty("roadTranshipperBondCode");
		String enterDeliveryHoursTextValue = pr.getProperty("deliveryHoursText");
		String enterSegmentGroupCodeValue = pr.getProperty("segmentGroupCode");
		
//****************************************************************	
		
		utilobj.clear(enterName, "Name textbox");
		utilobj.sendKeys(enterName, name, "Name");
		//utilobj.sendKeys(enterPortCode, PortCode);
		utilobj.click(enterPortCode, "Port Code");
		utilobj.selectAutoSuggest(enterPortCode, PortCode, PortCode);		
//		enterPortCode.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		utilobj.sendKeys(enterAddress, address, "Address");
		utilobj.sendKeys(enterAddress1, address1, "Address1");	
//		utilobj.sendKeys(selectDisplayStatus, displayStatus);
//		selectDisplayStatus.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);	
		utilobj.sendKeys(enterAddress2, address2, "Address2");
		utilobj.sendKeys(enterCity, city, "City");
		utilobj.selectAutoSuggestUsingKeys(selectState, State);	
		utilobj.sendKeys(enterZipCode, zipCode, "Zip Code");
		utilobj.sendKeys(enterContact, contact, "Contact");
		utilobj.sendKeys(enterPhone, phone, "Phone");
		utilobj.sendKeys(enterFax, fax, "Fax");
		utilobj.sendKeys(enterEmail, email, "Email");
		utilobj.sendKeys(enterPan, panNumber, "Pan Number");
		utilobj.sendKeys(enterEDIGroupCode, ediGroupCode, "EDI Group Code");
		utilobj.sendKeys(enterBondValue, bondValue, "Bond Value");
		utilobj.sendKeys(railTranshipperBondCode, railTranshipperBondCodeValue, "Rail Transhipper Bond Code Value");
		utilobj.sendKeys(enterTranshipperBondNo, enterTranshipperBondNoValue, "Transhipper Bond No Value");
		utilobj.sendKeys(enterTranshipperBondCode, enterTranshipperBondCodeValue, "Transhipper Bond Code Value");
		utilobj.sendKeys(roadTranshipperBondCode, roadTranshipperBondCodeValue, "Transhipper Bond Code Value");
		utilobj.sendKeys(enterDeliveryHoursText, enterDeliveryHoursTextValue, "Delivery Hours Text Value");
		utilobj.sendKeys(enterSegmentGroupCode, enterSegmentGroupCodeValue, "Segment Group Code Value");
		
		
		utilobj.click(enterSaveBtn, "Save button");
		utilobj.implicitlyWait();
        utilobj.validateAlertMessage("Record Saved successfully.");
	
	}
     
    
    
   
    
    // sending CFS Master Data By using DataProvider(Excel)
    public void cfsMasterDataByDataProvider(String name, String portCode, String address, String address1, String address2, String city, String state, String zipcode,
    		String contact, String phone, String fax, String email, String pan, String ediGroupCode, String bondValue) {
    	
    	utilobj.clear(enterName, "Name textox");
		utilobj.sendKeys(enterName, name, "Name textox");
		utilobj.click(enterPortCode, "Port Code");
		utilobj.selectAutoSuggest(enterPortCode, portCode, portCode);
		utilobj.sendKeys(enterAddress, address, "Address textox");
		utilobj.sendKeys(enterAddress1, address1, "Address1 textox");
		utilobj.sendKeys(enterAddress2, address2, "Address2 textox");
		utilobj.sendKeys(enterCity, city, "City textbox");
		utilobj.selectAutoSuggestUsingKeys(selectState, state);
		utilobj.sendKeys(enterZipCode, zipcode, "Zip Code textbox");
		utilobj.sendKeys(enterContact, contact, "Contact textbox");
		utilobj.sendKeys(enterPhone, phone, "Phone textbox");
		utilobj.sendKeys(enterFax, fax, "Fax textbox");
		utilobj.sendKeys(enterEmail, email, "Email textbox");
		utilobj.sendKeys(enterPan, pan, "PAN textbox");
		utilobj.sendKeys(enterEDIGroupCode, ediGroupCode, "EDI Group Code textbox");
		utilobj.sendKeys(enterBondValue, bondValue, "Bond Value textbox");

		utilobj.click(enterSaveBtn, "Save button");
		utilobj.implicitlyWait();
		utilobj.validateAlertMessage("Record Saved successfully.");
    	
    }
	

}
