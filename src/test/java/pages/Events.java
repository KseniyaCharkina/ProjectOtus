package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Events extends AbstractPage {
    private final By eventsCount = By.xpath("//span[@class='evnt-tab-counter evnt-label small white']");
    private final By card = By.xpath("//div[@class='evnt-events-column cell-3']");
    private final By pastEventsButton = By.cssSelector("li.evnt-tab-item:nth-child(2) > a:nth-child(1) > span:nth-child(1)");
    private final By language = By.cssSelector("p.language");
    private final By name = By.cssSelector("div.evnt-event-name");
    private final By date = By.cssSelector("span.date");
    private final By reg = By.cssSelector("span.status.reg-close");
    private final By speaker = By.xpath("//p[contains(text(),'Speakers']");


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




}
