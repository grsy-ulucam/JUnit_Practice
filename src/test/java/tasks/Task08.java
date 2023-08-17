package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Task08 {
    //    Go to https://www.linkedin.com/
    //    When we write an e-mail without the @ sign in the e-mail box and press enter.
    //    Let's test the "Invalid email address" warning.

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public  void linkedin() throws InterruptedException {

        driver.get("https://tr.linkedin.com/");

        WebElement emailBox=driver.findElement(By.xpath("//input[@id='session_key']"));

        emailBox.sendKeys("karlclarusway.com" + Keys.ENTER);


        WebElement password= driver.findElement(By.xpath("//*[@id='session_password']"));

        password.sendKeys("gdfgfdhfghfgjj"+Keys.ENTER);

        Thread.sleep(5000);

    }

}
