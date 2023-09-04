package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task30 extends BaseTest {

    @Test
    public  void  fullPageScreenshot() throws IOException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.amazon.com.tr/");
        File source = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File("test-output\\Screenshots\\amazonFullScreenshot.png"));
        driver.close();
    }
    @Test
    public  void getPageScreenshot() throws IOException {

        driver.get("https://www.n11.com/");
        File kaynak = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(kaynak,new File("test-output/Screenshots/n11PageScreenshot.png"));

    }
     @Test
    public  void getElementScreenshot() throws IOException {

         driver.get("https://opensource-demo.orangehrmlive.com/");
         WebElement logo = driver.findElement(By.className("orangehrm-login-branding"));
         File logoScreenshot = logo.getScreenshotAs(OutputType.FILE);
         String date=new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new Date());
         String path="test-output\\Screenshots\\logoScreenshot_" + date + ".png";
         FileUtils.copyFile(logoScreenshot,new File(path));

     }
     @Test
    public  void webTables(){

         driver.get("http://demo.guru99.com/test/web-table-element.php");
         WebElement table = driver.findElement(By.className("dataTable")).findElement(By.tagName("tbody"));
         WebElement row3 = table.findElement(By.xpath(".//tr[3]"));
         WebElement row3cell3 = row3.findElement(By.xpath(".//td[3]"));
         int satirSayisi = table.findElements(By.xpath(".//tr")).size();
         System.out.println(satirSayisi);
         int sutunSayisi = row3.findElements(By.xpath(".//td")).size();
         System.out.println(sutunSayisi);
         for (int i = 1; i<=satirSayisi; i++){
             for (int j = 1; j<=sutunSayisi; j++){
                 By locator = By.xpath(".//tr["+ i +"]//td[" + j + "]");
                 WebElement tableData = table.findElement(locator);
                 System.out.print(tableData.getText() + " ");
             }
             System.out.println();
         }
     }
}
