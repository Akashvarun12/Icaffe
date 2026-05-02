package masters_party_pagewise_classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webutil.WebUtil;

public class Exporter {

	
	private WebUtil utilobj;

	public Exporter(WebUtil utilobj) {
		this.utilobj = utilobj;
		PageFactory.initElements(utilobj.getDriver(), this);

	}
	
	@FindBy(xpath="//input[@name='ShipperName']")
	WebElement shipperName;
	
	@FindBy(xpath="//input[@name='IecNumber']")
	WebElement IecNumber;
	
	@FindBy(xpath="//select[@ID='txtClass']")
	WebElement classField;
	
	@FindBy(xpath="//select[@ID='txtClass']//option[text()='Private']")
	WebElement dropDownClass;
	
	@FindBy(xpath="//select[@name='MercManuf']")
	WebElement mercManuf;
	
	@FindBy(xpath="//select[@name='MercManuf']//option[text='Merchant']")
	WebElement dropDownOption_MercManuf;
	
	
	
	public void enterShipperDetailsMandatoryFields() {
		
		utilobj.sendKeys(shipperName, "Test1", "Shipper Name Textbox");
		utilobj.sendKeys(IecNumber, "9987654321", "IEC No Textbox");
		utilobj.click(classField, "Class");
		utilobj.selectDropDownByText(dropDownClass,"Private option");
		utilobj.click(mercManuf, "Merc/Manuf Dropdown Field");
		utilobj.selectDropDownByText(dropDownOption_MercManuf,"Merchant option");
	}
	
	
	
}
