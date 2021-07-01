package Railways;

import Common.Utilities;
import Constant.Constant;
import com.google.common.base.Verify;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class LoginTest {
    private HomePage homepage = new HomePage();


    @BeforeClass
    public void BeforeClass(){

        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath());
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();

    }

    @AfterClass
    public void AfterClass(){
        Constant.WEBDRIVER.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        homepage.open();
    }


    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");

    }

    @Test
    public void TC01() {

        System.out.println("TC01 - User can log into Railway with valid username and password");

        LoginPage loginPage = homepage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        /*String actualMsg = homepage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");*/

        Verify.verify(homepage.checklblWelcomeExist(),"Welcome message is not displayed as expected");
        homepage.logout();

    }

    @Test
    public void TC02() {

        System.out.println("TC02 - User can log into Railway with blank username and password");
        LoginPage loginPage = homepage.gotoLoginPage();
        loginPage.login("", Constant.PASSWORD);
        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");

    }

    @Test
    public void TC03(){

        System.out.println("TC03 - User cannot log into Railway with invalid password");
        LoginPage loginPage = homepage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, "nguyenlenhatquang0");
        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }


}
