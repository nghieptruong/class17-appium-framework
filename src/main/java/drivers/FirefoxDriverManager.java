package drivers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {


    @Override
    public void createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.setBrowserVersion("152");
        this.driver = new FirefoxDriver();
    }
}
