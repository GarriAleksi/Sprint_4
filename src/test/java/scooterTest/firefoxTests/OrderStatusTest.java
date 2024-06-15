package scooterTest.firefoxTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.*;

import static org.junit.Assert.assertTrue;

// Класс с автотестами для обработки заказа
@RunWith(Parameterized.class)
public class OrderStatusTest extends ConnectionFF {

    private final String buttonLocation;
    private final String name;
    private final String surname;
    private final String address;
    private final String telephone;
    private final String newDate;
    private final int days;
    private final String newColor;
    private final String newComment;
    private HomePage objHomePage;

    // конструктор тест-класса с параметрами заказа
    public OrderStatusTest(String buttonLocation, String name, String surname, String address, String telephone, String newDate, int days, String newColor, String newComment) {
        this.buttonLocation = buttonLocation;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.newDate = newDate;
        this.days = days;
        this.newColor = newColor;
        this.newComment = newComment;
    }

    // набор тестовых данных для заказа
    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"up", "Алексей", "Иванов", "Тверская", "89001144667", "01.01.2023", 3, "black", "Быстрее, пожалуйста!"},
                {"down", "Павел", "Сидоров", "Московская", "89001166445", "02.01.2023", 7, "grey", "Уже не могу дождаться!"},
        };
    }

    // Тест на оформление заказа
    @Test
    public void enterOrderAllDataTest() {
        openHomePage(); // Открытие главной страницы
        clickOrderButton(); // Нажатие кнопки заказа
        enterOrderData(); // Ввод данных для заказа
        enterRentData(); // Ввод данных для аренды
        confirmOrder(); // Подтверждение заказа
        verifyOrderProcessed(); // Проверка успешного оформления заказа
    }

    // Открытие главной страницы
    private void openHomePage() {
        objHomePage = new HomePage(driver);
        objHomePage.openScooterPage();
    }

    // Нажатие кнопки заказа в зависимости от местоположения
    private void clickOrderButton() {
        objHomePage.chooseOrderButtonAndClick(buttonLocation);
    }

    // Ввод данных для заказа
    private void enterOrderData() {
        new OrderDataPage(driver)
                .enterOrderAllData(name, surname, address, telephone);
    }

    // Ввод данных для аренды
    private void enterRentData() {
        new RentOrderPage(driver)
                .enterAllDataRentOrder(newDate, days, newColor, newComment);
    }

    // Подтверждение заказа
    private void confirmOrder() {
        new WishOrder(driver)
                .clickOkButton();
    }

    // Проверка успешного оформления заказа
    private void verifyOrderProcessed() {
        assertTrue(new OrderIsProcessed(driver).orderIsProcessedTextIsDisplayed());
    }
}
