package Testcase.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railways.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Testbase {

    public GeneralPage generalPage = new GeneralPage();
    public HomePage homepage = new HomePage();
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public ForgotPasswordPage forgotPasswordPage;
    public BookTicketPage bookTicketPage;
    public TicketPricePage ticketPricePage;

    @BeforeClass
    public void BeforeClass(){
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath());
        Constant.WEBDRIVER.maximize();
        homepage.open();
    }

    @AfterClass
    public void AfterClass(){
        Constant.WEBDRIVER.quit();
    }


}
