package branch_division;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import webutil.WebUtil;

public class LoginBranchDivision {

	private WebUtil utilobj;

	public LoginBranchDivision(WebUtil utilobj) {
		this.utilobj = utilobj;
		PageFactory.initElements(utilobj.getDriver(), this);
	}

	
	@FindBy(xpath = "//input[@id='txtBranch']")
	private WebElement enterBranch;

	@FindBy(xpath = "//input[@id='txtFinancialYear']")
	private WebElement enterFinancialYr;

	@FindBy(xpath = "//button[@id='ChooseButton']")
	private WebElement loginBranchOkButon;

	
	// Selecting Branch Name
	public void SelectBranch(String BraName) {
		
		utilobj.clear(enterBranch,"Branch Textbox");
		utilobj.sendKeys(enterBranch, "%","Branch Name Textbox");
		utilobj.getDriver()
				.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete')]//div[text()='" + BraName + "']"))
				.click();
		
	}

	
	// Selecting Division Radio button
	public void SelectDevision(String division) {

		utilobj.getDriver().findElement(By.xpath("//input[contains(@id,'" + division + "')]")).click();
	}

	// Selecting Financial Year
	public void SelectFinYear(String finYear) {
		utilobj.clear(enterFinancialYr,"Financial Year");
		utilobj.sendKeys(enterFinancialYr, "2026","Financial Year Textbox");
		utilobj.getDriver()
				.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete')]//div[text()='" + finYear + "']"))
				.click();

	}

	// Clicking on OK button
	public void clickOnOKButton() {
		utilobj.click(loginBranchOkButon,"Login_Branch_Division Ok Button");

	}
	
	
	// Validation of Branch, Division and Financial Year	  
	public String capitalize(String text) {    
		return text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase();	   
	}

	
	// Validation of Branch, Division and Financial Year	   
	public String getDivisionText(String division) {		        
		switch (division) {		            
		case "optExportAir": return "Export Air";		            
		case "optExportSea": return "Export Sea";		            
		case "optImportAir": return "Import Air";		            
		case "optImportSea": return "Import Sea";		            
		default: return division;		        
		}		    
	}
	
	// Validation of Branch, Division and Financial Year
	public String getFinYearShort(String finYear) {		     
		return "(" + finYear.replace("-", "").substring(2) + ")";		   
	}
	
	
	
}
