package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Task09 {
    //    Create the driver with BeforeClass and make it static inside the class.
    //    Go to http://www.google.com
    //    Type "Green Mile" in the search box and print the number of results.
    //    Type "Premonition" in the search box and print the number of results.
    //    Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
    //    Close with AfterClass.

    static WebDriver driver;
    static WebElement searchBox;

    @BeforeClass
    public static void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Before
    public void beforeEach() {
        driver.get("http://www.google.com");
    }

    @AfterClass
    public static void closeDriver() {
        driver.quit();
    }

    @Test
    public void test1() {

        searchBox = driver.findElement(By.xpath("//*[@id='APjFqb']"));

        searchBox.sendKeys("Green Mile" + Keys.ENTER);

        WebElement result1 = driver.findElement(By.xpath("//*[@id='result-stats']"));

        System.out.println("First Result" + result1.getText());

    }

    @Test
    public void test2() {

        searchBox = driver.findElement(By.xpath("//*[@id='APjFqb']"));

        searchBox.sendKeys("Premonition" + Keys.ENTER);

        WebElement result2 = driver.findElement(By.xpath("//*[@id='result-stats']"));

        System.out.println("Second Result" + result2.getText());

    }

    @Test
    public void test3() {

        searchBox = driver.findElement(By.xpath("//*[@id='APjFqb']"));

        searchBox.sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);

        WebElement result3 = driver.findElement(By.xpath("//*[@id='result-stats']"));

        System.out.println("Third Result" + result3.getText());

    }

}
