package pages.ios;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstracts.LoginPage;

public class IOSLoginPage extends LoginPage {

    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    private WebElement txtUsername;

    @iOSXCUITFindBy(className = "XCUIElementTypeSecureTextField")
    private WebElement txtPassword;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Login\"`]")
    private WebElement btnLogin;

    public IOSLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterUsername(String username) {
        sendKeys(txtUsername, username);
    }

    @Override
    public void enterPassword(String password) {
        sendKeys(txtPassword, password);
    }

    @Override
    public void clickLogin() {
        click(btnLogin);
    }
}
