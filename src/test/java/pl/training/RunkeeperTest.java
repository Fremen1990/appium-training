package pl.training;

import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static pl.training.AndroidTestConfig.startServer;
import static pl.training.AndroidTestConfig.stopServer;

class RunkeeperTest {

    private final String CITY_NAME = "gdynia";

    private final AndroidTestConfig config = new AndroidTestConfig();
    private final ForecastPage page = new ForecastPage();

    @Test
    void test() throws InterruptedException {
        page.cityEdit.sendKeys(CITY_NAME);
        page.checkButton.click();
        new WebDriverWait(config.getDriver(), Duration.ofSeconds(5)).until(visibilityOf(page.city));
        assertEquals(CITY_NAME, page.city.getText());
    }

    @BeforeAll
    static void beforeAll() {
        startServer();
    }

    @AfterAll
    static void afterAll() {
        stopServer();
    }

    @BeforeEach
    void beforeEach() {
        config.initDriver();
        PageFactory.initElements(config.getDriver(), page);
    }

    @AfterEach
    void afterEach() {
        config.releaseDriver();
    }

}
