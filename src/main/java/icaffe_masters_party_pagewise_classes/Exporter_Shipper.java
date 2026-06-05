package icaffe_masters_party_pagewise_classes;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class Exporter_Shipper {

	private WebUtil utilobj;

	public Exporter_Shipper(WebUtil utilobj) {
		this.utilobj = utilobj;
		PageFactory.initElements(utilobj.getDriver(), this);

	}

	@FindBy(xpath = "//input[@name='ShipperName']")
	WebElement shipperName;

	@FindBy(xpath = "//input[@name='IecNumber']")
	WebElement IecNumber;

	@FindBy(xpath = "//select[@id='txtClass']")
	WebElement selectDropDown_ClassOption;

	@FindBy(xpath = "//select[@name='MercManuf']")
	WebElement selectDropDown_MercManufOption;

	@FindBy(xpath = "//input[@name='SerialNumber ']")
	WebElement serialNumber;

	@FindBy(xpath = "//input[@name='Address1']")
	WebElement address;

	@FindBys(@FindBy(xpath = "//ul[@id='ui-id-2']//li"))
	List<WebElement> listOfCountrytext;

	@FindBy(xpath = "//input[@placeholder='Country']")
	WebElement clikOnCountry;

	@FindBy(xpath = "//ul[@id='ui-id-1']//li")
	List<WebElement> listOfStatetext;

	@FindBy(xpath = "//input[@placeholder='State']")
	WebElement clickState;

	@FindBy(xpath = "//select[@name='GSTStateName']")
	WebElement selectCtxState;

	@FindBy(xpath = "//input[@name='GSTNumber']")
	WebElement selectGSTNumber;

	@FindBy(xpath = "//button[@onclick='InsertAddress();']")
	WebElement clickOnAddBT;

	@FindBy(xpath = "//button[@id='btnAdd']")
	WebElement clickOnSaveBT;

	@FindBy(xpath = "//a[@id='ext-gen24']")
	WebElement otherTab;

	@FindBy(xpath = "//select[@id='ddlQueryClassType']")
	WebElement selectDropDown_ClassOptionInSearchField;

	@FindBy(xpath = "//select[@id='ddlSearchType']")
	WebElement search_WithShipperName_or_ID;

	@FindBy(xpath = "//input[@id='txtListShipperName']")
	WebElement enter_Name_or_ID;

	@FindBy(xpath = "//img[@src='../../CSImages/edit.png']")
	WebElement clickEditIconOnPrtyAddressGrid;

	@FindBy(xpath = "//button[@id='btnModify']")
	WebElement clickOnModifyButton;

	@FindBy(xpath = "//button[@id='btnDelete']")
	WebElement clickOnDeleteBT;
	
	@FindBy(xpath = "//button[@id='btnClear']")
	WebElement clickOnClearBT;

	// Enter Mandatory details in shipper details section
	public void enterShipperDetailsMandatoryFields(String partyName, String IECNumber, String classDropDownOption,
			String mercManufDropDownOption) {
		utilobj.clear(shipperName, "Shipper Name Textbox");
		utilobj.sendKeys(shipperName, partyName, "Shipper Name Textbox");
		utilobj.clear(IecNumber, "IEC No Textbox");
		utilobj.sendKeys(IecNumber, IECNumber, "IEC No Textbox");
		utilobj.selectDropDownByText(selectDropDown_ClassOption, classDropDownOption);
		utilobj.selectDropDownByText(selectDropDown_MercManufOption, mercManufDropDownOption);

	}

	// Modify Mandatory details in shipper details section
	public void modifyShipperDetailsMandatoryFields(String partyName, String IECNumber, 
			String classDropDownOption,String mercManufDropDownOption) {
		utilobj.clear(shipperName, "Shipper Name Textbox");
		utilobj.sendKeys(shipperName, partyName, "Shipper Name Textbox");
		utilobj.clear(IecNumber, "IEC No Textbox");
		utilobj.sendKeys(IecNumber, IECNumber, "IEC No Textbox");
		utilobj.selectDropDownByText(selectDropDown_ClassOption, classDropDownOption);
		utilobj.selectDropDownByText(selectDropDown_MercManufOption, mercManufDropDownOption);

	}

	// Enter Mandatory details in shipper address section
	public void enterShipperAddressMandatoryFields(String partySerialNumber, String partyAddress, String entCountry,
			String expSelCountry, String entState, String expSelState, String GSTNumber, String ctxState) {
		utilobj.clear(serialNumber, "serial Number Textbox");
		utilobj.sendKeys(serialNumber, partySerialNumber, "serial Number Textbox");
		utilobj.clear(address, "address Textbox");
		utilobj.sendKeys(address, partyAddress, "address Textbox");
		utilobj.clear(clikOnCountry, " Country");
		utilobj.selectAutoSuggestOption(listOfCountrytext, clikOnCountry, entCountry, "Country Textbox",
				expSelCountry);
		utilobj.clear(clickState, "State");
		utilobj.selectAutoSuggestOption(listOfStatetext, clickState, entState, "State Textbox", expSelState);
		utilobj.selectDropDownByText(selectCtxState, ctxState);
		utilobj.clear(selectGSTNumber, "GST Number Textbox");
		utilobj.sendKeys(selectGSTNumber, GSTNumber, "GST Number Textbox");

	}

	// Modify Mandatory details in shipper address section
	public void modifyShipperAddressMandatoryFields(String partyAddress, String entState, String expSelState,
			String GSTNumber, String ctxState) {

		utilobj.clear(address, "address Textbox");
		utilobj.sendKeys(address, partyAddress, "address Textbox");

		utilobj.clear(clickState, "State");
		utilobj.selectAutoSuggestOption(listOfStatetext, clickState, entState, "State Textbox", expSelState);
		utilobj.selectDropDownByText(selectCtxState, ctxState);
		utilobj.clear(selectGSTNumber, "GST Number Textbox");
		utilobj.sendKeys(selectGSTNumber, GSTNumber, "GST Number Textbox");

	}

	// Select created shipper party in search grid
	public void selectSearchShipperParty(ITestContext context, String selectclassDropDownOption_InSearch,
			String selectname_or_ID_InSearch) {

		utilobj.selectDropDownByText(selectDropDown_ClassOptionInSearchField, selectclassDropDownOption_InSearch);
		utilobj.selectDropDownByText(search_WithShipperName_or_ID, selectname_or_ID_InSearch);

	}

	// Log or Print all created shipper Name and Status from Search Grid
	public void logShipperPartySearchTableData() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		utilobj.printTableData();

	}


	// Modify shipper party mandatory details partially
	public void modifyShipperPartyWithPartialData(ITestContext context, String selectclassDropDownOption_InSearch,
			String selectname_or_ID_InSearch, String selectpartyName_InSearchGrid, String partyName, String IECNumber,
			String classDropDownOption, String mercManufDropDownOption,  String partyAddress,
			 String entState, String expSelState, String GSTNumber,
			String ctxState) {

		selectSearchShipperParty(context, selectclassDropDownOption_InSearch, selectname_or_ID_InSearch);

		utilobj.selectOptionFromSearch("Search Grid", selectpartyName_InSearchGrid);
		modifyShipperDetailsMandatoryFields(partyName, IECNumber,classDropDownOption, mercManufDropDownOption);
		clickOnPartyAddressGrid();
		modifyShipperAddressMandatoryFields( partyAddress,  entState,
				expSelState,  ctxState,GSTNumber);

	}

	// Deleting shipper party
	public void deleteShipperParty(ITestContext context, String selectclassDropDownOption_InSearch,
			String selectname_or_ID_InSearch, String selectpartyName_InSearchGrid) {
		selectSearchShipperParty(context, selectclassDropDownOption_InSearch, selectname_or_ID_InSearch);
		utilobj.selectOptionFromSearch("Search Grid", selectpartyName_InSearchGrid);
		utilobj.scrollByAction(clickOnDeleteBT);

	}

	// Click on Add Button
	public void clickOnAddButton() {
		utilobj.click(clickOnAddBT, "Add Button");

	}

	// Click on Party Address Grid Edit Icon
	public void clickOnPartyAddressGrid() {
		utilobj.click(clickEditIconOnPrtyAddressGrid, "Grid Edit Button");

	}

	// Click on Modify Button
	public void clickOnModifyButton() {
		utilobj.click(clickOnModifyButton, "Modify Button");
		utilobj.explicitlyWait(clickOnModifyButton);

	}

	// Click on Delete Button
	public void clickOnDeleteButton() {
		utilobj.click(clickOnDeleteBT, "Delete Button");

	}

	// Click on Save Button
	public void clickOnSaveButton() {

		utilobj.click(clickOnSaveBT, "Save Button");

	}
	
	// Click on clear Button
	public void clickOnClearButton() {

		utilobj.click(clickOnClearBT, "Clear Button");

	}

	// goto Shipper party other tab
	public void goToOtherTab() {
		utilobj.click(otherTab, "Other Tab");

	}

}
