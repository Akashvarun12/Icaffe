package masters;

import java.util.Map;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import basetest.BaseTest;

import icaffe_homepage.Homepage;
import masters_party_pagewise_classes.Exporter_OtherTab;
import masters_party_pagewise_classes.Exporter_ShipperTab;
import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class Party_Exporter_TestCase extends BaseTest {

	@Test(priority = 1)
	public void verifyShipperMasterTitle(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();

		utilObj.validateTitleForAllPages(context);

	}

	@Test(priority = 2)

	public void verifyPrivateShipperPartyCreationWithMandatoryFieldsTest(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		String partyName = testData.get("partyName");
		String IECNumber = testData.get("IECNumber");
		String classDropDownOption = testData.get("classDropDownOption");
		String mercManufDropDownOption = testData.get("mercManufDropDownOption");
		String serialNumber = testData.get("serialNumber");
		String partyAddress = testData.get("partyAddress");
		String entCountry = testData.get("entCountry");
		String country = testData.get("country");
		String entState = testData.get("entState");
		String state = testData.get("state");
		String regNumber = testData.get("regNumber");
		String ctxState = testData.get("ctxState");
		String ADCode = testData.get("ADCode");
		String expConfirmationMsg = testData.get("expConfirmationMsg");
		Exporter_ShipperTab expShipperObj = new Exporter_ShipperTab(utilObj);
		expShipperObj.enterShipperDetailsMandatoryFields(partyName, IECNumber, classDropDownOption,
				mercManufDropDownOption);
		expShipperObj.enterShipperAddressMandatoryFields(serialNumber, partyAddress, entCountry, country, entState,
				state, regNumber, ctxState);
		expShipperObj.clickOnAddButton();

		expShipperObj.goToOtherTab();

		Exporter_OtherTab expOtherObj = new Exporter_OtherTab(utilObj);
		expOtherObj.enterShipperOtherTabMandatoryFields(ADCode);
		expShipperObj.clickOnSaveButton();
		utilObj.alertTextValidation(expConfirmationMsg);
	}

	@Test(priority = 3)

	public void verifyGovernmentShipperPartyCreationWithMandatoryFieldsTest(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		String partyName = testData.get("partyName");
		String IECNumber = testData.get("IECNumber");
		String classDropDownOption = testData.get("classDropDownOption");
		String mercManufDropDownOption = testData.get("mercManufDropDownOption");
		String serialNumber = testData.get("serialNumber");
		String partyAddress = testData.get("partyAddress");
		String entCountry = testData.get("entCountry");
		String country = testData.get("country");
		String entState = testData.get("entState");
		String state = testData.get("state");
		String regNumber = testData.get("regNumber");
		String ctxState = testData.get("ctxState");
		String ADCode = testData.get("ADCode");
		String expConfirmationMsg = testData.get("expConfirmationMsg");
		Exporter_ShipperTab expShipperObj = new Exporter_ShipperTab(utilObj);
		expShipperObj.enterShipperDetailsMandatoryFields(partyName, IECNumber, classDropDownOption,
				mercManufDropDownOption);
		expShipperObj.enterShipperAddressMandatoryFields(serialNumber, partyAddress, entCountry, country, entState,
				state, regNumber, ctxState);
		expShipperObj.clickOnAddButton();

		expShipperObj.goToOtherTab();

		Exporter_OtherTab expOtherObj = new Exporter_OtherTab(utilObj);
		expOtherObj.enterShipperOtherTabMandatoryFields(ADCode);
		expShipperObj.clickOnSaveButton();
		utilObj.alertTextValidation(expConfirmationMsg);
	}

	@Test(priority = 4)

	public void verifyDuplicateShipperNameForGovernmentPartyCreationTest(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		String partyName = testData.get("partyName");
		String IECNumber = testData.get("IECNumber");
		String classDropDownOption = testData.get("classDropDownOption");
		String mercManufDropDownOption = testData.get("mercManufDropDownOption");
		String serialNumber = testData.get("serialNumber");
		String partyAddress = testData.get("partyAddress");
		String entCountry = testData.get("entCountry");
		String country = testData.get("country");
		String entState = testData.get("entState");
		String state = testData.get("state");
		String regNumber = testData.get("regNumber");
		String ctxState = testData.get("ctxState");
		String ADCode = testData.get("ADCode");
		String expConfirmationMsg = testData.get("expConfirmationMsg");
		Exporter_ShipperTab expShipperObj = new Exporter_ShipperTab(utilObj);
		expShipperObj.enterShipperDetailsMandatoryFields(partyName, IECNumber, classDropDownOption,
				mercManufDropDownOption);
		expShipperObj.enterShipperAddressMandatoryFields(serialNumber, partyAddress, entCountry, country, entState,
				state, regNumber, ctxState);
		expShipperObj.clickOnAddButton();

		expShipperObj.goToOtherTab();

		Exporter_OtherTab expOtherObj = new Exporter_OtherTab(utilObj);
		expOtherObj.enterShipperOtherTabMandatoryFields(ADCode);
		expShipperObj.clickOnSaveButton();
		utilObj.alertTextValidation(expConfirmationMsg);
	}

	@Test(priority = 4)

	public void verifyDuplicateIECNumberForGovernmentShipperCreation(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		String partyName = testData.get("partyName");
		String IECNumber = testData.get("IECNumber");
		String classDropDownOption = testData.get("classDropDownOption");
		String mercManufDropDownOption = testData.get("mercManufDropDownOption");
		String serialNumber = testData.get("serialNumber");
		String partyAddress = testData.get("partyAddress");
		String entCountry = testData.get("entCountry");
		String country = testData.get("country");
		String entState = testData.get("entState");
		String state = testData.get("state");
		String regNumber = testData.get("regNumber");
		String ctxState = testData.get("ctxState");
		String ADCode = testData.get("ADCode");
		String expConfirmationMsg = testData.get("expConfirmationMsg");
		Exporter_ShipperTab expShipperObj = new Exporter_ShipperTab(utilObj);
		expShipperObj.enterShipperDetailsMandatoryFields(partyName, IECNumber, classDropDownOption,
				mercManufDropDownOption);
		expShipperObj.enterShipperAddressMandatoryFields(serialNumber, partyAddress, entCountry, country, entState,
				state, regNumber, ctxState);
		expShipperObj.clickOnAddButton();

		expShipperObj.goToOtherTab();

		Exporter_OtherTab expOtherObj = new Exporter_OtherTab(utilObj);
		expOtherObj.enterShipperOtherTabMandatoryFields(ADCode);
		expShipperObj.clickOnSaveButton();
		utilObj.alertTextValidation(expConfirmationMsg);
	}

	@Test(priority = 5)

	public void verifyDuplicateIECNumberForPrivateShipperCreation(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		String partyName = testData.get("partyName");
		String IECNumber = testData.get("IECNumber");
		String classDropDownOption = testData.get("classDropDownOption");
		String mercManufDropDownOption = testData.get("mercManufDropDownOption");
		String serialNumber = testData.get("serialNumber");
		String partyAddress = testData.get("partyAddress");
		String entCountry = testData.get("entCountry");
		String country = testData.get("country");
		String entState = testData.get("entState");
		String state = testData.get("state");
		String regNumber = testData.get("regNumber");
		String ctxState = testData.get("ctxState");
		String ADCode = testData.get("ADCode");
		String expConfirmationMsg = testData.get("expConfirmationMsg");
		Exporter_ShipperTab expShipperObj = new Exporter_ShipperTab(utilObj);
		expShipperObj.enterShipperDetailsMandatoryFields(partyName, IECNumber, classDropDownOption,
				mercManufDropDownOption);
		expShipperObj.enterShipperAddressMandatoryFields(serialNumber, partyAddress, entCountry, country, entState,
				state, regNumber, ctxState);
		expShipperObj.clickOnAddButton();

		expShipperObj.goToOtherTab();

		Exporter_OtherTab expOtherObj = new Exporter_OtherTab(utilObj);
		expOtherObj.enterShipperOtherTabMandatoryFields(ADCode);
		expShipperObj.clickOnSaveButton();
		utilObj.alertTextValidation(expConfirmationMsg);
	}

	@Test(priority = 3)
	public void verifyShipperPartyModification(ITestContext context) {
		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		String selectclassDropDownOption_InSearch = testData.get("selectclassDropDownOption_InSearch");
		String selectname_or_ID_InSearch = testData.get("selectname_or_ID_InSearch");
		String selectpartyName_InSearchGrid = testData.get("selectpartyName_InSearchGrid");
		String partyName = testData.get("partyName");
		String IECNumber = testData.get("IECNumber");
		String classDropDownOption = testData.get("classDropDownOption");
		String mercManufDropDownOption = testData.get("mercManufDropDownOption");
		String serialNumber = testData.get("serialNumber");
		String partyAddress = testData.get("partyAddress");
		String entCountry = testData.get("entCountry");
		String country = testData.get("country");
		String entState = testData.get("entState");
		String state = testData.get("state");
		String regNumber = testData.get("regNumber");
		String ctxState = testData.get("ctxState");
		String ADCode = testData.get("ADCode");
		String expConfirmationMsg = testData.get("expConfirmationMsg");
		Exporter_ShipperTab expShipperObj = new Exporter_ShipperTab(utilObj);
		expShipperObj.modifyShipperWithAllParty(context, selectclassDropDownOption_InSearch, selectname_or_ID_InSearch,
				selectpartyName_InSearchGrid, partyName, IECNumber, classDropDownOption, mercManufDropDownOption,
				serialNumber, partyAddress, entCountry, country, entState, state, regNumber, ctxState);
		expShipperObj.clickOnAddButton();

		expShipperObj.goToOtherTab();
		Exporter_OtherTab expOtherObj = new Exporter_OtherTab(utilObj);
		expOtherObj.enterShipperOtherTabMandatoryFields(ADCode);
		expShipperObj.clickOnModifyButton();
		utilObj.alertTextValidation(expConfirmationMsg);

	}

	@Test(priority = 4)
	public void verifyShipperPartyDisplayedInSearchGrid(ITestContext context) {
		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Exporter_ShipperTab expShipperObj = new Exporter_ShipperTab(utilObj);
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		String selectclassDropDownOption_InSearch = testData.get("selectclassDropDownOption_InSearch");
		String selectname_or_ID_InSearch = testData.get("selectname_or_ID_InSearch");

		expShipperObj.selectSearchShipperParty(context, selectclassDropDownOption_InSearch, selectname_or_ID_InSearch);
		expShipperObj.logShipperPartySearchTableData();

	}

	@Test(priority = 5)
	public void verifyShipperPartyDeletion(ITestContext context) {
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		
		String selectclassDropDownOption_InSearch = testData.get("selectclassDropDownOption_InSearch");
		String selectname_or_ID_InSearch = testData.get("selectname_or_ID_InSearch");
		String selectpartyName_InSearchGrid = testData.get("selectpartyName_InSearchGrid");
		String expConfirmationMsg = testData.get("expConfirmationMsg");
		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Exporter_ShipperTab expShipperObj = new Exporter_ShipperTab(utilObj);
		expShipperObj.deleteShipperParty(context, selectclassDropDownOption_InSearch, selectname_or_ID_InSearch,
				selectpartyName_InSearchGrid);
		expShipperObj.clickOnDeleteButton();

		utilObj.alertHandleAccept();

		utilObj.alertTextValidation(expConfirmationMsg);

	}

//	@Test(priority = 2, dataProvider = "ReadDataFromExcel", dataProviderClass = ExcelDataSuplier.class)
//
//	public void verifyShipperAccountCreationWithMandatoryFieldsDataProvider(String partyName, String IECNumber,
//			String classDropDownOption, String mercManufDropDownOption, String serialNumber, String partyAddress,
//			String entCountry, String country, String entState, String state, String regNumber, String ctxState,String ADCode,
//			String expConfirmationMsg) {
//
//		Homepage homeObj = new Homepage(utilObj);
//		homeObj.Goto_Masters_PartyExporter();
//		Exporter_ShipperTab expShipperObj = new Exporter_ShipperTab(utilObj);
//		expShipperObj.enterShipperDetailsMandatoryFields(partyName, IECNumber, classDropDownOption,
//				mercManufDropDownOption);
//		expShipperObj.enterShipperAddressMandatoryFields(serialNumber, partyAddress, entCountry, country, entState,
//				state, regNumber, ctxState);
//		expShipperObj.clickOnAddButton();
//		expShipperObj.goToOtherTab();
//		Exporter_OtherTab expOtherObj = new Exporter_OtherTab(utilObj);
//		expOtherObj.enterShipperOtherTabMandatoryFields(ADCode);
//		expShipperObj.clickOnSaveButton();
//		utilObj.alertTextValidation(expConfirmationMsg);
//	}

}
