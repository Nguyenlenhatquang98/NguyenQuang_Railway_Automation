package Testcase.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.WebDriverManager.WebDriverManager;
import Model.Account;
import Model.Ticket;
import PageObjects.Railways.*;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestBase {

    public GeneralPage generalPage = new GeneralPage();
    public HomePage homepage = new HomePage();
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public ForgotPasswordPage forgotPasswordPage;
    public BookTicketPage bookTicketPage;
    public TicketPricePage ticketPricePage;
    public MyTicketPage myTicketPage;
    public Account account;
    public Ticket ticket;

    @BeforeClass
    public void BeforeClass() {
        System.setProperty("webdriver.chrome.driver", Utilities.getDriverPath());
        Constant.WEBDRIVER = WebDriverManager.getInstance();
        Constant.WEBDRIVER.maximize();
        homepage.open();
    }


    @AfterClass
    public void AfterClass() {
        Constant.WEBDRIVER.quit();
    }


}
