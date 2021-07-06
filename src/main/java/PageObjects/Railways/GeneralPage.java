package PageObjects.Railways;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant.Constant;

public class GeneralPage {

    // Locators

    private final By _tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By _tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By _tabContact = By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']");
    private final By _lblWelcomeMessage = By.xpath("//div[@class='account']/strong[normalize-space(text())]");

    private final By _tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By _tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By _tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");

    // Elements

    protected WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(_tabLogin);
    }

    protected WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(_tabLogout);
    }

    protected WebElement getTabContact(){
        return Constant.WEBDRIVER.findElement(_tabContact);
    }

    protected WebElement getlblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(_lblWelcomeMessage);
    }

    protected WebElement getTabMyTicket(){
        return Constant.WEBDRIVER.findElement(_tabMyTicket);
    }

    protected  WebElement getTabChangePassword(){
        return Constant.WEBDRIVER.findElement(_tabChangePassword);
    }

    protected WebElement getTabRegister(){
        return Constant.WEBDRIVER.findElement(_tabRegister);
    }


    // Methods

    public String getWelcomeMessage(){
        return this.getlblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public MyTicketPage gotoMyTicketPage(){
        this.getTabMyTicket().click();
        return new MyTicketPage();
    }

    public ContactPage gotoContactPage(){
        this.getTabContact().click();
        return new ContactPage();
    }

    public RegisterPage gotoRegisterPage(){
        this.getTabRegister().click();
        return new RegisterPage();
    }

    public ChangePasswordPage gotoChangePasswordPage(){
        this.getTabChangePassword().click();
        return new ChangePasswordPage();
    }

    public boolean isElementExist(By locator){
        try{
            Constant.WEBDRIVER.findElement(locator);
            return true;
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }



    public HomePage logout(){
        if(this.getTabLogout()!= null){
            this.getTabLogout().click();
        }
        return new HomePage();
    }

    public boolean checkWelcomeExist(){
        if(isElementExist(this._lblWelcomeMessage)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkTabsDisplayed (){
        Boolean check1,check2,check3;
        check1 = isElementExist(_tabMyTicket);
        check2 = isElementExist(_tabChangePassword);
        check3 = isElementExist(_tabLogout);
        if(check1 == true && check2 == true && check3 ==true){
            return true;
        }
        else{
            return false;
        }
    }

}
