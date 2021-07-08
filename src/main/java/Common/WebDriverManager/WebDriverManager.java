package Common.WebDriverManager;

import Common.Constant.Constant;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    ChromeDriver driver;
    private static WebDriverManager instance = null;

    private WebDriverManager() {
        driver = new ChromeDriver();
    }

    public static WebDriverManager getInstance() {
        if (instance == null)
            instance = new WebDriverManager();
        return instance;
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void navigate() {
        driver.navigate().to(Constant.RAILWAY_URL);
    }

    public WebElement findElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException ex) {
            return null;
        } catch (StaleElementReferenceException ex) {
            return null;
        }
    }

    public Alert switchToAlert(){
        return driver.switchTo().alert();
    }

    public void quit() {
        driver.quit();
        instance = null;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    /*public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = driver;
        js.executeScript("argument[0].scrollIntoView()", element);
    }*/
}
