package base;

import drivers.DriverManager;
import drivers.DriverManagerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import reports.ExtentReportManager;

import java.lang.reflect.Method;

public class BaseTest {

    protected final Logger LOG = LogManager.getLogger(getClass());

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        LOG.info("beforeSuite executing...");
        ExtentReportManager.initializeExtentReports(); // khoi tao extentreport manager
        LOG.info("beforeSuite ended...");
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        LOG.info("beforeMethod executing...");
        ExtentReportManager.createTest(method.getName());
        DriverManager driverManager = DriverManagerFactory.getDriverManager("chrome");
        driverManager.createWebDriver();
        driver = driverManager.getDriver();
        LOG.info("beforeMethod ended...");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        LOG.info("afterMethod executing...");
        if(result.getStatus() == ITestResult.FAILURE) {
            ExtentReportManager.captureScreenshot(driver, result.getMethod().getMethodName());
            ExtentReportManager.fail(result.getThrowable().toString());
        }
        driver.quit();
        LOG.info("afterMethod ended...");
    }

    @AfterSuite
    public void afterSuite() {
        LOG.info("afterSuite executing...");
        ExtentReportManager.flushReports(); // tong ket report
        LOG.info("afterSuite ended...");
    }
}
