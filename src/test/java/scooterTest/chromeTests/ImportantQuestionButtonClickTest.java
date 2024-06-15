package scooterTest.chromeTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.HomePage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ImportantQuestionButtonClickTest extends SetupBrowserChrome {

    private final int listIndex;

    // Конструктор тест-класса Вопросы о важном с параметром индекса
    public ImportantQuestionButtonClickTest(int listIndex) {
        this.listIndex = listIndex;
    }

    // Набор тестовых данных
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{{0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}};
    }

    @Test
    public void verifyTextVisibilityOnClick() {
        // Создаю объект класса главной страницы
        HomePage homePage = new HomePage(driver);
        // Открываю главную страницу
        homePage.openScooterPage();
        // Кликаю по кнопке с вопросом в зависимости от индекса
        homePage.clickButtonsImpotantQuestions(listIndex);
        // Сравниваю результаты
        assertTrue(homePage.contentIsDisplayed(listIndex));
    }
}
