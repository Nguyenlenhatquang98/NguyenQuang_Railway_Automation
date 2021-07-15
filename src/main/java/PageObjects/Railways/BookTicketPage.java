package PageObjects.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Model.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {

    // Locators

    private final By _comboBoxDepartDate = By.name("Date");
    private final By _comboBoxDepartFrom = By.name("DepartStation");
    private final By _comboBoxArriveAt = By.name("ArriveStation");
    private final By _comboBoxSeatType = By.name("SeatType");
    private final By _comboBoxTicketAmount = By.name("TicketAmount");
    private final By _btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By _lblErrorForm = By.xpath("//p[@class='message error']");
    private final By _lblErrorTicketAmount = By.xpath("//label[@class='validation-error']");
    private final By _lblDepartFrom = By.xpath("//select[@name='DepartStation']/option[@selected='selected']");
    private final By _lblArriveStation = By.xpath("//select[@name='ArriveStation']/option[@selected='selected']");
    private final By _lblSeatType = By.xpath("//select[@name='SeatType']/option[@selected='selected']");


    // Elements

    protected WebElement getDepartDateElement() {
        return Constant.WEBDRIVER.findElement(_comboBoxDepartDate);
    }

    protected WebElement getDepartFromElement() {
        return Constant.WEBDRIVER.findElement(_comboBoxDepartFrom);
    }

    protected WebElement getArriveAtElement() {
        return Constant.WEBDRIVER.findElement(_comboBoxArriveAt);
    }

    protected WebElement getSeatTypeElement() {
        return Constant.WEBDRIVER.findElement(_comboBoxSeatType);
    }

    protected WebElement getTicketAmountElement() {
        return Constant.WEBDRIVER.findElement(_comboBoxTicketAmount);
    }

    protected WebElement getBookTicketElement() {
        return Constant.WEBDRIVER.findElement(_btnBookTicket);
    }

    // Methods

    public void BookTicket(Ticket ticket, int amount) {
        Utilities.pageDownEnd();
        Select departDateSelect = new Select(getDepartDateElement());
        Select departFromSelect = new Select(getDepartFromElement());
        Select arriveAtSelect = new Select(getArriveAtElement());
        Select seatTypeSelect = new Select(getSeatTypeElement());
        Select ticketAmountSelect = new Select(getTicketAmountElement());
        departDateSelect.selectByVisibleText(ticket.getDEPARTDATE());
        departFromSelect.selectByValue(Integer.toString(changeCityToIndex(ticket.getDEPARTFROM())));
        arriveAtSelect.selectByValue(Integer.toString(changeCityToIndex(ticket.getARRIVEAT())));
        seatTypeSelect.selectByValue(Integer.toString(changeSeatTypeToIndex(ticket.getSEATTYPE())));
        ticketAmountSelect.selectByVisibleText(Integer.toString(amount));
        getBookTicketElement().click();
    }

    public String getDepartStationCheck() {
        return Constant.WEBDRIVER.findElement(_lblDepartFrom).getText();
    }

    public String getArriveStationCheck() {
        return Constant.WEBDRIVER.findElement(_lblArriveStation).getText();
    }

    public String getSeatTypeCheck() {
        return Constant.WEBDRIVER.findElement(_lblSeatType).getText();
    }

    public String getBookDepartStation() {
        return getDepartFromElement().getText();
    }

    public String getBookArriveStation() {
        return getArriveAtElement().getText();
    }

    public String getBookSeatType() {
        return getSeatTypeElement().getText();
    }

    public String getErrorForm() {
        return Constant.WEBDRIVER.findElement(_lblErrorForm).getText();
    }

    public String getErrorAmountTicket() {
        return Constant.WEBDRIVER.findElement(_lblErrorTicketAmount).getText();
    }


}
