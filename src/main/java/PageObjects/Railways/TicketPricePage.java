package PageObjects.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TicketPricePage extends GeneralPage{

    // Locators

    // Elements

    // Methods


    public BookTicketPage SelectOption(String departFrom , String arriveAt, String seatType){
        String XPathCheckPrice = String.format("//div[@id='content']//a[contains(@href,'id1="+"%d"+"&id2="+"%d')]",changeCityToIndex(departFrom),changeCityToIndex(arriveAt));
        By _btnCheckPrice = By.xpath(XPathCheckPrice);
        Constant.WEBDRIVER.findElement(_btnCheckPrice).click();
        String XPathBookTicket = String.format("//div[@id='content']//a[contains(@href,'id1="+"%d"+"&id2="+"%d"+"&id3="+"%d')]",changeCityToIndex(departFrom),changeCityToIndex(arriveAt),changeSeatTypeToIndex(seatType));
        By _btnBookTicket = By.xpath(XPathBookTicket);
        Constant.WEBDRIVER.findElement(_btnBookTicket).click();
        return new BookTicketPage();
    }


}
