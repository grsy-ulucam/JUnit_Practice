package tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class Task31 extends BaseTest {

    @Test
    public  void  webTable(){

        driver.get("http://demo.guru99.com/test/web-table-element.php");

        WebElement webTable= driver.findElement(By.xpath("//*[@id='leftcontainer']/table"));

        List<WebElement>rows=webTable.findElements(By.tagName("tr"));
        int rowsCount= rows.size();
        for (int i = 0; i <rowsCount ; i++) {
            List<WebElement>columns=rows.get(i).findElements(By.tagName("td"));
            int columnsCount=columns.size();
            for (int j = 0; j <columnsCount ; j++) {
                String cellText=columns.get(j).getText();
             if (cellText.equals("Time Technoplast Ltd")){
                 System.out.println("Time Technoplast Ltd:  "+columns.get(2).getText());
             }
            }
        }
    }
}
