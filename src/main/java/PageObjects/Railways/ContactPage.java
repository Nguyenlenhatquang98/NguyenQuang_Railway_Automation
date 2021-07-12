package PageObjects.Railways;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends GeneralPage {

    // Locators

    private final By _lblEmail = By.xpath("//a[@href='mailto:thanh.viet.le@logigear.com']");

    // Elements

    protected WebElement getEmailElement() {
        return Constant.WEBDRIVER.findElement(_lblEmail);
    }

    // Methods

    public String getEmailHref() {
        return getEmailElement().getAttribute("href");
    }
}
