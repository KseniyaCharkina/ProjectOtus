package pages;

import io.qameta.allure.Step;
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
    private final By card = By.xpath("//span[contains(text(),'QA')]");
    private final By input = By.cssSelector("input.evnt-text-fields.form-control.evnt-search");


    public TalksLibrary(WebDriver driver) {
        super(driver);
    }

    @Step("Настройка фильтрации")
    public TalksLibrary moreFiltersEnter() {
        driver.findElement(moreFilters).click();
        return this;
    }

    @Step("Фильтр по категории")
    public TalksLibrary filterCategory() {
        driver.findElement(category).click();
        return this;
    }

    @Step("Testing ")
    public TalksLibrary filterTesting() {
        driver.findElement(testing).click();
        return this;
    }

    @Step("Фильтр по локации")
    public TalksLibrary filterLocation() {
        driver.findElement(location).click();
        return this;
    }

    @Step("Беларуссия")
    public TalksLibrary filterBelarus() {
        driver.findElement(belarus).click();
        return this;
    }

    @Step("Фильтр по языку")
    public TalksLibrary filterLanguage() {
        driver.findElement(language).click();
        return this;
    }

    @Step("Английский язык")
    public TalksLibrary filterEnglish() {
        driver.findElement(english).click();
        return this;
    }

    @Step("Переход в карточку мероприятию")
    public void cardEnter() {
        driver.findElement(card).click();
    }

    @Step("Ввод ключевого слова в строку поиска")
    public TalksLibrary inputData(String word) {
        driver.findElement(input).sendKeys(word);
        return this;
    }


}

