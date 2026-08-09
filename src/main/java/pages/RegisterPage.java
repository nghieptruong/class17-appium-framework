package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends BasePage {
    private By byTxtAccount;
    private By byTxtPassword;
    private By byTxtConfirmPassword;
    private By byTxtFullname;
    private By byTxtEmail;
    private By byBtnRegister;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.byTxtAccount = By.id("taiKhoan");
        this.byTxtPassword = By.name("matKhau");
        this.byTxtConfirmPassword = By.xpath("//input[@id='confirmPassWord']");
        this.byTxtFullname = By.id("hoTen");
        this.byTxtEmail = By.id("email");
        this.byBtnRegister = By.xpath("//button[.='Đăng ký']");
    }

    public void enterAccount(String account) {
        sendKeys(byTxtAccount, account);
    }

    public void enterPassword(String password) {
        sendKeys(byTxtPassword, password);
    }

    public void confirmPassword(String password) {
        sendKeys(byTxtConfirmPassword, password);
    }

    public void enterFullName(String fullname) {
        sendKeys(byTxtFullname, fullname);
    }

    public void enterEmail(String email) {
        sendKeys(byTxtEmail, email);
    }

    public void clickRegister() {
        click(byBtnRegister);
    }
}
