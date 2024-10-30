package pl.training.common;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class IOSTestConfig {

    private static final String DEFAULT_APPIUM_URL = "http://127.0.0.1:4723";
    private static final String PLATFORM_NAME = "iOS";
    private static final String AUTOMATION_NAME = "xcuitest";

    private IOSDriver driver;
    /*private static final AppiumDriverLocalService appiumService = AppiumDriverLocalService.buildDefaultService();

    public static void startServer() {
        if (!appiumService.isRunning()) {
            //appiumService.start();
        }
    }

    public static void stopServer() {
        if (appiumService.isRunning()) {
            //appiumService.stop();
        }
    }*/

    public void initDriver() {
        try {
            var appiumUrl = System.getenv("APPIUM_URL");
            appiumUrl = appiumUrl != null ? appiumUrl : DEFAULT_APPIUM_URL;
            var url = new URI(appiumUrl).toURL();
            driver = new IOSDriver(url, getOptions());
        } catch (URISyntaxException | MalformedURLException e) {
           throw new RuntimeException(e);
        }
    }

    public void releaseDriver() {
        driver.quit();
    }

    public IOSDriver getDriver() {
        return driver;
    }

    private XCUITestOptions getOptions() {
        return new XCUITestOptions()
                .setPlatformName(PLATFORM_NAME)
                .setAutomationName(AUTOMATION_NAME)
                .setUdid(System.getenv("APPIUM_UDID"))
                .setPlatformVersion(System.getenv("APPIUM_PLATFORM_VERSION"))
                .setApp(System.getenv("APPIUM_APP"))
                .setFullReset(true);
    }

}