package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Класс страницы Хотите оформить заказ?
public class WishOrder {
    private final WebDriver driver;
    // Кнопка Да в окне Хотите оформить заказ?
    private final By okButton = By.xpath(".//*[text()='Да']");

    public WishOrder(WebDriver driver) {
        this.driver = driver;
    }

    // Метод нажатия на кнопку Да
    public WishOrder clickOkButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement okButtonElement = wait.until(ExpectedConditions.elementToBeClickable(okButton));
        okButtonElement.click();
        return this;
    }
}
