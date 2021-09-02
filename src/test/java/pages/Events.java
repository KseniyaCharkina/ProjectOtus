package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.*;

public class Events extends AbstractPage {
    private final By eventsCount = By.xpath("//span[@class='evnt-tab-counter evnt-label small white']");
    private final By pastEventsCount = By.cssSelector("a.active:nth-child(1) > span:nth-child(3)");
    private final By card = By.xpath("//div[contains(@class,'evnt-event-card')]");
    private final By pastEventsButton = By.cssSelector("li.evnt-tab-item:nth-child(2)");
    private final By upComingEventsButton = By.cssSelector("li.evnt-tab-item:nth-child(1)");
    private final By language = By.cssSelector("p.language");
    private final By name = By.cssSelector("div.evnt-event-name");
    private final By date = By.xpath(".//p/span[contains(@class,'date')]");
    private final By reg = By.cssSelector("span.status.reg-close");
    private final By speaker = By.cssSelector("div.speakers-wrapper");
    private final By locationFilter = By.id("filter_location");
    private final By canadaEnter = By.cssSelector("label[data-value= Canada]");

    public Events(WebDriver driver) {
        super(driver);
    }

    @Step("Считываем кол-во карточек")
    public int getCards() {
        return driver.findElements(card).size();
    }

    @Step("Считываем кол-во предстоящих мероприятий")
    public int getEvents() {
        return Integer.parseInt(driver.findElement(eventsCount).getText());
    }

    @Step("Считываем кол-во прошедших мероприятий")
    public int getPastEvents() {
        return Integer.parseInt(driver.findElement(pastEventsCount).getText());
    }

    @Step("Выбрать отображение карточек прошедших меропиятий")
    public void enterPastEvents() {
        driver.findElement(pastEventsButton).click();
    }

    @Step("Выбрать отображение карточек предстоящих меропиятий")
    public void enterUpcomingEvents() {
        driver.findElement(upComingEventsButton).click();
    }

    @Step("Получение дат мероприятий в строковом формате")
    public List<String> getDates() {
        List<WebElement> listCards = driver.findElements(card);
        List<String> dates = new ArrayList<>();

        for (WebElement card : listCards) {
            dates.add(card.findElement(date).getText());
        }
        return dates;
    }

    @Step("Фильтр по локации")
    public void locationFilter() {
        driver.findElement(locationFilter).click();
    }

    @Step("Проверка содержания карточки:язык,название,дата,статус регистрации")
    public boolean validateAtributes() {
        //Получаем лист карточек
        List<WebElement> list = driver.findElements(card);
        //Проходим по листу.Получаем нужный атрибут карточки проверяем на заполненность.
        //Спикеры проверяем на наличие элемента.
        for (WebElement el : list) {
            String lan = el.findElement(language).getText();
            String nam = el.findElement(name).getText();
            String dat = el.findElement(date).getText();
            String infoReg = el.findElement(reg).getText();
            driver.findElement(speaker);
            if (lan.isEmpty() | nam.isEmpty() | dat.isEmpty() | infoReg.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Step("Canada")
    public void canadaEnter() {
        driver.findElement(canadaEnter).click();

    }


}
