package Testcase.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Model.Account;
import PageObjects.Railways.ChangePasswordPage;
import PageObjects.Railways.MyTicketPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    @BeforeMethod
    public void beforeMethod() {
        account = new Account();
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
        String WelcomeUser = homepage.getWelcomeUser();
        Assert.assertEquals(WelcomeUser, Constant.CHECK_MSG_WELCOME, "Welcome message is not displayed as expected");

    }

    @Test(description = "TC02 - User can log into Railway with blank username and password")
    public void TC02() {

        loginPage.login(Constant.EMPTY_DATA, Constant.PASSWORD);
        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = Constant.CHECK_MSG_BLANK;
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test(description = "TC03 - User cannot log into Railway with invalid password")
    public void TC03() {

        loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);
        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = Constant.CHECK_MSG_INVALID;
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");

    }

    @Test(description = "TC05 - System shows message when user enters wrong password several times")
    public void TC05() {
        String expectedMessage = Constant.CHECK_MSG_UNABLE_LOGIN;
        String actualMessage = loginPage.getUnableMsgExist(Constant.AMOUNT_OF_LOGIN);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message is not displayed as expected");


    }

    @Test(description = "TC06 - Additional pages display once user logged in")
    public void TC06() {
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        boolean checkTabExist = homepage.checkTabsDisplayed();
        Assert.assertTrue(checkTabExist, "1 of 3 tab was not exist");
        MyTicketPage myTicketPage = homepage.gotoMyTicketPage();
        String lblManageTicket = myTicketPage.getManageTicket();
        Assert.assertEquals(lblManageTicket, Constant.CHECK_LBL_MANAGE_TICKETS, "User still not directed to My ticket page");
        ChangePasswordPage changePasswordPage = myTicketPage.gotoChangePasswordPage();
        String changePasswordText = changePasswordPage.getChangePassword();
        Assert.assertEquals(changePasswordText, Constant.CHECK_LBL_CHANGE_PASSWORD, "User still not directed to Change password page");
    }

    @Test(description = "TC08 - User can't login with an account hasn't been activated")
    public void TC08() {
        registerPage = loginPage.gotoRegisterPage();
        Utilities.pageDownEnd();
        registerPage.register(account);
        loginPage = registerPage.gotoLoginPage();
        loginPage.login(account.getEmail(), account.getPassword());
        Assert.assertTrue(loginPage.isLoginPageLanding(), "User still can log in without activated account");
        String expectMsg = Constant.CHECK_MSG_INVALID;
        String actualMsg = loginPage.getLoginErrorMsg();
        Assert.assertEquals(actualMsg, expectMsg, "Error message is not displayed correctly");
    }


}
