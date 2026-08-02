package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class TC01_RegisterUser {

    @Test
    public void verify_register_successfully() {

        //Pre-condition: 

        //        //Start chrome browser
        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("149");
        //Tat hien thi automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        ChromeDriver chromeDriver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));

        // Mo full man hinh
        chromeDriver.manage().window().maximize();
        // Mo trang https://demo1.cybersoft.edu.vn/
        chromeDriver.get("https://demo1.cybersoft.edu.vn/sign-up");

        //Step 1: Enter account
        //By va WebElement --> tuong ung locator tren trang web html
        //Tim element Tai khoan textbox
        String account = UUID.randomUUID().toString();
        System.out.println(account);

        By byTxtAccount = By.id("taiKhoan");
        WebElement txtAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtAccount));
        //Go text vao Tai khoan textbox
        txtAccount.sendKeys(account);

        //Step 2: Enter password
        By byTxtPassword = By.name("matKhau");
        WebElement txtPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPassword));
        txtPassword.sendKeys("123456");

        //Step 3: Re-enter password
        By byTxtConfirmPassword = By.xpath("//input[@id='confirmPassWord']");
        WebElement txtConfirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtConfirmPassword));
        txtConfirmPassword.sendKeys("123456");

        //Step 4: Enter full name
        By byTxtFullname = By.id("hoTen");
        WebElement txtFullname = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtFullname));
        txtFullname.sendKeys("John John");

        //Step 5: Enter email
        String email = account + "@example.com";
        By byTxtEmail = By.id("email");
        WebElement txtEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtEmail));
        txtEmail.sendKeys(email);

        //Step 6: Click register
        By byBtnRegister = By.xpath("//button[.='Đăng ký']");
        WebElement btnRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(byBtnRegister));
        btnRegister.click();

        //Step 7: Verify user registers successfully
        //VP1 (Verify Point): Message 'Đăng ký thành công' displays
        By byLblMessage = By.id("swal2-title");
        WebElement lblMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblMessage));
        String recordedText = lblMessage.getText();
        Assert.assertEquals(recordedText, "Đăng ký thành công", "Register message is incorrect !");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byLblMessage));

        //VP2: User login successfully with new account


        //Post-condition: Delete user created above --> call bang API


        //Quit driver: close browser & kill process chromedriver
        chromeDriver.quit();
    }
}
