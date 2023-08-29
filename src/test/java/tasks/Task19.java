package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task19 {
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
    public void alert1() throws InterruptedException {
       /*
        Go to URL: http://demo.automationtesting.in/Alerts.html
Click "Alert with OK" and click 'click the button to display an alert box:’
Accept Alert(I am an alert box!) and print alert on console.
Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
Cancel Alert (Press a Button !)
Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
And then sendKeys «BootcampCamp» (Please enter your name)
Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.
        */

        driver.get("http://demo.automationtesting.in/Alerts.html");
        WebElement okButton = driver.findElement(By.xpath("(//a[@class='analystic'])[1]"));
        okButton.click();
        WebElement alertBox= driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        alertBox.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(5000);
        alert.accept();
        WebElement okAndCancel = driver.findElement(By.xpath("(//a[@class='analystic'])[2]"));
        okAndCancel.click();
        WebElement displayButton=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        displayButton.click();
        driver.switchTo().alert().dismiss();
        WebElement textBoxButton = driver.findElement(By.xpath("(//a[@class='analystic'])[3]"));
        textBoxButton.click();
        WebElement promptBoxButton=driver.findElement(By.xpath("//button[@class='btn btn-info']"));
        promptBoxButton.click();
        driver.switchTo().alert().sendKeys("SoftwareTestEngineer");
        System.out.println(driver.switchTo().alert().getText());

    }
    @Test
    public  void  alert2() throws InterruptedException {

        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alert= driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alert.click();
        Thread.sleep(500);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        WebElement confirm= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirm.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        WebElement prompt= driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        prompt.click();
        driver.switchTo().alert().sendKeys("My wife is very good");
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        WebElement text= driver.findElement(By.xpath("//p[@id='result']"));
        String textText=text.getText();

    }
      @Test
    public  void authentication() throws InterruptedException {

          driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
          Thread.sleep(5000);
          WebElement text= driver.findElement(By.id("content"));
          Assert.assertTrue(text.getText().contains("Congratulations!"));

    }


}
