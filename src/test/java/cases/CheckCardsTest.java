package cases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import pages.Events;
import pages.Home;
import utils.BaseSettings;

@Epic("Карточки мероприятий")
public class CheckCardsTest extends BaseSettings {
    private final Logger logger = LogManager.getLogger(CheckCardsTest.class);

    @Test
    @Feature("Вывод информации о мероприятии в карточку")
    @Description("Тест проверяет есть ли на карточках необходимый набор атрибутов")
    public void testPastEvents() throws InterruptedException {
        Home homePage = new Home(driver);
        logger.info("Драйвер поднят");
        homePage.open()
                .clickEvents();
        logger.info("Переход в вкладку EVENTS");
        Events events = new Events(driver);
        events.enterPastEvents();
        Thread.sleep(5000);
        logger.info("Выбрана вкладка PAST_EVENTS");
        Assert.assertTrue(events.validateAtributes());





    }

}
