package pl.training.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class AndroidTestConfig {

    private static final String DEFAULT_APPIUM_URL = "http://127.0.0.1:4723";
    private static final String PLATFORM_NAME = "Android";
    private static final String AUTOMATION_NAME = "uiAutomator2";

    private AndroidDriver driver;
    private static final AppiumDriverLocalService appiumService = AppiumDriverLocalService.buildDefaultService();

    public static void startServer() {
        if (!appiumService.isRunning()) {
            appiumService.start();
        }
    }

    public static void stopServer() {
        if (appiumService.isRunning()) {
            appiumService.stop();
        }
    }

    public void initDriver() {
        try {
            var appiumUrl = System.getenv("APPIUM_URL");
            appiumUrl = appiumUrl != null ? appiumUrl : DEFAULT_APPIUM_URL;
            var url = new URI(appiumUrl).toURL();
            driver = new AndroidDriver(url, getOptions());
        } catch (URISyntaxException | MalformedURLException e) {
           throw new RuntimeException(e);
        }
    }

    public void releaseDriver() {
        driver.quit();
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    private UiAutomator2Options getOptions() {
        return new UiAutomator2Options()
                .setPlatformName(PLATFORM_NAME)
                .setAutomationName(AUTOMATION_NAME)
                .setDeviceName(System.getenv("APPIUM_DEVICE_NAME"))
                .setUdid(System.getenv("APPIUM_UDID"))
                .setPlatformVersion(System.getenv("APPIUM_PLATFORM_VERSION"))
                .setApp(System.getenv("APPIUM_APP"))
                .setFullReset(true);
    }

}

// APPIUM_DEVICE_NAME=sdk_gphone64_x86_64;APPIUM_UDID=emulator-5554;APPIUM_PLATFORM_VERSION=15;APPIUM_APP=C:\\Users\\admin\\Desktop\\apk\\runkeeper.apk