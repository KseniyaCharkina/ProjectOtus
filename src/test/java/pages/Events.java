package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class Events extends AbstractPage {
    private final By eventsCount = By.xpath("//span[@class='evnt-tab-counter evnt-label small white']");
    private final By card = By.xpath("//div[contains(@class,'evnt-event-card')]");
    private final By pastEventsButton = By.cssSelector("li.evnt-tab-item:nth-child(2)");
    private final By upComingEventsButton = By.cssSelector("li.evnt-tab-item:nth-child(1)");
    private final By language = By.cssSelector("p.language");
    private final By name = By.cssSelector("div.evnt-event-name");
    private final By date = By.xpath(".//p/span[contains(@class,'date')]");
    private final By reg = By.cssSelector("span.status.reg-close");
    private final By speaker = By.xpath("//p[contains(text(),'Speakers']");
    private final By locationFilter = By.id("filter_location");
    private final By canadaEnter = By.cssSelector("label[data-value= Canada]");

    public Events(WebDriver driver) {
        super(driver);
    }

    public int getCards() {
        return driver.findElements(card).size();
    }

    public int getLanguage() {
        return driver.findElements(language).size();
    }

    public int getName() {
        return driver.findElements(name).size();
    }

    public int getDate() {
        return driver.findElements(date).size();
    }

    public int getReg() {
        return driver.findElements(reg).size();
    }

    public int getSpeaker() {
        return driver.findElements(speaker).size();
    }


    public int getEvents() {
        return Integer.parseInt(driver.findElement(eventsCount).getText());
    }

    public void enterPastEvents() {
        driver.findElement(pastEventsButton).click();
    }

    public void enterUpcomingEvents() {
        driver.findElement(upComingEventsButton).click();
    }

    public List<String> getDates() {
        List<WebElement> listCards = driver.findElements(card);
        List<String> dates = new ArrayList<>();

        for (WebElement card : listCards) {
            dates.add(card.findElement(date).getText());
        }
        return dates;
    }

    public void locationFilter() {
        driver.findElement(locationFilter).click();
    }

    public void canadaEnter() {
        driver.findElement(canadaEnter).click();
    }


}
