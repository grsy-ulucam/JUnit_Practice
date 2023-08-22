package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class Task14 {
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
    public void checkBox() {

//    Go to https://the-internet.herokuapp.com/checkboxes
//    Locate the elements of checkboxes.
//    Then click on checkbox 1 if box is not selected.
//    Then click on checkbox 2 if box is not selected.
//    Then that checkbox 1 and checkbox 2 are checked

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        WebElement checkbox1 = checkboxes.get(0);
        WebElement checkbox2 = checkboxes.get(1);


        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }

        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());

    }

    @Test
    public void checkBox2() {

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement chechBox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));

        if (!chechBox1.isSelected()) {
            chechBox1.click();
        }
        Assert.assertTrue(chechBox1.isSelected());

        WebElement chechBox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        if (!chechBox2.isSelected()) {
            chechBox2.click();
        }
        Assert.assertTrue(chechBox2.isSelected());

    }

    @Test
    public void demoqa() {
//    Click on Elements.
//    Click on Checkbox.
//    Verify if Home checkbox is selected.
//    Verify that "You have selected" is visible.

        driver.get("https://demoqa.com/");

        WebElement element = driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(1) > div > div.avatar.mx-auto.white > svg"));

        element.click();

        WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"item-1\"]/span"));

        checkBox.click();

        WebElement home = driver.findElement(By.cssSelector("#tree-node > ol > li > span > label > span.rct-checkbox > svg"));

        if (!home.isSelected()) {
            home.click();

        }
        WebElement verify = driver.findElement(By.xpath("//*[@id='result']/span[1]"));

        Assert.assertTrue(verify.getText().contains("You have selected"));
    }
}
