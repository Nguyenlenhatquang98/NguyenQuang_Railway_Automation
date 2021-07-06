package Testcase.Railways;

import Common.Constant.Constant;
import PageObjects.Railways.ContactPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ContactTest extends Testbase {


    @Test(description = "TC04 - Contact Email contains correct href value which can help to quickly open Outlook Compose Message dialog")
    public void TC04() {
        ContactPage contactPage = homepage.gotoContactPage();
        String expectedEmail = Constant.EMAIL;
        String actualEmail = contactPage.getEmailHref();
        Assert.assertEquals(actualEmail, expectedEmail, "Error message is not displayed as expected");
    }


}
