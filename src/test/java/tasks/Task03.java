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

public class Task03 {
//    Go to Amazon homepage.
//    Do the following tasks by creating 3 different test methods.
//    1- Test if the URL contains Amazon.
//    2- Test if the title does not contain Facebook.
//    3- Test that the Amazon logo appears in the upper left corner.

    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void URLControl() {
        driver.get("https://www.amazon.com.tr/");
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        Assert.assertTrue("it is not contains amazon", currentURL.contains("amazon"));
    }

    @Test
    public void titleControl() {
        driver.get("https://www.amazon.com.tr/");
        String title = driver.getTitle();
        System.out.println(title);
        title.contains("Facebook");
        Assert.assertFalse(title.contains("Facebook"));
    }

    @Test
    public void logoControl() {
        driver.get("https://www.amazon.com.tr/");
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
        String logoText = logo.getText();
        System.out.println(logoText);
        Assert.assertTrue(logoText.contains("com"));
    }


}
