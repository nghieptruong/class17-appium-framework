package pages;

import org.openqa.selenium.WebDriver;
import pages.abstracts.components.NavigationBar;
import pages.android.components.AndroidNavigationBar;
import pages.ios.components.IOSNavigationBar;
import utils.PlatformUtils;

public class PageManager {

    public static NavigationBar getNavigationBar(WebDriver driver) {
        if (PlatformUtils.isAndroidPlatform(driver)) {
            return new AndroidNavigationBar(driver);
        } else {
            return new IOSNavigationBar(driver);
        }
    }
}
