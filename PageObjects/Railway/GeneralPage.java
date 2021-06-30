package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong[normalize-space(text())]");

    protected WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getlblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }


    public String getWelcomeMessage(){
        return this.getlblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public HomePage logout(){
        this.getTabLogout().click();
        return new HomePage();
    }



}
