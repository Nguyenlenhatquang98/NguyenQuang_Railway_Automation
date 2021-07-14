package Testcase.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Model.Account;
import Model.Ticket;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTicketTest extends TestBase {

    @BeforeMethod
    public void beforeMethod() {
        account = new Account();
        ticket = new Ticket();
        System.out.println("Pre-condition");
        registerPage = homepage.gotoRegisterPage();
        Utilities.pageDownEnd();
        registerPage.register(account);
        loginPage = registerPage.gotoLoginPage();
        loginPage.login(account.getEmail(), account.getPassword());


    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        generalPage.logout();
    }

    @Test(description = "User can't book more than 10 tickets")
    public void TC14() {
        bookTicketPage = homepage.gotoBookTicketPage();
        bookTicketPage.BookTicket(ticket, Constant.MAX_AMOUNT_OF_TICKET);
        bookTicketPage.gotoBookTicketPage();
        bookTicketPage.BookTicket(ticket, Constant.A_TICKET);
        Assert.assertEquals(bookTicketPage.getErrorForm(), Constant.CHECK_MSG_FORM_ERROR, "Error message not displayed correctly");
        Assert.assertEquals(bookTicketPage.getErrorAmountTicket(), Constant.CHECK_MSG_TICKET_AMOUNT_ERROR, "Error message not displayed correctly");

    }

    @Test(description = "User can open 'Book ticket' page by click on 'Book ticket' link in 'Ticket price'")
    public void TC15() {
        ticketPricePage = homepage.gotoTicketPricePage();
        ticketPricePage.checkPriceFromTicketPrice(ticket);
        bookTicketPage = ticketPricePage.bookTicketFromticketPrice(ticket);
        Assert.assertEquals(bookTicketPage.getDepartStationCheck(), Constant.DEPART_FROM, "Depart Station was incorrect");
        Assert.assertEquals(bookTicketPage.getArriveStationCheck(), Constant.ARRIVE_AT, "Arrive Station was incorrect");
        Assert.assertEquals(bookTicketPage.getSeatTypeCheck(), Constant.SEAT_TYPE, "Seat type was incorrect");

    }

    @Test(description = "User can cancel a ticket")
    public void TC16() {
        bookTicketPage = homepage.gotoBookTicketPage();
        bookTicketPage.BookTicket(ticket, Constant.A_TICKET);
        myTicketPage = bookTicketPage.gotoMyTicketPage();
        By ticketDeleted = myTicketPage.cancelTicket(Constant.ROW_TICKET_CANCEL);
        boolean isTicketExist = myTicketPage.checkIdTicketExist(ticketDeleted);
        Assert.assertTrue(!isTicketExist, "Ticket still not cancel");
    }


}
