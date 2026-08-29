package pages.ios.components;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstracts.components.NavigationBar;

public class IOSNavigationBar extends NavigationBar {

    @iOSXCUITFindBy(accessibility = "More-tab-item")
    private WebElement viewMenu;

    @iOSXCUITFindBy(accessibility = "LogOut-menu-item")
    private WebElement loginMenuItem;

    public IOSNavigationBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickMenu() {
        click(viewMenu);
    }

    @Override
    public void navigateLoginPage() {
        clickMenu();
        click(loginMenuItem);
    }
}
