package tasks;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

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

        WebElement basicAjax = driver.findElement(By.xpath("//*[@id='basicajaxtest']"));

        basicAjax.click();

        WebElement code = driver.findElement(By.xpath("/html/body/div/div[3]/form/input[1]"));

        code.click();

        WebElement goBack = driver.findElement(By.linkText("Go back to the form"));

        goBack.click();

        driver.navigate().back();

        String URL = driver.getCurrentUrl();

        System.out.println(URL);

    }

    @Test
    public void toolsQA() throws InterruptedException {

        driver.get("https://demoqa.com/select-menu");
        WebElement colour = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(colour);
        select.selectByIndex(5);
        select.selectByValue("8");
        Thread.sleep(5000);
        select.selectByVisibleText("White");
        boolean result = select.isMultiple();
        System.out.println(result);

    }

    @Test
    public void cars() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/select-menu");
        WebElement cars = driver.findElement(By.cssSelector("#cars"));
        js.executeScript("arguments[0].scrollIntoView();", cars);
        Select select = new Select(cars);
        select.selectByIndex(1);
        select.selectByValue("volvo");
        System.out.println(select.isMultiple());

    }

    @Test
    public void option() {

        driver.get("https://demoqa.com/select-menu");
        WebElement colour = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(colour);
        String txt = String.valueOf(select.getFirstSelectedOption());
        System.out.println(txt);

    }

    @Test
    public void orange() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement email = driver.findElement(By.xpath("//input[@name='username']"));
        email.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        WebElement pim = driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]"));
        pim.click();
        WebElement employeeList = driver.findElement(By.linkText("Employee List"));
        employeeList.click();
        Thread.sleep(5000);
        Faker faker = new Faker();
        WebElement name = driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]"));
        name.sendKeys(faker.name().firstName());
        WebElement id = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
        id.sendKeys(faker.idNumber().valid());
        List<WebElement>list=driver.findElements(By.xpath("//div[@class='oxd-select-text-input']"));
        WebElement status=list.get(0);
        Select select=new Select(status);
        select.selectByIndex(2);
        WebElement job=list.get(1);
        Select select1=new Select(job);
        select1.selectByVisibleText("Past Employees");
        WebElement jobTitle=list.get(2);
        Select select2=new Select(jobTitle);
        select2.selectByValue("IT Manager");
        WebElement supervisor=driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[2]"));
        supervisor.sendKeys(faker.name().name());
        WebElement subUnit=list.get(3);
        Select select3=new Select(subUnit);
        select3.selectByIndex(3);
        WebElement searchButton=driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.clear();

    }


}
