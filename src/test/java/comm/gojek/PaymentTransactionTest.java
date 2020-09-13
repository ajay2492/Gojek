package comm.gojek;

import comm.framework.TestBaseTest;
import comm.gojeck.assigment.HomeToPaymentsPage;
import comm.gojeck.assigment.PaymentTransactionPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PaymentTransactionTest extends TestBaseTest {

    public static PaymentTransactionPage paymentTransactionPage;

    @BeforeTest
    public static void initializeSetup(){
        initialSetup();
        paymentTransactionPage = new PaymentTransactionPage(getdriver());
        paymentTransactionPage.moveToPaymentsPage();
    }

    @Test
    public static void verifyPaymentSuccess(){
        paymentTransactionPage.verifyPaymentSuccess();
    }
}
