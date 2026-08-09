package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.modals.CommonModal;

import java.time.Duration;

public class TC02_Login {

    @Test
    public void Verify_Valid_Login() {
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

        //Khoi tao cho pages
        LoginPage loginPage = new LoginPage(chromeDriver);
        CommonModal commonModal = new CommonModal(chromeDriver);

        //Pre-condition: Click 'Đăng Nhập' link
        By byLnkLogin = By.xpath("//a[h3[text()='Đăng Nhập']]");
        WebElement lnkLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byLnkLogin));
        lnkLogin.click();

        //Step 1: Enter account login
        String account = "8458c3ea-aee8-43e5-bdd8-626af797f013";
        loginPage.enterAccount(account);

        //Step 2: Enter password login
        loginPage.enterPassword("123456");

        //Step 3: Click button login
        loginPage.clickLogin();

        //Step 4: Verify login successfully
        //VP: "Đăng nhập thành công" dialog message displays
        String recordedTextLogin = commonModal.getMessageText();
        Assert.assertEquals(recordedTextLogin, "Đăng nhập thành công", "Login message is incorrect !");
        commonModal.waitModalDisappear();

        //VP2: User profile dislays on the top right
        //VP3: Logout link displays

        //Quit driver: close browser & kill process chromedriver
        chromeDriver.quit();
    }
}
