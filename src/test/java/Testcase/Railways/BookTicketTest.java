package Testcase.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTicketTest extends Testbase{

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
        registerPage.register(USERNAME_REGISTER,PASSWORD_REGISTER,PASSWORD_REGISTER,PID_PASSPORT_REGISTER);
        loginPage = registerPage.gotoLoginPage();
        loginPage.login(USERNAME_REGISTER,PASSWORD_REGISTER);


    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        generalPage.logout();
    }

    @Test(description = "User can't book more than 10 tickets")
    public void TC14(){
        bookTicketPage = homepage.gotoBookTicketPage();
        bookTicketPage.BookTicket(Constant.DEPART_DATE,Constant.DEPART_FROM,Constant.ARRIVE_AT,Constant.SEAT_TYPE,Constant.MAX_AMOUNT_OF_TICKET);
        bookTicketPage.gotoBookTicketPage();
        bookTicketPage.BookTicket(Constant.DEPART_DATE,Constant.DEPART_FROM,Constant.ARRIVE_AT,Constant.SEAT_TYPE,Constant.A_TICKET);
        Assert.assertEquals(bookTicketPage.getErrorForm(),Constant.CHECK_MSG_FORM_ERROR,"Error message not displayed correctly");
        Assert.assertEquals(bookTicketPage.getErrorAmountTicket(),Constant.CHECK_MSG_TICKET_AMOUNT_ERROR,"Error message not displayed correctly");

    }

    @Test(description = "User can open 'Book ticket' page by click on 'Book ticket' link in 'Ticket price'")
    public void TC15(){
        ticketPricePage = homepage.gotoTicketPricePage();
        bookTicketPage =  ticketPricePage.SelectOption(Constant.DEPART_FROM,Constant.ARRIVE_AT,Constant.SEAT_TYPE);
        Assert.assertEquals(bookTicketPage.getDepartStationCheck(),Constant.DEPART_FROM,"Depart Station was incorrect");
        Assert.assertEquals(bookTicketPage.getArriveStationCheck(),Constant.ARRIVE_AT,"Arrive Station was incorrect");
        Assert.assertEquals(bookTicketPage.getSeatTypeCheck(),Constant.SEAT_TYPE,"Seat type was incorrect");

    }
}
