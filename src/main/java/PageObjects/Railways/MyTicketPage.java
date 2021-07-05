package PageObjects.Railways;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {

    //locators

    private final By _lblManageTicket = By.xpath("//div[@id='content']//h1");

    //Elements

    protected WebElement getLblMangeTicket() {
        return Constant.WEBDRIVER.findElement(_lblManageTicket);
    }

    //Methods

    public Boolean checkManageTicket(){
        return isElementExist(_lblManageTicket);
    }
}
