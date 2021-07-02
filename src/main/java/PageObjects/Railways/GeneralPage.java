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


    public String getWelcomeMessage(){
        return this.getlblWelcomeMessage().getText();
    }


    // Methods

    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public ContactPage gotoContactPage(){
        this.getTabContact().click();
        return new ContactPage();
    }

    public HomePage logout(){
        this.getTabLogout().click();
        return new HomePage();
    }



    public boolean isElementExist(By locator){
        try{
            Constant.WEBDRIVER.findElement(locator);
            return true;
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public boolean checkWelcomeExist(){
        if(isElementExist(this._lblWelcomeMessage)){
            return true;
        }
        else{
            return false;
        }
    }



}
