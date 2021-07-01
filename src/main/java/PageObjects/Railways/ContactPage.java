package Railways;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends GeneralPage{

    // Locators

    private final By email = By.xpath("//div[@id='content']//a");

    // Elements

    protected WebElement getEmail(){
        return Constant.WEBDRIVER.findElement(email);
    }

    // Methods

    public String getEmailHref(){
        return getEmail().getAttribute("href");
    }
}
