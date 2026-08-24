package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageManager;
import pages.abstracts.HomePage;
import pages.abstracts.LoginPage;
import reports.ExtentReportManager;

public class TC01_Login extends BaseTest {

    @Test
    public void verify_login_successfully() {
        HomePage homePage = PageManager.getHomePage(driver);
        LoginPage loginPage = PageManager.getLoginPage(driver);

        //Step 1: Click on menu -> Login
        LOG.info("Step 1: Click on menu -> Login");
        ExtentReportManager.info("Step 1: Click on menu -> Login");
        homePage.getNavigationBar().navigateLoginPage();

        //Step 2: Enter username
        LOG.info("Step 2: Enter username");
        ExtentReportManager.info("Step 2: Enter username");
        loginPage.enterUsername("bod@example.com");

        //Step 3: Enter password
        LOG.info("Step 3: Enter password");
        ExtentReportManager.info("Step 3: Enter password");
        loginPage.enterPassword("10203040");

        //Step 4: Login
        LOG.info("Step 4: Login");
        ExtentReportManager.info("Step 4: Login");
        loginPage.clickLogin();

        //Step 5: Verify login successfully
        LOG.info("Step 5: Verify login successfully");
        ExtentReportManager.info("Step 5: Verify login successfully");
        //VP: Verify Home Page displays
        Assert.assertEquals(homePage.getTitle(), "Products", "Home Page does not display");

        //VP: Logout menu item displays

    }
}
