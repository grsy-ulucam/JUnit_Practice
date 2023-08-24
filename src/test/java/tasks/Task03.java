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

public class Task03 {
//    Go to Amazon homepage.
//    Do the following tasks by creating 3 different test methods.
//    1- Test if the URL contains Amazon.
//    2- Test if the title does not contain Facebook.
//    3- Test that the Amazon logo appears in the upper left corner.

    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void URLControl() {
        driver.get("https://www.amazon.com.tr/");
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        Assert.assertTrue("it is not contains amazon", currentURL.contains("amazon"));
    }

    @Test
    public void titleControl() {
        driver.get("https://www.amazon.com.tr/");
        String title = driver.getTitle();
        System.out.println(title);
        title.contains("Facebook");
        Assert.assertFalse(title.contains("Facebook"));
    }

    @Test
    public void logoControl() {
        driver.get("https://www.amazon.com.tr/");
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
        String logoText = logo.getText();
        System.out.println(logoText);
        Assert.assertTrue(logoText.contains("com"));
    }

    @Test
    public void pageSource() {

        driver.get("https://www.amazon.com.tr/");
        String text = driver.getPageSource();
        System.out.println("pageSource" + text);

    }

    @Test
    public void navigation() {

        driver.get("https://www.amazon.com.tr/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("telefon" + Keys.ENTER);
        driver.navigate().back();

    }

    @Test
    public void navigationBack() {

        driver.navigate().to("https://www.google.com/");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();

    }

    @Test
    public void task() {

        //Invoke FirefoxDriver
        //Navigate to URL: https://clarusway.com/
        //Navigate to URL: http://amazon.com/
        //Come back to the Clarusway using the back command.
        // Again go back to the amazon website using forward command
        //Refresh the Browser using refresh command.
        //Close the Browser.

        driver.navigate().to("https://clarusway.com/");
        driver.navigate().to("http://amazon.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }

    @Test
    public void windowCommands() throws InterruptedException {
        /*
        • Invoke Chrome Browser
• Open URL: https://www.google.com/
• Maximize the window.
• Print the position and size of the page.
• Minimize the page.
• Wait 5 seconds in the icon state and maximize the page.
• Print the position and dimensions of the page in maximized state.
• Make the page fullscreen.
• Close the Browser
         */

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        String size = String.valueOf(driver.manage().window().getSize());
        System.out.println("Size" + size);
        String position = String.valueOf(driver.manage().window().getPosition());
        System.out.println("Position" + position);
        driver.manage().window().minimize();
        Thread.sleep(5000);
        String minSize = String.valueOf(driver.manage().window().getSize());
        System.out.println("MinSize" + minSize);
        String minPosition = String.valueOf(driver.manage().window().getPosition());
        System.out.println("MinPosition");
        driver.manage().window().fullscreen();

    }
}
