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

public class Task11 {
    // Go to http://www.bestbuy.com
    // Verify that the page title contains "Best" Also
    // LogoTest  Verify if the BestBuy logo is displayed.
    // canadaLinkTest  Verify if the link is displayed.

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
    public void bestBuy() {

        driver.get("http://www.bestbuy.com");

        String title = driver.getTitle();

        Assert.assertTrue("title not contains best word", title.contains("Best"));

        System.out.println("Title:  " + title);

        WebElement logo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/img"));

        Assert.assertTrue(logo.isDisplayed());

        WebElement canada= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/a[1]/img"));

        Assert.assertTrue(canada.isDisplayed());
    }

}
