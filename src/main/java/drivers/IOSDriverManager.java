package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IOSDriverManager extends DriverManager {

    @Override
    public void createWebDriver() {
        URL appiumServer = null;
        try {
            appiumServer = new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("ios");
        options.setAutomationName("XCUITest");
        options.setUdid("87F8DA42-F0F6-4C6F-85C9-84646D59A10B");
        options.setPlatformVersion("26");
        options.setNewCommandTimeout(Duration.ofSeconds(300));
        options.setBundleId("com.saucelabs.mydemo.app.ios");

        this.driver = new IOSDriver(appiumServer, options);
    }
}
