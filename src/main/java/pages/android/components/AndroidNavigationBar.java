package pages.android.components;

import constants.TimeoutConstant;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstracts.components.NavigationBar;

public class AndroidNavigationBar extends NavigationBar {

    @AndroidFindBy(accessibility = "View menu")
    private WebElement viewMenu;

    @AndroidFindBy(accessibility = "Login Menu Item")
    private WebElement loginMenuItem;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Don't Show Again\")")
    private WebElement btnDonotShowCompatibility;

    public AndroidNavigationBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickMenu() {
        //Handle Android 16
        if(isDisplayed(btnDonotShowCompatibility, TimeoutConstant.DEFAULT_TIMEOUT)) {
            click(btnDonotShowCompatibility);
        }
        click(viewMenu);
    }

    @Override
    public void navigateLoginPage() {
        clickMenu();
        click(loginMenuItem);
    }
}
