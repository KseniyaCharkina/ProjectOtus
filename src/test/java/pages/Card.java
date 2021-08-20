package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Card extends AbstractPage {
    private final By language = By.cssSelector("div.evnt-talk-details:nth-child(3) > span:nth-child(1)");
    private final By location = By.xpath("//span[contains(text(),'Belarus')]");
    private final By category = By.cssSelector("div.evnt-topic:nth-child(1)");

    public Card(WebDriver driver) {
        super(driver);
    }

    public String getLanguage() {
        return driver.findElement(language).getText();
    }
    public String getLocation() {
        return driver.findElement(location).getText();
    }
    public String getCategory() {
        return driver.findElement(category).getText();
    }


}
