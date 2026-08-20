package login;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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



	// Sending login data By using Properties files
	public void enterLoginCreadential() {
		Properties pr = utilobj.propertiFile("Shivam_browser_url_and_credential.properties");
	    String userName = pr.getProperty("username");
	    String password = pr.getProperty("password");
	    utilobj.clear(usernameTB, "User Name Textbox");
	    utilobj.sendKeys(usernameTB, userName, "User Name Textbox");
	    utilobj.clear(passwordTB, "Password Textbox");
	    utilobj.sendKeys(passwordTB, password, "Password Textbox");
	    WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(signinBT));
	}
	


	public void enterLoginCreadentialFromDataProvider(String userName, String password,String usernamevalue,String passwordvalue) {
		utilobj.clear(usernameTB,"User Name Textbox");
		utilobj.sendKeys(usernameTB, userName,"User Name Textbox");
		utilobj.clear(passwordTB,"Password Textbox");
		utilobj.sendKeys(passwordTB, password,"Password Textbox");
		WebDriverWait wait = new WebDriverWait(utilobj.getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(signinBT));

		
	}
	
	
	public void clickOnLoginBT() throws Exception {
	    utilobj.explicitlyWait(signinBT);
	    utilobj.click(signinBT, "Login Button");
	}


	
}
