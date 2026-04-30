package masters_party_pagewise_classes;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import webutil.WebUtil;

public class BankBRO_Page {
	
	private WebUtil utilobj ;
	
	// Constructor
	public BankBRO_Page(WebUtil webUtil) {
        this.utilobj = webUtil;
        PageFactory.initElements(webUtil.getDriver(), this);
    }
	
	
	// Bank Name Textbox
	@FindBy(xpath = "//input[@name='Contactperson']")
	 WebElement bankName ;
	
	
	// Branch Name Textbox
	@FindBy(xpath = "//input[@name='BranchName']")
	 WebElement branchName ;
	
	
	// Add Button
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-plus']")
	WebElement addButton ;
	
	
	
	// Save button
	@FindBy(xpath = "(//span[@class='glyphicon glyphicon-save-file'])[1]")
	WebElement saveButton ;
	
	
	
	
	// Send Data Manually in the Bank BRO page.
	public void send_BankBRO_Data_Manually() {
		utilobj.sendKeys(bankName, "Test Bank Name By SST", "Bank Name");
		utilobj.sendKeys(branchName, "SST Branch Name", "Branch Name");
		utilobj.click(addButton, "Ok button");
		utilobj.click(saveButton, "Save button");
		utilobj.validateAlertMessage("Bank Details saved successfully");
		utilobj.implicitlyWait();	
	}
	
	
	// Send Data By Properties File in the Bank BRO Page
	public void send_BankBRO_Data_PropertiesFile() {
		Properties propertiesfile =  utilobj.propertiFile("Bank_BRO_Data.properties");
		String bankNamep =  propertiesfile.getProperty("bankName");
		String branchNamep =  propertiesfile.getProperty("branchName");
		
		utilobj.sendKeys(bankName, bankNamep, "Bank Name");
		utilobj.sendKeys(branchName, branchNamep, "Branch Name");
		utilobj.click(addButton, "OK button");
		utilobj.click(saveButton, "Save button");
		utilobj.validateAlertMessage("Bank Details saved successfully");
		utilobj.implicitlyWait();
			
	}
	
	
	// Send Data By using DataProvider (Excel File) in the Bank BRO Page
	public void send_BankBRO_Data_Excel(String bankNameE, String branchNameE) {
		
		utilobj.sendKeys(bankName, bankNameE, "Bank Name");
		utilobj.sendKeys(branchName, branchNameE, "Branch Name");
		utilobj.click(addButton, "OK button");
		utilobj.click(saveButton, "Save button");
			
		utilobj.validateAlertMessage("Bank Details saved successfully");
		utilobj.implicitlyWait();
		
	}
			
	
	
}
