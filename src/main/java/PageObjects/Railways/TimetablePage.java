package PageObjects.Railways;

import Common.Constant.Constant;
import Model.Ticket;
import org.openqa.selenium.By;

public class TimetablePage extends GeneralPage {

    // Locators

    // Elements


    // Methods


    public TicketPricePage checkPriceFromTimetable(Ticket ticket) {
        String xpathCheckPrice = String.format("//a[contains(@href,'id1=" + "%d" + "&id2=" + "%d')]", changeCityToIndex(ticket.getDEPARTFROM()), changeCityToIndex(ticket.getARRIVEAT()));
        By _linkCheckPrice = By.xpath(xpathCheckPrice);
        Constant.WEBDRIVER.findElement(_linkCheckPrice).click();
        return new TicketPricePage();
    }


}
