package frameWorkClasses;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;

    // constructor of the base class (manage browsers)
    public BasePage() {
        if (driver == null) {   //]WHY DO WE HAVE TO CHECK IF NULL?]
            // get parameter values
            String driverDirectory = getDataConfigProperties("driverDir");
            String browserName = getDataConfigProperties("browser");
            String baseURL = getDataConfigProperties("TelcoURL");

            // check browser parameter passed, and set correct system property and browser driver
            if (browserName.equalsIgnoreCase("firefox")) {
                // instantiate geckodriver driver if parameter passed is firefox
                System.setProperty("webdriver.gecko.driver", driverDirectory + "geckodriver.exe");
                driver = new FirefoxDriver();
                // driver.get(baseURL);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            } else if (browserName.equalsIgnoreCase("chrome")) {
                // instantiate chromedriver driver if parameter passed is chrome
                System.setProperty("webdriver.chromedriver", driverDirectory + "chromedriver.exe");
                driver = new ChromeDriver();
                //driver.get(baseURL);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
        }
    }

    //Create a method to read the config
    public String getDataConfigProperties(String propertyName) {
        // properties set-up
        Properties prop = new Properties();
        InputStream iS = null;
        // open config file using inputStream object
        try {
            iS = new FileInputStream("config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // load file using properties object
        try {
            prop.load(iS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // return property name to the method, for it could be used wherever method is called
        return prop.getProperty(propertyName);
    }

    //create a method to Wait for Element
    public void waitForElement(int elementWait, By pLocator) {
        WebDriverWait wait = new WebDriverWait(driver, elementWait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pLocator));
    }

    //create a method to wait for the URL
    public void waitForUrl(int elementWait, String pLocator) {
        WebDriverWait wait = new WebDriverWait(driver, elementWait);
        wait.until(ExpectedConditions.urlContains(pLocator));
    }

    //create a method to wait for element to be clickable
    public void waitForClick(int elementWait, By pLocator) {
        WebDriverWait wait = new WebDriverWait(driver, elementWait);
        wait.until(ExpectedConditions.elementToBeClickable(pLocator));
    }

    //create a method to get Element
    public WebElement getElement(By pLocator) {
        waitForClick(10, pLocator);
        return driver.findElement(pLocator);
    }

    //create a method to get Element Text
    public String getElementText(By pLocator) {
        waitForElement(10, pLocator);
        String headerText = getElement(pLocator).getText();
        return headerText;
    }

    //create a method to click Element
    public void clickElement(By pLocator) {
        waitForClick(15, pLocator);
        getElement(pLocator).click();
    }

    //create a method to EnterText
    public void enterText(By pLocator, String pText) {
        waitForClick(10, pLocator);
        driver.findElement(pLocator).sendKeys(pText);
    }

    // create a method to select from dropdown
    public void selectDropDown(By pLocator, String pValue) {
        // create instance of dropdown element
        Select sDropDown = new Select(getElement(pLocator));
        // select dropdown option
        sDropDown.selectByVisibleText(pValue);
    }

    public void goHome() {
        driver.get(getDataConfigProperties("TelcoURL"));
    }

    // method to handle the popup windows
    public void closePopUp() {
        driver.switchTo().alert().accept();
    }

    public void getAlertText() {
        driver.switchTo().alert().getText();
    }

    // method to take last page screenshots in the event of a passed test
    @AfterMethod
    public void takePassScreenshots(ITestResult result) {
        if (ITestResult.SUCCESS == result.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(srcFile, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterMethod
    public void takeFailScreenshots(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(srcFile, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //clean up
    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
