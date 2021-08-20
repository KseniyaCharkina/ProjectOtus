package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TalksLibrary extends AbstractPage {
    private final By moreFilters = By.cssSelector("div.evnt-toogle-filters-text.show-more");
    private final By category = By.xpath("//span[contains(text(),'Category')]");
    private final By testing = By.cssSelector("label[data-value = Testing]");
    private final By location = By.xpath("//span[contains(text(),'Location')]");
    private final By belarus = By.cssSelector("label[data-value = Belarus]");
    private final By language = By.xpath("//span[contains(text(),'Language')]");
    private final By english = By.cssSelector("label[data-value = ENGLISH]");
    private final By card = By.cssSelector("div.evnt-talks-column.cell-6");

    public TalksLibrary(WebDriver driver) {
        super(driver);
    }

    public TalksLibrary moreFiltersEnter() {
        driver.findElement(moreFilters).click();
        return this;
    }

    public TalksLibrary filterCategory() {
        driver.findElement(category).click();
        return this;
    }

    public TalksLibrary filterTesting() {
        driver.findElement(testing).click();
        return this;
    }

    public TalksLibrary filterLocation() {
        driver.findElement(location).click();
        return this;
    }

    public TalksLibrary filterBelarus() {
        driver.findElement(belarus).click();
        return this;
    }

    public TalksLibrary filterLanguage() {
        driver.findElement(language).click();
        return this;
    }

    public TalksLibrary filterEnglish() {
        driver.findElement(english).click();
        return this;
    }

    public void cardEnter() {
        driver.findElement(card).click();
    }


}

