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

public class Task07 {


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
    public void test() throws InterruptedException {

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement basicButton = driver.findElement(By.id("basicpagetest"));

        basicButton.click();

        String URL = driver.getCurrentUrl();

        System.out.println(URL);

        driver.navigate().back();

        String URLs = driver.getCurrentUrl();

        System.out.println(URLs);

        WebElement attributesTest = driver.findElement(By.id("elementattributestest"));

        attributesTest.click();

        WebElement button = driver.findElement(By.className("styled-click-button"));

        button.click();

        String URLS = driver.getCurrentUrl();

        System.out.println(URLS);

        driver.navigate().back();

        String URLText = driver.getCurrentUrl();

        System.out.println(URLText);

        WebElement table = driver.findElement(By.linkText("Table Test Page"));

        table.click();

        WebElement tableText = driver.findElement(By.xpath("//*[@id='tablehere']"));

        System.out.println(tableText.getText());

        Assert.assertTrue(tableText.isDisplayed());

        driver.navigate().back();

        WebElement alerts = driver.findElement(By.id("alerttest"));

        alerts.click();

        WebElement alertBox = driver.findElement(By.id("alertexamples"));

        alertBox.click();

        driver.switchTo().alert().accept();

    }

    @Test
    public void test2() {

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement basicAjax = driver.findElement(By.xpath("//*[@id=\"basicajaxtest\"]"));

        basicAjax.click();

        WebElement code = driver.findElement(By.xpath("/html/body/div/div[3]/form/input[1]"));

        code.click();

        WebElement goBack = driver.findElement(By.linkText("Go back to the form"));

        goBack.click();

        driver.navigate().back();

        String URL = driver.getCurrentUrl();

        System.out.println(URL);

    }

}
