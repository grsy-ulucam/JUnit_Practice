package tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BaseTestReport;

public class Task33 extends BaseTestReport {

    @Test
    public void test(){

        extentTest=extentReports.createTest("My Test","This is explanation");
        extentTest.info("Go to amazon");
        driver.get("https://www.amazon.com.tr/");
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        extentTest.info("write ball on searchbox");
        searchBox.sendKeys("ball"+ Keys.ENTER);
        extentTest.pass("Test is pass");
    }
}
