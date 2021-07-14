package Testcase.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Model.Account;
import Model.Ticket;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 extends TestBase{

    @BeforeMethod
    public void beforeMethod(){
        account = new Account();
        registerPage = homepage.gotoRegisterPage();

    }

    @AfterMethod
    public void afterMethod(){
        generalPage.logout();
    }

    @Test
    public void tcTesT(){
        Utilities.pageDownEnd();
        registerPage.register(account);
        loginPage = registerPage.gotoLoginPage();
        loginPage.login(account.getEmail(),account.getPassword());
        timetablePage = homepage.gotoTimetablePage();
        ticketPricePage = timetablePage.checkPriceFromTimetable(ticket);
        Ticket ticket1 = new Ticket("Sài Gòn","Phan Thiết");
        ticketPricePage.bookTicketFromticketPrice(ticket1);
    }

    @Test
    public void TcTest1(){
        Utilities.pageDownEnd();
        registerPage.register(account);
        loginPage = registerPage.gotoLoginPage();
        loginPage.login(account.getEmail(),account.getPassword());
        changePasswordPage = homepage.gotoChangePasswordPage();
        changePasswordPage.changePassword(account, Constant.NEW_PASSWORD);

        Assert.assertEquals(changePasswordPage.getSuccessMsg(),Constant.CHECK_MSG_PASSWORD_UPDATE_SUCCESS,"update msg not displayed correctly");
    }

}
