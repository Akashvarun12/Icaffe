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
	
	
	
	
	
	
	
	
	
	
	
	
}
