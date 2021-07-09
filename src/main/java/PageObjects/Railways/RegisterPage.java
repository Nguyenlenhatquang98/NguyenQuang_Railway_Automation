package PageObjects.Railways;

import Common.Constant.Constant;
import Model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    //Locators

    private final By _txtEmail = By.xpath("//div[@id='content']//input[@id='email']");
    private final By _txtPassword = By.xpath("//div[@id='content']//input[@id='password']");
    private final By _txtConfirmPassword = By.xpath("//div[@id='content']//input[@id='confirmPassword']");
    private final By _txtPIDPassport = By.xpath("//div[@id='content']//input[@id='pid']");
    private final By _btnRegister = By.xpath("//div[@id='content']//input[@value='Register']");
    private final By _lblConfirmRegister = By.xpath("//div[@id='content']/p[contains(text(),'here')]");
    private final By _lblErrorMsg = By.xpath("//div[@id='content']/p[@class='message error']");
    private final By _lblPasswordErrorMsg = By.xpath("//div[@id='content']//li[@class='password']/label[@class='validation-error']");
    private final By _lblPidErrorMsg = By.xpath("//div[@id='content']//li[@class='pid-number']/label[@class='validation-error']");

    //Elements

    protected WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }

    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    protected WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }

    protected WebElement getTxtPidPassport() {
        return Constant.WEBDRIVER.findElement(_txtPIDPassport);
    }

    protected WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }

    protected WebElement getLblConfirmRegister() {
        return Constant.WEBDRIVER.findElement(_lblConfirmRegister);
    }

    //Methods

    public RegisterPage register(Account account) {
        getTxtEmail().sendKeys(account.getEmail());
        getTxtPassword().sendKeys(account.getPassword());
        getTxtConfirmPassword().sendKeys(account.getPassword());
        getTxtPidPassport().sendKeys(account.getPID());
        getBtnRegister().click();
        return new RegisterPage();
    }

    public RegisterPage registerFail(Account account) {
        getTxtEmail().sendKeys(account.getEmail());
        getTxtPassword().sendKeys(Constant.EMPTY_DATA);
        getTxtConfirmPassword().sendKeys(Constant.EMPTY_DATA);
        getTxtPidPassport().sendKeys(Constant.EMPTY_DATA);
        getBtnRegister().click();
        return new RegisterPage();
    }

    public String getConfirmRegister() {
        return getLblConfirmRegister().getText();
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
