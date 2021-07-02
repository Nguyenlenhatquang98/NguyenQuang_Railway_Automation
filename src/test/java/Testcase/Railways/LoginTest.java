package Testcase.Railways;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railways.HomePage;
import PageObjects.Railways.LoginPage;
import com.google.common.base.Verify;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class LoginTest {
    private HomePage homepage = new HomePage();
    private LoginPage loginPage;

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
        loginPage = homepage.gotoLoginPage();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
    }

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

//        String actualMsg = homepage.getWelcomeMessage();
//        String expectedMsg = "Welcome " + Constant.USERNAME;
//        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

        boolean checklblWelcomeExist = homepage.checkWelcomeExist();

        Verify.verify(checklblWelcomeExist,"Welcome message is not displayed as expected");
        homepage.logout();
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


}
