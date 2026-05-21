package webutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Properties;

import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.google.common.io.Files;

public class WebUtil {

	private WebDriver driver;
	private static ExtentReports extReport;
	private static ExtentTest extentTest;

	// Returns current WebDriver instance
	public WebDriver getDriver() {
		return driver;
	}

	// Sets WebDriver instance
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	// Launches browser based on browser name (Chrome, Edge, Firefox)
	public void launchBrowser(String browser) {

		try {
			if (browser.equalsIgnoreCase("chromebrowser")) {
//				  ChromeOptions options = new ChromeOptions();
//
//		            options.addArguments("--remote-allow-origins=*");
//		            options.addArguments("--headless=new");
//		            options.addArguments("--disable-gpu");
//		            options.addArguments("--no-sandbox");
//		            options.addArguments("--window-size=1366,768");

				setDriver(new ChromeDriver());
			} else if (browser.equalsIgnoreCase("edgebrowser")) {

//				  EdgeOptions options= new EdgeOptions();
//
//		            options.addArguments("--remote-allow-origins=*");
//		            options.addArguments("--headless=new");
//		            options.addArguments("--disable-gpu");
//		            options.addArguments("--no-sandbox");
//		            options.addArguments("--window-size=1366,768");
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
	
	public static ExtentReports genrateExtentReport(String reportType) {

	    try {
	        extReport = new ExtentReports();

	        SimpleDateFormat simpDateFormat =
	                new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");

	        String timeStamp = simpDateFormat.format(new Date());

	        File folderObj = new File("ExtentReport");

	        if (!folderObj.exists()) {
	            folderObj.mkdir();
	        }

	        String reportPath = "ExtentReport\\"
	                + reportType + "_"
	                + timeStamp + ".html";

	        ExtentSparkReporter extSparkReport =
	                new ExtentSparkReporter(reportPath);

	        extSparkReport.config().setTheme(Theme.DARK);
	        extSparkReport.config().setReportName("Akash varun");

	        extReport.attachReporter(extSparkReport);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return extReport;
	}

//	// Generates Extent Report with timestamp report file
//	public static ExtentReports genrateExtentReport() {
//		try {
//			extReport = new ExtentReports();
//			SimpleDateFormat simpDateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
//			String timeStamp = simpDateFormat.format(new Date());
//			File folderObj = new File("ICaffeResult");
//			if (!folderObj.exists()) {
//				folderObj.mkdir();
//			}
//			ExtentSparkReporter extSparkReport = new ExtentSparkReporter("ICaffeResult\\icaffe_" + timeStamp + ".html");
//			extSparkReport.config().setTheme(Theme.DARK);
//			extSparkReport.config().setReportName("Akash Varun");
//			extReport.attachReporter(extSparkReport);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return extReport;
//	}

	// Creates ExtentTest for logging test execution
	public ExtentTest generateExtentTest(String testName,String reportType) {
		try {
			if (extReport == null) {
				genrateExtentReport(reportType);
			}
			extentTest = extReport.createTest(testName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return extentTest;
	}

	// Flushes and saves Extent Report
	public void flush() {
		try {
			if (extReport != null) {
				extReport.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Opens application URL in browser
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

	// Maximizes browser window
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

	// Closes current browser tab/window
	public void close() {
		try {
			getDriver().close();
			extentTest.log(Status.INFO, "Closed page successfully");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to close page");
			e.printStackTrace();
		}
	}

	// Quits complete browser session
	public void quit() {
		try {
			getDriver().quit();
			extentTest.log(Status.INFO, "Quit browser successfully");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to quit browser");
			e.printStackTrace();
		}
	}

	// Sends input value into text field
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

	// Clears existing text from input field
	public void clear(WebElement we, String eleName) {
		try {
			we.clear();
			System.out.println(eleName + " Cleared successfully");
			extentTest.log(Status.INFO, eleName + " Cleared successfully");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to clear text in " + eleName);
			e.printStackTrace();
		}
	}

	// Clicks on web element
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

	// Fetches visible text from web element
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

	// Validates page title for login scenarios (Valid/Invalid credentials)
	public void validateTitleForLoginPages(String expTitle, String type) {

		try {
			String actTitle = getDriver().getTitle();

			if (type.equalsIgnoreCase("Valid Credential")) {
				// valid case
				if (expTitle.equalsIgnoreCase(actTitle)) {
					extentTest.log(Status.PASS, "Title matches for: " + type);
					extentTest.log(Status.PASS, "Expected: " + expTitle + " Title matches Actual: " + actTitle);
				} else {
					System.out.println("Failed: Title mismatch");
					extentTest.log(Status.FAIL, "Expected: " + expTitle + " Title not matches: " + actTitle);
					extentTest.addScreenCaptureFromPath(takeScreenShot("TitleMismatch"));
				}

			} else {
				// invalid case
				if (expTitle.equalsIgnoreCase(actTitle)) {
					extentTest.log(Status.PASS, " Title Mismatch for: " + type);
					extentTest.log(Status.PASS, "Expected: " + expTitle + " Title Match Actual: " + actTitle
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

	// validation of get title with valid ... Ex- For All Page
	public void validateTitleForAllPages(ITestContext context) {
		String expTitle = context.getCurrentXmlTest().getParameter("expTitle");
		try {

			String actTitle = getDriver().getTitle();

			if (expTitle.equalsIgnoreCase(actTitle)) {

				extentTest.log(Status.PASS, "Page validated successfully");

				extentTest.log(Status.PASS, "Expected Title: " + expTitle + " | Actual Title: " + actTitle);

			} else {

				extentTest.log(Status.FAIL, "Page validation failed");

				extentTest.log(Status.FAIL, "Expected Title: " + expTitle + " | Actual Title: " + actTitle);

				extentTest.addScreenCaptureFromPath(takeScreenShot("PageValidationFail"));
			}

		} catch (Exception e) {

			extentTest.log(Status.FAIL, "Exception in validatePage: " + e.getMessage());

			e.printStackTrace();
		}
	}

	// Validates current page URL
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

	// Fetches attribute value from web element
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

	// Validates expected text with actual web element text
	public void validateTextValue(WebElement we, String expText) {

		String actText = getText(we);
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

	// Fetches first selected option from dropdown
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

	// Selects dropdown option using visible text
	public void selectDropDownByText(WebElement we, String visibleText) {
		try {
			Select selObj = new Select(we);

			if (!selObj.isMultiple()) {
				selObj.selectByVisibleText(visibleText);
			} else {
				selObj.selectByVisibleText(visibleText); // works for multi also
			}

			extentTest.log(Status.INFO, "Selected dropdown: " + visibleText);

		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to select dropdown: " + visibleText);
			extentTest.log(Status.FAIL, "Exception: " + e.getMessage());
		}
	}

	// Applies implicit wait globally
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

	// Applies explicit wait until element becomes visible
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

	// Accepts browser alert popup
	public void alertHandleAccept() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();

			extentTest.log(Status.INFO, "Alert handled successfully");

		} catch (TimeoutException e) {
			extentTest.log(Status.WARNING, "No alert appeared to handle");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to handle alert: " + e.getMessage());
		}
	}

	// Validates alert popup text and accepts alert
	public void alertTextValidation(String expectedText) {

		try {
			// Wait until alert is present (prevents NoAlertPresentException)
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			// Get actual alert text
			String actualText = alert.getText().trim();

			// Validate alert text
			if (actualText.equalsIgnoreCase(expectedText.trim())) {
				extentTest.log(Status.PASS,
						"Alert text matched successfully. Expected: " + expectedText + " | Actual: " + actualText);
			} else {
				extentTest.log(Status.FAIL,
						"Alert text mismatch. Expected: " + expectedText + " | Actual: " + actualText);
			}

			// Optional: accept alert after validation (recommended)
			alert.accept();

		} catch (TimeoutException e) {
			extentTest.log(Status.WARNING, "No alert appeared within timeout");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Exception while handling alert: " + e.getMessage());
		}
	}

	// Captures screenshot and returns screenshot path
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

	// Reads data from properties file
	public static Properties propertiFile(String fileName) {
		Properties properties = new Properties();

		try {
			String path = System.getProperty("user.dir") + "/src/test/resources/" + fileName;

			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

	// Performs mouse hover action on element
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

	// Performs click action using Actions class
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

	// Performs generic click using Actions class
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

	// Sends keyboard input using Actions class
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

	// Scrolls page until element becomes visible
	public void scrollByAction(WebElement ele) {
		Actions actbj = new Actions(driver);
		try {
			actbj.scrollToElement(ele).build().perform();
			extentTest.log(Status.INFO, "Scroll Succsessfully on Element");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Scroll not Succsessfully on Element");
			e.printStackTrace();
		}

	}

	// Fetches list of text from multiple web elements
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

	// Validates actual list with expected list
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

	// Selects option from auto-suggestion dropdown
	public void selectAutoSuggestOption(List<WebElement> options, WebElement weSendKeys, String sendValue,
			String eleName, String valueToSelect) {
		try {
			// Step 1: Type value
			sendKeys(weSendKeys, sendValue, eleName);

			// Step 2: Wait until list is visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfAllElements(options));

			// Step 3: Iterate and match
			for (WebElement option : options) {
				String text = option.getText().trim();

				if (text.equalsIgnoreCase(valueToSelect)) {
					option.click();
					extentTest.pass(text + " selected successfully in: " + eleName);
					return;
				}
			}

			// Step 4: Not found
			extentTest.fail("Option not found: " + valueToSelect + " in " + eleName);
			throw new RuntimeException("Option not found: " + valueToSelect);

		} catch (Exception e) {
			extentTest.fail("Failed to select option: " + valueToSelect + " in " + eleName);
			extentTest.fail("Exception: " + e.getMessage());
		}
	}

	// Selects value from search result grid/table
	public void selectOptionFromSearch(String eleName, String valueToSelect) {
		try {

			List<WebElement> options = driver.findElements(By.xpath(
					"//img[contains(@src,'accept.png')]/ancestor::td/following-sibling::td[@class='x-grid3-col x-grid3-cell x-grid3-td-2 ']"));

			// Step 2: Wait until list is visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfAllElements(options));

			// Step 3: Iterate and match
			for (WebElement option : options) {
				String text = option.getText().trim();

				if (text.equalsIgnoreCase(valueToSelect)) {
					WebElement weClick = driver.findElement(
							By.xpath("//div[text()='" + text + "']/parent::td/preceding-sibling::td//div//img"));
					weClick.click();

					extentTest.pass(text + " selected successfully in: " + eleName);
					return;
				}
			}

			// Step 4: Not found
			extentTest.fail("Option not found: " + valueToSelect + " in " + eleName);
			throw new RuntimeException("Option not found: " + valueToSelect);

		} catch (Exception e) {
			extentTest.fail("Failed to select option: " + valueToSelect + " in " + eleName);
			extentTest.fail("Exception: " + e.getMessage());
		}
	}

	// Fetches and prints table data into Extent Report
	public void printTableData() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		List<WebElement> rows = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@class='x-grid3-viewport'])[1]//div//tr")));

		StringBuilder tableHtml = new StringBuilder();

		tableHtml.append("<table border='1' style='border-collapse:collapse; width:50%;'>");
		tableHtml.append("<tr style='background-color:#D3D3D3;'>");
		tableHtml.append("<th>Column 3</th>");
		tableHtml.append("<th>Column 4</th>");
		tableHtml.append("</tr>");

		boolean isDataPresent = false;

		for (WebElement row : rows) {
			try {
				String col3 = row.findElement(By.xpath("./td[3]")).getText().trim();
				String col4 = row.findElement(By.xpath("./td[4]")).getText().trim();

				// Ignore empty rows
				if (!col3.isEmpty() || !col4.isEmpty()) {
					isDataPresent = true;

					tableHtml.append("<tr>");
					tableHtml.append("<td>").append(col3).append("</td>");
					tableHtml.append("<td>").append(col4).append("</td>");
					tableHtml.append("</tr>");

					System.out.println(col3 + " | " + col4);
				}

			} catch (Exception e) {
				System.out.println("Column not found");
			}
		}

		tableHtml.append("</table>");

		// VALID SEARCH RESULT
		if (isDataPresent) {
			extentTest.pass("Search Result Table:");
			extentTest.info(tableHtml.toString());
		} else {
			// INVALID SEARCH RESULT
			extentTest.pass("No data found for invalid search input.");
			System.out.println("No data found.");
		}
	}
}
