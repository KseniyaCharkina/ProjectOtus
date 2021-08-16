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
        Events events = new Events(driver);
        Assert.assertEquals(events.getEvents(),events.getCards());
        logger.info(events.getCards());
    }
}
