package icaffe_masters_party_pagewise_classes;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

import webutil.WebUtil;

public class Consignee {

	private WebUtil utilobj;

	public Consignee(WebUtil utilobj) {
		this.utilobj = utilobj;
		PageFactory.initElements(utilobj.getDriver(), this);

	}

	@FindBy(xpath = "//input[@name='ConsigneeName']")
	WebElement consigneeName;

	@FindBy(xpath = "//input[@name='ConEXTENDEDNAME']")
	WebElement extendedName;

	@FindBy(xpath = "//input[@name='ContactPerson']")
	WebElement contactPerson;

	@FindBy(xpath = "//input[@name='Address1']")
	WebElement address;

	@FindBys(@FindBy(xpath = "//ul[@id='ui-id-1']//li"))
	List<WebElement> listOfCountrytext;

	@FindBy(xpath = "//input[@placeholder='Country']")
	WebElement clikOnCountry;

	@FindBy(xpath = "//input[@placeholder='State']")
	WebElement clickState;

	@FindBy(xpath = "//input[@name='Email1']")
	WebElement clickEmail;
	
	@FindBy(xpath = "//input[@id='txtListConsigneeName']")
	WebElement searchPartyNameTB;

	@FindBy(xpath = "//button[@onclick='InsertAddress();']")
	WebElement clickOnAddBT;

	@FindBy(xpath = "//button[@id='btnAdd']")
	WebElement clickOnSaveBT;

	@FindBy(xpath = "//select[@id='ddlSearchType']")
	WebElement consigneeType_InSearch;

	@FindBy(xpath = "//img[@src='../../CSImages/edit.png']")
	WebElement clickEditIconOnPrtyAddressGrid;

	@FindBy(xpath = "//button[@id='btnModify']")
	WebElement clickOnModifyButton;

	@FindBy(xpath = "//button[@id='btnDelete']")
	WebElement clickOnDeleteBT;

	// Select Consignee type Supplier/Buyer/Notify Radio button...
	public void selectConsigneeTypeRadiobutton(String selRaidioBT) {
		if (selRaidioBT.equals("rdoConsignee")) {
			utilobj.selectRadioButton(selRaidioBT, "Supplier Radio Button Selected");
		} else if (selRaidioBT.equals("rdoConsignee")) {
			utilobj.selectRadioButton(selRaidioBT, "Buyer Radio Button Selected");
		} else if (selRaidioBT.equals("rdoConsignee")) {
			utilobj.selectRadioButton(selRaidioBT, "Notify Radio Button Selected");
		}
	}

	// Enter Mandatory details in consignee details section
	public void enterConsigneePartyDetailsMandatoryFields(String selRaidioBT, String entConsignee,
			String entExtendedName) {
		selectConsigneeTypeRadiobutton(selRaidioBT);
		utilobj.clear(consigneeName, "Consignee Name Textbox");
		utilobj.sendKeys(consigneeName, entConsignee, "Consignee Name Textbox");
		utilobj.clear(extendedName, "Extended Name Textbox");
		utilobj.sendKeys(extendedName, entExtendedName, "Extended Name Textbox");

	}

	// Modify Mandatory details in consignee details section
	public void modifyConsigneePartyrDetailsMandatoryFields( String selectconsigneeType_InSearch,
			String selectPartyName_InSearchGrid,String modConsignee, String modExtendedName) {
		selectSearchConsigneeParty(selectconsigneeType_InSearch,selectPartyName_InSearchGrid);
		utilobj.clear(consigneeName, "Consignee Name Textbox");
		utilobj.sendKeys(consigneeName, modConsignee, "Consignee Name Textbox");
		utilobj.clear(extendedName, "Extended Name Textbox");
		utilobj.sendKeys(extendedName, modExtendedName, "Extended Name Textbox");

	}

	// Enter Mandatory details in consignee address section
	public void enterConsigneePartyAddressMandatoryFields(String entAddress, String entContactPerson, String entCountry,
			String selCountry, String entState, String entEmail) {
		utilobj.clear(address, "address1 Textbox");
		utilobj.sendKeys(address, entAddress, "address1 Textbox");
		utilobj.clear(contactPerson, "contactPerson Textbox");
		utilobj.sendKeys(contactPerson, entContactPerson, "contactPerson Textbox");
		utilobj.clear(clikOnCountry, "Country");
		utilobj.selectAutoSuggestOption(listOfCountrytext, clikOnCountry, entCountry, "Country Textbox", selCountry);
		utilobj.clear(clickState, "State Textbox");
		utilobj.sendKeys(clickState, entState, "State Textbox");
		utilobj.clear(clickEmail, "Email Textbox");
		utilobj.sendKeys(clickEmail, entEmail, "Email Textbox");

	}

	// Modify Mandatory details in consignee address section
	public void modifyConsigneePartyAddressMandatoryFields(String entAddress, String entState, String entEmail) {

		utilobj.clear(address, "address Textbox");
		utilobj.sendKeys(address, entAddress, "address Textbox");
		utilobj.clear(clickState, "State Textbox");
		utilobj.sendKeys(clickState, entState, "State Textbox");
		utilobj.clear(clickState, "Email Textbox");
		utilobj.sendKeys(clickEmail, entEmail, "Email Textbox");

	}

	// Select created shipper party in search grid
	public void selectSearchConsigneeParty(ITestContext context, String selectconsigneeType_InSearch,
			String selectname_or_ID_InSearch) {

		utilobj.selectDropDownByText(consigneeType_InSearch, selectconsigneeType_InSearch);

	}

	// Log or Print all created shipper Name and Status from Search Grid
	public void logConsigneePartySearchTableData() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		utilobj.sendKeys(searchPartyNameTB, "Consignee", "Search Party Name");
		utilobj.printTableData();

	}

	// Modify shipper party mandatory details partially
//	public void modifyConsigneePartyWithPartialData(ITestContext context, String selectconsigneeType_InSearch,
//			String selectname_or_ID_InSearch, String entConsignee, String entExtendedName,
//			String selectpartyName_InSearchGrid, String entAddress, String entState, String entEmail) {
//
//		selectSearchConsigneeParty(context, selectconsigneeType_InSearch, selectname_or_ID_InSearch);
//
//		utilobj.selectOptionFromSearch("Search Grid", selectpartyName_InSearchGrid);
//		modifyConsigneePartyrDetailsMandatoryFields(entConsignee, entExtendedName);
//		clickOnPartyAddressGridEditBT();
//		modifyConsigneePartyAddressMandatoryFields(entAddress, entState, entEmail);
//
//	}

	// Deleting shipper party
	public void deleteConsigneeParty(ITestContext context, String selectconsigneeType_InSearch,
			String selectname_or_ID_InSearch, String selectpartyName_InSearchGrid) {
		selectSearchConsigneeParty(context, selectconsigneeType_InSearch, selectname_or_ID_InSearch);
		utilobj.selectOptionFromSearch("Search Grid", selectpartyName_InSearchGrid);
		utilobj.scrollByAction(clickOnDeleteBT);

	}

	// Click on Add Button
	public void clickOnAddButton() {
		utilobj.click(clickOnAddBT, "Add Button");

	}

	// Click on Party Address Grid Edit Icon
	public void clickOnPartyAddressGridEditBT() {
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

}
