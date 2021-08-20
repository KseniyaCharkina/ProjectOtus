package pages;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends AbstractPage{
    private final ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    private final By eventsButton = By.xpath("//a[contains(text(),'Events')]");
   // private final By eventsButton = By.xpath("//a[@href='/events']");
    private final By videoButton = By.xpath("//a[@href='/video?f%5B0%5D%5Bmedia%5D%5B%5D=Video']");

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

    public void clickVideo() {
        driver.findElement(videoButton).click();

    }


}
