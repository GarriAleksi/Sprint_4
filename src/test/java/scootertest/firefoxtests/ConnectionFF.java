package scootertest.firefoxtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

// базовый класс для подключения драйвера FireFox
public class ConnectionFF {
    WebDriver driver;

    @Before
    // метод для настройки браузера и установки ожидания в 5 секунд
    public void setupBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    // метод для закрытия браузера
    @After
    public void closeBrowser() {
        driver.quit();
    }
}
