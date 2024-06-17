package scootertest.chrometests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//базовый класс для подключения драйвера Chrome
public class ConnectionChrome {
    WebDriver driver;

    //подключение драйвера браузера и установление ожидания в 5 секунд

    @Before
    public void setupBrowser() {
        // Автоматическое управление драйвером Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //закрываю браузер
    @After
    public void close() {
        driver.quit();
    }
}