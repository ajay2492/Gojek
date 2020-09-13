package comm.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestBasePage {

    protected static Properties properties;
    protected static WebDriver driver;
    protected static JavascriptExecutor javascriptExecutor;
    protected static WebDriverWait explicitWait;

    public TestBasePage() {
        loadconfigFile();
    }

    public void javaScriptExecutor(){
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public void setExplicitWait(){
        explicitWait = new WebDriverWait(driver,Constants.EXPLICIT_WAIT_TIME);
    }

    public void initializeDriverinTestBasePAge(WebDriver driver) {
        this.driver = driver;
    }


    private static void loadconfigFile() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(Constants.CONFIG_FILE_PATH);
            //Logger.info("Loading Config file to properties Object");
            properties.load(fileInputStream);

        } catch (FileNotFoundException e) {
            Logger.error(e.toString());
        } catch (IOException e) {
            Logger.error(e.toString());
        }
    }

    public String getConfigValue(String inputValue) {
        return properties.getProperty(inputValue);
    }

    public static WebElement findByXpath(String inputXpath) {
        return driver.findElement(By.xpath(inputXpath));
    }

    public static WebElement findById(String inputId) {
        return driver.findElement(By.id(inputId));
    }

    public static WebElement findByClassName(String inputClassName) {
        return driver.findElement(By.className(inputClassName));
    }

    public static WebElement findByPartialLinkText(String inputText) {
        return driver.findElement(By.partialLinkText(inputText));
    }

    public static WebElement findByLinkText(String inputText) {
        return driver.findElement(By.linkText(inputText));
    }

    public static WebElement findByCSSSelector(String inputCSS) {
        return driver.findElement(By.cssSelector(inputCSS));
    }

    public static List<WebElement> findListByXpath(String inputXpath) {
        return driver.findElements(By.xpath(inputXpath));
    }

    public static List<WebElement> findListById(String inputId) {
        return driver.findElements(By.id(inputId));
    }

    public static List<WebElement> findListByClassName(String inputClassName) {
        return driver.findElements(By.className(inputClassName));
    }

    public static List<WebElement> findListByPartialLinkText(String inputText) {
        return driver.findElements(By.partialLinkText(inputText));
    }

    public static List<WebElement> findListByLinkText(String inputText) {
        return driver.findElements(By.linkText(inputText));
    }

    public static List<WebElement> findListByCSSSelector(String inputCSS) {
        return driver.findElements(By.cssSelector(inputCSS));
    }

    public static String currentDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Logger.info("Executing the currentDate method & today date is " + simpleDateFormat.format(date));
        return simpleDateFormat.format(date).toString();
    }

    public static void verticalScrollByElement(WebElement scrollTillelement){
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",scrollTillelement);
    }
    public static void verticalScrollByPixel(String inputPixel){
        javascriptExecutor.executeScript("window.scrollBy(0," +inputPixel+")");
    }
    public static void verticalScrollTillEnd(){
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void explicitWaitByClassName(String elementToVisible){
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(elementToVisible)));
    }

    public static void explicitWaitByXpath(String elementToVisible){
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementToVisible)));
    }
    public static void explicitWaitByid(String iid){
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(iid)));
    }
    public static void changeTOIframeById(String id){
        driver.switchTo().frame(id);
    }
    public static void changeTOIframeById(int index){
        driver.switchTo().frame(index);
    }
    public static void staticWait(int input){
        try {
            for(int i = 1; i <= input;i++){
                Logger.info("Static wait time is " + i + "sec");
            Thread.sleep(input*100);
            }
        }
        catch (Exception e){
            Logger.error(e.getMessage());
        }
    }
    public static void changeFrameToParent(){
        driver.switchTo().parentFrame();
    }
    public static void changeFrameToDefault(){
        driver.switchTo().defaultContent();
    }
}
