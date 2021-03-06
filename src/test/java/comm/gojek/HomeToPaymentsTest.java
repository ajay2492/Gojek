package comm.gojek;

import comm.framework.TestBaseTest;
import comm.gojek.assigment.HomeToPaymentsPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeToPaymentsTest extends TestBaseTest {

    public static HomeToPaymentsPage homeToPaymentsPage;

    @BeforeClass
    public static void initializeSetup(){
        initialSetup();
        homeToPaymentsPage = new HomeToPaymentsPage(getdriver());
    }
    @AfterClass
    public static void CloseSetUp(){
        if(getdriver() != null){
            //driver.close();
            driver.quit();
        }
    }

    @Test(priority = 1, enabled = false)
    public static void verifyBuyNowButton(){
        homeToPaymentsPage.verifyBuyNowButton();
    }
    @Test(priority = 2, enabled = false)
    public static void verifyCheckOutButton(){
        homeToPaymentsPage.verifyCheckOutButton();
    }
    @Test(priority = 3, enabled = false)
    public static void verifyOrderSummaryContinue(){
        homeToPaymentsPage.verifyOrderSummaryContinueButton();
    }
    @Test(priority = 4, enabled = false)
    public static void verifyCreditDebitOption(){
        homeToPaymentsPage.verifyCreditDebitOption();
    }
}
