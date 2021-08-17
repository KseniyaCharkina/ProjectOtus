package cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import pages.Events;
import pages.Home;
import utils.BaseSettings;

public class CheckCardsTest extends BaseSettings {
    private final Logger logger = LogManager.getLogger(CheckCardsTest.class);

    @Test
    public void testPastEvents() throws InterruptedException {
        Home homePage = new Home(driver);
        logger.info("Драйвер поднят");
        homePage.open()
                .clickEvents();
        Events events = new Events(driver);
        events.enterPastEvents();
        Thread.sleep(5000);
        int count = events.getCards();
        /*logger.info(count);
        logger.info(events.getLanguage());*/
        Assert.assertEquals(count,events.getLanguage());
        Assert.assertEquals(count,events.getName());
        Assert.assertEquals(count,events.getDate());
        Assert.assertEquals(count,events.getReg());
        Assert.assertEquals(count,events.getSpeaker());




    }

}
