package PageObjects.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Model.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {

    // Locators

    private final By _comboBoxDepartDate = By.xpath("//form//select[@name='Date']");
    private final By _comboBoxDepartFrom = By.xpath("//form//select[@name='DepartStation']");
    private final By _comboBoxArriveAt = By.xpath("//form//select[@name='ArriveStation']");
    private final By _comboBoxSeatType = By.xpath("//form//select[@name='SeatType']");
    private final By _comboBoxTicketAmount = By.xpath("//form//select[@name='TicketAmount']");
    private final By _btnBookTicket = By.xpath("//form//input[@value='Book ticket']");
    private final By _lblErrorForm = By.xpath("//div[@id='content']//p[@class='message error']");
    private final By _lblErrorTicketAmount = By.xpath("//form//li[5]//label[@class='validation-error']");
    private final By _lblDepartFrom = By.xpath("//div[@id='content']//select[@name='DepartStation']/option[@selected='selected']");
    private final By _lblArriveStation = By.xpath("//div[@id='content']//select[@name='ArriveStation']/option[@selected='selected']");
    private final By _lblSeatType = By.xpath("//div[@id='content']//select[@name='SeatType']/option[@selected='selected']");


    // Elements

    protected WebElement getDepartDate() {
        return Constant.WEBDRIVER.findElement(_comboBoxDepartDate);
    }

    protected WebElement getDepartFrom() {
        return Constant.WEBDRIVER.findElement(_comboBoxDepartFrom);
    }

    protected WebElement getArriveAt() {
        return Constant.WEBDRIVER.findElement(_comboBoxArriveAt);
    }

    protected WebElement getSeatType() {
        return Constant.WEBDRIVER.findElement(_comboBoxSeatType);
    }

    protected WebElement getTicketAmount() {
        return Constant.WEBDRIVER.findElement(_comboBoxTicketAmount);
    }

    protected WebElement getBookTicket() {
        return Constant.WEBDRIVER.findElement(_btnBookTicket);
    }

    // Methods

    public void BookTicket(Ticket ticket, int amount) {
        Utilities.pageDownEnd();
        Select departDateSelect = new Select(getDepartDate());
        Select departFromSelect = new Select(getDepartFrom());
        Select arriveAtSelect = new Select(getArriveAt());
        Select seatTypeSelect = new Select(getSeatType());
        Select ticketAmountSelect = new Select(getTicketAmount());
        departDateSelect.selectByVisibleText(ticket.getDEPARTDATE());
        departFromSelect.selectByValue(Integer.toString(changeCityToIndex(ticket.getDEPARTFROM())));
        arriveAtSelect.selectByValue(Integer.toString(changeCityToIndex(ticket.getARRIVEAT())));
        seatTypeSelect.selectByValue(Integer.toString(changeSeatTypeToIndex(ticket.getSEATTYPE())));
        ticketAmountSelect.selectByVisibleText(Integer.toString(amount));
        getBookTicket().click();
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
        return getDepartFrom().getText();
    }

    public String getBookArriveStation() {
        return getArriveAt().getText();
    }

    public String getBookSeatType() {
        return getSeatType().getText();
    }


    public String getErrorForm() {
        return Constant.WEBDRIVER.findElement(_lblErrorForm).getText();
    }

    public String getErrorAmountTicket() {
        return Constant.WEBDRIVER.findElement(_lblErrorTicketAmount).getText();
    }


}
