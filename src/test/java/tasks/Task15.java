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
import java.util.List;

public class Task15 {
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

    //    Go to URL:  https://www.facebook.com/
//    Click on Create an Account button.
//    Click 'Kadin'
//    Click 'Erkek'
//      Validate 'Kadin' is not selected and 'Erkek' is selecte
    @Test
    public void dropDown() {

        driver.get("https://www.facebook.com/");

        WebElement newAccount = driver.findElement(By.linkText("Yeni hesap oluştur"));

        newAccount.click();

        List<WebElement> genders = driver.findElements(By.className("_8esa"));

        WebElement woman = genders.get(0);

        woman.click();

        WebElement man = genders.get(1);

        man.click();

        Assert.assertFalse(woman.isSelected());

        Assert.assertTrue(man.isSelected());

    }
}
