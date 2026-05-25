package masterstestcase;

import java.util.Map;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import basetest.BaseTest;

import icaffe_homepage.Homepage;
import icaffe_masters_party_pagewise_classes.Exporter_Other;
import icaffe_masters_party_pagewise_classes.Exporter_Shipper;
import pojo.ExporterTestData;
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
		ExporterTestData data = new ExporterTestData(testData);

		Exporter_Shipper expShipperObj = new Exporter_Shipper(utilObj);
		expShipperObj.enterShipperDetailsMandatoryFields(data.getPartyName(), data.getIECNumber(),
				data.getClassDropDownOption(), data.getMercManufDropDownOption());
		expShipperObj.enterShipperAddressMandatoryFields(data.getSerialNumber(), data.getPartyAddress(),
				data.getEntCountry(), data.getCountry(), data.getEntState(), data.getState(), data.getRegNumber(),
				data.getCtxState());
		expShipperObj.clickOnAddButton();

		expShipperObj.goToOtherTab();

		Exporter_Other expOtherObj = new Exporter_Other(utilObj);
		expOtherObj.enterShipperOtherTabMandatoryFields(data.getADCode());
		expShipperObj.clickOnSaveButton();
		utilObj.alertTextValidation(data.getExpConfirmationMsg());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Test(priority = 3)

	public void verifyGovernmentShipperPartyCreationWithMandatoryFieldsTest(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		ExporterTestData data = new ExporterTestData(testData);

		Exporter_Shipper expShipperObj = new Exporter_Shipper(utilObj);
		expShipperObj.enterShipperDetailsMandatoryFields(data.getPartyName(), data.getIECNumber(),
				data.getClassDropDownOption(), data.getMercManufDropDownOption());
		expShipperObj.enterShipperAddressMandatoryFields(data.getSerialNumber(), data.getPartyAddress(),
				data.getEntCountry(), data.getCountry(), data.getEntState(), data.getState(), data.getRegNumber(),
				data.getCtxState());
		expShipperObj.clickOnAddButton();

		expShipperObj.goToOtherTab();

		Exporter_Other expOtherObj = new Exporter_Other(utilObj);
		expOtherObj.enterShipperOtherTabMandatoryFields(data.getADCode());
		expShipperObj.clickOnSaveButton();
		utilObj.alertTextValidation(data.getExpConfirmationMsg());

	}

	@Test(priority = 4)

	public void verifyDuplicateShipperNameForGovernmentPartyCreationTest(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		ExporterTestData data = new ExporterTestData(testData);

		Exporter_Shipper expShipperObj = new Exporter_Shipper(utilObj);
		expShipperObj.enterShipperDetailsMandatoryFields(data.getPartyName(), data.getIECNumber(),
				data.getClassDropDownOption(), data.getMercManufDropDownOption());
		expShipperObj.enterShipperAddressMandatoryFields(data.getSerialNumber(), data.getPartyAddress(),
				data.getEntCountry(), data.getCountry(), data.getEntState(), data.getState(), data.getRegNumber(),
				data.getCtxState());
		expShipperObj.clickOnAddButton();

		expShipperObj.goToOtherTab();

		Exporter_Other expOtherObj = new Exporter_Other(utilObj);
		expOtherObj.enterShipperOtherTabMandatoryFields(data.getADCode());
		expShipperObj.clickOnSaveButton();
		utilObj.alertTextValidation(data.getExpConfirmationMsg());
	}

	@Test(priority = 5)

	public void verifyDuplicateIECNumberForGovernmentShipperCreation(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		ExporterTestData data = new ExporterTestData(testData);

		Exporter_Shipper expShipperObj = new Exporter_Shipper(utilObj);
		expShipperObj.enterShipperDetailsMandatoryFields(data.getPartyName(), data.getIECNumber(),
				data.getClassDropDownOption(), data.getMercManufDropDownOption());
		expShipperObj.enterShipperAddressMandatoryFields(data.getSerialNumber(), data.getPartyAddress(),
				data.getEntCountry(), data.getCountry(), data.getEntState(), data.getState(), data.getRegNumber(),
				data.getCtxState());
		expShipperObj.clickOnAddButton();

		expShipperObj.goToOtherTab();

		Exporter_Other expOtherObj = new Exporter_Other(utilObj);
		expOtherObj.enterShipperOtherTabMandatoryFields(data.getADCode());
		expShipperObj.clickOnSaveButton();
		utilObj.alertTextValidation(data.getExpConfirmationMsg());
	}

	@Test(priority = 6)

	public void verifyDuplicateIECNumberForPrivateShipperCreation(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		ExporterTestData data = new ExporterTestData(testData);

		Exporter_Shipper expShipperObj = new Exporter_Shipper(utilObj);
		expShipperObj.enterShipperDetailsMandatoryFields(data.getPartyName(), data.getIECNumber(),
				data.getClassDropDownOption(), data.getMercManufDropDownOption());
		expShipperObj.enterShipperAddressMandatoryFields(data.getSerialNumber(), data.getPartyAddress(),
				data.getEntCountry(), data.getCountry(), data.getEntState(), data.getState(), data.getRegNumber(),
				data.getCtxState());
		expShipperObj.clickOnAddButton();

		expShipperObj.goToOtherTab();

		Exporter_Other expOtherObj = new Exporter_Other(utilObj);
		expOtherObj.enterShipperOtherTabMandatoryFields(data.getADCode());
		expShipperObj.clickOnSaveButton();
		utilObj.alertTextValidation(data.getExpConfirmationMsg());
	}

	@Test(priority = 7)
	public void verifyShipperPartyModification(ITestContext context) {
		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		ExporterTestData data = new ExporterTestData(testData);

		Exporter_Shipper expShipperObj = new Exporter_Shipper(utilObj);
		expShipperObj.modifyShipperPartyWithPartialData(context, data.getSelectclassDropDownOption_InSearch(),
				data.getSelectname_or_ID_InSearch(), data.getselectpartyName_InSearchGrid(), data.getPartyName(),
				data.getIECNumber(), data.getClassDropDownOption(), data.getMercManufDropDownOption(),
				data.getPartyAddress(),data.getEntState(), data.getState(), data.getCtxState(), data.getRegNumber());
		expShipperObj.clickOnAddButton();

		expShipperObj.goToOtherTab();

		Exporter_Other expOtherObj = new Exporter_Other(utilObj);
		expOtherObj.enterShipperOtherTabMandatoryFields(data.getADCode());
		expShipperObj.clickOnModifyButton();
		utilObj.alertTextValidation(data.getExpConfirmationMsg());

	}

	@Test(priority = 8)
	public void verifyShipperPartyDisplayedInSearchGrid(ITestContext context) {
		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		ExporterTestData data = new ExporterTestData(testData);
		Exporter_Shipper expShipperObj = new Exporter_Shipper(utilObj);

		expShipperObj.selectSearchShipperParty(context, data.getSelectclassDropDownOption_InSearch(),
				data.getSelectname_or_ID_InSearch());
		expShipperObj.logShipperPartySearchTableData();

	}

	@Test(priority = 9)
	public void verifyGovernmentShipperPartyDeletion(ITestContext context) {
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		ExporterTestData data = new ExporterTestData(testData);
		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Exporter_Shipper expShipperObj = new Exporter_Shipper(utilObj);
		expShipperObj.deleteShipperParty(context, data.getSelectclassDropDownOption_InSearch(),
				data.getSelectname_or_ID_InSearch(), data.getselectpartyName_InSearchGrid());
		expShipperObj.clickOnDeleteButton();

		utilObj.alertHandleAccept();

		utilObj.alertTextValidation(data.getExpConfirmationMsg());

	}
	
	@Test(priority = 10)
	public void verifyDuplicateGovernmentShipperPartyDeletion(ITestContext context) {
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		ExporterTestData data = new ExporterTestData(testData);
		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Exporter_Shipper expShipperObj = new Exporter_Shipper(utilObj);
		expShipperObj.deleteShipperParty(context, data.getSelectclassDropDownOption_InSearch(),
				data.getSelectname_or_ID_InSearch(), data.getselectpartyName_InSearchGrid());
		expShipperObj.clickOnDeleteButton();

		utilObj.alertHandleAccept();

		utilObj.alertTextValidation(data.getExpConfirmationMsg());

	}
	
	@Test(priority = 11)
	public void verifyPrivateShipperPartyDeletion(ITestContext context) {
		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		ExporterTestData data = new ExporterTestData(testData);
		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Exporter_Shipper expShipperObj = new Exporter_Shipper(utilObj);
		expShipperObj.deleteShipperParty(context, data.getSelectclassDropDownOption_InSearch(),
				data.getSelectname_or_ID_InSearch(), data.getselectpartyName_InSearchGrid());
		expShipperObj.clickOnDeleteButton();

		utilObj.alertHandleAccept();

		utilObj.alertTextValidation(data.getExpConfirmationMsg());

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
