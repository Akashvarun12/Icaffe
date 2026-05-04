package masters;

import org.testng.annotations.Test;

import basetest.BaseTest;

import icaffe_homepage.Homepage;
import masters_party_pagewise_classes.Exporter;

public class Party_Exporter_TestCase extends BaseTest {

//	@Test
	public void validate_ShipperPageWith_Title() {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();

		utilObj.validateGetTitle("Shipper Master", "valid", "Masters Page");

	}

	@Test
	public void validate_NewShipperAccount_CreationWith_MandadatoryField() {

		Homepage homeObj = new Homepage(utilObj);
		homeObj.Goto_Masters_PartyExporter();
		Exporter expObj = new Exporter(utilObj);
		expObj.enterShipperAddressMandatoryFields("India");
	}

}
