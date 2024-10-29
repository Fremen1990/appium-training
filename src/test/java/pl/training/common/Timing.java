package pl.training.common;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class Timing {

    private final AndroidDriver driver;

    public Timing(AndroidDriver driver) {
        this.driver = driver;
    }

    public <V> V waitFor(Function<? super WebDriver, V> isTrue, Duration maxTime) {
        return new WebDriverWait(driver, maxTime).until(isTrue);
    }

}
