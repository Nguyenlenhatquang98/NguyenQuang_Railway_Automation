package PageObjects.Railways;

import Common.Constant.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {

    //locators

    private final By _lblManageTicket = By.xpath("//div[@id='content']//h1[text()='Manage Tickets']");
    private final By _lblNoteMsg = By.xpath("//div[@class='message']/li[contains(text(),'0 ticket')]");

    //Elements

    protected WebElement getLblMangeTicket() {
        return Constant.WEBDRIVER.findElement(_lblManageTicket);
    }

    //Methods

    public String getManageTicket() {
        return getLblMangeTicket().getText();
    }

    public By cancelTicket(int row) {
        int actualRow = row + 1;
        String OperationXpath = "//table[@class='MyTable']//tr[" + actualRow + "]/td[11]/input[@value='Cancel']";
        By _btnOperation = By.xpath(OperationXpath);
        Constant.WEBDRIVER.findElement(_btnOperation).click();
        Alert alert = Constant.WEBDRIVER.switchToAlert();
        alert.accept();
        return _btnOperation;
    }

    public boolean checkIdTicketExist(By locator) {
        if (Constant.WEBDRIVER.findElement(locator) == null) {
            return false;
        } else {
            return true;
        }
    }

    public String getErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblNoteMsg).getText();
    }

}
