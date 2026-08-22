package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

public class PlatformUtils {

    public static boolean isAndroidPlatform(WebDriver driver) {
        return driver instanceof AndroidDriver;
    }
}
