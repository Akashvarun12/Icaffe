package webutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.base.Functions;
import com.google.common.io.Files;



public class WebUtil {

	private WebDriver driver;
	private static ExtentReports extReport;
	private static ExtentTest extentTest;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void launchBrowser(String browser) {
		try {
			if (browser.equalsIgnoreCase("chromebrowser")) {
				setDriver(new ChromeDriver());
			} else if (browser.equalsIgnoreCase("edgebrowser")) {
				setDriver(new EdgeDriver());
			} else if (browser.equalsIgnoreCase("firefoxbrowser")) {
				setDriver(new FirefoxDriver());
			} else {
				System.out.println("Invalid browser: " + browser);
				return;
			}
			System.out.println(browser + " launched successfully");
			extentTest.log(Status.INFO, browser + " launched successfully");
			implicitlyWait();
		} catch (Exception e) {
			System.out.println("Failed to launch browser: " + browser);
			e.printStackTrace();
			extentTest.log(Status.FAIL, "Failed to launch browser: " + browser);
		}

		maxmize();
	}

	public static ExtentReports genrateExtentReport() {
		try {
			extReport = new ExtentReports();
			SimpleDateFormat simpDateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
			String timeStamp = simpDateFormat.format(new Date());
			File folderObj = new File("ICaffeResult");
			if (!folderObj.exists()) {
				folderObj.mkdir();
			}
			ExtentSparkReporter extSparkReport = new ExtentSparkReporter("ICaffeResult\\icaffe_" + timeStamp + ".html");
			extSparkReport.config().setTheme(Theme.DARK);
			extSparkReport.config().setReportName("Akash Varun");
			extReport.attachReporter(extSparkReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return extReport;
	}

	public ExtentTest generateExtentTest(String testName) {
		try {
			if (extReport == null) {
				genrateExtentReport();
			}
			extentTest = extReport.createTest(testName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return extentTest;
	}

	public void flush() {
		try {
			if (extReport != null) {
				extReport.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openURL(String URL) {
		try {
			getDriver().get(URL);
			System.out.println("URL opened successfully");
			extentTest.log(Status.INFO, URL + " opened successfully");

		} catch (Exception e) {
			e.printStackTrace();
			extentTest.log(Status.FAIL, "Failed to open URL: " + URL);
			extentTest.addScreenCaptureFromPath(takeScreenShot("OpenURL"));
		}
	}

	public void maxmize() {
		try {
			getDriver().manage().window().maximize();
			System.out.println("Window Maxmize successfully");
			extentTest.log(Status.INFO, "Maxmize Window successfully");

		} catch (Exception e) {
			e.printStackTrace();
			extentTest.log(Status.FAIL, "Failed to Maxmize Window: ");
			extentTest.addScreenCaptureFromPath(takeScreenShot("Maxmize Window"));
		}
	}

	public void close() {
		try {
			getDriver().close();
			extentTest.log(Status.INFO, "Closed page successfully");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to close page");
			e.printStackTrace();
		}
	}

	public void quit() {
		try {
			getDriver().quit();
			extentTest.log(Status.INFO, "Quit browser successfully");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to quit browser");
			e.printStackTrace();
		}
	}

	public void sendKeys(WebElement we, String value, String eleName) {
		try {
			we.sendKeys(value);
			System.out.println(value + " entered successfully");
			extentTest.log(Status.INFO, value + " entered successfully in " + eleName);

		} catch (Exception e) {
			extentTest.log(Status.FAIL, value + " send in " + eleName);
			extentTest.addScreenCaptureFromPath(takeScreenShot("SendKeys"));
			e.printStackTrace();
		}
	}

	public void clear(WebElement we, String eleName) {
		try {
			we.clear();
			System.out.println(eleName + " Cleared successfully");
			extentTest.log(Status.INFO, eleName + " Cleared text successfully");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to clear text in " + eleName);
			e.printStackTrace();
		}
	}

	public void click(WebElement we, String eleName) {
		try {
			we.click();
			System.out.println("Clicked successfully in " + eleName);
			extentTest.log(Status.INFO, "Clicked successfully in " + eleName);
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to click on " + eleName);
			e.printStackTrace();
		}
	}

	public String getText(WebElement we) {
		String elementText = "";
		try {
			elementText = we.getText();
			System.out.println(elementText + " Text fetched successfully");
			extentTest.log(Status.INFO, elementText + " Text fetched successfully");
			extentTest.addScreenCaptureFromPath(takeScreenShot("GetText"));
		} catch (Exception e) {
			extentTest.log(Status.FAIL, elementText + " Failed to get text");
			e.printStackTrace();
		}
		return elementText;
	}

	// validation of get title with valid and invalid data...
	public void validateGetTitle(String expTitle, String type, String elemName) {

		try {
			String actTitle = getDriver().getTitle();

			if (type.equalsIgnoreCase("valid")) {
				// valid case
				if (expTitle.equalsIgnoreCase(actTitle)) {
					extentTest.log(Status.PASS, "Title matches for: " + type + " " + elemName);
					extentTest.log(Status.PASS, "Expected: " + expTitle + " Title matches Actual: " + actTitle);
				} else {
					System.out.println("Failed: Title mismatch");
					extentTest.log(Status.FAIL, "Expected: " + expTitle + " Title not matches: " + actTitle);
					extentTest.addScreenCaptureFromPath(takeScreenShot("TitleMismatch"));
				}

			} else {
				// invalid case
				if (expTitle.equalsIgnoreCase(actTitle)) {
					extentTest.log(Status.PASS, " Title Mismatch for: " + type + " " + elemName);
					extentTest.log(Status.PASS, "Expected: " + expTitle + " Title Not Match Actual: " + actTitle
							+ " And User stayed on Same Page");

				} else {
					extentTest.log(Status.FAIL,
							"Expected: " + expTitle + " Title matches:and user redirected " + actTitle);
					extentTest.addScreenCaptureFromPath(takeScreenShot("InvalidCaseFailure"));
				}
			}

		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Exception in validateGetTitle: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void validateCurrentURL(String expURL) {
		try {
			String actURL = getDriver().getCurrentUrl();
			if (expURL.equalsIgnoreCase(actURL)) {
				System.out.println("Passed: URL matches");
				extentTest.log(Status.PASS, expURL + " URL matches: " + actURL);
			} else {
				System.out.println("Failed: URL mismatch");
				extentTest.log(Status.FAIL, expURL + " URL Not matches: " + actURL);
				extentTest.addScreenCaptureFromPath(takeScreenShot("URLMismatch"));
			}
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Exception in verifyCurrentURL");
			e.printStackTrace();
		}
	}

	public String getAttribute(WebElement we, String attributeValue) {
		String value = "";
		try {
			value = we.getAttribute(attributeValue);
			System.out.println("Attribute value fetched successfully");
			extentTest.log(Status.INFO, "Fetched attribute: " + attributeValue);
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to get attribute: " + attributeValue);
			e.printStackTrace();
		}
		return value;
	}

	public void validateTextValue(String actText, String expText) {
		try {
			if (expText.equalsIgnoreCase(actText)) {
				System.out.println("Passed: Text matches");
				extentTest.log(Status.PASS, expText + " Text matches: " + actText);
			} else {
				System.out.println("Failed: Text mismatch");
				extentTest.log(Status.FAIL, expText + " Text Not matches: " + actText);
				extentTest.addScreenCaptureFromPath(takeScreenShot("TextMismatch"));
			}
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Exception in verifyTextValue");
			e.printStackTrace();
		}
	}

	public WebElement verifyGetFirstSelectedOption(WebElement we) {
		WebElement selectedOption = null;
		try {
			Select selObj = new Select(we);
			selectedOption = selObj.getFirstSelectedOption();
			extentTest.log(Status.INFO, "Fetched selected option");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to get selected option");
			e.printStackTrace();
		}
		return selectedOption;
	}

	public void selectDropDownByText(WebElement we, String visibleText) {
		try {
			Select selObj = new Select(we);
			selObj.selectByVisibleText(visibleText);
			extentTest.log(Status.INFO, "Selected dropdown: " + visibleText);
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to select dropdown: " + visibleText);
			e.printStackTrace();
		}
	}

	public void implicitlyWait() {
		try {
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			System.out.println("Implicit wait applied");
			extentTest.log(Status.INFO, "Implicit wait applied");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to set implicit wait");
			e.printStackTrace();
		}
	}

	public void explicitlyWait(WebElement WeEle) {
		try {
			WebDriverWait visiviltyOfEle = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
			visiviltyOfEle.until(ExpectedConditions.visibilityOfAllElements(WeEle));
			System.out.println("Explicitly wait applied");
			extentTest.log(Status.INFO, "Explicitly wait applied");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to set Explicitly wait");
			e.printStackTrace();
		}
	}

	public String takeScreenShot(String testCaseImageName) {
		String path = "";
		try {
			DateFormat dFormat = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss");
			String timeStamp = dFormat.format(new Date());
			TakesScreenshot tssObj = (TakesScreenshot) driver;
			File sourceFile = tssObj.getScreenshotAs(OutputType.FILE);
			File folderObj = new File("SnapshotsFolder");
			if (!folderObj.exists()) {
				folderObj.mkdir();
			}
			File destinationFile = new File(folderObj, testCaseImageName + "_" + timeStamp + ".jpg");
			Files.copy(sourceFile, destinationFile);
			path = destinationFile.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public static Properties propertiFile(String propFile) {
		Properties properties = null;
		try {
			properties = new Properties();
			String path = System.getProperty("user.dir") + "/src/test/resources/" + propFile + "";
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
//	public class ConfigReader {
//	    public String getConfig(String key) {
//	        return configProps.getProperty(key);
//	    }
//	}
//	
//
//	    private static Properties configProps = new Properties();
//
//	    static {
//	        try (InputStream is = ConfigReader.class
//	                .getClassLoader()
//	                .getResourceAsStream("config.properties")) {
//
//	            configProps.load(is);
//
//	        } catch (Exception e) {
//	            throw new RuntimeException(e);
//	        }
//	    }
//
//	    public static String getConfig(String key) {
//	        return configProps.getProperty(key);
//	    }
//	


	public void mouseOver(WebElement weEle, String eleName) {
		Actions actbj = new Actions(driver);
		try {
			actbj.moveToElement(weEle).build().perform();
			extentTest.log(Status.INFO, "Mouse Over Succsessfully on " + eleName);
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Mouse Over Fail on " + eleName);
			e.printStackTrace();
		}
	}

	public void clickByAction(WebElement ele, String eleName) {
		Actions actbj = new Actions(driver);
		try {
			actbj.click(ele).build().perform();
			extentTest.log(Status.INFO, "Clicked Succsessfully on " + eleName + " by Action");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Clicked Failed on " + eleName + " by Action");
			e.printStackTrace();
		}

	}

	public void clickByAction(String eleName) {
		Actions actbj = new Actions(driver);
		try {
			actbj.click().build().perform();
			extentTest.log(Status.INFO, "Clicked Succsessfully on " + eleName + " by Action");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Clicked Failed on " + eleName + " by Action");
			e.printStackTrace();
		}

	}

	public void sendkeyByAction(WebElement ele, String input, String eleName) {
		Actions actbj = new Actions(driver);
		try {
			actbj.sendKeys(input).build().perform();
			extentTest.log(Status.INFO, input + " Send Succsessfully on " + eleName + " by Action");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, " Send Fail on " + eleName + " by Action");
			e.printStackTrace();
		}

	}

	public List<String> getListOfText(List<WebElement> listOfWebEle) {
		List<String> strList = new ArrayList<>();
		try {
			for (WebElement webEle : listOfWebEle) {
				String textList = webEle.getText();
				extentTest.log(Status.INFO, textList + " List of Element Fetch successfully");
				System.out.println("List of Element Details Fetch successfully - " + textList);
				strList.add(textList);
			}
		} catch (Exception e) {
			extentTest.log(Status.INFO, " List of Element not Fetch successfully");
			e.printStackTrace();
		}
		return strList;
	}

	public void validateListOfText(List<WebElement> weActualList, List<String> expectedList) {

		List<String> actualList = getListOfText(weActualList);

		try {
			Assert.assertEquals(actualList, expectedList);
			extentTest.pass("List matched successfully");
			extentTest.pass("Actual List: " + actualList + " ↓ ");
			extentTest.pass(" Matches ↑ Expected List: " + expectedList);
		} catch (AssertionError e) {
			extentTest.fail("List mismatch");
			extentTest.fail("Actual: " + actualList);
			extentTest.fail("Expected: " + expectedList);
			throw e;
		}
	}

}
