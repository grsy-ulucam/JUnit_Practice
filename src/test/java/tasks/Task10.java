package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class Task10 {

    //http://the-internet.herokuapp.com/add_remove_elements/
    // Click on the "Add Element" button 100 times.
    // Write a function that takes a number, and clicks the "Delete" button.
    // Given number of times, and then validates that given number of buttons was deleted.
    // 1. Method: createButtons(100)
    // 2. Method: DeleteButtonsAndValidate()

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
    public void test() {

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        addElement(100);

        deleteButton(40);

    }

    private void deleteButton(int amount) {

        List<WebElement> deleteButtonsList = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int silinmedenOnceDeleteButtonSayisi = deleteButtonsList.size(); // 100

        for (int i = 0; i < amount; i++) {
            deleteButtonsList.get(i).click();
        }

        List<WebElement> deleteButtonsListAfter = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int silinmedenSonraDeleteButtonSayisi = deleteButtonsListAfter.size(); // 60

        Assert.assertEquals(silinmedenOnceDeleteButtonSayisi - amount, silinmedenSonraDeleteButtonSayisi);

    }

    private void addElement(int amount) {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addElement = driver.findElement(By.xpath("//*[@id='content']/div/button"));

        for (int i = 1; i <= amount; i++) {
            addElement.click();
        }
    }
}
