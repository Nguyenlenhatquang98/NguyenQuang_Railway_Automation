package Testcase.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railways.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends Testbase{

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
        homepage.open();
        registerPage = homepage.gotoRegisterPage();
        Utilities.pageDownEnd();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
    }

    @Test(description = "User can create new account")
    public void TC07(){
        registerPage.register(Constant.USERNAME_REGISTER,Constant.PASSWORD_REGISTER,Constant.PASSWORD_REGISTER,Constant.PID_PASSPORT_REGISTER);
        String lblConfirmRegister = registerPage.getConfirmRegister();
        Assert.assertEquals(lblConfirmRegister,Constant.CHECK_MSG_REGISTER,"User register account unsuccessfully");

    }
}
