package icaffe_homepage;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import webutil.WebUtil;

public class Homepage {

	private WebUtil utilobj;

	public Homepage(WebUtil utilobj) {
		this.utilobj = utilobj;
		PageFactory.initElements(utilobj.getDriver(), this);
	}

	// Master Heading
	@FindBy(xpath = "//a[text()='Masters ']")
	private WebElement goToMasters;

	// Party under Master
	@FindBy(xpath = "//a[text()='Party ']")
	private WebElement goToParty;

	@FindBy(xpath = "//a[text()='Exporter']")
	private WebElement clickOnExporter;
	
	// Bank BRO Page opening
	@FindBy(xpath = "//a[text() = 'Bank BRO']")
	private WebElement clickOnBankBRO ;
		
		
	// CFS Master Page opening 
	@FindBy(xpath = "//a[text() = 'CFS Master']")
	private WebElement clickOnCFSMaster ;
		
		
	// Going To Shipment Info under Master.
	@FindBy(xpath = "//a[text()= 'Shipment Info '] ")
	WebElement goToShipmentInfo ;
		
		
	// Going To IMO Master Page under Shipment Info
	@FindBy(xpath = "//a[text()='IMO Master']")
	WebElement clickOnIMOMaster ;
	
	
	// Going to Unit Master Page under Shipment Info
	@FindBy(xpath = "//a[text()='UNIT Master']")
	WebElement clickOnUnitMaster ;
	
	
	// Going To CHA Service Page under Shipment Info
	@FindBy(xpath = "//a[text()='CHA Service']")
	WebElement clickOnCHAService ;
	
	
	// Regional Master under Master
	@FindBy(xpath = "//a[text()='Regional Master ']")
	WebElement goToRegionalMaster ;
	
	
	// Zone Master under Regional Master
	@FindBy(xpath = "//a[text()='Zone Master']")
	WebElement clickOnZoneMaster ;
	
	
	// Region Master under Regional Master
	@FindBy(xpath = "//a[text()='Region Master']")
	WebElement clickOnRegionMaster ;
	
	
	// Cose Center Master Page
	@FindBy(xpath = "//a[text()='Cost Center Master']")
	WebElement clickOnCostCenterMaster ;
	
	
	// Period Master Page
	@FindBy(xpath = "//a[text()='Period Master']")
	WebElement clickOnPeriodMaster ;
	
	
	// Action Master Page
	@FindBy(xpath = "//a[text()='Action Master']")
	WebElement clickOnActionMaster ;
	
	
	// Country Master Page
	@FindBy(xpath = "//a[text()='Country Master']")
	WebElement clickOnCountryMaster ;
	
	// FF Port Master Page
	@FindBy(xpath = "//a[text()='FF PORT MASTER']")
	WebElement clickOnffPortMaster ;
	
	// Misc Master Under Master
	@FindBy(xpath = "//a[text()='Misc Master ']")
	WebElement goToMiscMaster ;
	
	// Segment Master Page Under Misc Master
	@FindBy(xpath = "//a[text()='Segment Master']")
	WebElement clickOnSegmentMaster ;
	
	// Trigger Master Page Under Misc Master	
	@FindBy(xpath = "//a[text()='Trigger Master']")
	WebElement clickOnTriggerMaster ;
	
	// Principle Line HBL Master Page Under Misc Master
	@FindBy(xpath = "//a[text()= 'Principle Line HBL Master']")
	WebElement clickOnPrincipleLineHBLMaster ;
	
	// Project Type Master Page Under Misc Master
	@FindBy(xpath = "//a[text()='Project Type Master']")
	WebElement clickOnprojectTypeMaster ;
	
	
	// Notes, Terms & Condition Master PAge under Misc Master
	@FindBy(xpath = "//a[text()='Notes,Terms & Conditions']")
	WebElement clickOnNotesMaster ;
	
	// Stuffing Master Page Under Master
	@FindBy(xpath = "//a[text()='StuffingMaster']")
	WebElement clickOnStuffingMaster ;
	
	// Destuffing Page Under Master
	@FindBy(xpath = "//a[text()='DeStuffing']")
	WebElement clickOnDestuffing ;
	
