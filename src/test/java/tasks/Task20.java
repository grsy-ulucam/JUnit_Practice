package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class Task20 extends BaseTest {

    JavascriptExecutor js = (JavascriptExecutor) driver;

    /*
    Go to URL: https://the-internet.herokuapp.com/iframe
Verify the Bolded text contains “Editor”
Locate the text box
Delete the text in the text box
Type “Hi everyone”
Verify the text Elemental Selenium text is displayed on the page.
     */

    @Test
    public void iframe1() {

        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement text = driver.findElement(By.xpath("//div[@class='example']"));
        Assert.assertTrue(text.getText().contains("Editor"));
        driver.switchTo().frame("mce_0_ifr");
        WebElement textArea = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textArea.click();
        textArea.clear();
        textArea.sendKeys("Hi everyone");
        driver.switchTo().defaultContent();
        WebElement seleniumText = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(seleniumText.isDisplayed());

    }
    /*
    Go to URL: http://demo.guru99.com/test/guru99home/
Find the number of iframes on the page.
Link to the fourth iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
Exit the iframe and return to the main page.
     */

    @Test
    public void iframe2() {

        driver.navigate().to("http://demo.guru99.com/test/guru99home/");
        List<WebElement>iframeSize=driver.findElements(By.xpath("//iframe"));
        int numbersOfIframe=iframeSize.size();
        System.out.println(numbersOfIframe);
        WebElement iframe= driver.findElement(By.xpath("//*[@id='a077aa5e']"));
        driver.switchTo().frame(iframe);
        iframe.click();
        driver.switchTo().defaultContent();
        driver.navigate().back();

    }
    /*
    https://demoqa.com/frames
     */
    @Test
    public  void  freeWork(){

        driver.navigate().to("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        WebElement pageText= driver.findElement(By.id("sampleHeading"));
        Assert.assertTrue(pageText.isDisplayed());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        WebElement samplePage= driver.findElement(By.id("sampleHeading"));
        String textPage=samplePage.getText();
        System.out.println("Text"+textPage);
        Assert.assertTrue(samplePage.isDisplayed());

    }

}
