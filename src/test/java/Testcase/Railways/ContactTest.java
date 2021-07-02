package Testcase.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railways.ContactPage;
import PageObjects.Railways.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class ContactTest {
    private HomePage homepage = new HomePage();



    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath());
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
        System.out.println("Pre-condition");
        homepage.open();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC04() {
        System.out.println("TC04 - Contact Email contains correct href value which can help to quickly open Outlook Compose Message dialog");
        ContactPage contactPage = homepage.gotoContactPage();
        String expectedEmail = Constant.EMAIL;
        String actualEmail = contactPage.getEmailHref();
        Assert.assertEquals(actualEmail,expectedEmail, "Error message is not displayed as expected");
    }




}
