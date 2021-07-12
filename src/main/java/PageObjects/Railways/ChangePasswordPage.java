package PageObjects.Railways;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {
    //locators

    private final By _lblChangePassword = By.xpath("//h1[text()='Change password']");

    //Elements

    protected WebElement getChangePasswordElement() {
        return Constant.WEBDRIVER.findElement(_lblChangePassword);
    }

    //Methods

    public String getChangePassword() {
        return getChangePasswordElement().getText();
    }
}
