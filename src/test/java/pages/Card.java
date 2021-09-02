package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Card extends AbstractPage {
    private final By language = By.cssSelector("div.evnt-talk-details:nth-child(3) > span:nth-child(1)");
    private final By location = By.xpath("//span[contains(text(),'Belarus')]");
    private final By category = By.cssSelector("div.evnt-topic:nth-child(1)");
    private final By name = By.cssSelector("h1.evnt-talk-title");

    public Card(WebDriver driver) {
        super(driver);
    }

    @Step("Получение языка мероприятия")
    public String getLanguage() {
        return driver.findElement(language).getText();
    }

    @Step("Получение адреса проведения")
    public String getLocation() {
        return driver.findElement(location).getText();
    }

    @Step("Получение категории мероприятия")
    public String getCategory() {
        return driver.findElement(category).getText();
    }

    @Step("Получения названия мероприятия")
    public String getName() {
        return driver.findElement(name).getText();
    }


}
