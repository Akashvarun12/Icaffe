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
    @FindBy(xpath = "//input[@id='txtState']")
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
    public void save_CFS_Master() throws Exception   {

        // Name Field Value
    	utilobj.sendKeys(enterName, "CFS Master Testing By Automation");
        Thread.sleep(2000);
        
        // PORT CODE Auto-suggest
        utilobj.selectAutoSuggest(enterPortCode, "CZLOB", "CZLOB"); 
        Thread.sleep(2000);
       
        // Address Filed Value
        utilobj.sendKeys(enterAddress, "D-105");
        Thread.sleep(2000);
        
        //Address1 Field Value
        utilobj.sendKeys(enterAddress1, "Noida Sector-63");
        Thread.sleep(2000);
        
        // Display Status Value
        utilobj.click(selectDisplayStatus);
        Thread.sleep(2000);
        
        
        // Address2 Field Value
        utilobj.sendKeys(enterAddress2, "Uttar Pradesh");
        Thread.sleep(2000);
        
        // City Field Value
        utilobj.sendKeys(enterCity, "Noida"); 
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
        utilobj.sendKeys(enterZipCode, "201301");
        Thread.sleep(2000);
        
        // Contact Field Value
        utilobj.sendKeys(enterContact, "1230456789");
        Thread.sleep(2000);
        
        // Phone Field Value
        utilobj.sendKeys(enterPhone, "123-456789");
        Thread.sleep(2000);
        
        // Fax Field Value
        utilobj.sendKeys(enterFax, "1234567890");
        Thread.sleep(2000);
        
        // Email Field Value
        utilobj.sendKeys(enterEmail, "Test12@gmail.com");
        Thread.sleep(2000);
        
        // Pan Field Value
        utilobj.sendKeys(enterPan, "ABCDE1234F");
        Thread.sleep(2000);
        
        // EDI Group Code Field Value
        utilobj.sendKeys(enterEDIGroupCode, "ABCD12345");
        Thread.sleep(2000);
        
        // Bond Value Field Value
        utilobj.sendKeys(enterBondValue, "12345");
        Thread.sleep(2000);
        
        // Rail Transhipper Bond Code Field Value
        utilobj.sendKeys(railTranshipperBondCode, "Rail123");
        Thread.sleep(2000);

        
        // Transhipper Bond No Field Value
        utilobj.sendKeys(enterTranshipperBondNo, "123456");
        Thread.sleep(2000);
        
        // Transhipper Bond Code Field Value
        utilobj.sendKeys(enterTranshipperBondCode, "XYZ123");
        Thread.sleep(2000);
        
        // Road Transhipper Bond Code
        utilobj.sendKeys(roadTranshipperBondCode, "ABCD1234");
        Thread.sleep(2000);
        
        // Delivery Hours Text Field Value
        utilobj.sendKeys(enterDeliveryHoursText, "12");
        Thread.sleep(2000);
        
        // Segment Group Code Field Value
        utilobj.sendKeys(enterSegmentGroupCode, "XYZ1235");
        Thread.sleep(2000);
        
        
        // Save button
        utilobj.click(enterSaveBtn);
        utilobj.close();
        Thread.sleep(20000);
      
    }
    
    
    /*
    // Sending CFS Master Data by using properties file
    public void enterCFSMasterDataByPropertiesFile() {
		Properties pr = utilobj.propertiFile("CFS_Master_data.properties");
		String name = pr.getProperty("name");
		String PortCode = pr.getProperty("portCode");
		String address = pr.getProperty("address");
		String address1 = pr.getProperty("address1");
		//String displayStatus = pr.getProperty("displayStatus");
		String address2 = pr.getProperty("address2");
		String city = pr.getProperty("city");
		String state = pr.getProperty("state");
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
		
		utilobj.clear(enterName);
		utilobj.sendKeys(enterName, name);
		//utilobj.sendKeys(enterPortCode, PortCode);
		utilobj.click(enterPortCode);
		utilobj.selectAutoSuggest(enterPortCode, PortCode, PortCode);
		
//		enterPortCode.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	
		
		
		utilobj.sendKeys(enterAddress, address);
		utilobj.sendKeys(enterAddress1, address1);
		
		
		
		
//		utilobj.sendKeys(selectDisplayStatus, displayStatus);
//		selectDisplayStatus.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		
		utilobj.sendKeys(enterAddress2, address2);
		utilobj.sendKeys(enterCity, city);
		
		
//		utilobj.sendKeys(selectState, selectStateValue);
		utilobj.click(selectState);
		utilobj.selectAutoSuggest(selectState, state, state);
		selectState.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);		
		
		
		utilobj.sendKeys(enterZipCode, zipCode);
		utilobj.sendKeys(enterContact, contact);
		utilobj.sendKeys(enterPhone, phone);
		utilobj.sendKeys(enterFax, fax);
		utilobj.sendKeys(enterEmail, email);
		utilobj.sendKeys(enterPan, panNumber);
		utilobj.sendKeys(enterEDIGroupCode, ediGroupCode);
		utilobj.sendKeys(enterBondValue, bondValue);
		utilobj.sendKeys(railTranshipperBondCode, railTranshipperBondCodeValue);
		utilobj.sendKeys(enterTranshipperBondNo, enterTranshipperBondNoValue);
		utilobj.sendKeys(enterTranshipperBondCode, enterTranshipperBondCodeValue);
		utilobj.sendKeys(roadTranshipperBondCode, roadTranshipperBondCodeValue);
		utilobj.sendKeys(enterDeliveryHoursText, enterDeliveryHoursTextValue);
		utilobj.sendKeys(enterSegmentGroupCode, enterSegmentGroupCodeValue);
		
		
		utilobj.click(enterSaveBtn);
		utilobj.implicitlyWait();
	
	}
     */
   
    
    
    
    // sending CFS Master Data By using DataProvider(Excel)
   
    public void cfsMasterDataByDataProvider(String name, String portCode) {
    	utilobj.clear(enterName);
		utilobj.sendKeys(enterName, name);
		utilobj.click(enterPortCode);
		utilobj.selectAutoSuggest(enterPortCode, portCode, portCode);
		
		
		
		utilobj.click(enterSaveBtn);
		utilobj.implicitlyWait();
    	
    }
	

}
