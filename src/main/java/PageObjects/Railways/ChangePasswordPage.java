package PageObjects.Railways;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {
    //locators

    private final By _lblChangePassword = By.xpath("//h1[text()='Change password']");
    private final By _txtCurrentPassword = By.id("currentPassword");
    private final By _txtNewPassword = By.id("newPassword");
    private final By _txtConfirmPassword = By.id("confirmPassword");
    private final By _btnChangePassword = By.xpath("//input[@value='Change Password']");


    //Elements

    protected WebElement getChangePasswordElement() {
        return Constant.WEBDRIVER.findElement(_lblChangePassword);
    }

    protected WebElement getCurrentPasswordElement() {
        return Constant.WEBDRIVER.findElement(_txtCurrentPassword);
    }

    protected WebElement getNewPasswordElement() {
        return Constant.WEBDRIVER.findElement(_txtNewPassword);
    }

    protected WebElement getConfirmPassword() {
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }

    protected WebElement getUpdatePasswordElement() {
        return Constant.WEBDRIVER.findElement(_btnChangePassword);
    }


    //Methods

    public String getChangePassword() {
        return getChangePasswordElement().getText();
    }

}
