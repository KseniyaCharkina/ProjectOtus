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

public class EventsCanadaTest extends BaseSettings {
    private final Logger logger = LogManager.getLogger(EventsCanadaTest.class);
    private final Date now = new Date();
    private final SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);

    @Test
    @Step("Проверка дат заданным условиям и кол-во карточек")
    @Epic("EventsCanada-Просмотр прошедших мероприятий в Канаде")
    @Feature("Фильтрация мероприятий")
    @Description("Тест проверяет корректное отображение карточек:все мероприятия имеют дату меньше текущей," +
            "количество карточек равно счетчику на кнопке Past Events")
    public void validationDateEventsCanada() throws ParseException, InterruptedException {
        Map<String, String> dateMap = new HashMap<>();
        StringBuilder startDate;
        String endDate;

        Home homePage = new Home(driver);
        logger.info("Драйвер поднят");
        homePage.open()
                .clickEvents();
        Events events = new Events(driver);
        events.enterPastEvents();
        logger.info("Выбрана вкладка PAST_EVENTS");
        events.locationFilter();
        events.canadaEnter();
        logger.info("Установлен фильтр Canada");
        Thread.sleep(5000);
        //Проходим по листу.Разбиваем строку на подстроки - начало и конец мероприятия.Кладем в мапу.
        List<String> dates = events.getDates();
        for (String date : dates) {

            String one = date.substring(0, date.indexOf("-"));
            endDate = date.substring(date.indexOf("-") + 2);
            String monthAndYear = date.substring(date.length() - 8);
            startDate = new StringBuilder(one);
            startDate.append(monthAndYear);
            dateMap.put(startDate.toString(), endDate);
        }
        //Итерация по мапе.Получаем даты в строковом значении и преобразуем в Date.Assert по условиям.
        for (Map.Entry<String, String> entry : dateMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Date start = format.parse(key);
            Date end = format.parse(value);
            Assert.assertTrue(now.after(start) & now.after(end));


        }
        //Сравниваем кол-во мероприятий и карточек
        Assert.assertEquals(events.getPastEvents(), events.getCards());

    }
}
