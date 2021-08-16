package pages;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends AbstractPage{
    private final ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    private final By eventsButton = By.xpath("//a[@href='/events']");

    public Home(WebDriver driver) {
        super(driver);
    }

    public Home open() {
        driver.get(cfg.url());
        return this;
    }

    public void clickEvents() {
        driver.findElement(eventsButton).click();

    }

}
