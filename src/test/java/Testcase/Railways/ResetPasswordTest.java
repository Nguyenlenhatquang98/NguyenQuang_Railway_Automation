package Testcase.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Model.Account;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResetPasswordTest extends TestBase {

    @BeforeMethod
    public void beforeMethod() {
        account = new Account();
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getDriverPath());
        Constant.WEBDRIVER.maximize();
        homepage.open();

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
    }

    @Test(description = "User can reset password successfully")
    public void TC09() {
        registerPage = homepage.gotoRegisterPage();
        Utilities.pageDownEnd();
        registerPage.register(account);
        loginPage = registerPage.gotoLoginPage();
        forgotPasswordPage = loginPage.gotoForgotPasswordPage();
        Assert.assertEquals(forgotPasswordPage.getPasswordResetText(), Constant.PASSWORD_RESET_TITLE, "User still not access to Forgot password page");
        forgotPasswordPage.sendInstructions(account.getEmail());
    }

    @Test(description = "User can't reset password if enter incorrect email address")
    public void TC10() {
        loginPage = homepage.gotoLoginPage();
        forgotPasswordPage = loginPage.gotoForgotPasswordPage();
        forgotPasswordPage.sendInstructions(Constant.RESET_EMAIL_INVALID);
        Assert.assertEquals(forgotPasswordPage.getErrorMessage(), Constant.CHECK_MSG_RESET_EXIST, "Error message not display correctly");
    }

    @Test(description = "Errors display when password reset token is blank")
    public void TC12() {
        registerPage = homepage.gotoRegisterPage();
        Utilities.pageDownEnd();
        registerPage.register(account);
        loginPage = registerPage.gotoLoginPage();
        forgotPasswordPage = loginPage.gotoForgotPasswordPage();
        Assert.assertEquals(forgotPasswordPage.getPasswordResetText(), Constant.PASSWORD_RESET_TITLE, "User still not access to Forgot password page");
        forgotPasswordPage.sendInstructions(account.getEmail());
    }

    @Test(description = "Errors display if password and confirm password don't match when resetting password")
    public void TC13() {
        registerPage = homepage.gotoRegisterPage();
        Utilities.pageDownEnd();
        registerPage.register(account);
        loginPage = registerPage.gotoLoginPage();
        forgotPasswordPage = loginPage.gotoForgotPasswordPage();
        Assert.assertEquals(forgotPasswordPage.getPasswordResetText(), Constant.PASSWORD_RESET_TITLE, "User still not access to Forgot password page");
        forgotPasswordPage.sendInstructions(account.getEmail());
    }


}
