package pages;

import base.BasePage;
import constants.TimeoutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private By byTxtAccountLogin;
    private By byTxtPasswordLogin;
    private By byBtnLogin;

    //Ham khoi tao (constructor)
    public LoginPage(WebDriver driver) {
        super(driver);
        this.byTxtAccountLogin = By.id("taiKhoan");
        this.byTxtPasswordLogin = By.id("matKhau");
        this.byBtnLogin = By.xpath("//button[span[text()='Đăng nhập']]");
    }

    public void enterAccount(String account) {
        sendKeys(byTxtAccountLogin, account);
    }

    public void enterPassword(String password) {
        sendKeys(byTxtPasswordLogin, password);
    }

    public void clickLogin() {
        click(byBtnLogin);
    }

    //High level action (business action)
    public void login(String account, String password) {
        enterAccount(account);
        enterPassword(password);
        clickLogin();
    }
}
