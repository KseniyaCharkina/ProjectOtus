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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Epic("Даты мероприятий")
public class ValidationDateTest extends BaseSettings {
    private final Logger logger = LogManager.getLogger(ValidationDateTest.class);
    private final Date now = new Date();
    private final SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);


    @Test
    @Feature("Отображение даты предстоящих мепроприятий")
    @Description("Тест проверяет соответствуют ли даты предстоящих мероприятий заданным условиям:" +
            "Даты проведения мероприятий больше или равны текущей дате " +
            "(или текущая дата находится в диапазоне дат проведения)")
    public void validationTest() throws ParseException {
        Map<String, String> dateMap = new HashMap<>();
        StringBuilder startDate;
        String endDate;

        Home homePage = new Home(driver);
        logger.info("Драйвер поднят");
        homePage.open()
                .clickEvents();
        logger.info("Переход в вкладку EVENTS");
        Events events = new Events(driver);
        events.enterUpcomingEvents();
        List<String> dates = events.getDates();
        logger.info("Получен лист дат в формате string");
        //Проходим по листу.Разбиваем строку на подстроки - начало и конец мероприятия.Кладем в мапу.
        for (String date : dates) {
            String one = date.substring(0, date.indexOf("-"));
            endDate = date.substring(date.indexOf("-") + 2);
            String year = date.substring(date.length() - 4);
            startDate = new StringBuilder(one);
            startDate.append(year);
            dateMap.put(startDate.toString(), endDate);
        }
        //Итерация по мапе.Получаем даты в строковом значении и преобразуем в Date.Assert по условиям.
        for (Map.Entry<String, String> entry : dateMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Date start = format.parse(key);
            Date end = format.parse(value);
            Assert.assertTrue(now.before(start) & now.before(end) | now.after(start) & now.before(end));

        }


    }
}
