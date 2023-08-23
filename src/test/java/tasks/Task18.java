package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseTest;

import java.time.Duration;
import java.util.List;

public class Task18 extends BaseTest {
    @Test
    public void webDriverWait() {

        driver.get("https://demoqa.com/interaction");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        WebElement category = driver.findElement(By.className("header-text"));


        wait.until(ExpectedConditions.elementToBeClickable(category)).click();

        WebElement button = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[3]/span"));

        wait.until(ExpectedConditions.elementToBeClickable(button)).click();

    }

    @Test
    public void Iframe() {

        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement text = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));

        String textText = text.getText();

        Assert.assertTrue(textText.contains("Editor"));

        driver.switchTo().frame(0);

        WebElement textBox = driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));

        textBox.clear();

        textBox.sendKeys("Hi everyone");

        driver.switchTo().parentFrame();

        WebElement element = driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/a"));

        Assert.assertTrue(element.isDisplayed());

    }

    @Test
    public void iframeExample() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidiniz.
        // Web sitesini maximize yapınız.
        // İkinci emojiye tıklayınız.
        // Tüm ikinci emoji öğelerine tıklayınız.
        // Parent iframe geri dönünüz.
        // Formu doldurun (Formu istediğiniz metinlerle doldurun) apply button’a basınız.

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        driver.manage().window().maximize();

        driver.switchTo().frame("emoojis");

        WebElement secondEmojiTab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/a[2]"));

        secondEmojiTab.click();
        ;

        List<WebElement> list = driver.findElements(By.xpath("//*[@id='nature']/div"));

        for (WebElement w : list) {
            w.click();
        }

        driver.switchTo().defaultContent();

        WebElement text = driver.findElement(By.id("text"));
        text.sendKeys("Text");

        WebElement smiles = driver.findElement(By.id("smiles"));
        smiles.sendKeys("Smiles");

        WebElement nature = driver.findElement(By.id("nature"));
        nature.sendKeys("Nature");

        WebElement food = driver.findElement(By.id("food"));
        food.sendKeys("Food");

        WebElement activities = driver.findElement(By.id("activities"));
        activities.sendKeys("Activities");

        WebElement places = driver.findElement(By.id("places"));
        places.sendKeys("Places");

        WebElement objects = driver.findElement(By.id("objects"));
        objects.sendKeys("Objects");

        WebElement applyButton = driver.findElement(By.id("send"));
        applyButton.click();

    }


}
