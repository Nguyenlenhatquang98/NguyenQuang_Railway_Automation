package PageObjects.Railways;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage {
    //Locators

    private final By _txtEmailAddress = By.id("email");
    private final By _btnSendInstructions = By.xpath("//input[@value='Send Instructions']");
    private final By _lblPasswordReset = By.xpath("//legend[contains(text(),'Password Reset')]");
    private final By _msgError = By.xpath("//p[@class='message error']");

    //Elements

    protected WebElement getEmailAddressElememt() {
        return Constant.WEBDRIVER.findElement(_txtEmailAddress);
    }

    protected WebElement getSendInstructionsElement() {
        return Constant.WEBDRIVER.findElement(_btnSendInstructions);
    }

    protected WebElement getPasswordResetElement() {
        return Constant.WEBDRIVER.findElement(_lblPasswordReset);
    }

    protected WebElement getErrorMsgElement() {
        return Constant.WEBDRIVER.findElement(_msgError);
    }
    //Methods

    public void sendInstructions(String username) {
        getEmailAddressElememt().sendKeys(username);
        getSendInstructionsElement().click();
    }

    public String getPasswordResetText() {
        return getPasswordResetElement().getText();
    }

    public String getErrorMessage() {
        return getErrorMsgElement().getText();
    }

}
