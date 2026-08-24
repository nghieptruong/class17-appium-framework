package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstracts.LoginPage;

public class AndroidLoginPage extends LoginPage {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement txtUsername;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private WebElement txtPassword;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    private WebElement btnLogin;

    public AndroidLoginPage(WebDriver driver) {
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
