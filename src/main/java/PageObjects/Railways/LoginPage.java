package PageObjects.Railways;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {

    // Locators

    private final By _txtUsername = By.xpath("//div[@id='content']//input[@id='username']");
    private final By _txtPassword = By.xpath("//div[@id='content']//input[@id='password']");
    private final By _btnLogin = By.xpath("//div[@id='content']//input[@value='Login']");
    private final By _lblLoginErrorMsg = By.xpath("//div[@id='content']//p[@class='message error LoginForm']");
    private final By _lblLoginPage = By.xpath("//div[@id='content']/h1[contains(text(),'Login')]");
    private final By _linkForgotPassword = By.xpath("//div[@id='content']//a[@href='/Account/ForgotPassword.cshtml']");


    // Elements

    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    public WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }

    public WebElement getLblLoginPage() {
        return Constant.WEBDRIVER.findElement(_lblLoginPage);
    }

    public WebElement getLinkForgotPassword() {
        return Constant.WEBDRIVER.findElement(_linkForgotPassword);
    }

    // Methods

    public GeneralPage login(String username, String password) {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
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
            if (this.getLblLoginErrorMsg().getText().equals(Constant.CHECK_MSG_INVALID)) {
                Result = Constant.CHECK_MSG_INVALID;
            }
        }
        return Result;
    }

    public String getLoginErrorMsg() {
        return getLblLoginErrorMsg().getText();
    }

    public boolean isLoginPageLanding() {
        if (getLblLoginPage() != null) {
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
