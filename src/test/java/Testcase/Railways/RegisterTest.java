package Testcase.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends Testbase{
    public String USERNAME_REGISTER;
    public String PASSWORD_REGISTER;
    public String PID_PASSPORT_REGISTER;

    @BeforeMethod
    public void beforeMethod(){
        USERNAME_REGISTER = Utilities.getRandomAlphabetString(10)+"@gmail.com";
        PASSWORD_REGISTER = Utilities.getRandomNumberString(9);
        PID_PASSPORT_REGISTER =Utilities.getRandomNumberString(9);
        System.out.println("Pre-condition");
        registerPage = homepage.gotoRegisterPage();
        Utilities.pageDownEnd();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
    }

    @Test(description = "User can create new account")
    public void TC07(){
        registerPage.register(USERNAME_REGISTER,PASSWORD_REGISTER,PASSWORD_REGISTER,PID_PASSPORT_REGISTER);
        String lblConfirmRegister = registerPage.getConfirmRegister();
        Assert.assertEquals(lblConfirmRegister,Constant.CHECK_MSG_REGISTER,"User register account unsuccessfully");
    }

    @Test
    public void TC11(){
        registerPage.register(USERNAME_REGISTER,Constant.EMPTY_DATA,Constant.EMPTY_DATA,Constant.EMPTY_DATA);
        Assert.assertEquals(registerPage.getErrorMsg(),Constant.CHECK_MSG_FORM_ERROR,"Error form not displayed correctly");
        Assert.assertEquals(registerPage.getPasswordErrorMsg(),Constant.CHECK_MSG_PASSWORD_ERROR,"Error password message not displayed correctly");
        Assert.assertEquals(registerPage.getPidErrorMsg(),Constant.CHECK_MSG_ID_ERROR,"Error PID message not displayed correctly");
    }
}
