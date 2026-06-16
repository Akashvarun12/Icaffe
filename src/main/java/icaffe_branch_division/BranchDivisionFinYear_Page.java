package icaffe_branch_division;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import webutil.WebUtil;

public class BranchDivisionFinYear_Page {

	private WebUtil utilobj;
	private ExtentTest extObj;

	public BranchDivisionFinYear_Page(WebUtil utilobj, ExtentTest extObj) {
		this.utilobj = utilobj;
		this.extObj = extObj;
		PageFactory.initElements(utilobj.getDriver(), this);

	}

	@FindBys(@FindBy(xpath = "//ul[@id='ui-id-1']//li"))
	private List<WebElement> listOfBranchText;
	
	@FindBy(xpath = "//input[@id='txtBranch']")
	private WebElement enterBranch;
	
	@FindBy(xpath = "//ul[@id='ui-id-2']//li")
	private List<WebElement> listOfYearText;

	@FindBy(xpath = "//input[@id='txtFinancialYear']")
	private WebElement enterFinancialYr;

	@FindBy(xpath = "//button[@id='ChooseButton']")
	private WebElement loginBranchOkButon;

	public void SelectBranch(String expBranchName) {
		utilobj.clear(enterBranch, "Branch Name textbox");
		utilobj.selectAutoSuggestOption(listOfBranchText,enterBranch, "%", "Branch Name Textbox", expBranchName);
	}

	public void SelectDevision(String division) {
		try {
			utilobj.getDriver().findElement(By.xpath("//input[contains(@id,'" + division + "')]")).click();

			extObj.log(Status.INFO, division + " selected successfully");

		} catch (Exception e) {
			extObj.log(Status.FAIL, "Failed to select division: " + division);
			
		}
	}
	

	public void SelectFinYear(String finYear) {
		utilobj.clear(enterFinancialYr, "Financial Year Textbox");
		utilobj.selectAutoSuggestOption(listOfYearText,enterFinancialYr, "20", "Financial Year Textbox", finYear);
	}

	public void clickOnOKButton() {

		utilobj.click(loginBranchOkButon, "Login_Branch_Division Ok Button");

	}
}
