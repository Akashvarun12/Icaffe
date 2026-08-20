package pricingMasterPageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webutil.WebUtil;

public class CostRevenueMasterPage {
	
	WebUtil utilobj ;
	
	public CostRevenueMasterPage(WebUtil utilobj) {
		this.utilobj = utilobj ;
		PageFactory.initElements(utilobj.getDriver(), this);
	}
	
	
	// Charge Type Dropdown
	@FindBy(xpath = "//select[@id='ddlChargeType']")
	WebElement chargeType ;
	
	// For Carrier Textbox
	@FindBy(xpath = "//input[@id='txtShipline']")
	WebElement forCarrier ;
	
	//Destination Textbox
	@FindBy(xpath = "//input[@id='txtDestination']")
	WebElement destination ;
	
	//Origin Textbox
	@FindBy(xpath = "//input[@id='txtChargeOrigin']")
	WebElement origin ;
	
	// Segment Textbox
	@FindBy(xpath = "//input[@id='txtSeg']")
	WebElement segment ;
	
	// Unit Textbox
	@FindBy(xpath = "//input[@id='txtUnit']")
	WebElement unit ;
	
	// Amount Per Unit Textbox
	@FindBy(xpath = "//input[@id='txtAmountPerUnit']")
	WebElement amountPerUnit ;
	
	// Basis Dropdown
	@FindBy(xpath = "//select[@id='ddlBasis']")
	WebElement basis ;
	
	// Add Button
	@FindBy(xpath = "//button[@id='btnInsertCharge']")
	WebElement addBtn ;
	
	// Save Button
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement saveBtn ;
	
	// Clear Button
	@FindBy(xpath = "//button[@id='btnClear']")
	WebElement clearBtn ;
	
	// Search Textbox
	@FindBy(xpath = "//input[@id='txtSeaSearch']")
	WebElement searchBox ;
	
	// Search Grid Record
	@FindBy(xpath = "(((//div[@class='x-grid3-scroller'])[1]/div/div)[1]/table/tbody/tr/td)[1]/div/img")
	WebElement searchGridRecord ;
	
	// Page Grid Record
	
 
}
