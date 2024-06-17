package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Класс страницы Заказ оформлен
public class OrderIsProcessed {

    private WebDriver driver;
    // Локатор поля Заказ оформлен.
    private By orderIsProcessed = By.xpath("//div[text()='Заказ оформлен']");

    public OrderIsProcessed(WebDriver driver) {
        this.driver = driver;
    }

    // Метод возвращает истину, если поле Заказ оформлен отображено
    public boolean orderIsProcessedTextIsDisplayed() {
        WebElement orderProcessedElement = driver.findElement(orderIsProcessed);
        return orderProcessedElement != null && orderProcessedElement.isDisplayed();
    }
}
