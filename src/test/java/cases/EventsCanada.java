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
import java.util.*;

public class EventsCanada extends BaseSettings {
    private final Logger logger = LogManager.getLogger(EventsCanada.class);
    private final Date now = new Date();
    private final SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);

    @Test
   public void validationEventsCanada() throws ParseException, InterruptedException {
        Map<String, String> dateMap = new HashMap<>();
        StringBuilder startDate;
        String endDate;

        Home homePage = new Home(driver);
        logger.info("Драйвер поднят");
        homePage.open()
                .clickEvents();
        Events events = new Events(driver);
        events.enterPastEvents();
        events.locationFilter();
        events.canadaEnter();
        Thread.sleep(5000);

        List<String> dates = events.getDates();
        for(String date : dates){

            String one = date.substring(0, date.indexOf("-"));
            endDate = date.substring(date.indexOf("-") + 2);
            String monthAndYear = date.substring(date.length() - 8);
            startDate = new StringBuilder(one);
            startDate.append(monthAndYear);
            dateMap.put(startDate.toString(), endDate);
        }
        for (Map.Entry<String, String> entry : dateMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Date start = format.parse(key);
            Date end = format.parse(value);
            Assert.assertTrue(now.after(start) & now.after(end));

        }


    }
}
