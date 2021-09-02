package pages;

import config.ServerConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends AbstractPage {
    private final ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    private final By eventsButton = By.xpath("//a[contains(text(),'Events')]");
    private final By videoButton = By.xpath("//a[@href='/video?f%5B0%5D%5Bmedia%5D%5B%5D=Video']");

    public Home(WebDriver driver) {
        super(driver);
    }

    @Step("Открываем страницу https://events.epam.com/")
    public Home open() {
        driver.get(cfg.url());
        return this;
    }

    @Step("Переход в раздел EVENTS")
    public void clickEvents() {
        driver.findElement(eventsButton).click();

    }

    @Step("Переход в раздел VIDEO")
    public void clickVideo() {
        driver.findElement(videoButton).click();

    }


}
