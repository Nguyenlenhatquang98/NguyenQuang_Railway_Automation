package Common.Common;

import Common.Constant.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import java.util.Random;

public class Utilities {

    public static final String getProjectPath(){
        return "src/main/java/Executables/chromedriver.exe";
    }

    public static String getRandomAlphabetString(int n)
    {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = n;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
    public static String getRandomNumberString(int n)
    {

        int leftLimit = 48; // letter 'a'
        int rightLimit = 96; // letter 'z'
        int targetStringLength = n;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }


    public static void pageDownEnd() {
        Constant.WEBDRIVER.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }

}
