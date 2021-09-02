package cases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import pages.Card;
import pages.Home;
import pages.TalksLibrary;
import utils.BaseSettings;

@Epic("Поиск")
public class ReportQATest extends BaseSettings {
    private final Logger logger = LogManager.getLogger(ReportQATest.class);

    @Test
    @Feature("Поиск по ключевому слову")
    @Description("Тест проверяет результаты поиска приложения по ключевому слову")
    public void checkReport() {
        String expected = "QA";
        Home homePage = new Home(driver);
        logger.info("Драйвер поднят");
        homePage.open()
                .clickVideo();
        logger.info("Переход на страницу VIDEO");
        TalksLibrary libraryPage = new TalksLibrary(driver);
        libraryPage.inputData(expected)
                        .cardEnter();
        Card card = new Card(driver);
        logger.info("Вводим текст.Переходим в карточку.Смотрим название мероприятия");
        //Получаем стрингу названия.Проверяем название на содержание введенного текста.
        String actual = card.getName();
        Assert.assertTrue(actual.contains(expected));

    }

}
