package PageObjects.Railways;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {

    //locators

    private final By _lblManageTicket = By.xpath("//div[@id='content']//h1");

    //Elements

    protected WebElement getLblMangeTicket() {
        return Constant.WEBDRIVER.findElement(_lblManageTicket);
    }

    //Methods

    public boolean checkManageTicket(){
        return isElementExist(_lblManageTicket);
    }

    public String getManageTicket(){
        return getLblMangeTicket().getText();
    }

    public void cancelTicket(int row){
        String OperationXpath = "//table[@class='MyTable']//tr["+row+"]/td[11]/input";
        By _btnOperation =  By.xpath(OperationXpath);
    }

}
