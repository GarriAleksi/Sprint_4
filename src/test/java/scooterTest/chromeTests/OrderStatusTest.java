package scooterTest.chromeTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.*;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderStatusTest extends ConnectionChrome {

    private final String buttonLocation;
    private final String name;
    private final String surname;
    private final String address;
    private final String telephone;
    private final String newDate;
    private final int days;
    private final String newColor;
    private final String newComment;

    // Конструктор тест-класса
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

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"up", "Алексей", "Иванов", "Тверская", "89001144667", "01.01.2023", 3, "black", "Быстрее, пожалуйста!"},
                {"down", "Павел", "Сидоров", "Московская", "89001166445", "02.01.2023", 7, "grey", "Уже не могу дождаться!"},
        };
    }

    @Test
    public void enterOrderAllDataTest() {
        openHomePage();
        clickOrderButton();
        enterOrderData();
        enterRentData();
        confirmOrder();
        verifyOrderProcessed();
    }

    private void openHomePage() {
        // Создаю объект главной страницы и открываю сайт Самоката
        HomePage objHomePage = new HomePage(driver);
        objHomePage.openScooterPage();
    }

    private void clickOrderButton() {
        // Выбираю кнопку Заказать для клика
        HomePage objHomePage = new HomePage(driver);
        objHomePage.chooseOrderButtonAndClick(buttonLocation);
    }

    private void enterOrderData() {
        // Ввожу данные на странице Для кого самокат
        new OrderDataPage(driver).enterOrderAllData(name, surname, address, telephone);
    }

    private void enterRentData() {
        // Ввожу данные на странице Про аренду
        new RentOrderPage(driver).enterAllDataRentOrder(newDate, days, newColor, newComment);
    }

    private void confirmOrder() {
        // Нажимаю кнопку Да в окне Хотите оформить заказ?
        new WishOrder(driver).clickOkButton();
    }

    private void verifyOrderProcessed() {
        // Проверяю, что поле "Заказ оформлен". В приложении есть баг, который не даёт оформить заказ. Он воспроизводится только в Chrome
        assertTrue(new OrderIsProcessed(driver).orderIsProcessedTextIsDisplayed());
    }
}
