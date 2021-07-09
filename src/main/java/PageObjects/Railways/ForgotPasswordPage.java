package PageObjects.Railways;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage {
    //Locators

    private final By _txtEmailAddress = By.xpath("//div[@id='content']//input[@id='email']");
    private final By _btnSendInstructions = By.xpath("//div[@id='content']//input[@value='Send Instructions']");
    private final By _lblPasswordReset = By.xpath("//div[@id='content']//legend[contains(text(),'Password Reset')]");
    private final By _msgError = By.xpath("//div[@id='content']//p[@class='message error']");

    //Elements

    protected WebElement getEmailAddress(){
        return Constant.WEBDRIVER.findElement(_txtEmailAddress);
    }

    protected WebElement getSendInstructions(){
        return Constant.WEBDRIVER.findElement(_btnSendInstructions);
    }

    protected  WebElement getPasswordReset(){
        return Constant.WEBDRIVER.findElement(_lblPasswordReset);
    }

    protected  WebElement getErrorMsg(){
        return Constant.WEBDRIVER.findElement(_msgError);
    }
    //Methods

    public void sendInstructions(String username){
        getEmailAddress().sendKeys(username);
        getSendInstructions().click();
    }
    public String getPasswordResetText(){
        return getPasswordReset().getText();
    }

    public String getErrorMessage(){
        return getErrorMsg().getText();
    }

}
