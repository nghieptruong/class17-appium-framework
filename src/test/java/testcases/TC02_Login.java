package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.modals.CommonModal;

public class TC02_Login extends BaseTest {

    @Test(priority = 1)
    public void Verify_Valid_Login() {

        // Mo full man hinh
        driver.manage().window().maximize();
        // Mo trang https://demo1.cybersoft.edu.vn/
        driver.get("https://demo1.cybersoft.edu.vn");

        //Khoi tao cho pages
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CommonModal commonModal = new CommonModal(driver);

        //Pre-condition: Click 'Đăng Nhập' link
        homePage.getTopNavigation().navigateToLoginPage();

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
    }

    @Test(priority = 0)
    public void Verify_Invalid_Login() {

        // Mo full man hinh
        driver.manage().window().maximize();
        // Mo trang https://demo1.cybersoft.edu.vn/
        driver.get("https://demo1.cybersoft.edu.vn");

        //Khoi tao cho pages
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CommonModal commonModal = new CommonModal(driver);

        //Pre-condition: Click 'Đăng Nhập' link
        homePage.getTopNavigation().navigateToLoginPage();

        //Step 1: Enter account login
        String account = "invalid";
        loginPage.enterAccount(account);

        //Verify
    }
}
