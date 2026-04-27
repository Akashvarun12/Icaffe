package icaffe_homepage;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import webutil.WebUtil;

public class Homepage {

	private WebUtil utilobj;

	public Homepage(WebUtil utilobj) {
		this.utilobj = utilobj;
		PageFactory.initElements(utilobj.getDriver(), this);

	}

	@FindBy(xpath = "//a[text()='Masters ']")
	private WebElement goToMasters;

	@FindBy(xpath = "//a[text()='Party ']")
	private WebElement goToParty;

	@FindBy(xpath = "//a[text()='Exporter']")
	private WebElement clickOnExporter;
	
	@FindBys(@FindBy(xpath = "// label[@id='UserTag']//span"))
	private List<WebElement> listOfWebEle;
	


	public List<String> verifyLoginBranchDivision_OnHomePage() {

		 List<String> actualList = utilobj.getListOfText(listOfWebEle);
		 
     return actualList;
	}
	
	
	public void Goto_Masters_PartyExporter() {

		utilobj.mouseOver(goToMasters);
		utilobj.mouseOver(goToParty);

		utilobj.clickByAction(clickOnExporter);

		
	}



}
