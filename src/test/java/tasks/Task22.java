package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class Task22 extends BaseTest {

    /*
Go to URL: https://demoqa.com/buttons
Run the buttons on the page using the Actions Class.
Verify the texts that appear after the buttons are operated.
     */
    @Test
    public void actions() {

        Actions actions = new Actions(driver);
        driver.get(" https://demoqa.com/buttons");
        WebElement doubleClickMe = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        actions.doubleClick(doubleClickMe).build().perform();
        WebElement doubleClickResult = driver.findElement(By.id("doubleClickMessage"));
        Assert.assertTrue(doubleClickResult.getText().contains("You have done a double click"));
        WebElement rightClikMe = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClikMe).build().perform();
        WebElement rightClickResult = driver.findElement(By.id("rightClickMessage"));
        Assert.assertTrue(rightClickResult.getText().contains("You have done a right click"));

    }

    @Test
    public void clickMe() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get(" https://demoqa.com/buttons");
        WebElement clickMe = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button"));
        actions.click(clickMe).build().perform();
        Thread.sleep(5000);
        WebElement clickResult = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertTrue(clickResult.isDisplayed());

    }

    @Test
    public void amazon() throws InterruptedException {

        Actions actions = new Actions(driver);
        driver.get("https://www.amazon.com.tr/");
        driver.manage().deleteAllCookies();
        WebElement entry = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(entry).build().perform();
        Thread.sleep(5000);
        WebElement clickEntry = driver.findElement(By.cssSelector("#nav-flyout-ya-signin > a > span"));
        clickEntry.click();

    }

    @Test
    public void keyBoard() {
        driver.get("https://demoqa.com/auto-complete");

        WebElement input = driver.findElement(By.id("autoCompleteSingleContainer"));

        Actions actions = new Actions(driver);


        actions
                .click(input)
                .keyDown(Keys.SHIFT)
                .sendKeys("y")
                .keyUp(Keys.SHIFT)
                .sendKeys("ou are ")
                .keyDown(Keys.SHIFT)
                .sendKeys("e")
                .keyUp(Keys.SHIFT)
                .sendKeys("xceptional")
                .perform();

    }

    @Test
    public void keyBoard2() throws InterruptedException {

        driver.get("https://demoqa.com/auto-complete");

        WebElement input = driver.findElement(By.xpath("//*[@id='autoCompleteMultipleContainer']/div/div[1]"));

        Actions actions = new Actions(driver);

        actions.
                keyDown(Keys.SHIFT).
                sendKeys("Soft").keyUp(Keys.SHIFT).
                sendKeys("ware").keyUp(Keys.SHIFT).
                sendKeys("Test").keyUp(Keys.SHIFT).
                sendKeys("Engineer").
                perform();
        Thread.sleep(10000);
        System.out.println("The End");

    }

    /*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
     */
    @Test
    public void dragAndDrop() {

        Actions actions = new Actions(driver);
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        driver.manage().deleteAllCookies();

        WebElement bankButton = driver.findElement(By.xpath("(//a[@class='button button-orange'])[5]"));
        WebElement bankPlace = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
        WebElement salesButton = driver.findElement(By.xpath("(//a[@class='button button-orange'])[6]"));
        WebElement salesPlace = driver.findElement(By.xpath("(//li[@class='placeholder'])[3]"));
        WebElement firstFiveMoney = driver.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));
        WebElement secondFiveMoney = driver.findElement(By.xpath("(//a[@class='button button-orange'])[4]"));
        WebElement firstMoneyPlace = driver.findElement(By.xpath("(//li[@class='placeholder'])[2]"));
        WebElement secondMoneyPlace = driver.findElement(By.xpath("(//li[@class='placeholder'])[4]"));
        WebElement perfectText = driver.findElement(By.xpath("( //div[@id='equal']/child::a[@class='button button-green'])[1]"));

        actions.dragAndDrop(bankButton, bankPlace).build().perform();
        actions.dragAndDrop(salesButton, salesPlace).build().perform();
        actions.dragAndDrop(firstFiveMoney, firstMoneyPlace).build().perform();
        actions.dragAndDrop(secondFiveMoney, secondMoneyPlace).build().perform();
        Assert.assertTrue(perfectText.isDisplayed());

    }

    /*
    Drag and Drop by Horizontal
    Go to URL: https://rangeslider.js.org/
    Shift 100 units to the right and 100 units to the left on the horizontal axis.
     */
    @Test
    public void horizontal() throws InterruptedException {

        Actions actions = new Actions(driver);
        driver.get("https://rangeslider.js.org/");
        WebElement button = driver.findElement(By.xpath(" //div[@id='js-rangeslider-0']/child::div[@class='rangeslider__handle']"));
        Thread.sleep(5000);
        actions.dragAndDropBy(button, -100, 0);
        Thread.sleep(5000);
        actions.dragAndDropBy(button, +100, 0);
        Thread.sleep(5000);

    }
    /*
Go to URL: https://www.amazon.com/
Click on “Hello, Sign in Account & Lists” link.
Click on Orders page.
Verify the page title contains “Amazon”.
     */
    @Test
    public void amazon2() {

        Actions actions = new Actions(driver);
        driver.get("https://www.amazon.com/");
        WebElement helloButton = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(helloButton).click(helloButton).build().perform();
        WebElement orderButton= driver.findElement(By.xpath("//*[@id='nav_prefetch_yourorders']/child::span[@class='nav-text']"));
        actions.click(orderButton).build().perform();
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

    }
}