	// Document Page Under Master
	@FindBy(xpath = "//a[text()='Document']")
	WebElement clickOnDocument ;
	
	
	// Charge Master under Master
	@FindBy(xpath = "//a[text()='Charge Master '] ")
	WebElement clickOnChargeMaster ;
	
	// Pricing Master under Charge Master
	@FindBy(xpath = "//a[text()='Pricing']")
	WebElement clickOnPricing ;
	
	// logout dropdown 
	@FindBy(xpath = "//label[@id='UserTag']")
	WebElement logoutDropdown ;
		
		
	// Logout button
	@FindBy(xpath = "//a[@id='lnkLogout']")
	WebElement logoutBtn ;
	
	
	@FindBys(@FindBy(xpath = "//label[@id='UserTag']//span[not(contains(text(),'Welcome'))]"))
	private List<WebElement> listOfWebEle;
	

	
	public void getText_LoginBranchDivision_OnHomePage(List<String> expectedList) {
		utilobj.validateListOfText(listOfWebEle,expectedList);	 
	}
	
	
	
	public List<String> verifyLoginBranchDivision_OnHomePage() {
		 List<String> actualList = utilobj.getListOfText(listOfWebEle);
    return actualList;
	}
	
	
	// Page Logout Function
	public void logout() {
		utilobj.mouseOver(logoutDropdown, "Page Logout");
		utilobj.clickByAction(logoutBtn, "Logout Button");
	}
	
	
	
	
	public void Goto_Masters_PartyExporter() {
		utilobj.mouseOver(goToMasters,"Masters");
		utilobj.mouseOver(goToParty,"Party");
		utilobj.explicitlyWait(goToParty);
		utilobj.clickByAction(clickOnExporter,"Exporter");		
	}
	
	
	
	// Bank BRO Page opening 
	public void goToBankBROPage() {	
		utilobj.mouseOver(goToMasters, "Master");			
		utilobj.mouseOver(goToParty, "Party");			
		utilobj.clickByAction(clickOnBankBRO, "Bank BRO Page");		
	}
		
		
	// CFS Master Page opening	
	public void goToCFSMasterPage() {			
		utilobj.mouseOver(goToMasters, "Master");			
		utilobj.mouseOver(goToParty, "Party");				
		utilobj.clickByAction(clickOnCFSMaster, "CFS Master Page");		
	}
		
		
		
	// IMO Master Page Opening Under Shipment Info	
	public void goToIMOMasterPage() {	
		utilobj.mouseOver(goToMasters, "Master");			
		utilobj.mouseOver(goToShipmentInfo, "Shipment Info");			
		utilobj.clickByAction(clickOnIMOMaster, "IMO Master Page");		
	}
	
	
	// Unit Master Page Opening Under Shipment Info
	public void goToUnitMasterPage() {
		utilobj.mouseOver(goToMasters, "Master");
		utilobj.mouseOver(goToShipmentInfo, "Shipment Info");
		utilobj.clickByAction(clickOnUnitMaster, "Unit Master Page");
	}
	
	
	
	// CHA Service Page Opening Under Shipment Info
	public void goToCHAServicePage() {
		utilobj.mouseOver(goToMasters, "Master");
		utilobj.mouseOver(goToShipmentInfo, "Shipment Info");
		utilobj.clickByAction(clickOnCHAService, "CHA Service Page");
	}
	
	
	// Zone Master page opening under the Regional Master
	public void goToZoneMasterPage() {
		utilobj.mouseOver(goToMasters, "Master");
		utilobj.mouseOver(goToRegionalMaster, "Regional Master");
		utilobj.clickByAction(clickOnZoneMaster, "Zone Master page");	
	}
	
	// Region Master page opening under the Regional Master
	public void goToRegionMasterPage() {
		utilobj.mouseOver(goToMasters, "Master");
		utilobj.mouseOver(goToRegionalMaster, "Regional Master");
		utilobj.clickByAction(clickOnRegionMaster, "Region Master Page");
	}

	
	
	// Cost Center Master page opening under the Regional Master
	public void goToCostCenterMasterPage() {
		utilobj.mouseOver(goToMasters, "Master");
		utilobj.mouseOver(goToRegionalMaster, "Regional Master");
		utilobj.clickByAction(clickOnCostCenterMaster, "Cost Center Master Page");		
	}
	
	
	
