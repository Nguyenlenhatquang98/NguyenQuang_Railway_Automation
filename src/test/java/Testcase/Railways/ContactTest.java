package Railways;

import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class ContactTest {
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
    public void TC04() {

        System.out.println("TC04 - Contact Email contains correct href value which can help to quickly open Outlook Compose Message dialog");
        ContactPage contactPage = homepage.gotoContactPage();
        String expectedEmail = "mailto:thanh.viet.le@logigear.com";
        Assert.assertEquals(contactPage.getEmailHref(),expectedEmail, "Error message is not displayed as expected");
    }




}
