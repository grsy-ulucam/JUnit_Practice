package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task13 {

    @Test
    public void chromeOptions() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");

        // ChromeDriver driver = new ChromeDriver(options);

    }
}
