package masterstestcase;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import basetest.BaseTest;
import icaffe_homepage.Homepage;
import icaffe_masters_party_pagewise_classes.Consignee;
import icaffe_masters_party_pagewise_classes.Exporter_Other;
import icaffe_masters_party_pagewise_classes.Exporter_Shipper;
import pojo.ExporterTestData;
import webutil.ExcelDataSuplier;

public class Party_Consignee_TestCase extends BaseTest{

	
	@Test(priority = 1)
	public void verifyConsigneeMasterURL(ITestContext context) {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyConsignee();

		utilObj.validateCurrentURL(context);

	}
//	
//	@Test(priority = 2)
//
//	public void verifyConsigneePartyCreationWithMandatoryFieldsTest(ITestContext context) {
//
//		Homepage homeObj = new Homepage(utilObj);
//		homeObj.Goto_Masters_PartyConsignee();
//		
//		Map<String, String> testData = ExcelDataSuplier.readDynamicDataFromExcel(context);
//		ExporterTestData data = new ExporterTestData(testData);

	
//		
//		Consignee conObj=	new Consignee(utilObj);
//		conObj.enterConsigneePartyDetailsMandatoryFields();
//		conObj.enterConsigneePartyAddressMandatoryFields();
//		conObj.clickOnAddButton();
//		conObj.clickOnSaveButton();
		

//		expShipperObj.enterShipperDetailsMandatoryFields(data.getPartyName(), data.getIECNumber(),
//				data.getClassDropDownOption(), data.getMercManufDropDownOption());
//		expShipperObj.enterShipperAddressMandatoryFields(data.getSerialNumber(), data.getPartyAddress(),
//				data.getEntCountry(), data.getCountry(), data.getEntState(), data.getState(), data.getRegNumber(),
//				data.getCtxState());
//		expShipperObj.clickOnAddButton();
//
//		expShipperObj.goToOtherTab();
//
//		Exporter_Other expOtherObj = new Exporter_Other(utilObj);
//		expOtherObj.enterShipperOtherTabMandatoryFields(data.getADCode());
//		expShipperObj.clickOnSaveButton();
//		utilObj.alertTextValidation(data.getExpConfirmationMsg());
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
//	}
	
	
}
