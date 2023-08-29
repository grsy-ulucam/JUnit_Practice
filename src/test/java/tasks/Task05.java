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
import java.util.List;

public class Task05 {
    //    Go to https://www.linkedin.com/
    //    When we write an e-mail without the @ sign in the e-mail box and press enter.
    //    Let's test the "Invalid email address" warning.
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
    public void linkedin() {

        driver.get("https://www.linkedin.com/");

        WebElement text = driver.findElement(By.xpath("//input[@id='session_key']"));

        text.sendKeys("zaharyas.com" + Keys.ENTER);

        WebElement password = driver.findElement(By.name("session_password"));

        password.sendKeys("123344dsfsf" + Keys.ENTER);

        WebElement alertMessage = driver.findElement(By.id("error-for-username"));

        Assert.assertTrue(alertMessage.isDisplayed());

    }

    @Test
    public void email() throws InterruptedException {
       /*
https://id.heroku.com/login sayfasına gidiniz.
Bir mail adresi giriniz.
Bir password giriniz.
Login butonuna tıklayınız.
"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
Tüm sayfaları kapatınız.
        */
        driver.get("https://id.heroku.com/login");
        List<WebElement> list = driver.findElements(By.className("form-control"));
        WebElement mailBox = list.get(0);
        mailBox.sendKeys("emre.yucel45.20");
        WebElement password = list.get(1);
        password.sendKeys("1234545666");
        WebElement loginButton = driver.findElement(By.cssSelector("#login > form > button"));
        loginButton.click();
        Thread.sleep(10000);
        WebElement errorMesaj = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[2]/label"));
        Assert.assertTrue(errorMesaj.isDisplayed());
        if (errorMesaj.isDisplayed()) {
            System.out.println("Kayıt Yapılamadı");
        } else System.out.println("Kayıt Yapıldı");
    }

    @Test
    public void calculate() {
        /*
Go to URL: https://opensource-demo.orangehrmlive.com/
Locate the username, password, login button using absolute xpath and relative xpath
         */

        driver.navigate().to(" https://opensource-demo.orangehrmlive.com/");
        WebElement email = driver.findElement(By.xpath("//*[@name='username']"));
        email.sendKeys("emre.yucel");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("232342345");
        WebElement login = driver.findElement(By.xpath("//*[@type='submit']"));
        login.click();
    }

    @Test
    public void radioButton() {

        driver.get("https://demoqa.com/radio-button");
        List<WebElement> list = driver.findElements(By.className("custom-control-label"));
        WebElement yesButton = list.get(0);
        yesButton.click();
        Assert.assertTrue(yesButton.getText().contains("Yes"));
        WebElement ımpressive = list.get(1);
        ımpressive.click();
        Assert.assertTrue(ımpressive.getText().contains("Impressive"));
        WebElement noButton = list.get(2);
        Assert.assertFalse(noButton.isSelected());


    }

}
