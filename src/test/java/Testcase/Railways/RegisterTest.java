package Testcase.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Model.Account;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends Testbase {

    @BeforeMethod
    public void beforeMethod() {
        account = new Account();
        System.out.println("Pre-condition");
        registerPage = homepage.gotoRegisterPage();
        Utilities.pageDownEnd();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
    }

    @Test(description = "User can create new account")
    public void TC07() {
        registerPage.register(account);
        String lblConfirmRegister = registerPage.getConfirmRegister();
        Assert.assertEquals(lblConfirmRegister, Constant.CHECK_MSG_REGISTER, "User register account unsuccessfully");
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11() {
        registerPage.registerFail(account);
        Assert.assertEquals(registerPage.getErrorMsg(), Constant.CHECK_MSG_FORM_ERROR, "Error form not displayed correctly");
        Assert.assertEquals(registerPage.getPasswordErrorMsg(), Constant.CHECK_MSG_PASSWORD_ERROR, "Error password message not displayed correctly");
        Assert.assertEquals(registerPage.getPidErrorMsg(), Constant.CHECK_MSG_ID_ERROR, "Error PID message not displayed correctly");
    }
}
