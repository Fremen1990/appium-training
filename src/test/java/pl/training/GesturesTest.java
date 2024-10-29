package pl.training;

import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.AppiumBy.ByAndroidUIAutomator;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.training.common.AndroidTestConfig;
import pl.training.common.gestures.GestureImporter;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

// https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
// https://monfared.medium.com/gestures-in-appium-part9-plugin-9f83b954a400
// https://github.com/AppiumTestDistribution/appium-gestures-plugin
public class GesturesTest {

    private final AndroidTestConfig config = new AndroidTestConfig();
    private AndroidDriver driver;

    @Test
    void doubleTap() {
        driver.findElement(new ByAndroidUIAutomator("new UiSelector().text(\"Double Tap\")")).click();

        var button = driver.findElement(new ByAccessibilityId("doubleTapMe"));

        var params = Map.of(
                "x", button.getLocation().x,
                "y", button.getLocation().y
        );
        driver.executeScript("mobile: doubleClickGesture", params);
    }

    @Test
    void longPress() {
        driver.findElement(new ByAndroidUIAutomator("new UiSelector().text(\"Long Press\")")).click();

        var button = driver.findElement(new ByAndroidUIAutomator("new UiSelector().text(\"Long Press Me\")"));

        var params = Map.of(
                "x", button.getLocation().x,
                "y", button.getLocation().y
        );
        driver.executeScript("mobile: longClickGesture", params);
    }

    @Test
    void scroll() {
        driver.findElement(new ByAndroidUIAutomator("new UiSelector().text(\"Vertical swiping\")")).click();

        var element = driver.findElement(new ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(2)"));

        /*var params = Map.of(
                "left", 80, "top", 460, "width", 1000, "height", 2200,
                "direction", "up",
                "percent", 1.0
        );*/

        var params = Map.of(
                "elementId", element,
                "direction", "up",
                "percent", 1.0
        );
        driver.executeScript("mobile: swipeGesture", params);
    }

    @Test
    void drag() {
        driver.findElement(new ByAndroidUIAutomator("new UiSelector().text(\"Drag & Drop\")")).click();

        var element = driver.findElement(new ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(4)"));
        var dropZone = driver.findElement(new ByAndroidUIAutomator("new UiSelector().description(\"dropzone\")"));

        var params = Map.of(
                "elementId", element,
                "endX", dropZone.getLocation().x + 50,
                "endY", dropZone.getLocation().y + 50
        );

        driver.executeScript("mobile: dragGesture", params);
    }

    @Test
    void custom() throws IOException {
        driver.findElement(new ByAndroidUIAutomator("new UiSelector().text(\"Vertical swiping\")")).click();
        var importer = new GestureImporter(driver);
        var gesture = importer.importGestures("gesture-SwipeUp.json");
        driver.perform(gesture);
    }

    /*
    Scroll: Moving contents of the page within a container (scroll bounding area) to 4 main directions (up, down, left, right).
    It is performed slowly and in a controlled manner. You release your finger at the end of the gesture, after you’ve moved the contents
    you’re searching for into view. The same action we do in desktop browsers and OS using the scrollbar or mouse wheel. We scroll
    to view content that extends beyond the visible area of a screen.

    Swipe: A quick but continuous movement of the finger across the screen in a particular direction (usually up/down/right/left as a scroll).
    It is very close to scrolling but is much faster than it, and you usually don’t control the finger or follow contents as a scroll.
    It is commonly used for various interactions, such as navigating between screens or pages in an app, revealing additional options
    or actions (e.g., swiping to delete an item in iOS), or switching between different views or tabs.

    Flick (Fling): It is a rapid movement of the finger across the screen as fast as possible. You don’t care about contents and you
    don’t control the finger movement. You release your finger while performing a Flick. For example, flicking up quickly and multiple times to reach the first message in a Telegram/WhatsApp thread or playing Fruit Ninja Game!
    */

    @BeforeEach
    void beforeEach() {
        config.initDriver();
        driver = config.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

        var loginButton = driver.findElement(new ByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\")"));
        loginButton.click();
    }

    @AfterEach
    void afterEach() {
        config.releaseDriver();
    }

}
