package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class Task04 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.linkedin.com/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void idLocator() {
        WebElement email = driver.findElement(By.id("session_key"));
        email.sendKeys("Clarusway selenium dersinden selamlar");

    }

    @Test
    public void nameLocator() {

        WebElement password = driver.findElement(By.name("session_password"));

        password.sendKeys("Sifre");
    }

    @Test
    public void classLocator() {

        WebElement email = driver.findElement(By.className("input__input"));
        email.sendKeys("Class locator test");

    }

    @Test
    public void tagLocator(){

        List<WebElement> emailList = driver.findElements(By.tagName("input"));

        WebElement email = emailList.get(1);

        email.sendKeys("Tag locator test");

    }

    @Test
    public void linkTextLocator(){

        WebElement forgotPwd = driver.findElement(By.linkText("Forgot password?"));
        forgotPwd.click();

    }

    @Test
    public void partialLinkTextLocator(){

        WebElement forgotPwd = driver.findElement(By.partialLinkText("Forgot"));
        forgotPwd.click();

    }

    @Test
    public void absoluteXpath(){
        WebElement email = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[2]/div[1]/input"));
        email.sendKeys("Karl absolute xpath konusunu gayet basirili tamamladi");
    }


    @Test
    public void relativeXpath(){

        WebElement email = driver.findElement(By.xpath("//input[@name='session_key']"));
        email.sendKeys("Karl relative xpath konusunu gayet basirili tamamladi");
    }

    @Test
    public void multipleAttributeXpath(){

        WebElement email = driver.findElement(By.xpath("//input[@class='input__input'][@name='session_key']"));
        email.sendKeys("Karl relative xpath konusunu gayet basirili tamamladi");
    }

    @Test
    public void andOrXpath(){

        WebElement email = driver.findElement(By.xpath("//input[@class='input__input' and @name='session_key']"));
        email.sendKeys("Karl relative xpath konusunu gayet basirili tamamladi");
    }

    @Test
    public void containsXpath(){

        WebElement email = driver.findElement(By.xpath("//input[contains(@name, 'key')]"));
        email.sendKeys("Karl relative xpath konusunu gayet basirili tamamladi");
    }
    
}