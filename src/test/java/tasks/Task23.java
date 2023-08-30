package tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class Task23 extends BaseTest {
    @Test
    public void scrollPageUpDown() throws InterruptedException {

        driver.get("https://www.trendyol.com/");
        driver.manage().deleteAllCookies();
        WebElement kabulEt= driver.findElement(By.id("onetrust-accept-btn-handler"));
        kabulEt.click();
        Actions actions=new Actions(driver);
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);

    }
    @Test
    public void scrollArrowUpDown() throws InterruptedException {
        driver.get("https://www.trendyol.com/");
        driver.manage().deleteAllCookies();
        WebElement kabulEt= driver.findElement(By.id("onetrust-accept-btn-handler"));
        kabulEt.click();
        Actions act = new Actions(driver);
        Thread.sleep(2000);

        act.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        act.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        act.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(2000);
        act.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(2000);
    }
    /*
     /*
    go to url : https://api.jquery.com/dblclick/
    double click on the blue square at the bottom of the page and then write the changed color.
     */
   @Test
    public  void doubleClickButton(){

       driver.get("https://api.jquery.com/dblclick/");
       driver.switchTo().frame(0);
       WebElement square= driver.findElement(By.cssSelector("body > div"));
       JavascriptExecutor js= (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView()",square);
       System.out.println("Before color : "+square.getCssValue("background-color"));
       Actions actions=new Actions(driver);
       actions.doubleClick(square).build().perform();
       System.out.println("After color : "+square.getCssValue("background"));

   }
}



