package PageObjects.Railways;

import Common.Constant.Constant;
import Model.Ticket;
import org.openqa.selenium.By;

public class TicketPricePage extends GeneralPage {

    // Locators

    // Elements

    // Methods


    public TicketPricePage checkPriceFromTicketPrice(Ticket ticket) {
        String XPathCheckPrice = String.format("//a[@href='TicketPricePage.cshtml?id1=" + "%d" + "&id2=" + "%d']", changeCityToIndex(ticket.getDEPARTFROM()), changeCityToIndex(ticket.getARRIVEAT()));
        By _btnCheckPrice = By.xpath(XPathCheckPrice);
        Constant.WEBDRIVER.findElement(_btnCheckPrice).click();
        return new TicketPricePage();
    }

    public BookTicketPage bookTicketFromTicketPrice(Ticket ticket) {
        String XPathBookTicket = String.format("//a[@href='BookTicketPage.cshtml?id1=" + "%d" + "&id2=" + "%d" + "&id3=" + "%d']", changeCityToIndex(ticket.getDEPARTFROM()), changeCityToIndex(ticket.getARRIVEAT()), changeSeatTypeToIndex(ticket.getSEATTYPE()));
        By _btnBookTicket = By.xpath(XPathBookTicket);
        Constant.WEBDRIVER.findElement(_btnBookTicket).click();
        return new BookTicketPage();
    }


}
