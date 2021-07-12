package PageObjects.Railways;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {

    // Locators

    private final By _txtUsername = By.id("username");
    private final By _txtPassword = By.id("password");
    private final By _btnLogin = By.xpath("//input[@value='Login']");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By _lblLoginPage = By.xpath("//h1[contains(text(),'Login')]");
    private final By _linkForgotPassword = By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");


    // Elements

    public WebElement getUsernameElement() {
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getPasswordElement() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getLoginElement() {
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    public WebElement getLoginErrorMsgElement() {
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }

    public WebElement getLoginPageElement() {
        return Constant.WEBDRIVER.findElement(_lblLoginPage);
    }

    public WebElement getLinkForgotPassword() {
        return Constant.WEBDRIVER.findElement(_linkForgotPassword);
    }

    // Methods




    public GeneralPage login(String username, String password) {
        this.getUsernameElement().sendKeys(username);
        this.getPasswordElement().sendKeys(password);
        this.getLoginElement().click();
        if (isElementExist(_lblLoginErrorMsg)) {
            return new LoginPage();
        } else {
            return new HomePage();
        }
    }



    public String getUnableMsgExist(int n) {
        String Result = null;
        for (int i = 0; i < n; i++) {
            this.login(Constant.USERNAME, Constant.INVALID_PASSWORD);
            if (this.getLoginErrorMsgElement().getText().equals(Constant.CHECK_MSG_INVALID)) {
                Result = Constant.CHECK_MSG_INVALID;
            }
        }
        return Result;
    }

    public String getLoginErrorMsg() {
        return getLoginErrorMsgElement().getText();
    }

    public boolean isLoginPageLanding() {
        if (getLoginPageElement() != null) {
            return true;
        } else {
            return false;
        }
    }

    public ForgotPasswordPage gotoForgotPasswordPage() {
        getLinkForgotPassword().click();
        return new ForgotPasswordPage();
    }


}
