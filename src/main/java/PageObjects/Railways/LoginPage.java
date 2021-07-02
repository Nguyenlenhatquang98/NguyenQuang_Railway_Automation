package PageObjects.Railways;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{

    // Locators

    private final By _txtUsername = By.xpath("//li[@class='username']/input");
    private final By _txtPassword = By.xpath("//li[@class='password']/input");
    private final By _btnLogin = By.xpath("//p[@class='form-actions']/input");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");


    // Elements

    public WebElement getTxtUsername(){
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getBtnLogin(){
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    public WebElement getLblLoginErrorMsg(){
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }


    // Methods

    public GeneralPage login(String username, String password){
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
        if(isElementExist(_lblLoginErrorMsg)){
            return new LoginPage();
        }
        else{
            return new HomePage();
        }
    }

    public String getUnableMsgExist(int n){
        String Result = null;
        for(int i=0;i<n;i++){
            this.login(Constant.USERNAME,Constant.INVALID_PASSWORD);
            if(this.getLblLoginErrorMsg().getText().equals(Constant.CHECK_MSG_INVALID)) {
                Result = Constant.CHECK_MSG_INVALID;
            }
        }
        return Result;
    }



}
