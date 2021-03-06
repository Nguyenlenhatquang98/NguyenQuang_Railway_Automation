package PageObjects.Railways;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    // Locators

    private final By _tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
    private final By _tabLogout = By.xpath("//a[@href='/Account/Logout']");
    private final By _tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");
    private final By _lblWelcomeMessage = By.xpath("//div[@class='account']/strong[normalize-space(text())]");
    private final By _tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    private final By _tabMyTicket = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");
    private final By _tabChangePassword = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
    private final By _tabRegister = By.xpath("//a[@href='/Account/Register.cshtml']");
    private final By _tabTicketPrice = By.xpath("//a[@href='/Page/TrainPriceListPage.cshtml']");

    // Elements

    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(_tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(_tabLogout);
    }

    protected WebElement getTabContact() {
        return Constant.WEBDRIVER.findElement(_tabContact);
    }

    protected WebElement getWelcomeMessageElement() {
        return Constant.WEBDRIVER.findElement(_lblWelcomeMessage);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(_tabBookTicket);
    }

    protected WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(_tabMyTicket);
    }

    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(_tabChangePassword);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(_tabRegister);
    }

    protected WebElement getTabTicketPrice() {
        return Constant.WEBDRIVER.findElement(_tabTicketPrice);
    }


    // Methods

    public LoginPage gotoLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }

    public MyTicketPage gotoMyTicketPage() {
        this.getTabMyTicket().click();
        return new MyTicketPage();
    }

    public ContactPage gotoContactPage() {
        this.getTabContact().click();
        return new ContactPage();
    }

    public BookTicketPage gotoBookTicketPage() {
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }

    public TicketPricePage gotoTicketPricePage() {
        this.getTabTicketPrice().click();
        return new TicketPricePage();
    }

    public RegisterPage gotoRegisterPage() {
        this.getTabRegister().click();
        return new RegisterPage();
    }

    public ChangePasswordPage gotoChangePasswordPage() {
        this.getTabChangePassword().click();
        return new ChangePasswordPage();
    }

    public boolean isElementExist(By locator) {
        try {
            Constant.WEBDRIVER.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public int changeCityToIndex(String cityName) {
        if (cityName.equals("S??i G??n"))
            return 1;
        else if (cityName.equals("Phan Thi???t"))
            return 2;
        else if (cityName.equals("Nha Trang"))
            return 3;
        else if (cityName.equals("???? N???ng"))
            return 4;
        else if (cityName.equals("Hu???"))
            return 5;
        else {
            return 6;
        }
    }

    public int changeSeatTypeToIndex(String seatType) {
        if (seatType.equals("Hard seat"))
            return 1;
        else if (seatType.equals("Soft seat"))
            return 2;
        else if (seatType.equals("Soft seat with air conditioner"))
            return 3;
        else if (seatType.equals("Hard bed"))
            return 4;
        else if (seatType.equals("Soft bed"))
            return 5;
        else {
            return 6;
        }
    }

    public HomePage logout() {
        if (this.getTabLogout() != null) {
            this.getTabLogout().click();
        }
        return new HomePage();
    }


    public boolean checkTabsDisplayed() {
        Boolean check1, check2, check3;
        check1 = isElementExist(_tabMyTicket);
        check2 = isElementExist(_tabChangePassword);
        check3 = isElementExist(_tabLogout);
        if (check1 == true && check2 == true && check3 == true) {
            return true;
        } else {
            return false;
        }
    }

    public String getWelcomeUser() {
        return getWelcomeMessageElement().getText();
    }

}
