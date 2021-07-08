package PageObjects.Railways;

import Common.Constant.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {

    //locators

    private final By _lblManageTicket = By.xpath("//div[@id='content']//h1");
    private final By _lblErrorMsg = By.xpath("//div[@class='message']/li");

    //Elements

    protected WebElement getLblMangeTicket() {
        return Constant.WEBDRIVER.findElement(_lblManageTicket);
    }

    //Methods

    public String getManageTicket(){
        return getLblMangeTicket().getText();
    }

    public void cancelTicket(int row){
        int actualRow = row + 1;
        String OperationXpath = "//table[@class='MyTable']//tr["+actualRow+"]/td[11]/input";
        By _btnOperation =  By.xpath(OperationXpath);
        Constant.WEBDRIVER.findElement(_btnOperation).click();
        Alert alert =  Constant.WEBDRIVER.switchToAlert();
        alert.accept();
    }

    public String getErrorMsg(){
        return Constant.WEBDRIVER.findElement(_lblErrorMsg).getText();
    }

}
