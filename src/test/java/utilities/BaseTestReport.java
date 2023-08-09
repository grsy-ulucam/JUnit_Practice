package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTestReport {

    protected WebDriver driver;

    protected ExtentReports extentReports;;

    protected ExtentHtmlReporter extentHtmlReporter;

    protected ExtentTest extentTest;

    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();

        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().maximize();

        extentReports=new ExtentReports();

        String currentDate = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

        String filePath = System.getProperty("user.dir") + "/test-output/reports/testReport_" + currentDate + ".html";

        extentHtmlReporter =new ExtentHtmlReporter(filePath);

        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("Environment","QA");

        extentReports.setSystemInfo("Browser","FireFox");

        extentReports.setSystemInfo("QA","Gürsoy");

        extentHtmlReporter.config().setDocumentTitle("MyReport");

        extentHtmlReporter.config().setReportName("Test run report");

    }
     @After
    public  void  teardown(){
        driver.quit();
        extentReports.flush();
     }

}
