package PageObjects.Railways;

import Common.Constant.Constant;
import Model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {
    //locators

    private final By _lblChangePassword = By.xpath("//h1[text()='Change password']");
    private final By _txtCurrentPassword = By.id("currentPassword");
    private final By _txtNewPassword = By.id("newPassword");
    private final By _txtConfirmPassword = By.id("confirmPassword");
    private final By _btnChangePassword = By.xpath("//input[@value='Change Password']");
    private final By _msgSuccess = By.xpath("//p[@class='message success']");
    private final By _msgError = By.xpath("//p[@class='message error']");

    //Elements

    protected WebElement getChangePasswordElement() {
        return Constant.WEBDRIVER.findElement(_lblChangePassword);
    }
    protected WebElement getCurrentPasswordElement(){
        return Constant.WEBDRIVER.findElement(_txtCurrentPassword);
    }
    protected WebElement getNewPasswordElement(){
        return Constant.WEBDRIVER.findElement(_txtNewPassword);
    }
    protected WebElement getConfirmPassword(){
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }
    protected WebElement getUpdatePasswordElement(){
        return Constant.WEBDRIVER.findElement(_btnChangePassword);
    }
    protected WebElement getSuccessElement(){
        return Constant.WEBDRIVER.findElement(_msgSuccess);
    }
    protected WebElement getErrorElement(){
        return Constant.WEBDRIVER.findElement(_msgError);
    }

    //Methods

    public String getChangePassword() {
        return getChangePasswordElement().getText();
    }

    public String getSuccessMsg(){
        return getSuccessElement().getText();
    }
    public String getErrorMsg(){
        return getErrorElement().getText();
    }
    public ChangePasswordPage changePassword(Account account, String newPassword){
        getCurrentPasswordElement().sendKeys(account.getPassword());
        getNewPasswordElement().sendKeys(newPassword);
        getConfirmPassword().sendKeys(newPassword);
        getUpdatePasswordElement().click();
        return new ChangePasswordPage();
    }
}
