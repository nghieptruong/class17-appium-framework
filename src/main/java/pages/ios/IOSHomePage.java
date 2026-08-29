package pages.ios;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstracts.HomePage;

public class IOSHomePage extends HomePage {

    @iOSXCUITFindBy(accessibility = "title")
    private WebElement lblTitle;

    public IOSHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return getText(lblTitle);
    }
}
