package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.BaseTest;

import java.time.Duration;
import java.util.List;

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

    @Test
    public void driverManage() {
        /*
         Go to the Amazon URL : https://www.amazon.com/
         Print the position and size of the page.
         Adjust the position and size of the page as desired.
         Test that the page is in the position and size you want.
          Close the page
         */

        driver.navigate().to("https://www.amazon.com/");
        String position = String.valueOf(driver.manage().window().getPosition());
        System.out.println("Position" + position);
        String size = String.valueOf(driver.manage().window().getSize());
        System.out.println("Size " + size);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().setPosition(new Point(80, 100));
        driver.manage().window().setSize(new Dimension(800, 600));

    }

    @Test
    public void amazon() {

        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Performance Metrics" + Keys.ENTER);
        String text1 = driver.getPageSource();
        System.out.println(text1);
        searchBox.sendKeys("MEOW" + Keys.ENTER);
        String text2 = driver.getPageSource();
        System.out.println(text2);
        Assert.assertFalse(text1.contains(text2));

    }

    @Test
    public void googleTitle() {
        /*
         Maximize the window.
• Open google home page https://www.google.com/
• Verify that you are Google in the title
         */
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("Google"));
    }

    @Test
    public void trendYol() throws InterruptedException {

        driver.get("https://www.trendyol.com/");
        WebElement searchBox = driver.findElement(By.className("V8wbcUhU"));
        searchBox.sendKeys("pen"+Keys.ENTER);
        WebElement pen1= driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[4]/div[1]/div/div[1]/div[1]/a/div[1]/div[2]/div[2]"));
        pen1.click();
        Thread.sleep(5000);
        System.out.println(pen1.getSize());
        Point point=pen1.getLocation();
        System.out.println("Location "+"x="+point.getX()+"  y="+point.getY());


    }

}
