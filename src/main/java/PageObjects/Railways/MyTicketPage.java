package PageObjects.Railways;

import Common.Constant.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage extends GeneralPage {

    //locators

    private final By _lblManageTicket = By.xpath("//h1[text()='Manage Tickets']");
    private final By _comboBoxDpStation = By.name("FilterDpStation");
    private final By _comboBoxArStation = By.name("FilterArStation");
    private final By _txtDepartDate = By.name("FilterDpDate");
    private final By _comboBoxStatus = By.name("FilterStatus");
    private final By _btnFilter = By.xpath("//input[@value='Apply Filter']");
    private final By _msgError = By.xpath("//div[@class='error message']");

    //Elements

    protected WebElement getManageTicketElement() {
        return Constant.WEBDRIVER.findElement(_lblManageTicket);
    }

    protected WebElement getDpStationElement() {
        return Constant.WEBDRIVER.findElement(_comboBoxDpStation);
    }

    protected WebElement getArStationElement() {
        return Constant.WEBDRIVER.findElement(_comboBoxArStation);
    }

    protected WebElement getDpDateElement() {
        return Constant.WEBDRIVER.findElement(_txtDepartDate);
    }

    protected WebElement getFilterTicketElement() {
        return Constant.WEBDRIVER.findElement(_btnFilter);
    }

    protected WebElement getErrorElement() {
        return Constant.WEBDRIVER.findElement(_msgError);
    }

    //Methods

    public String getManageTicket() {
        return getManageTicketElement().getText();
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
        return getErrorElement().getText();
    }

    public int countRowCondition(String ArriveStation) {
        String xpathRowCondition = "//table[@class='MyTable']//td[3][.='" + ArriveStation + "']";
        By rowConditionElement = By.xpath(xpathRowCondition);
        return Constant.WEBDRIVER.countElements(rowConditionElement);
    }

    public int countRow(By locator) {
        return Constant.WEBDRIVER.countElements(locator) - 1;
    }

    public void filterTicket(String DepartStation, String ArriveStation, String DepartDate) {
        Select departStationFilter = new Select(getDpStationElement());
        Select arriveStationFilter = new Select(getArStationElement());
        if (DepartStation.equals(Constant.EMPTY_DATA)) {
            departStationFilter.selectByVisibleText("Ignore");
        } else {
            departStationFilter.selectByVisibleText(DepartStation);
        }
        if (ArriveStation.equals(Constant.EMPTY_DATA)) {
            departStationFilter.selectByVisibleText("Ignore");
        } else {
            arriveStationFilter.selectByVisibleText(ArriveStation);
        }
        getDpDateElement().sendKeys(DepartDate);
        getFilterTicketElement().click();
    }

    public boolean checkFilterCorrect(int rowConditionBeforeFilter, int rowConditionAfterFilter) {
        By rowElement = By.xpath("//table[@class='MyTable']//tr");
        int rowAfterFilter = countRow(rowElement);
        if (rowConditionBeforeFilter != rowConditionAfterFilter) {
            return false;
        } else {
            if (rowConditionAfterFilter != rowAfterFilter) {
                return false;
            } else {
                return true;
            }
        }
    }


}
