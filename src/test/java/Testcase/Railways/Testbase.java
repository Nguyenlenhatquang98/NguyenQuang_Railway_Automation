package Testcase.Railways;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railways.HomePage;
import PageObjects.Railways.LoginPage;
import PageObjects.Railways.RegisterPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Testbase {

    public HomePage homepage = new HomePage();
    public LoginPage loginPage;
    public RegisterPage registerPage;

    @BeforeClass
    public void BeforeClass(){
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath());
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterClass
    public void AfterClass(){
        Constant.WEBDRIVER.quit();
    }


}
