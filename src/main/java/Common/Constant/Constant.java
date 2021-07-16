package Common.Constant;


import Common.Common.Utilities;
import Common.WebDriverManager.WebDriverManager;


public class Constant {

    public static WebDriverManager WEBDRIVER;
    public static final String EMPTY_DATA = "";
    public static final String RAILWAY_URL = "http://www.railway2.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "nguyenlenhatquang1@gmail.com";
    public static final String PASSWORD = "nguyenlenhatquang1";
    public static final String CHECK_MSG_WELCOME = "Welcome " + USERNAME;
    public static final String CHECK_LBL_MANAGE_TICKETS = "Manage Tickets";
    public static final String CHECK_LBL_CHANGE_PASSWORD = "Change password";
    public static final String CHECK_MSG_BLANK = "There was a problem with your login and/or errors exist in your form.";
    public static final String CHECK_MSG_INVALID = "Invalid username or password. Please try again.";
    public static final String CHECK_MSG_REGISTER = "Thank you for registering your account";
    public static final String INVALID_PASSWORD = "nguyenlenhatquang0";
    public static final String EMAIL = "mailto:thanh.viet.le@logigear.com";
    public static final String CHECK_MSG_UNABLE_LOGIN = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
    public static final String PASSWORD_RESET_TITLE = "Password Reset Instructions Form";
    public static final String RESET_EMAIL_INVALID = "nguyenlenhatquang4656@gmail.com";
    public static final String CHECK_MSG_RESET_EXIST = "This email address doesn't exist.";
    public static final String CHECK_MSG_FORM_ERROR = "There're errors in the form. Please correct the errors and try again.";
    public static final String CHECK_MSG_TICKET_AMOUNT_ERROR = "You have booked 10 tickets. You can book no more.";
    public static final String CHECK_MSG_PASSWORD_ERROR = "Invalid password length";
    public static final String CHECK_MSG_ID_ERROR = "Invalid ID length";
    public static final String DEPART_DATE = Utilities.setDepartDate(5);
    public static final String DEPART_FROM = "Quảng Ngãi";
    public static final String ARRIVE_AT = "Huế";
    public static final String SEAT_TYPE = "Hard bed";
    public static final int MAX_AMOUNT_OF_TICKET = 10;
    public static final int ONE_TICKET = 1;
    public static final int ROW_TICKET_CANCEL = 1;
    public static final int AMOUNT_OF_TICKET = 2;
    public static final int AMOUNT_OF_LOGIN = 6;
    public static final int AMOUNT_OF_BOOK_TICKET = 7;
    public static final String CHECK_MSG_BOOK_SUCCESS = "Ticket Booked Successfully!";
    public static final String BOOK_ARRIVE_STATION = "Huế";
    public static final String INVALID_DEPART_DATE = "16/7/2021";
    public static final String CHECK_MSG_ERROR_FILTER = "The date format is wrong, date filter is ignored.\n" +
            "Example of a proper date: Today is " + Utilities.setDepartDate(-4);
}
