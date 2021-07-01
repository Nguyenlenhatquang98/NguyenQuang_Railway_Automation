package Railways;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends GeneralPage{
    private final By email = By.xpath("//div[@id='content']//a");

    protected WebElement getEmail(){
        return Constant.WEBDRIVER.findElement(email);
    }

    public String getEmailHref(){
        return getEmail().getAttribute("href");
    }
}
