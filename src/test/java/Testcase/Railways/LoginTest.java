package Testcase.Railways;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railways.*;
import com.google.common.base.Verify;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class LoginTest extends Testbase {



    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        loginPage = homepage.gotoLoginPage();

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        generalPage.logout();
    }

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

//        String actualMsg = homepage.getWelcomeMessage();
//        String expectedMsg = "Welcome " + Constant.USERNAME;
//        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

        boolean checklblWelcomeExist = homepage.checkWelcomeExist();

        Verify.verify(checklblWelcomeExist,"Welcome message is not displayed as expected");
       // homepage.logout();
    }

    @Test(description = "TC02 - User can log into Railway with blank username and password")
    public void TC02() {

        loginPage.login("", Constant.PASSWORD);
        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = Constant.CHECK_MSG_BLANK;
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test(description = "TC03 - User cannot log into Railway with invalid password")
    public void TC03(){

        loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);
        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = Constant.CHECK_MSG_INVALID;
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test(description = "TC05 - System shows message when user enters wrong password several times")
    public void TC05(){
        String expectedMessage = Constant.CHECK_MSG_UNABLE_LOGIN;
        String actualMessage = loginPage.getUnableMsgExist(6);
        Assert.assertEquals(actualMessage,expectedMessage,"Error message is not displayed as expected");
    }

    @Test(description = "TC06 - Additional pages display once user logged in")
    public void TC06(){
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
        Boolean checkTabExist = homepage.checkTabsDisplayed();
        Verify.verify(checkTabExist,"1 of 3 tab was not exist");
        MyTicketPage myTicketPage = homepage.gotoMyTicketPage();
        Boolean checkManageTicketPage = myTicketPage.checkManageTicket();
        Verify.verify(checkManageTicketPage,"User still not directed to My ticket page");
        ChangePasswordPage changePasswordPage = myTicketPage.gotoChangePasswordPage();
        Boolean checkChangePasswordPage = changePasswordPage.checkChangePasswordPage();
        Verify.verify(checkManageTicketPage,"User still not directed to Change password page");
        //changePasswordPage.logout();
    }

    @Test(description = "TC08 - User can't login with an account hasn't been activated")
    public void TC08(){
        registerPage = loginPage.gotoRegisterPage();
        Utilities.pageDownEnd();
        registerPage.register(Constant.USERNAME_REGISTER,Constant.PASSWORD_REGISTER,Constant.PASSWORD_REGISTER,Constant.PID_PASSPORT_REGISTER);
        loginPage = registerPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME_REGISTER,Constant.PASSWORD_REGISTER);
        Assert.assertTrue(loginPage.isLoginPageLanding(),"User still can log in without activated account");
        String expectMsg = Constant.CHECK_MSG_INVALID;
        String actualMsg = loginPage.getLoginErrorMsg();
        Assert.assertEquals(actualMsg,expectMsg,"Error message is not displayed correctly");
    }



}
