package login;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webutil.WebUtil;

public class IcaffeLogin {

	private WebUtil utilObj;

	public IcaffeLogin(WebUtil utilObj) {
		this.utilObj = utilObj;
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
	private WebElement logOut; 

	public void enterLoginCreadential() {
		Properties proObj = WebUtil.propertiFile("Akash_CommonSelection_Login_BranchDivisionYear.properties");
		String userName = proObj.getProperty("userName");
		String password = proObj.getProperty("password");
		
		utilObj.clear(usernameTB,"User Name Textbox");
		utilObj.sendKeys(usernameTB, userName,"User Name Textbox");
		utilObj.clear(passwordTB,"Password Textbox");
		utilObj.sendKeys(passwordTB, password,"Password Textbox");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	


	public void enterLoginCreadential(String userName, String password,String usernamevalue,String passwordvalue) {

		utilObj.clear(usernameTB,"User Name Textbox");
		utilObj.sendKeys(usernameTB, userName,"User Name Textbox");
		utilObj.clear(passwordTB,"Password Textbox");
		utilObj.sendKeys(passwordTB, password,"Password Textbox");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnLogOut() {

		utilObj.mouseOver(mouseOverOnLogOut, "Mouse Over On UserTag");
		utilObj.clickByAction(logOut,"Logout");
	}
	
	public void clickOnLoginBT() {

		utilObj.click(signinBT,"Login Button");
	}


	
}
