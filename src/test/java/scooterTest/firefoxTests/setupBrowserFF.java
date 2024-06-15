package scooterTest.firefoxTests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

// базовый класс для подключения драйвера FireFox
public class setupBrowserFF {
    WebDriver driver;

    @Before
    // метод для настройки браузера и установки ожидания в 5 секунд
    public void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", "C:\\EDIprojects\\FireFoxTest\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    // метод для закрытия браузера
    @After
    public void closeBrowser() {
        driver.quit();
    }
}
