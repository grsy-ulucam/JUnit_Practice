package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Task12 {

    //https://www.teknosa.com/ adresine gidiniz.
    // Arama çubuğuna ‘’oppo’’ yazıp ENTER tıklayınız.
    // Sonuç sayısını yazdırınız.
    // Çıkan ilk ürüne tıklayınız.
    // Sepete ekleyiniz.
    // Sepetime gite tıklayınız.
    // Konsolda "Sipariş Özeti" WebElement’inin text’ini yazdırınız.
    // Alışverişi tamamlayınız.
    // Son olarak "Teknosa’ya Hoş Geldiniz" WebElement’inin text’ini yazdırınız.
    // Driver’ı kapatınız.
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
    public void teknosa() throws InterruptedException {

        driver.get("https://www.teknosa.com/");

        WebElement searchBox = driver.findElement(By.id("search-input"));

        searchBox.sendKeys("oppo" + Keys.ENTER);

        Thread.sleep(5000);

        WebElement result = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/div[1]/div/div[1]/div[1]/div[1]"));

        System.out.println("Result" + result.getText());

        WebElement a16 = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/div[1]/div/div[2]/div[2]/div[1]/div[1]/a"));

        a16.click();

        WebElement addBox = driver.findElement(By.id("addToCartButton"));

        addBox.click();

        WebElement goBox = driver.findElement(By.cssSelector("a.btn-primary > span:nth-child(1)"));

        goBox.click();

        WebElement summaryBox = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/div[1]/div[1]/div[2]/div/div[1]"));

        System.out.println(summaryBox.getText());

        WebElement completeBuy = driver.findElement(By.cssSelector(".btn-primary > span:nth-child(1)"));

        completeBuy.click();

        WebElement welcomeTeknosa = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/div[1]"));

        System.out.println(welcomeTeknosa.getText());
        
    }


}
