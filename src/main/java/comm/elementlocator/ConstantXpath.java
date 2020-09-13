package comm.elementlocator;

public class ConstantXpath {
    /* Xpath Locators for Home Page */
    public static final String BUY_NOW = "//a[text()='BUY NOW']";
    public static final String CHECKOUT_BUTTON = "//div[text()='CHECKOUT']";
    public static final String CREDIT_BUTTON = "//div[text()='Credit/Debit Card']";

    /* Payment Locator */
    public static final String CARD_NUMBER = "//input[@name='cardnumber']";
    public static final String EXPIRY_DATE = "//input[@placeholder='MM / YY']";
    public static final String CVV = "//input[@placeholder='123']";
    public static final String PAY_NOW_BUTTON="//div[@id='application']//div[@class='button-main show']";
    public static final String OTP = "//input[@id='PaRes']";
    public static final String OTP_OK = "//button[@name='ok']";
    public static final String SUCCESS_HEADER_1 = "//div[@class = 'notification-wrapper']//div//span[1]";
    public static final String SUCCESS_HEADER_2 = "//div[@class = 'notification-wrapper']//div//span[2]";
}
