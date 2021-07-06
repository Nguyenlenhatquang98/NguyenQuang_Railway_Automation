package Common.Constant;


import Common.Common.Utilities;
import Common.WebDriverManager.WebDriverManager;
import org.openqa.selenium.WebDriver;


public class Constant {

    public static WebDriverManager WEBDRIVER = WebDriverManager.getInstance();
    public static final String EMPTY_DATA = "";
    public static final String RAILWAY_URL = "http://www.railway2.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "nguyenlenhatquang1@gmail.com";
    public static final String PASSWORD = "nguyenlenhatquang1";
    public static final String CHECK_MSG_BLANK = "There was a problem with your login and/or errors exist in your form.";
    public static final String CHECK_MSG_INVALID = "Invalid username or password. Please try again.";
    public static final String CHECK_MSG_REGISTER = "Thank you for registering your account";
    public static final String INVALID_PASSWORD = "nguyenlenhatquang0";
    public static final String EMAIL = "mailto:thanh.viet.le@logigear.com";
    public static final String CHECK_MSG_UNABLE_LOGIN = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
    public static final String USERNAME_REGISTER = Utilities.getRandomString(10)+"@gmail.com";
    public static final String PASSWORD_REGISTER = Utilities.getRandomString(9);
    public static final String PID_PASSPORT_REGISTER =Utilities.getRandomString(8);
    public static final String PASSWORD_RESET_TITLE = "Password Reset Instructions Form";
    public static final String RESET_EMAIL_INVALID = "nguyenlenhatquang4656@gmail.com";
    public static final String CHECK_MSG_RESET_EXIST = "This email address doesn't exist.";
    public static final String CHECK_MSG_REGISTER_ERROR = "There're errors in the form. Please correct the errors and try again.";
    public static final String CHECK_MSG_PASSWORD_ERROR = "Invalid password length";
    public static final String CHECK_MSG_ID_ERROR = "Invalid ID length";
}
