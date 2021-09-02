package cases;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import pages.Events;
import pages.Home;
import utils.BaseSettings;

public class ViewEventsTest extends BaseSettings {
    private final Logger logger = LogManager.getLogger(ViewEventsTest.class);

    @Test
    @Step("Сравнение кол-ва мероприятий и карточек")
    @Epic("ViewEvents-Корректное отображение карточек")
    @Feature("Число предстоящих событий равно числу карточек мероприятий")
    @Description("Тест проверяет верное ли кол-во карточек отображается у пользователя:кол-во карточек = кол-ву предстоящих мероприятий")
    public void testEvents(){
        Home homePage = new Home(driver);
        logger.info("Драйвер поднят");
        homePage.open()
                .clickEvents();
        logger.info("Переход в вкладку EVENTS");
        Events events = new Events(driver);
        Assert.assertEquals(events.getEvents(),events.getCards());

    }
}
