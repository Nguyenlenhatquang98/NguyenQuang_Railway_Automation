package PageObjects.Railways;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage{

    //Locators

    private final By _txtEmail = By.xpath("//div[@id='content']//li[@class='email']/input");
    private final By _txtPassword = By.xpath("//div[@id='content']//li[@class='password']/input");
    private final By _txtConfirmPassword = By.xpath("//div[@id='content']//li[@class='confirm-password']/input");
    private final By _txtPIDPassport = By.xpath("//div[@id='content']//li[@class='pid-number']/input");
    private final By _btnRegister = By.xpath("//p[@class='form-actions']/input");
    private final By _lblConfirmRegister =  By.xpath("//div[@id='content']/p");
    private final By _lblErrorMsg = By.xpath("//div[@id='content']/p[@class='message error']");
    private final By _lblPasswordErrorMsg = By.xpath("//div[@id='content']//li[@class='password']/label[@class='validation-error']");
    private final By _lblPidErrorMsg = By.xpath("//div[@id='content']//li[@class='pid-number']/label[@class='validation-error']");

    //Elements

    protected WebElement getTxtEmail(){
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }

    protected  WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    protected  WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }

    protected  WebElement getTxtPidPassport(){
        return Constant.WEBDRIVER.findElement(_txtPIDPassport);
    }

    protected  WebElement getBtnRegister(){
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }

    protected  WebElement getLblConfirmRegister(){
        return Constant.WEBDRIVER.findElement(_lblConfirmRegister);
    }

    //Methods

    public RegisterPage register(String email,String password, String confirmPassword, String PIDPassport){
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPidPassport().sendKeys(PIDPassport);
        getBtnRegister().click();
        return new RegisterPage();
    }

    public String getConfirmRegister(){
        return getLblConfirmRegister().getText();
    }

    public String getErrorMsg(){
        return Constant.WEBDRIVER.findElement(_lblErrorMsg).getText();
    }

    public String getPasswordErrorMsg(){
        return Constant.WEBDRIVER.findElement(_lblPasswordErrorMsg).getText();
    }

    public String getPidErrorMsg(){
        return Constant.WEBDRIVER.findElement(_lblPidErrorMsg).getText();
    }

}
