package scootertest.firefoxtests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.HomePage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ImpotantQuestionTest extends ConnectionFF {

    private final int listIndex;

    // Конструктор тест-класса для проверки видимости текста при нажатии кнопки вопроса
    public ImpotantQuestionTest(int listIndex) {
        this.listIndex = listIndex;
    }

    // Набор тестовых данных для параметризации
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7},
        };
    }

    // Тест на проверку видимости текста после клика по кнопке
    @Test
    public void isVisibleTextWhenClickedButton() {
        HomePage objHomePage = new HomePage(driver); // Создание объекта главной страницы
        objHomePage.openScooterPage(); // Открытие главной страницы
        objHomePage.clickButtonsImpotantQuestions(listIndex); // Клик по кнопке с вопросом
        assertTrue(objHomePage.contentIsDisplayed(listIndex)); // Проверка, что контент отображается
    }

}
