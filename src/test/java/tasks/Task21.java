package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class Task21 extends BaseTest {

    /*
Go to URL: https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/
Print the existing windowHandles ids by clicking all the links on the page.
Click on the links that open a new page.
Close other pages other than the home page.
Set the driver back to the main page.
     */

    @Test
    public void windowsHandle() {

        driver.get("https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/");
        String firstWindow = driver.getWindowHandle();
        WebElement seleniumButton = driver.findElement(By.xpath("(//a[@class='fs-13 lh-26'])[2]"));
        seleniumButton.click();
        Set<String> windows = driver.getWindowHandles();

        Iterator<String> itr = windows.iterator();

        while (itr.hasNext()) {
            String window = itr.next();
            driver.switchTo().window(window);
            if (driver.getTitle().equals("Selenium-webdriver Articles"))
                System.out.println(driver.getTitle());
            driver.close();
        }
        driver.switchTo().window(firstWindow);

    }

    @Test
    public void windowsHandle2() {

        driver.get("https://testproject.io/");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://blog.testproject.io/");

    }

    @Test
    public void windowsHandle3() {

        driver.get("https://testproject.io/");
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
        newTab.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());

    }

    @Test
    public void windowsHandle4() {

        driver.get("https://www.amazon.com/");
        String homePageHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com.tr/");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com/");

        Set<String> handles = driver.getWindowHandles();

        Iterator<String> i = handles.iterator();

        while (i.hasNext()) {
            String currentTab = i.next();
            driver.switchTo().window(currentTab);

            System.out.println(driver.getTitle());

        }
    }

    /*
 Go to URL: https://demoqa.com/browser-windows
 Click on the windows - "WindowButton"
 Click on all the child windows.
 Print the text present on all the child windows in the console.
 Print the heading of the parent window in the console.
     */
    @Test
    public void task() throws InterruptedException {

        driver.get("https://demoqa.com/browser-windows");
        String wimdow = driver.getWindowHandle();
        WebElement windowButton = driver.findElement(By.xpath("//button[@id='windowButton']"));
        windowButton.click();
        WebElement tabButton = driver.findElement(By.xpath("//button[@id='tabButton']"));
        tabButton.click();

        Set<String> windows = driver.getWindowHandles();

        Iterator<String> itr = windows.iterator();
        while (itr.hasNext()) {
            String currentTab = itr.next();
            driver.switchTo().window(currentTab);
            System.out.println(driver.getTitle());
            if (driver.getTitle().equals("This is a sample page")) {
                System.out.println(driver.getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(wimdow);
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
    }
}