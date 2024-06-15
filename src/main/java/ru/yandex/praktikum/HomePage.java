

package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Класс главной страницы сайта Самокат
public class HomePage {
    private WebDriver driver;

    // Локаторы для кнопок Заказать
    private By higherOrderButton = By.xpath(".//button[(@class ='Button_Button__ra12g' and text()='Заказать')]");
    private By lowerOrderButton = By.className("Button_Middle__1CSJM");

    // Локаторы кнопок вопросов раздела Вопросы о важном
    private By[] buttonsImpotantQuestionsArray = {
            By.id("accordion__heading-0"), By.id("accordion__heading-1"), By.id("accordion__heading-2"),
            By.id("accordion__heading-3"), By.id("accordion__heading-4"), By.id("accordion__heading-5"),
            By.id("accordion__heading-6"), By.id("accordion__heading-7")
    };

    // Локаторы текстовых ответов раздела Вопросы о важном
    private By[] answersImpotantQuestionsArray = {
            By.xpath(".//div[@id='accordion__panel-0']/p"), By.xpath(".//div[@id='accordion__panel-1']/p"),
            By.xpath(".//div[@id='accordion__panel-2']/p"), By.xpath(".//div[@id='accordion__panel-3']/p"),
            By.xpath(".//div[@id='accordion__panel-4']/p"), By.xpath(".//div[@id='accordion__panel-5']/p"),
            By.xpath(".//div[@id='accordion__panel-6']/p"), By.xpath(".//div[@id='accordion__panel-7']/p")
    };

    // Ожидаемые ответы на вопросы
    private String[] expectedAnswersImpotantQuestions = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Открыть главную страницу Самоката
    public void openScooterPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // Пролистнуть страницу и кликнуть по кнопке в разделе Вопросы о важном
    public void clickButtonsImpotantQuestions(int listIndex) {
        By locator = buttonsImpotantQuestionsArray[listIndex];
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
    }

    // Кликнуть по верхней кнопке Заказать на главной странице
    public void higherOrderButtonClick() {
        driver.findElement(higherOrderButton).click();
    }

    // Кликнуть по нижней кнопке Заказать
    public HomePage lowerOrderButtonClick() {
        WebElement element = driver.findElement(lowerOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        return this;
    }

    // Выбор кнопки Заказать на странице
    public HomePage chooseOrderButtonAndClick(String buttonLocation) {
        if ("up".equals(buttonLocation)) {
            higherOrderButtonClick();
        } else if ("down".equals(buttonLocation)) {
            lowerOrderButtonClick();
        }
        return this;
    }

    // Получение текста из текстовых ответов раздела Вопросы о важном
    public String getAnswersImpotantQuestions(int listIndex) {
        By locator = answersImpotantQuestionsArray[listIndex];
        return driver.findElement(locator).getText();
    }

    // Сравнение текстовых ответов с ожидаемыми ответами
    public boolean contentIsDisplayed(int listIndex) {
        By locator = answersImpotantQuestionsArray[listIndex];
        String expectedAnswerText = expectedAnswersImpotantQuestions[listIndex];
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        return element.isDisplayed() && expectedAnswerText.equals(element.getText());
    }
}
