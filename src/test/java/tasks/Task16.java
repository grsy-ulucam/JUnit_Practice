package tasks;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Task16 {
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
    public void fakerExample(){

        Faker faker = new Faker();
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.address().fullAddress());
    }
    @Test
    public  void selectByIndex(){

    driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement dropDown= driver.findElement(By.name("country"));
        Select select=new Select(dropDown);
        select.selectByIndex(6);

    }
    @Test
    public void selectByValue() {

        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement dropDown= driver.findElement(By.name("country"));
        Select select=new Select(dropDown);

        select.selectByValue("ARUBA");

    }
    @Test
    public void selectByVisibleText() {

        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement dropDown= driver.findElement(By.name("country"));
        Select select=new Select(dropDown);

        select.selectByVisibleText("ANGOLA");
    }
    @Test
    public void multipleSelect() {

        driver.get("https://output.jsbin.com/osebed/2");

        WebElement fruit= driver.findElement(By.xpath("//*[@id='fruits']"));

        Select select=new Select(fruit);

        select.selectByValue("apple");

        select.selectByIndex(2);

    }

    @Test
    public void getOptions(){

        driver.get("https://demo.guru99.com/test/newtours/register.php");

        WebElement dropDown= driver.findElement(By.name("country"));

        Select select=new Select(dropDown);

        List<WebElement>options =select.getOptions();

        System.out.println(options.size());

        for (int i = 0; i <options.size() ; i++) {
            options.get(i).click();
        }
        for(WebElement option : options){
            System.out.println(option.getText());
        }
    }
    @Test
    public void getFirstSelectedOption(){

        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));

        select.selectByIndex(1);

        select.selectByIndex(2);

        WebElement selectOption=select.getFirstSelectedOption();

        System.out.println(selectOption.getText());

    }
    @Test
    public void getAllSelectedOptions() {

        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));

        select.selectByValue("banana");
        select.selectByValue("apple");

        List<WebElement> selectedOptions = select.getAllSelectedOptions();

        selectedOptions.forEach(t-> System.out.println(t.getText()));

    }


}