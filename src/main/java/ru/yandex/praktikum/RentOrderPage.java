package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Класс страницы Про аренду
public class RentOrderPage {

    private final WebDriver driver;
    // Локатор для поля Когда привезти самокат
    private final By orderDataWhenDelivery = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // Локатор для поля Срок аренды
    private final By rentalPeriod = By.className("Dropdown-placeholder");
    // Локаторы для сроков аренды
    private final By[] rentalPeriods = {
            By.xpath(".//*[@class='Dropdown-option'][1]"),
            By.xpath(".//*[@class='Dropdown-option'][2]"),
            By.xpath(".//*[@class='Dropdown-option'][3]"),
            By.xpath(".//*[@class='Dropdown-option'][4]"),
            By.xpath(".//*[@class='Dropdown-option'][5]"),
            By.xpath(".//*[@class='Dropdown-option'][6]"),
            By.xpath(".//*[@class='Dropdown-option'][7]")
    };
    // Цвет самоката Черный жемчуг
    private final By blackPearl = By.xpath(".//input[@id='black']");
    // Цвет самоката Серая безысходность
    private final By grayHopelessness = By.xpath(".//input[@id='grey']");
    // Поле Комментарий для курьера
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка "Заказать"
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    public RentOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для выбора даты в поле Когда привезти самокат
    public void enterDate(String newDate) {
        WebElement dateField = driver.findElement(orderDataWhenDelivery);
        dateField.sendKeys(newDate);
        dateField.sendKeys(Keys.ENTER);
    }

    // Метод для выбора количества дней аренды
    public void choosePeriod(int days) {
        if (days >= 1 && days <= 7) {
            driver.findElement(rentalPeriod).click();
            driver.findElement(rentalPeriods[days - 1]).click();
        } else {
            throw new IllegalArgumentException("Invalid number of rental days: " + days);
        }
    }

    // Выбор цвета самоката Черный жемчуг
    public void clickBlackPearl() {
        driver.findElement(blackPearl).click();
    }

    // Выбор цвета самоката Серая безысходность
    public void clickGrayHopelessness() {
        driver.findElement(grayHopelessness).click();
    }

    // Метод выбора цвета
    public void chooseColor(String newColor) {
        if ("black".equals(newColor)) {
            clickBlackPearl();
        } else if ("grey".equals(newColor)) {
            clickGrayHopelessness();
        } else {
            throw new IllegalArgumentException("Invalid color: " + newColor);
        }
    }

    // Метод для ввода комментария для курьера
    public RentOrderPage enterComment(String newComment) {
        driver.findElement(comment).sendKeys(newComment);
        return this;
    }

    // Метод для нажатия кнопки Заказать
    public RentOrderPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    // Общий метод для ввода даты, выбора периода, выбора цвета, ввода комментария и нажатия на кнопку Заказать на странице Про аренду
    public RentOrderPage enterAllDataRentOrder(String newDate, int days, String newColor, String newComment) {
        enterDate(newDate);
        choosePeriod(days);
        chooseColor(newColor);
        enterComment(newComment);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(orderButton));
        clickOrderButton();
        return this;
    }
}
