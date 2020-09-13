package comm.gojeck.assigment;

import comm.elementlocator.ConstantXpath;
import comm.framework.Constants;
import comm.framework.TestBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentTransactionPage extends TestBasePage {

    private static WebDriver driver;

    public PaymentTransactionPage(WebDriver inputDriver){
        driver = inputDriver;
    }
    protected static WebElement getCardNumberBox(){
        return findByXpath(ConstantXpath.CARD_NUMBER);
    }
    protected static WebElement getExpiryTextBox(){
        return findByXpath(ConstantXpath.EXPIRY_DATE);
    }
    protected static WebElement getCvv(){
        return findByXpath(ConstantXpath.CVV);
    }
    protected static WebElement getPayNow(){
        return findByXpath(ConstantXpath.PAY_NOW_BUTTON);
    }
    protected static WebElement getOtp(){
        return findByXpath(ConstantXpath.OTP);
    }
    protected static WebElement getOtpOkButton(){
        return findByXpath(ConstantXpath.OTP_OK);
    }
    protected static WebElement getSuccessHeader1(){
        return findByXpath(ConstantXpath.SUCCESS_HEADER_1);
    }
    protected static WebElement getSuccessHeader2(){
        return findByXpath(ConstantXpath.SUCCESS_HEADER_2);
    }

    public void moveToPaymentsPage(){
        HomeToPaymentsPage homeToPaymentsPage = new HomeToPaymentsPage(driver);
        homeToPaymentsPage.verifyBuyNowButton();
        homeToPaymentsPage.verifyCheckOutButton();
        homeToPaymentsPage.verifyOrderSummaryContinueButton();
        homeToPaymentsPage.verifyCreditDebitOption();
    }
    public void verifyPaymentSuccess(){
        Assert.assertTrue(getCardNumberBox().isDisplayed());
        getCardNumberBox().sendKeys(Constants.POSITIVE_CARD);
        Assert.assertTrue(getExpiryTextBox().isDisplayed());
        getExpiryTextBox().sendKeys(Constants.EXPIRY_DATE);
        Assert.assertTrue(getCvv().isDisplayed());
        getCvv().sendKeys(Constants.CVV);
        Assert.assertTrue(getPayNow().isDisplayed());
        getPayNow().click();
        changeTOIframeById(0);
        staticWait(10);
        getOtp().sendKeys(Constants.OTP);
        Assert.assertTrue(getOtpOkButton().isDisplayed());
        getOtpOkButton().click();
        explicitWaitByXpath(ConstantXpath.SUCCESS_HEADER_1);
        Assert.assertEquals(getSuccessHeader1().getText(),Constants.SUCCESS_HEADER_1);
        Assert.assertEquals(getSuccessHeader2().getText(),Constants.SUCCESS_HEADER_2);
    }
}
