package comm.gojek;

import comm.framework.TestBaseTest;
import comm.gojek.assigment.PaymentTransactionPage;
import org.testng.annotations.*;

public class PaymentTransactionTest extends TestBaseTest {

    public static PaymentTransactionPage paymentTransactionPage;

    @BeforeMethod
    public static void initializeSetup(){
        initialSetup();
        paymentTransactionPage = new PaymentTransactionPage(getdriver());
        paymentTransactionPage.moveToPaymentsPage();
    }
    @AfterMethod
    public static void closeConnection(){
        if(getdriver() != null){
            closeDriver();
        }
    }

    @Test(priority = 1)
    public static void verifyPaymentSuccess(){
        paymentTransactionPage.verifyPaymentSuccess();
    }

    @Test(priority = 2)
    public static void verifyPaymentFailure(){
        paymentTransactionPage.verifyPaymentFailure();
    }
}

