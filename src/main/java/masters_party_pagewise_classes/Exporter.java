package masters_party_pagewise_classes;

import org.openqa.selenium.support.PageFactory;

import webutil.WebUtil;

public class Exporter {

	
	private WebUtil utilobj;

	public Exporter(WebUtil utilobj) {
		this.utilobj = utilobj;
		PageFactory.initElements(utilobj.getDriver(), this);

	}
	
	
	
}