	// Period Master page opening under the Regional Master
	public void goToPeriodMasterPage() {	
		utilobj.mouseOver(goToMasters, "Master");	
		utilobj.mouseOver(goToRegionalMaster, "Regional Master");	
		utilobj.clickByAction(clickOnPeriodMaster, "Period Master Page");			
	}
	
	
	// Action Master page opening under the Regional Master
	public void goToActionMasterPage() {	
		utilobj.mouseOver(goToMasters, "Master");		
		utilobj.mouseOver(goToRegionalMaster, "Regional Master");		
		utilobj.clickByAction(clickOnActionMaster, "Period Master Page");				
	}
	
	
	// Country Master page opening under the Regional Master	
	public void goToCountryMasterPage() {		
		utilobj.mouseOver(goToMasters, "Master");				
		utilobj.mouseOver(goToRegionalMaster, "Regional Master");			
		utilobj.clickByAction(clickOnCountryMaster, "Country Master Page");				
	}
	
	
	// FF Port Master page opening under the Regional Master		
	public void goToFFPortMasterPage() {			
		utilobj.mouseOver(goToMasters, "Master");				
		utilobj.mouseOver(goToRegionalMaster, "Regional Master");			
		utilobj.clickByAction(clickOnffPortMaster, "FF Port Master Page");				
		}
	
	
	// Segment Master page opening under the Misc Master			
	public void goToSegmentMasterPage() {				
		utilobj.mouseOver(goToMasters, "Master");					
		utilobj.mouseOver(goToMiscMaster, "Misc Master");				
		utilobj.clickByAction(clickOnSegmentMaster, "Segment Master Page");					
	}
	
	
	// Trigger Master page opening under the Misc Master				
	public void goToTriggerMasterPage() {						
		utilobj.mouseOver(goToMasters, "Master");						
		utilobj.mouseOver(goToMiscMaster, "Misc Master");						
		utilobj.clickByAction(clickOnTriggerMaster, "Trigger Master Page");						
	}
	
	
	// Notes, Terms & Condition Master Page under Misc Master Page
	public void goToNotesMaster() {
		utilobj.mouseOver(goToMasters, "Master");						
		utilobj.mouseOver(goToMiscMaster, "Misc Master");						
		utilobj.clickByAction(clickOnNotesMaster, "Notes, Terms & Consition Master Page");
	}
	
	
	// Principle Line HBL Master Page under Misc Master Page
	public void goToPrincipleLineHBLMaster() {	
		utilobj.mouseOver(goToMasters, "Master");							
		utilobj.mouseOver(goToMiscMaster, "Misc Master");						
		utilobj.clickByAction(clickOnPrincipleLineHBLMaster, "Principle Line HBL Master Master Page");
	}
	
	
	// Principle Line HBL Master Page under Misc Master Page	
	public void goToProjectTypeMaster() {		
		utilobj.mouseOver(goToMasters, "Master");								
		utilobj.mouseOver(goToMiscMaster, "Misc Master");							
		utilobj.clickByAction(clickOnprojectTypeMaster, "Project Type Master Page");	
	}
	
	
	// Stuffing Master Page under Master
	public void goToStuffingMaster() {
		utilobj.mouseOver(goToMasters, "Master");
		utilobj.clickByAction(clickOnStuffingMaster, "Stuffing Master Page");
	}
	
	
	// Destuffing Page under Master
	public void goToDestuffing() {	
		utilobj.mouseOver(goToMasters, "Master");	
		utilobj.clickByAction(clickOnDestuffing, "Destuffing Master Page");
	}
	
	
	// Document Page under Master	
	public void goToDocument() {		
		utilobj.mouseOver(goToMasters, "Master");		
		utilobj.clickByAction(clickOnDocument, "Document Page");
	}
	
	
	// Pricing under Charge Master
	public void goToPricing() {
		utilobj.mouseOver(goToMasters, "Master");
		utilobj.mouseOver(clickOnChargeMaster, "Charge Master");
		utilobj.clickByAction(clickOnPricing, "Pricing Master");
	}

}
