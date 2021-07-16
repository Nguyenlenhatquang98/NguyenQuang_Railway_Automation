package PageObjects.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Model.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
    private final By _lblDepartStationBooked = By.xpath("//th[text()='Depart Station']/parent::tr/following-sibling::tr/td[1]");
    private final By _lblArriveStationBooked = By.xpath("//th[text()='Arrive Station']/parent::tr/following-sibling::tr/td[2]");
    private final By _lblSeatTypeBooked = By.xpath("//th[text()='Seat Type']/parent::tr/following-sibling::tr/td[3]");
    private final By _lblDepartDateBooked = By.xpath("//th[text()='Depart Date']/parent::tr/following-sibling::tr/td[4]");
    private final By _lblAmountTicketBooked = By.xpath("//th[text()='Amount']/parent::tr/following-sibling::tr/td[7]");
    private final By _msgBookedSuccessfully = By.xpath("//h1[text()='Ticket Booked Successfully!']");

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

    public void bookTicket(Ticket ticket, int amount) {
        Utilities.pageDownEnd();
        if (!ticket.getDEPARTDATE().equals(Constant.EMPTY_DATA)) {
            Select departDateSelect = new Select(getDepartDateElement());
            departDateSelect.selectByVisibleText(ticket.getDEPARTDATE());
        }
        if (!ticket.getDEPARTFROM().equals(Constant.EMPTY_DATA)) {
            Select departFromSelect = new Select(getDepartFromElement());
            departFromSelect.selectByValue(Integer.toString(changeCityToIndex(ticket.getDEPARTFROM())));
        }
        if (!ticket.getARRIVEAT().equals(Constant.EMPTY_DATA)) {
            Select arriveAtSelect = new Select(getArriveAtElement());
            arriveAtSelect.selectByValue(Integer.toString(changeCityToIndex(ticket.getARRIVEAT())));
        }
        if (!ticket.getSEATTYPE().equals(Constant.EMPTY_DATA)) {
            Select seatTypeSelect = new Select(getSeatTypeElement());
            seatTypeSelect.selectByValue(Integer.toString(changeSeatTypeToIndex(ticket.getSEATTYPE())));
        }
        if (amount > 0) {
            Select ticketAmountSelect = new Select(getTicketAmountElement());
            ticketAmountSelect.selectByVisibleText(Integer.toString(amount));
        }
        getBookTicketElement().click();
    }

    public List<Integer> listIndex() {
        List<Integer> numbers = new LinkedList<>();
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        return numbers;
    }

    public void bookTicketSeveralTime(Ticket ticket, int amount, int times) {
        for (int i = 0; i < times; i++) {
            Random random = new Random();
            List<Integer> indexOfArrive = listIndex();
            Utilities.pageDownEnd();
            Select departDateSelect = new Select(getDepartDateElement());
            Select departFromSelect = new Select(getDepartFromElement());
            Select arriveAtSelect = new Select(getArriveAtElement());
            Select seatTypeSelect = new Select(getSeatTypeElement());
            Select ticketAmountSelect = new Select(getTicketAmountElement());
            departDateSelect.selectByVisibleText(ticket.getDEPARTDATE());
            departFromSelect.selectByValue(Integer.toString(changeCityToIndex(ticket.getDEPARTFROM())));
            arriveAtSelect.selectByValue(Integer.toString(indexOfArrive.get(random.nextInt(indexOfArrive.size()))));
            seatTypeSelect.selectByValue(Integer.toString(changeSeatTypeToIndex(ticket.getSEATTYPE())));
            ticketAmountSelect.selectByVisibleText(Integer.toString(amount));
            getBookTicketElement().click();
            GeneralPage generalPage = new GeneralPage();
            generalPage.gotoBookTicketPage();
        }
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


    public String getDepartStationBooked() {
        return Constant.WEBDRIVER.findElement(_lblDepartStationBooked).getText();
    }

    public String getArriveStationBooked() {
        return Constant.WEBDRIVER.findElement(_lblArriveStationBooked).getText();
    }

    public String getSeatTypeBooked() {
        return Constant.WEBDRIVER.findElement(_lblSeatTypeBooked).getText();
    }

    public String getDepartDateBooked() {
        return Constant.WEBDRIVER.findElement(_lblDepartDateBooked).getText();
    }

    public int getAmountTicketBooked() {
        return Integer.parseInt(Constant.WEBDRIVER.findElement(_lblAmountTicketBooked).getText());
    }

    public String getBookedSuccessMsg() {
        return Constant.WEBDRIVER.findElement(_msgBookedSuccessfully).getText();
    }

    public String getErrorForm() {
        return Constant.WEBDRIVER.findElement(_lblErrorForm).getText();
    }

    public String getErrorAmountTicket() {
        return Constant.WEBDRIVER.findElement(_lblErrorTicketAmount).getText();
    }


    public boolean checkTicketInformation(Ticket ticket, int amount) {
        if (!getDepartStationBooked().equals(ticket.getDEPARTFROM()) || !getArriveStationBooked().equals(ticket.getARRIVEAT()) || !getSeatTypeBooked().equals(ticket.getSEATTYPE()) || !getDepartDateBooked().equals(ticket.getDEPARTDATE()) || getAmountTicketBooked() != amount) {
            return false;
        } else {
            return true;
        }
    }

}
