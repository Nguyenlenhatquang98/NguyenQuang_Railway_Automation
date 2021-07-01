package Railway;

import Common.Utilities;
import Constant.Constant;
import Railway.HomePage;
import Railway.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class LoginTest {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() );
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
        WebElement html = Constant.WEBDRIVER.findElement(By.tagName("html"));

    }


    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
    @Test
    public void TC01(){

        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homepage = new HomePage();
        homepage.open();

        LoginPage loginPage = homepage.gotoLoginPage();

        GeneralPage homepageLoggedIn = loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        String actualMsg = homepageLoggedIn.getWelcomeMessage();
        String expectedMsg = "Welcome "+ Constant.USERNAME;

        Assert.assertEquals(actualMsg,expectedMsg, "Welcome message is not displayed as expected");


    }
    @Test
    public void TC02(){

        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homepage = new HomePage();
        homepage.open();

        LoginPage loginPage = homepage.gotoLoginPage();

        loginPage.login("nguyenlenhatquang",Constant.PASSWORD);

        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg,expectedMsg, "Welcome message is not displayed as expected");

    }

}
