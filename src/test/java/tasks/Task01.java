package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.BaseTest;

public class Task01 extends BaseTest {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        String title = driver.getTitle();

        if (title.equals("Google")) {
            System.out.println("test PASSED");
        } else {
            System.out.println("test FAİLED");
        }
        driver.quit();
    }
}
