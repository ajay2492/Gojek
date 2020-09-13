package comm.framework;

public class Message {
    public static final String validateLanding = "Executing the validateLandingToCategoryPage test case. The test" +
            " cases will validate landing to Category page";
    public static final String validateSecondBusSelection = "Executing the validateSecondBusSelection test case. The test" +
            "will validate the selection of the seats in second availavble bus ";
    public static final String validateSeat = "Executing the validateSeatSelection test case. The test case" +
            " will validate selection process of the 2nd availbe bus.";
    public static final String validateProceedButton = "Executing the validateProceedButton test case. The test case" +
            " will validate the procced button.";

    /*     Error Messages    */
    public static final String validateSeat_ERROR = "Seats is not available as per the requirement";
    public static final String PROCEED_BUTTON_ERROR = "The WebDriver is not able to detect the Button.";
}
