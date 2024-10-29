package pl.training;

import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;
import pl.training.common.AndroidTestConfig;
import pl.training.common.Timing;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static pl.training.common.AndroidTestConfig.startServer;
import static pl.training.common.AndroidTestConfig.stopServer;
import static pl.training.common.UIAssertions.hasText;

class CheckForecastForCityTest {

    private final String CITY_NAME = "gdynia";

    private final AndroidTestConfig config = new AndroidTestConfig();
    private final ForecastPage page = new ForecastPage();
    private Timing timing;

    @Test
    void given_city_is_provided_when_check_forecast_then_should_display_the_forecast() {
        page.cityEdit.sendKeys(CITY_NAME);
        page.checkButton.click();
        timing.wait(visibilityOf(page.city), ofSeconds(4));
        hasText(page.city, CITY_NAME);
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
        timing = new Timing(config.getDriver());
    }

    @AfterEach
    void afterEach() {
        config.releaseDriver();
    }

}
