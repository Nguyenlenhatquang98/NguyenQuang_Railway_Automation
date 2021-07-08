package Testcase.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResetPasswordTest extends Testbase{

    public String USERNAME_REGISTER;
    public String PASSWORD_REGISTER;
    public String PID_PASSPORT_REGISTER;

    @BeforeMethod
    public void beforeMethod() {
        USERNAME_REGISTER = Utilities.getRandomAlphabetString(10)+"@gmail.com";
        PASSWORD_REGISTER = Utilities.getRandomNumberString(9);
        PID_PASSPORT_REGISTER =Utilities.getRandomNumberString(9);
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath());
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
        registerPage.register(USERNAME_REGISTER, PASSWORD_REGISTER, PASSWORD_REGISTER, PID_PASSPORT_REGISTER);
        loginPage = registerPage.gotoLoginPage();
        forgotPasswordPage =  loginPage.gotoForgotPasswordPage();
        Assert.assertEquals(forgotPasswordPage.getPasswordResetText(), Constant.PASSWORD_RESET_TITLE, "User still not access to Forgot password page");
        forgotPasswordPage.sendInstructions(USERNAME_REGISTER);
    }

    @Test(description = "User can't reset password if enter incorrect email address")
    public void TC10(){
        loginPage = homepage.gotoLoginPage();
        forgotPasswordPage = loginPage.gotoForgotPasswordPage();
        forgotPasswordPage.sendInstructions(Constant.RESET_EMAIL_INVALID);
        Assert.assertEquals(forgotPasswordPage.getErrorMessage(),Constant.CHECK_MSG_RESET_EXIST,"Error message not display correctly");
    }

    @Test(description = "Errors display when password reset token is blank")
    public void TC12(){
        registerPage = homepage.gotoRegisterPage();
        Utilities.pageDownEnd();
        registerPage.register(USERNAME_REGISTER, PASSWORD_REGISTER, PASSWORD_REGISTER, PID_PASSPORT_REGISTER);
        loginPage = registerPage.gotoLoginPage();
        forgotPasswordPage =  loginPage.gotoForgotPasswordPage();
        Assert.assertEquals(forgotPasswordPage.getPasswordResetText(), Constant.PASSWORD_RESET_TITLE, "User still not access to Forgot password page");
        forgotPasswordPage.sendInstructions(USERNAME_REGISTER);
    }

    @Test(description = "Errors display if password and confirm password don't match when resetting password")
    public void TC13(){
        registerPage = homepage.gotoRegisterPage();
        Utilities.pageDownEnd();
        registerPage.register(USERNAME_REGISTER,PASSWORD_REGISTER, PASSWORD_REGISTER, PID_PASSPORT_REGISTER);
        loginPage = registerPage.gotoLoginPage();
        forgotPasswordPage =  loginPage.gotoForgotPasswordPage();
        Assert.assertEquals(forgotPasswordPage.getPasswordResetText(), Constant.PASSWORD_RESET_TITLE, "User still not access to Forgot password page");
        forgotPasswordPage.sendInstructions(USERNAME_REGISTER);
    }


}
