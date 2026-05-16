package masters_party_pagewise_classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webutil.WebUtil;

public class Exporter_OtherTab {

	
	private WebUtil utilobj;

	public Exporter_OtherTab(WebUtil utilobj) {
		this.utilobj = utilobj;
		PageFactory.initElements(utilobj.getDriver(), this);

	}
	
	@FindBy(xpath = "//input[@id='txtADCode']")
	WebElement adCode_ADCodeDetailsSection;
	
	@FindBy(xpath = "//input[@id='txtDBKADCode']")
	WebElement adCode_ADCodeDrawbackACSection;
	
	
	public void enterShipperOtherTabMandatoryFields(String ADCode) {

		utilobj.sendKeys(adCode_ADCodeDetailsSection, ADCode, "AD Code Textbox on AD Code Details Section");
		utilobj.sendKeys(adCode_ADCodeDrawbackACSection, ADCode, "AD Code Textbox on Drawback AC Details Section");
		
	}
	
}

