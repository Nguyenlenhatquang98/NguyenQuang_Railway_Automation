package Testcase.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Model.Account;
import Model.Ticket;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FinalTest extends TestBase {

    @BeforeMethod
    public void beforeMethod() {
        account = new Account();
        ticket = new Ticket();
        System.out.println("Pre-Condition");
        registerPage = homepage.gotoRegisterPage();
        Utilities.pageDownEnd();
        registerPage.register(account);
        loginPage = registerPage.gotoLoginPage();
        loginPage.login(account.getEmail(), account.getPassword());
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-Condition");
        generalPage.logout();
    }

    @Test(description = "User can book 1 ticket at a time")
    public void TC01() {
        bookTicketPage = homepage.gotoBookTicketPage();
        bookTicketPage.bookTicket(ticket, Constant.AMOUNT_OF_TICKET);
        Assert.assertEquals(bookTicketPage.getBookedSuccessMsg(), Constant.CHECK_MSG_BOOK_SUCCESS, "Message Booked successfully displayed not correctly");
        Assert.assertTrue(bookTicketPage.checkTicketInformation(ticket, Constant.AMOUNT_OF_TICKET), "Ticket information was incorrect");
    }

    @Test(description = "User can filter 'Manage ticket' table with Arrive Station")
    public void TC02() {
        bookTicketPage = homepage.gotoBookTicketPage();
        bookTicketPage.bookTicketSeveralTime(ticket, Constant.ONE_TICKET, Constant.AMOUNT_OF_BOOK_TICKET);
        myTicketPage = bookTicketPage.gotoMyTicketPage();
        int rowConditionBeforeFilter = myTicketPage.countRowCondition(Constant.BOOK_ARRIVE_STATION);
        myTicketPage.filterTicket(Constant.EMPTY_DATA, Constant.BOOK_ARRIVE_STATION, Constant.EMPTY_DATA);
        int rowConditionAfterFilter = myTicketPage.countRowCondition(Constant.BOOK_ARRIVE_STATION);
        boolean checkFilterCorrect = myTicketPage.checkFilterCorrect(rowConditionBeforeFilter, rowConditionAfterFilter);
        Assert.assertTrue(checkFilterCorrect, "Filter ticket is not correctly");
    }

    @Test(description = "Error displays when user applies filter with invalid format for 'Depart Date' in 'Manage ticket' table")
    public void TC03() {
        bookTicketPage = homepage.gotoBookTicketPage();
        bookTicketPage.bookTicketSeveralTime(ticket, Constant.ONE_TICKET, Constant.AMOUNT_OF_BOOK_TICKET);
        myTicketPage = bookTicketPage.gotoMyTicketPage();
        myTicketPage.filterTicket(Constant.EMPTY_DATA, Constant.EMPTY_DATA, Constant.INVALID_DEPART_DATE);

        Assert.assertEquals(myTicketPage.getErrorMsg(), Constant.CHECK_MSG_ERROR_FILTER, "Error message not displayed correctly");
    }


}
