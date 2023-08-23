package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Task17 {
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
    public void alert() throws InterruptedException {

        driver.get("https://demo.guru99.com/test/delete_customer.php");

        WebElement searchBox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));

        searchBox.sendKeys("12233434");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));

        submitButton.click();

        Thread.sleep(5000);

        driver.switchTo().alert().dismiss();

    }

    @Test
    public void basicAuth() {

        driver.get("https://admin:admin@the-internet.herokuapp.com");

        WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[3]/a"));

        element.click();

        WebElement text = driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));

        Assert.assertTrue(text.isDisplayed());

        Assert.assertTrue(text.getText().contains("Congratulations!"));

    }

}
