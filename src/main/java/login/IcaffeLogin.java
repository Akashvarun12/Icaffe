package login;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webutil.WebUtil;

public class IcaffeLogin {

	private WebUtil utilobj;

	public IcaffeLogin(WebUtil utilobj) {
		this.utilobj = utilobj;
		PageFactory.initElements(utilobj.getDriver(), this);

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



	public void enterLoginCreadential(String userNamevalue,String Passwordvalue) {
		Properties pr = utilobj.propertiFile("browser_url_and_credential.properties");
		String userName = pr.getProperty("username");
		String password = pr.getProperty("password");
		
		utilobj.clear(usernameTB);
		utilobj.sendKeys(usernameTB, userName,userNamevalue);
		utilobj.clear(passwordTB);
		utilobj.sendKeys(passwordTB, password,Passwordvalue);
		
	}
	


	public void enterLoginCreadentialFromDataProvider(String userName, String password,String usernamevalue,String passwordvalue) {

		utilobj.clear(usernameTB);
		utilobj.sendKeys(usernameTB, userName,usernamevalue);
		utilobj.clear(passwordTB);
		utilobj.sendKeys(passwordTB, password,passwordvalue);
	}
	
	public void clickOnLoginBT() {

		utilobj.click(signinBT);
	}


	
}
