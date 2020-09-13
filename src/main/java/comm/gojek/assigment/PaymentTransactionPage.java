package comm.gojek.assigment;

import comm.elementlocator.ConstantXpath;
import comm.framework.Constants;
import comm.framework.TestBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PaymentTransactionPage extends TestBasePage {

    private static WebDriver driver;

    public PaymentTransactionPage(WebDriver inputDriver) {
        driver = inputDriver;
    }

    protected static WebElement getCardNumberBox() {
        return findByXpath(ConstantXpath.CARD_NUMBER);
    }

    protected static WebElement getExpiryTextBox() {
        return findByXpath(ConstantXpath.EXPIRY_DATE);
    }

    protected static WebElement getCvv() {
        return findByXpath(ConstantXpath.CVV);
    }

    protected static WebElement getPayNow() {
        return findByXpath(ConstantXpath.PAY_NOW_BUTTON);
    }

    protected static WebElement getOtp() {
        return findByXpath(ConstantXpath.OTP);
    }

    protected static WebElement getOtpOkButton() {
        return findByXpath(ConstantXpath.OTP_OK);
    }

    protected static WebElement getSuccessHeader1() {
        return findByXpath(ConstantXpath.SUCCESS_HEADER_1);
    }

    protected static WebElement getSuccessHeader2() {
        return findByXpath(ConstantXpath.SUCCESS_HEADER_2);
    }
    protected static WebElement getFailureHeader(){
        return findByXpath(ConstantXpath.FAILURE_HEADER);
    }
    protected static WebElement getFailureSubHeader1(){
        return findByXpath(ConstantXpath.FAILURE_SUBHEADER1);
    }

    protected static WebElement getFailureSubHeader2(){
        return findByXpath(ConstantXpath.FAILURE_SUBHEADER2);
    }



    public void moveToPaymentsPage() {
        HomeToPaymentsPage homeToPaymentsPage = new HomeToPaymentsPage(driver);
        homeToPaymentsPage.verifyBuyNowButton();
        homeToPaymentsPage.verifyCheckOutButton();
        homeToPaymentsPage.verifyOrderSummaryContinueButton();
        homeToPaymentsPage.verifyCreditDebitOption();
    }

    public static void makePayment(String cardNumber, String expiry, String cvv){
        explicitWaitByXpath(ConstantXpath.CARD_NUMBER);
        Assert.assertTrue(getCardNumberBox().isDisplayed());
        getCardNumberBox().sendKeys(cardNumber);
        Assert.assertTrue(getExpiryTextBox().isDisplayed());
        getExpiryTextBox().sendKeys(expiry);
        Assert.assertTrue(getCvv().isDisplayed());
        getCvv().sendKeys(cvv);
        Assert.assertTrue(getPayNow().isDisplayed());
        getPayNow().click();
    }
    public void verifyPaymentSuccess() {
        makePayment(Constants.POSITIVE_CARD,Constants.EXPIRY_DATE,Constants.CVV);
        changeTOIframeById(0);
        staticWait(10);
        getOtp().sendKeys(Constants.OTP);
        Assert.assertTrue(getOtpOkButton().isDisplayed());
        getOtpOkButton().click();
        changeFrameToDefault();
        explicitWaitByXpath(ConstantXpath.SUCCESS_HEADER_1);
        Assert.assertEquals(getSuccessHeader1().getText(), Constants.SUCCESS_HEADER_1);
        Assert.assertEquals(getSuccessHeader2().getText(), Constants.SUCCESS_HEADER_2);
    }

    public void verifyPaymentFailure(){
        makePayment(Constants.NEGATIVE_CARD,Constants.EXPIRY_DATE,Constants.CVV);
        changeTOIframeById(0);
        staticWait(10);
        getOtp().sendKeys(Constants.OTP);
        Assert.assertTrue(getOtpOkButton().isDisplayed());
        getOtpOkButton().click();
        changeFrameToParent();
        explicitWaitByXpath(ConstantXpath.FAILURE_HEADER);
        Assert.assertEquals(getFailureHeader().getText(), Constants.FAILURE_HEADER);
        Assert.assertEquals(getFailureSubHeader1().getText(), Constants.FAILURE_SUBHEADER_1);
        Assert.assertEquals(getFailureSubHeader2().getText(), Constants.FAILURE_SUBHEADER_2);
    }

}
