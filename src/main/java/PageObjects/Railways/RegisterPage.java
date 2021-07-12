package PageObjects.Railways;

import Common.Constant.Constant;
import Model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    //Locators

    private final By _txtEmail = By.id("email");
    private final By _txtPassword = By.id("password");
    private final By _txtConfirmPassword = By.id("confirmPassword");
    private final By _txtPIDPassport = By.id("pid");
    private final By _btnRegister = By.xpath("//input[@value='Register']");
    private final By _lblConfirmRegister = By.xpath("//p[contains(text(),'here')]");
    private final By _lblErrorMsg = By.xpath("//p[@class='message error']");
    private final By _lblPasswordErrorMsg = By.xpath("//label[@class='validation-error' and @for='password']");
    private final By _lblPidErrorMsg = By.xpath("//label[@class='validation-error' and @for='pid']");

    //Elements

    protected WebElement getEmailElement() {
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }

    protected WebElement getPasswordElement() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    protected WebElement getConfirmPasswordElement() {
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }

    protected WebElement getPidPassportElement() {
        return Constant.WEBDRIVER.findElement(_txtPIDPassport);
    }

    protected WebElement getRegisterElement() {
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }

    protected WebElement getConfirmRegisterElement() {
        return Constant.WEBDRIVER.findElement(_lblConfirmRegister);
    }

    //Methods

    public RegisterPage register(Account account) {
        getEmailElement().sendKeys(account.getEmail());
        getPasswordElement().sendKeys(account.getPassword());
        getConfirmPasswordElement().sendKeys(account.getPassword());
        getPidPassportElement().sendKeys(account.getPID());
        getRegisterElement().click();
        return new RegisterPage();
    }

    public RegisterPage registerFail(Account account) {
        getEmailElement().sendKeys(account.getEmail());
        getPasswordElement().sendKeys(Constant.EMPTY_DATA);
        getConfirmPasswordElement().sendKeys(Constant.EMPTY_DATA);
        getPidPassportElement().sendKeys(Constant.EMPTY_DATA);
        getRegisterElement().click();
        return new RegisterPage();
    }

    public String getConfirmRegister() {
        return getConfirmRegisterElement().getText();
    }

    public String getErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblErrorMsg).getText();
    }

    public String getPasswordErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblPasswordErrorMsg).getText();
    }

    public String getPidErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblPidErrorMsg).getText();
    }

}
