package masterstestcase;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import icaffe_masters_party_pagewise_classes.Consignee;
import pojo.ConsigneeTestData;
import webutil.ExcelDataSuplier;

public class Party_Consignee_TestCase extends BaseTest {

//	@Test(priority = 1)
	public void verifyConsigneeMasterURL(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyConsignee();

		utilObj.validateCurrentURL(context);

	}

	@Test(priority = 2)

	public void verifySupplierPartyCreationWithMandatoryFieldsTest(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyConsignee();

		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		ConsigneeTestData data = new ConsigneeTestData(testData);

		Consignee conObj = new Consignee(utilObj);
		conObj.enterConsigneePartyDetailsMandatoryFields(data.selSubTypeRaidioBT(), data.getPartyName(),
				data.entExtendedName());
		conObj.enterConsigneePartyAddressMandatoryFields(data.getPartyAddress(), data.entContactPerson(),
				data.getEntCountry(), data.getCountry(), data.getEntState(), data.entEmail());
		conObj.clickOnAddButton();
		conObj.clickOnSaveButton();

		utilObj.alertTextValidation(data.getExpConfirmationMsg());
	}

	@Test(priority = 3)

	public void verifyBuyerPartyCreationWithMandatoryFieldsTest(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyConsignee();

		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		ConsigneeTestData data = new ConsigneeTestData(testData);

		Consignee conObj = new Consignee(utilObj);
		conObj.enterConsigneePartyDetailsMandatoryFields(data.selSubTypeRaidioBT(), data.getPartyName(),
				data.entExtendedName());
		conObj.enterConsigneePartyAddressMandatoryFields(data.getPartyAddress(), data.entContactPerson(),
				data.getEntCountry(), data.getCountry(), data.getEntState(), data.entEmail());
		conObj.clickOnAddButton();
		conObj.clickOnSaveButton();

		utilObj.alertTextValidation(data.getExpConfirmationMsg());
	}

	@Test(priority = 4)

	public void verifyNotifyPartyCreationWithMandatoryFieldsTest(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyConsignee();

		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		ConsigneeTestData data = new ConsigneeTestData(testData);

		Consignee conObj = new Consignee(utilObj);
		conObj.enterConsigneePartyDetailsMandatoryFields(data.selSubTypeRaidioBT(), data.getPartyName(),
				data.entExtendedName());
		conObj.enterConsigneePartyAddressMandatoryFields(data.getPartyAddress(), data.entContactPerson(),
				data.getEntCountry(), data.getCountry(), data.getEntState(), data.entEmail());
		conObj.clickOnAddButton();
		conObj.clickOnSaveButton();

		utilObj.alertTextValidation(data.getExpConfirmationMsg());
	}

	@Test(priority = 5)

	public void verifySupplierPartyModificationWithMandatoryFieldsTest(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyConsignee();

		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		ConsigneeTestData data = new ConsigneeTestData(testData);

		Consignee conObj = new Consignee(utilObj);

		conObj.modifyConsigneePartyrDetailsMandatoryFields(data.getPartyName(), data.entExtendedName());
		conObj.modifyConsigneePartyAddressMandatoryFields(data.getPartyAddress(), data.getEntState(), data.entEmail());
		conObj.clickOnAddButton();
		conObj.clickOnSaveButton();

		utilObj.alertTextValidation(data.getExpConfirmationMsg());
	}

	@Test(priority = 6)

	public void verifyBuyerPartyModificationWithMandatoryFieldsTest(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyConsignee();

		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		ConsigneeTestData data = new ConsigneeTestData(testData);

		Consignee conObj = new Consignee(utilObj);

		conObj.modifyConsigneePartyrDetailsMandatoryFields(data.getPartyName(), data.entExtendedName());
		conObj.modifyConsigneePartyAddressMandatoryFields(data.getPartyAddress(), data.getEntState(), data.entEmail());
		conObj.clickOnAddButton();
		conObj.clickOnSaveButton();

		utilObj.alertTextValidation(data.getExpConfirmationMsg());
	}
	
	@Test(priority = 7)

	public void verifyNotifyPartyModificationWithMandatoryFieldsTest(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyConsignee();

		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
		ConsigneeTestData data = new ConsigneeTestData(testData);

		Consignee conObj = new Consignee(utilObj);

		conObj.modifyConsigneePartyrDetailsMandatoryFields(data.getPartyName(), data.entExtendedName());
		conObj.modifyConsigneePartyAddressMandatoryFields(data.getPartyAddress(), data.getEntState(), data.entEmail());
		conObj.clickOnAddButton();
		conObj.clickOnSaveButton();

		utilObj.alertTextValidation(data.getExpConfirmationMsg());
	}
}
