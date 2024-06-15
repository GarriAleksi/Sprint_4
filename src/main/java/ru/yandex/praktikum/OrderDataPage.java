package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Класс страницы Для кого самокат
public class OrderDataPage {

    private WebDriver driver;

    // Локаторы для полей формы
    private By orderDataName = By.xpath("//input[@placeholder='* Имя']");
    private By orderDataSurname = By.xpath("//input[@placeholder='* Фамилия']");
    private By orderDataAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private By orderDataSubwayStation = By.className("select-search__input");
    private By orderSelectorSubwayStation = By.className("select-search__select");
    private By orderDataTelephone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By orderButtonFurther = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    public OrderDataPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для ввода Имени
    public void enterOrderDataName(String name) {
        WebElement nameField = driver.findElement(orderDataName);
        nameField.clear();
        nameField.sendKeys(name);
    }

    // Метод для ввода Фамилии
    public void enterOrderDataSurname(String surname) {
        WebElement surnameField = driver.findElement(orderDataSurname);
        surnameField.clear();
        surnameField.sendKeys(surname);
    }

    // Метод для ввода Адреса
    public void enterOrderDataAddress(String address) {
        WebElement addressField = driver.findElement(orderDataAddress);
        addressField.clear();
        addressField.sendKeys(address);
    }

    // Метод обращения к полю Станция метро и выбора станции
    public void clickOrderDataSubwayStation() {
        WebElement subwayStationField = driver.findElement(orderDataSubwayStation);
        subwayStationField.click();
        WebElement subwayStationSelector = driver.findElement(orderSelectorSubwayStation);
        if (subwayStationSelector.isDisplayed()) {
            subwayStationField.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        }
    }

    // Метод для ввода номера Телефона
    public void enterOrderDataTelephone(String telephone) {
        WebElement telephoneField = driver.findElement(orderDataTelephone);
        telephoneField.clear();
        telephoneField.sendKeys(telephone);
    }

    // Кликнуть по кнопке Далее на странице Для кого самокат (страница)
    public void clickOrderButtonFurther() {
        WebElement furtherButton = driver.findElement(orderButtonFurther);
        furtherButton.click();
    }

    // Общий метод для ввода имени, фамилии, адреса, выбора станции, телефона, также кликает по кнопке Далее
    public OrderDataPage enterOrderAllData(String name, String surname, String address, String telephone) {
        enterOrderDataName(name);
        enterOrderDataSurname(surname);
        enterOrderDataAddress(address);
        clickOrderDataSubwayStation();
        enterOrderDataTelephone(telephone);
        clickOrderButtonFurther();
        return this;
    }
}
