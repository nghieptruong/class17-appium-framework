package pages;

import org.openqa.selenium.WebDriver;
import pages.abstracts.HomePage;
import pages.abstracts.LoginPage;
import pages.abstracts.components.NavigationBar;
import pages.android.AndroidHomePage;
import pages.android.AndroidLoginPage;
import pages.android.components.AndroidNavigationBar;
import pages.ios.IOSHomePage;
import pages.ios.IOSLoginPage;
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

    public static HomePage getHomePage(WebDriver driver) {
        if(PlatformUtils.isAndroidPlatform(driver)) {
            return new AndroidHomePage(driver);
        } else {
            return new IOSHomePage(driver);
        }
    }

    public static LoginPage getLoginPage(WebDriver driver) {
        if (PlatformUtils.isAndroidPlatform(driver)) {
            return new AndroidLoginPage(driver);
        } else {
            return new IOSLoginPage(driver);
        }
    }
}
