package cases;

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
    public void testEvents(){
        Home homePage = new Home(driver);
        logger.info("Драйвер поднят");
        homePage.open()
                .clickEvents();
        logger.info("Переход в вкладку EVENTS");
        Events events = new Events(driver);
        //Сравниваем кол-во мероприятий и карточек
        Assert.assertEquals(events.getEvents(),events.getCards());

    }
}
