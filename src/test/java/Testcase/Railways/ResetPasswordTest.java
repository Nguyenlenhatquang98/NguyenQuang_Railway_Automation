package Testcase.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResetPasswordTest extends Testbase {


    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
    }

    @Test(description = "User can reset password successfully")
    public void TC09() {
        registerPage = homepage.gotoRegisterPage();
        Utilities.pageDownEnd();
        registerPage.register(Constant.USERNAME_REGISTER, Constant.PASSWORD_REGISTER, Constant.PASSWORD_REGISTER, Constant.PID_PASSPORT_REGISTER);
        loginPage = registerPage.gotoLoginPage();
        forgotPasswordPage =  loginPage.gotoForgotPasswordPage();
        Assert.assertEquals(forgotPasswordPage.getPasswordResetText(), Constant.PASSWORD_RESET_TITLE, "User still not access to Forgot password page");
        forgotPasswordPage.sendInstructions(Constant.USERNAME_REGISTER);
    }

    @Test(description = "User can't reset password if enter incorrect email address")
    public void TC10(){
        loginPage = homepage.gotoLoginPage();
        forgotPasswordPage = loginPage.gotoForgotPasswordPage();
        forgotPasswordPage.sendInstructions(Constant.RESET_EMAIL_INVALID);
        Assert.assertEquals(forgotPasswordPage.getErrorMessage(),Constant.CHECK_MSG_RESET_EXIST,"Error message not display correctly");
    }

    public void TC13(){
        
    }


}
