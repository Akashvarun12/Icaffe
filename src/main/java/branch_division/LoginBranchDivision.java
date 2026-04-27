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

	public void SelectBranch(String BraName) {
		
		utilobj.clear(enterBranch);
		utilobj.sendKeys(enterBranch, "%");
		utilobj.getDriver()
				.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete')]//div[text()='" + BraName + "']"))
				.click();
	}

	public void SelectDevision(String division) {

		utilobj.getDriver().findElement(By.xpath("//input[contains(@id,'" + division + "')]")).click();
	}

	public void SelectFinYear(String finYear) {

		utilobj.clear(enterFinancialYr);
		utilobj.sendKeys(enterFinancialYr, "202");

		utilobj.getDriver()
				.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete')]//div[text()='" + finYear + "']"))
				.click();

	}

	public void clickOnOKButton() {

		utilobj.click(loginBranchOkButon);

	}
}
