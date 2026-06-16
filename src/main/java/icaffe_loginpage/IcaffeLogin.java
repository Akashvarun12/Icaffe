package icaffe_loginpage;

import java.util.Properties;

import org.openqa.selenium.Alert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import webutil.WebUtil;

public class IcaffeLogin {

	private WebUtil utilObj;
	protected static ExtentTest extObj;

	public IcaffeLogin(WebUtil utilObj, ExtentTest extObj) {
		this.utilObj = utilObj;
		this.extObj = extObj;
		PageFactory.initElements(utilObj.getDriver(), this);

	}

	@FindBy(xpath = "//input[@id='UserName']")
	private WebElement usernameTB;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTB;

	@FindBy(xpath = "//input[@id='LoginButton']")
	private WebElement signinBT;

	@FindBy(xpath = "//select[@name='login_theme']")
	private WebElement verifyLoginTheme;

	@FindBy(xpath = "//font[contains(text(),'You must specify a valid username and password.')]")
	private WebElement message;

	@FindBy(xpath = "//label[@id='UserTag']")
	private WebElement mouseOverOnLogOut;

	@FindBy(xpath = "//a[@id='lnkLogout']")
	private WebElement alreadyLoginText;

	@FindBy(xpath = "//a[@id='lnkLogout']")
	private WebElement logOut;

	public void enterLoginCreadential() {
		Properties proObj = WebUtil.propertiFile("Akash_CommonSelection_Login_BranchDivisionYear.properties");
		String userName = proObj.getProperty("userName");
		String password = proObj.getProperty("password");
		utilObj.clear(usernameTB, "User Name Textbox");
		utilObj.sendKeys(usernameTB, userName, "User Name Textbox");
		utilObj.clear(passwordTB, "Password Textbox");
		utilObj.sendKeys(passwordTB, password, "Password Textbox");

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterLoginCreadentialwithDataProvider(String userName, String password, String usernamevalue,
			String passwordvalue) {

		utilObj.clear(usernameTB, "User Name Textbox");
		utilObj.sendKeys(usernameTB, userName, "User Name Textbox");
		utilObj.clear(passwordTB, "Password Textbox");
		utilObj.sendKeys(passwordTB, password, "Password Textbox");

	}

	public void validateAlreadyLoginAlert() {

		SoftAssert softAssert = new SoftAssert();

		try {
			Alert alert = utilObj.getDriver().switchTo().alert();

			String actualText = alert.getText();

			if (actualText.equals("User Already Login.")) {

				alert.accept();

				extObj.log(Status.PASS, "Already Login alert displayed successfully. Message: " + actualText);

				softAssert.assertTrue(true, "Alert matched successfully");

			} else {

				alert.accept();

				extObj.log(Status.FAIL, "Alert displayed but text mismatch. Expected: 'User Already Login.' but found: "
						+ actualText + ". User should not be logged in.");

				softAssert.fail("Alert text mismatch: " + actualText);
			}

		} catch (Exception e) {

			extObj.log(Status.FAIL,
					"Expected 'User Already Login.' alert but user was allowed to login instead (no alert displayed).");

			softAssert.fail("No alert displayed. User was allowed to login instead.");
		}

	}

	public void clickOnLogOut() {

		utilObj.mouseOver(mouseOverOnLogOut, "Mouse Over On UserTag");
		utilObj.clickByAction(logOut, "Logout");
	}

	public void clickOnLoginBT() {

		utilObj.click(signinBT, "Login Button");
	}

}
