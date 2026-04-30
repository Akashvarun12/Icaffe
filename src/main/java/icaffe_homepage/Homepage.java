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

//	@FindBy(xpath = "//a[text()='Exporter']")
//	private WebElement clickOnExporter;
	
	// Bank BRO Page opening
	@FindBy(xpath = "//a[text() = 'Bank BRO']")
	private WebElement bankBRO ;
	
	
	// CFS Master Page opening 
	@FindBy(xpath = "//a[text() = 'CFS Master']")
	private WebElement cfsmaster ;
	
	
	// Going To Shipment Info page.
	@FindBy(xpath = "//a[text()= 'Shipment Info '] ")
	WebElement goToshipmentInfo ;
	
	
	// Going To IMO Master Page
	@FindBy(xpath = "//a[text()='IMO Master']")
	WebElement goToIMOMaster ;
	
	
	@FindBys(@FindBy(xpath = "// label[@id='UserTag']//span"))
	private List<WebElement> listOfWebEle;
	


	public List<String> verifyLoginBranchDivision_OnHomePage() {

		 List<String> actualList = utilobj.getListOfText(listOfWebEle);
     return actualList;
	}
	
	
//	public void Goto_Masters_PartyExporter() {
//
//		utilobj.mouseOver(goToMasters);
//		utilobj.mouseOver(goToParty);
//		//CFS MAster Page
//		utilobj.clickByAction(cfsmaster);
//
//		utilobj.clickByAction(clickOnExporter)
//		
//	}

	
	// Bank BRO Page opening 
	public void Go_To_Master_BankBRO() {
		utilobj.mouseOver(goToMasters);
		utilobj.mouseOver(goToParty);
		utilobj.clickByAction(bankBRO);
	}
	
	// CFS Master Page opening
	public void Goto_Masters_PartyCFSMaster() {

		utilobj.mouseOver(goToMasters);
		utilobj.mouseOver(goToParty);
		//CFS MAster Page
		utilobj.clickByAction(cfsmaster);
		
	}
	
	
	// IMO Master Page Opening Under Shipment Info
	public void GoTo_IMOMaster() {
		utilobj.mouseOver(goToMasters);
		utilobj.mouseOver(goToshipmentInfo);
		utilobj.clickByAction(goToIMOMaster);
	}
		



}
