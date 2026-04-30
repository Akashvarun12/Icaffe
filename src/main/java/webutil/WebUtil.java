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
import java.util.Map;
import java.util.Properties;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class WebUtil {

	private WebDriver driver;
	private static ExtentReports extReport;
	private static  ExtentTest extentTest;

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
			extSparkReport.config().setReportName("Shivam Singh");
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
			extentTest.log(Status.INFO, "Window Maxmize successfully");

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

	public void sendKeys(WebElement we, String value,String eleName) {
		try {
			we.sendKeys(value);
			System.out.println(value + " entered successfully");
			extentTest.log(Status.INFO, value + " entered successfully in "+ eleName);

		} catch (Exception e) {
			extentTest.log(Status.FAIL, value+" send in " + eleName);
			extentTest.addScreenCaptureFromPath(takeScreenShot("SendKeys"));
			e.printStackTrace();
		}
	}

	public void clear(WebElement we, String eleName) {
		try {
			we.clear();
			System.out.println(eleName + " Cleared successfully");
			extentTest.log(Status.INFO, eleName + " textbox Cleared successfully");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, eleName+ " Failed to clear text");
			e.printStackTrace();
		}
	}

	public void click(WebElement we, String eleName) {
		try {
			we.click();
			System.out.println(eleName + " Clicked successfully");
			extentTest.log(Status.INFO, eleName + " Clicked successfully");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, eleName + " Failed to click");
			e.printStackTrace();
		}
	}

	public String getText(WebElement we) {
		String elementText = "";
		try {
			elementText = we.getText();
			System.out.println("Text fetched successfully");
			extentTest.log(Status.INFO, "Text fetched successfully");
			extentTest.addScreenCaptureFromPath(takeScreenShot("GetText"));
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to get text");
			e.printStackTrace();
		}
		return elementText;
	}

	// validation of get title with valid and invalid data...
	public void validateGetTitle(String expTitle, String type,String elemName) {

	    try {
	        String actTitle = getDriver().getTitle();
	        
	        if (type.equalsIgnoreCase("valid")) {

	            if (expTitle.equalsIgnoreCase(actTitle)) {
	                System.out.println("Passed: Title matches");
	                extentTest.log(Status.PASS,"Expected: "+ expTitle+" "+elemName+" Title matches with: " + actTitle);
	            } else {
	                System.out.println("Failed: Title mismatch");
	                extentTest.log(Status.FAIL,
	                		"Expected: "+ expTitle+" "+elemName+" Title not matches: " + actTitle);
	                extentTest.addScreenCaptureFromPath(takeScreenShot("TitleMismatch"));
	            }

	        } else { 
	            // invalid case
	            if (expTitle.equalsIgnoreCase(actTitle)) {
	                extentTest.log(Status.PASS,
	                		"Expected: "+ expTitle+" "+elemName+" Title matches and User stayed on "+ elemName +" page " + actTitle);
	                
	            } else {
	                extentTest.log(Status.FAIL,"Expected: "+ expTitle+" "+elemName+" Title mismatches:and user redirected " + actTitle);
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
				extentTest.log(Status.PASS, expURL+ " URL matches: " + actURL);
			} else {
				System.out.println("Failed: URL mismatch");
				extentTest.log(Status.FAIL, expURL+ " URL Not matches: " + actURL);
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
				extentTest.log(Status.PASS, expText+ " Text matches: " + actText);
			} else {
				System.out.println("Failed: Text mismatch");
				extentTest.log(Status.FAIL, expText+ " Text Not matches: " + actText);
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

	public Properties propertiFile(String propFile) {
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

	public void mouseOver(WebElement ele) {
		Actions actbj = new Actions(driver);
		try {
		actbj.moveToElement(ele).build().perform();
		extentTest.log(Status.INFO, "Mouse Over Succsessfully on Element ");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Mouse Over Fail on Element");
			e.printStackTrace();
		}
	}

	public void clickByAction(WebElement ele) {
		Actions actbj = new Actions(driver);
		try {
		actbj.click(ele).build().perform();
		extentTest.log(Status.INFO, "Clicked Succsessfully on Element by Action");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Clicked Fail on Element by Action");
			e.printStackTrace();
		}

	}

	public void clickByAction() {
		Actions actbj = new Actions(driver);
		try {
		actbj.click().build().perform();
		extentTest.log(Status.INFO, " Clicked Succsessfully on Element by Action");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, " Clicked Fail on Element by Action");
			e.printStackTrace();
		}

	}

	public void sendkeyByAction(WebElement ele, String input) {
		Actions actbj = new Actions(driver);
		try {
		actbj.sendKeys(input).build().perform();
		extentTest.log(Status.INFO, input+" Send Succsessfully on Element by Action");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, " Send Fail on Element by Action");
			e.printStackTrace();
		}

	}

	public List<String> getListOfText(List<WebElement> listOfWebEle) {
	    List<String> strList = new ArrayList<>();
      try {
	    for (WebElement webEle : listOfWebEle) {
	        String textList = webEle.getText();
	        extentTest.log(Status.INFO, textList+" List of Element Fetch successfully");
	        System.out.println("List of Element Details Fetch successfully - " + textList);
	        strList.add(textList);
	    }
      } catch (Exception e) {
    	  extentTest.log(Status.INFO, " List of Element not Fetch successfully");
			e.printStackTrace();
		}
	    return strList;
	}
	
	public void validateListOfText(List<String> actualList,Map<String, List<String>> expectedList) {
		if (actualList.equals(expectedList)) {
			extentTest.pass(" List matched successfully");
			extentTest.pass(" Actual: " + actualList);
			extentTest.pass(" Expected: " + expectedList);
		} else {
			extentTest.fail(" List mismatch");
			extentTest.fail(" Actual: " + actualList);
			extentTest.fail(" Expected: " + expectedList);
		}

		Assert.assertEquals(actualList, expectedList);
	}
	
	public void validateListOfText(List<String> actualList,List<String> expectedList) {
		if (actualList.equals(expectedList)) {
			extentTest.pass(" List matched successfully");
			extentTest.pass(" Actual: " + actualList);
			extentTest.pass(" Expected: " + expectedList);
		} else {
			extentTest.fail(" List mismatch");
			extentTest.fail(" Actual: " + actualList);
			extentTest.fail(" Expected: " + expectedList);
		}

		Assert.assertEquals(actualList, expectedList);
	}
	
	
//  ---------------------------- Shivam ----------------------------------	
	
	// AutoSuggest selection
	public void selectAutoSuggest(WebElement input, String textToType, String valueToSelect) {

	    try {
	        input.clear();
	        input.sendKeys(textToType);
	        extentTest.log(Status.INFO, 
	                "Typing '" + textToType + "' to select '" + valueToSelect + "'");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        List<WebElement> allOptions = wait.until(
	            ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                By.xpath("//ul[contains(@class,'ui-autocomplete')]/li")
	            )
	        );

	        boolean isFound = false;
	        for (WebElement option : allOptions) {
	            String text = option.getText().trim();
	            System.out.println("Option: " + text);
	            if (text.equalsIgnoreCase(valueToSelect)) {
	                option.click();
	                isFound = true;
	                extentTest.log(Status.PASS, 
	                        "Selected value from autosuggest: " + valueToSelect);
	                break;
	            }
	        }

	        if (!isFound) {
	            extentTest.log(Status.FAIL, 
	                    "Value not found in autosuggest: " + valueToSelect);

	            extentTest.addScreenCaptureFromPath(
	                    takeScreenShot("AutoSuggestFail"));

	            Assert.fail("Autosuggest value not found: " + valueToSelect);
	        }

	    } catch (org.openqa.selenium.TimeoutException e) {
	        extentTest.log(Status.FAIL, 
	                "Autosuggest options not visible for input: " + textToType);
	        Assert.fail("Autosuggest options not loaded");
	    } catch (Exception e) {
	        extentTest.log(Status.FAIL, 
	                "Exception in selectAutoSuggest: " + e.getMessage());
	        Assert.fail("Exception in autosuggest method");
	    }
	}
		
        
    // Alert Handle Method 
    public void validateAlertMessage(String expectedText) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            String actualText = alert.getText().trim();
            System.out.println("Alert Message: " + actualText);

            if (actualText.equalsIgnoreCase(expectedText)) {
                System.out.println("Passed: Alert matches");
                extentTest.log(Status.PASS,
                        expectedText + " Alert matches: " + actualText);
            } else {
                System.out.println("Failed: Alert mismatch");
                extentTest.log(Status.FAIL,
                        expectedText + " Alert NOT matches: " + actualText);

                extentTest.addScreenCaptureFromPath(takeScreenShot("AlertMismatch"));
            }

            alert.accept();

        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Exception in validateAlertMessage");
            e.printStackTrace();
        }
    }

    
    public void selectAutoSuggestUsingKeys(WebElement input, String textToType) {

        try {
            input.clear();
            input.sendKeys(textToType);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // wait for autosuggest dropdown
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//ul[contains(@class,'ui-autocomplete')]")));

            Thread.sleep(500); // small wait (important)

            input.sendKeys(Keys.ARROW_DOWN);
            input.sendKeys(Keys.ENTER);

            extentTest.log(Status.PASS,
                    "Selected autosuggest using keyboard: " + textToType);

        } catch (Exception e) {
            extentTest.log(Status.FAIL,
                    "Keyboard autosuggest failed: " + e.getMessage());
            Assert.fail("Autosuggest keyboard selection failed");
        }
    }

	
   
    
    
    
  
    
   
    
}
