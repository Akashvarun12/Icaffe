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



	public void enterLoginCreadential() {
		
		
		Properties pr = utilobj.propertiFile("Akash_browser_url_and_credential.properties");
		String userName = pr.getProperty("username");
		String password = pr.getProperty("password");
		
		
		utilobj.clear(usernameTB,"User Name Textbox");
		utilobj.sendKeys(usernameTB, userName,"User Name Textbox");
		utilobj.clear(passwordTB,"Password Textbox");
		utilobj.sendKeys(passwordTB, password,"Password Textbox");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	


	public void enterLoginCreadentialFromDataProvider(String userName, String password,String usernamevalue,String passwordvalue) {

		utilobj.clear(usernameTB,"User Name Textbox");
		utilobj.sendKeys(usernameTB, userName,"User Name Textbox");
		utilobj.clear(passwordTB,"Password Textbox");
		utilobj.sendKeys(passwordTB, password,"Password Textbox");
	}
	
	public void clickOnLoginBT() {

		utilobj.click(signinBT,"Login Button");
	}


	
}
