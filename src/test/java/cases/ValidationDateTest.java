package cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import pages.Events;
import pages.Home;
import utils.BaseSettings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class ValidationDateTest extends BaseSettings {
    private final Logger logger = LogManager.getLogger(ValidationDateTest.class);
    private final Date now = new Date();
    private final SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);


    @Test
    public void validationTest() throws ParseException {
        Home homePage = new Home(driver);
        logger.info("Драйвер поднят");
        homePage.open()
                .clickEvents();
        Events events = new Events(driver);
        events.enterUpcomingEvents();
        events.validateDate();
        Map<String, String> map = events.validateDate();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Date start = format.parse(key);
            Date end = format.parse(value);
            Assert.assertTrue(now.before(start) & now.before(end) | now.after(start) & now.before(end));

        }


    }
}
