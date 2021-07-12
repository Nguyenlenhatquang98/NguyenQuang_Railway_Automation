package Testcase.Railways;

import Common.Common.Utilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestParalle {

    ChromeDriver driver;


    @Test
    public void Test1(){
        System.out.println("Test 1");
        System.setProperty("webdriver.chrome.driver", Utilities.getDriverPath());
        driver = new ChromeDriver();
        driver.quit();
    }

    @Test
    public void Test2(){
        System.out.println("Test 2");
        System.setProperty("webdriver.chrome.driver", Utilities.getDriverPath());
        driver = new ChromeDriver();
        driver.quit();
    }

    @Test
    public void Test3(){
        System.out.println("Test 3");
        System.setProperty("webdriver.chrome.driver", Utilities.getDriverPath());
        driver = new ChromeDriver();
        driver.quit();
    }



}
