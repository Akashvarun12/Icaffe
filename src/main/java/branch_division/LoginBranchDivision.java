package branch_division;



import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import webutil.WebUtil;

public class LoginBranchDivision {

	private WebUtil utilobj;
	private ExtentTest extObj;

	public LoginBranchDivision(WebUtil utilobj,ExtentTest extObj) {
		this.utilobj = utilobj;
		this.extObj = extObj;
		PageFactory.initElements(utilobj.getDriver(), this);

	}

	@FindBy(xpath = "//input[@id='txtBranch']")
	private WebElement enterBranch;

	@FindBy(xpath = "//input[@id='txtFinancialYear']")
	private WebElement enterFinancialYr;

	@FindBy(xpath = "//button[@id='ChooseButton']")
	private WebElement loginBranchOkButon;
	
	@FindBys(@FindBy(xpath="//ul[contains(@class,'ui-autocomplete')]//div"))
	List<WebElement> branchDivisionYearListandfinYear;
	
//	@FindBys(@FindBy(xpath="//ul[contains(@class,'ui-autocomplete')]//div"))
//	List<WebElement> finYearList;
	
	public void SelectBranch(String expBranchName) {
		utilobj.clear(enterBranch, "Branch Name textbox");
		utilobj.selectAutoSuggestOption(enterBranch, branchDivisionYearListandfinYear, "%", expBranchName, "Branch Name Textbox");
}
	

//	public void SelectBranch(String BraName) {
//	    try {
//	        utilobj.clear(enterBranch, "Branch Textbox");
//	        utilobj.sendKeys(enterBranch, "%", "Branch Name Textbox");
//
//	        utilobj.getDriver()
//	                .findElement(By.xpath("//ul[contains(@class,'ui-autocomplete')]//div[text()='" + BraName + "']"))
//	                .click();
//
//	        extObj.log(Status.INFO, BraName + " selected successfully");
//
//	    } catch (Exception e) {
//	        extObj.log(Status.FAIL, "Failed to select branch: " + BraName);
//	        extObj.log(Status.FAIL, "Exception: " + e.getMessage());
//	    }
//	}

	public void SelectDevision(String division) {
	    try {
	        utilobj.getDriver()
	                .findElement(By.xpath("//input[contains(@id,'" + division + "')]"))
	                .click();

	        extObj.log(Status.INFO, division + " selected successfully");

	    } catch (Exception e) {
	        extObj.log(Status.FAIL, "Failed to select division: " + division);
	        extObj.log(Status.FAIL, "Exception: " + e.getMessage());
	    }
	}
	
	public void SelectFinYear(String finYear) {
		utilobj.clear(enterFinancialYr, "Financial Year Textbox");
		utilobj.selectAutoSuggestOption(enterFinancialYr, branchDivisionYearListandfinYear, "%", finYear, "Branch Name Textbox");
}

//	public void SelectFinYear(String finYear) {
//	    try {
//	        utilobj.clear(enterFinancialYr, "Financial Year");
//	        utilobj.sendKeys(enterFinancialYr, "202", "Financial Year Textbox");
//
//	        utilobj.getDriver()
//	                .findElement(By.xpath("//ul[contains(@class,'ui-autocomplete')]//div[text()='" + finYear + "']"))
//	                .click();
//
//	        extObj.log(Status.INFO, finYear + " selected successfully");
//
//	    } catch (Exception e) {
//	        extObj.log(Status.FAIL, "Failed to select financial year: " + finYear);
//	        extObj.log(Status.FAIL, "Exception: " + e.getMessage());
//	    }
//	}

	public void clickOnOKButton() {

		utilobj.click(loginBranchOkButon,"Login_Branch_Division Ok Button");

	}
}
