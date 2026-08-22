package testcases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.PageManager;
import pages.abstracts.components.NavigationBar;

public class TC01_Login extends BaseTest {

    @Test
    public void verify_login_successfully() {
        NavigationBar navigationBar = PageManager.getNavigationBar(driver);
        navigationBar.navigateLoginPage();
    }
}
