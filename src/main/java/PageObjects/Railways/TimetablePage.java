package PageObjects.Railways;

import Common.Constant.Constant;
import Model.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {

    // Locators

    private final By _lblTimetable = By.xpath("//h1[text()='Train Timetable']");

    // Elements

    protected WebElement timetableElement = Constant.WEBDRIVER.findElement(_lblTimetable);

    // Methods

    public String getTrainTimetable() {
        return timetableElement.getText();
    }

    public TicketPricePage checkPriceFromTimetable(Ticket ticket) {
        String xpathCheckPrice = String.format("//a[contains(@href,'id1=" + "%d" + "&id2=" + "%d')]", changeCityToIndex(ticket.getDEPARTFROM()), changeCityToIndex(ticket.getARRIVEAT()));
        By _linkCheckPrice = By.xpath(xpathCheckPrice);
        Constant.WEBDRIVER.findElement(_linkCheckPrice).click();
        return new TicketPricePage();
    }


}
