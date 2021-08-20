package cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import pages.Card;
import pages.Home;
import pages.TalksLibrary;
import utils.BaseSettings;

public class FilterReportTest extends BaseSettings {
    private final Logger logger = LogManager.getLogger(FilterReportTest.class);

    @Test
    public void reportTest() {
        Home homePage = new Home(driver);
        logger.info("Драйвер поднят");
        homePage.open()
                .clickVideo();
        logger.info("Переход на страницу VIDEO");
        TalksLibrary libraryPage = new TalksLibrary(driver);
        libraryPage.moreFiltersEnter()
                .filterCategory()
                .filterTesting()
                .filterLocation()
                .filterBelarus()
                .filterLanguage()
                .filterEnglish()
                .cardEnter();
        logger.info("Заданы фильтры.Переход на страницу карточки.");
        Card card = new Card(driver);
        Assert.assertTrue(card.getLocation().contains("Belarus"));
        Assert.assertEquals("Testing", card.getCategory());
        Assert.assertEquals("ENGLISH", card.getLanguage());

    }
}
