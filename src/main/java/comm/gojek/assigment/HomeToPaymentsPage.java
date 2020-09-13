package comm.gojek.assigment;

import comm.elementlocator.ConstantClass;
import comm.elementlocator.ConstantId;
import comm.elementlocator.ConstantXpath;
import comm.framework.TestBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomeToPaymentsPage extends TestBasePage {
    public static WebDriver driver;

    public HomeToPaymentsPage(WebDriver inputDriver){
        driver = inputDriver;
    }

    protected static WebElement getBuyNowButton(){
        return findByXpath(ConstantXpath.BUY_NOW);
    }
    protected static WebElement getCheckOutButton(){
        return findByXpath(ConstantXpath.CHECKOUT_BUTTON);
    }
    protected static WebElement getOrderSummaryContinue(){
        return findByClassName(ConstantClass.ORDER_SUMMARY_CONTINUE);
    }
    protected static WebElement getCreditDebitCardOption(){
        return findByXpath(ConstantXpath.CREDIT_BUTTON);
    }
    public void verifyBuyNowButton(){
        Assert.assertTrue(getBuyNowButton().isDisplayed());
        getBuyNowButton().click();
        explicitWaitByXpath(ConstantXpath.CHECKOUT_BUTTON);
    }
    public void verifyCheckOutButton(){
        Assert.assertTrue(getCheckOutButton().isDisplayed());
        getCheckOutButton().click();
    }
    public void verifyOrderSummaryContinueButton(){
        changeTOIframeById(ConstantId.IFRAME_ORDER_SUMMARY);
        explicitWaitByClassName(ConstantClass.ORDER_SUMMARY_CONTINUE);
        Assert.assertTrue(getOrderSummaryContinue().isDisplayed());
        getOrderSummaryContinue().click();
    }
    public void verifyCreditDebitOption(){
        explicitWaitByXpath(ConstantXpath.CREDIT_BUTTON);
       Assert.assertTrue(getCreditDebitCardOption().isDisplayed());
       getCreditDebitCardOption().click();
    }
}
