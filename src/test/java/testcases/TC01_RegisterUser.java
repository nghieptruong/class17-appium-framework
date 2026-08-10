package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.modals.CommonModal;
import reports.ExtentReportManager;

import java.util.UUID;

public class TC01_RegisterUser extends BaseTest {

    @Test
    public void verify_register_successfully() {

                //Khoi tao pages
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CommonModal commonModal = new CommonModal(driver);

        // Mo full man hinh
        driver.manage().window().maximize();
        // Mo trang https://demo1.cybersoft.edu.vn/
        driver.get("https://demo1.cybersoft.edu.vn");

        //Pre-condition: User is at Register page
        LOG.info("Pre-condition: User is at Register page");
        ExtentReportManager.info("Pre-condition: User is at Register page");
        homePage.getTopNavigation().navigateToRegisterPage();

        //Step 1: Enter account
        LOG.info("Step 1: Enter account");
        ExtentReportManager.info("Step 1: Enter account");
        //By va WebElement --> tuong ung locator tren trang web html
        //Tim element Tai khoan textbox
        String account = UUID.randomUUID().toString();
        System.out.println(account);

        registerPage.enterAccount(account);

        //Step 2: Enter password
        LOG.info("Step 2: Enter password");
        ExtentReportManager.info("Step 2: Enter password");
        registerPage.enterPassword("123456");

        //Step 3: Re-enter password
        LOG.info("Step 3: Re-enter password");
        ExtentReportManager.info("Step 3: Re-enter password");
        registerPage.confirmPassword("123456");

        //Step 4: Enter full name
        LOG.info("Step 4: Enter full name");
        ExtentReportManager.info("Step 4: Enter full name");
        registerPage.enterFullName("John John");

        //Step 5: Enter email
        LOG.info("Step 5: Enter email");
        ExtentReportManager.info("Step 5: Enter email");
        String email = account + "@example.com";
        registerPage.enterEmail(email);

        //Step 6: Click register
        LOG.info("Step 6: Click register");
        ExtentReportManager.info("Step 6: Click register");
        registerPage.clickRegister();

        //Step 7: Verify user registers successfully
        LOG.info("Step 7: Verify user registers successfully");
        ExtentReportManager.info("Step 7: Verify user registers successfully");
        //VP1 (Verify Point): Message 'Đăng ký thành công' displays
        LOG.info("VP1 (Verify Point): Message 'Đăng ký thành công' displays");
        ExtentReportManager.info("VP1 (Verify Point): Message 'Đăng ký thành công' displays");
        String recordedText = commonModal.getMessageText();
        Assert.assertEquals(recordedText, "Đăng ký thành công", "Register message is incorrect !");
        commonModal.waitModalDisappear();

        //VP2: User login successfully with new account
        LOG.info("VP2: User login successfully with new account");
        ExtentReportManager.info("VP2: User login successfully with new account");
        //Navigate to Login page
        registerPage.getTopNavigation().navigateToLoginPage();

        //Login
        loginPage.login(account, "123456");

        String recordedTextLogin = commonModal.getMessageText();
        Assert.assertEquals(recordedTextLogin, "Đăng nhập thành công", "Login message is incorrect !");
        commonModal.waitModalDisappear();

        //Post-condition: Delete user created above --> call bang API

    }
}
