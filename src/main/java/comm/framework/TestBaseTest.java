package comm.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestBaseTest {
    private static TestBasePage testBasePage;
    private static String browserValue;
    public static WebDriver driver;

    private static String OSValue;
    private static String CHROME_PATH;

    public static void initialSetup(){
        testBasePage = new TestBasePage();
        OSValue = OperatingSystemDetector.operatingSystem();
        getChromeDriverPath();
        browserValue = testBasePage.getConfigValue(Constants.BROWSER);
        webDriverInitialization();
        testBasePage.initializeDriverinTestBasePAge(driver);
        testBasePage.javaScriptExecutor();
        testBasePage.setExplicitWait();
        getWebsite();
    }

    public static void getChromeDriverPath(){
        if(OSValue.contains("windows")){
            CHROME_PATH = Constants.WINDOW_CHROMEDRIVER_PATH;
        } else if(OSValue.contains("mac")){
            CHROME_PATH = testBasePage.getConfigValue("MAC_CHROMEDRIVER_PATH");
        } else if(OSValue.contains("lin")){
            CHROME_PATH = Constants.LINUX_CHROMEDRIVER_PATH;
        }
    }
    public static void webDriverInitialization(){

        if(browserValue.equalsIgnoreCase(Constants.CHROME)){
            Logger.info("Initializing the WebDriver with selected brower as " + Constants.CHROME + " Browser");
            Logger.info("The Chrome path is " + CHROME_PATH);
            System.setProperty(Constants.CHROME_KEY, CHROME_PATH);
            ChromeOptions chromeOptions = new ChromeOptions();
            Logger.info("Chrome driver version is " + chromeOptions.getVersion());
            driver = new ChromeDriver();
        }
    }

    public static WebDriver getdriver(){
        return driver;
    }

    public static void getWebsite(){
        Logger.info("Opening the WebSite for testing");
        driver.get(testBasePage.getConfigValue(Constants.URL));
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeDriver(){
            driver.close();
            driver.quit();
    }
}
