package comm.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class TestBaseTest {
    private static TestBasePage testBasePage;
    public static WebDriver driver;

    private static String OSValue;
    private static String DRIVER_PATH;
    private static String BROWSER;
    private static String BROWSER_KEY;

    public static void initialSetup() {
        testBasePage = new TestBasePage();
        OSValue = OperatingSystemDetector.operatingSystem();
        setBrowserKeyValue();
        getDriverPath();
        webDriverInitialization();
        testBasePage.initializeDriverinTestBasePAge(driver);
        testBasePage.javaScriptExecutor();
        testBasePage.setExplicitWait();
        getWebsite();
    }

    public static void setBrowserKeyValue(){
        BROWSER = testBasePage.getConfigValue("browser");
        if (BROWSER.equalsIgnoreCase(Constants.CHROME) || BROWSER.equalsIgnoreCase(Constants.GOOGLE_CHROME)){
            BROWSER_KEY = Constants.CHROME_KEY;
        } else if(BROWSER.equalsIgnoreCase(Constants.MOZILLA)||BROWSER.equalsIgnoreCase(Constants.MOZILLA_FIREFOX)||
                BROWSER.equalsIgnoreCase(Constants.FIREFOX)||BROWSER.equalsIgnoreCase(Constants.GECKO)){
            BROWSER_KEY = Constants.FIREFOX_KEY;
        }
    }

    public static void getDriverPath() {
        if (OSValue.contains("windows")) {
            if (BROWSER.equalsIgnoreCase(Constants.CHROME) || BROWSER.equalsIgnoreCase(Constants.GOOGLE_CHROME)) {
                DRIVER_PATH = testBasePage.getConfigValue("WINDOW_CHROMEDRIVER_PATH");

            } else if (BROWSER.equalsIgnoreCase(Constants.MOZILLA)||BROWSER.equalsIgnoreCase(Constants.MOZILLA_FIREFOX)||
                    BROWSER.equalsIgnoreCase(Constants.FIREFOX)||BROWSER.equalsIgnoreCase(Constants.GECKO)) {
                DRIVER_PATH = testBasePage.getConfigValue("WINDOW_GECKO_PATH");
            }
        } else if (OSValue.contains("mac")) {
            if (BROWSER.equalsIgnoreCase(Constants.CHROME) || BROWSER.equalsIgnoreCase(Constants.GOOGLE_CHROME)) {
                DRIVER_PATH = testBasePage.getConfigValue("MAC_CHROMEDRIVER_PATH");

            } else if (BROWSER.equalsIgnoreCase(Constants.MOZILLA)||BROWSER.equalsIgnoreCase(Constants.MOZILLA_FIREFOX)||
                    BROWSER.equalsIgnoreCase(Constants.FIREFOX)||BROWSER.equalsIgnoreCase(Constants.GECKO)) {
                DRIVER_PATH = testBasePage.getConfigValue("MAC_GECKO_PATH");
            }
        } else if (OSValue.contains("lin")) {
            DRIVER_PATH = Constants.LINUX_CHROMEDRIVER_PATH;
        }
    }

    public static void webDriverInitialization() {
        Logger.info("Initializing the WebDriver with selected brower as " + BROWSER + " Browser");
        Logger.info("The "+BROWSER+" with key "+BROWSER_KEY+" path is " + DRIVER_PATH);
        System.setProperty(BROWSER_KEY, DRIVER_PATH);
        if (BROWSER.equalsIgnoreCase(Constants.CHROME) || BROWSER.equalsIgnoreCase(Constants.GOOGLE_CHROME)) {
            //ChromeOptions chromeOptions = new ChromeOptions();
            //Logger.info("Chrome driver version is " + chromeOptions.getVersion());
            driver = new ChromeDriver();
        }else if(BROWSER.equalsIgnoreCase(Constants.MOZILLA)||BROWSER.equalsIgnoreCase(Constants.MOZILLA_FIREFOX)||
                BROWSER.equalsIgnoreCase(Constants.FIREFOX)||BROWSER.equalsIgnoreCase(Constants.GECKO)){
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette",true);
            driver= new FirefoxDriver(capabilities);
        }
    }

    public static WebDriver getdriver() {
        return driver;
    }

    public static void getWebsite() {
        Logger.info("Opening the WebSite for testing");
        driver.get(testBasePage.getConfigValue(Constants.URL));
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeDriver() {
        driver.quit();
    }
}
