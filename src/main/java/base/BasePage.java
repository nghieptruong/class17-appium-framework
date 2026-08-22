package base;

import constants.TimeoutConstant;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(TimeoutConstant.LONG_TIMEOUT)), this);
    }

    public WebDriverWait getWebDriverWait() {
        return getWebDriverWait(TimeoutConstant.DEFAULT_TIMEOUT);
    }

    public WebDriverWait getWebDriverWait(long timeOutInSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOutInSec));
    }

    public WebElement waitVisibilityOfElementLocated(By locator, long timeOutInSec) {
        WebDriverWait wait = getWebDriverWait(timeOutInSec);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitVisibilityOfElementLocated(By locator) {
        return waitVisibilityOfElementLocated(locator, TimeoutConstant.DEFAULT_TIMEOUT);
    }

    public WebElement waitElementToBeClickable(By locator, long timeOutInSec) {
        WebDriverWait wait = getWebDriverWait(timeOutInSec);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitElementToBeClickable(WebElement element, long timeOutInSec) {
        WebDriverWait wait = getWebDriverWait(timeOutInSec);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitElementToBeClickable(By locator) {
        return waitElementToBeClickable(locator, TimeoutConstant.DEFAULT_TIMEOUT);
    }

    //============================

    public Boolean waitInvisibilityOfElementLocated(By locator, long timeOutInSec) {
        WebDriverWait wait = getWebDriverWait(timeOutInSec);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public Boolean waitInvisibilityOfElementLocated(By locator) {
        return waitInvisibilityOfElementLocated(locator, TimeoutConstant.DEFAULT_TIMEOUT);
    }

    public void sendKeys(By locator, String value, long timeOut) {
        WebElement element = waitVisibilityOfElementLocated(locator, timeOut);
        element.sendKeys(value);
    }

    public void sendKeys(By locator, String value) {
        sendKeys(locator, value, TimeoutConstant.DEFAULT_TIMEOUT);
    }

    //=========================
    public void click(By locator, long timeOut) {
        WebElement element = waitElementToBeClickable(locator, timeOut);
        element.click();
    }

    public void click(WebElement element, long timeOut) {
        WebElement elementHandle = waitElementToBeClickable(element, timeOut);
        elementHandle.click();
    }

    public void click(By locator) {
        click(locator, TimeoutConstant.DEFAULT_TIMEOUT);
    }

    public void click(WebElement element) {
        click(element, TimeoutConstant.DEFAULT_TIMEOUT);
    }

    public String getText(By locator, long timeOut) {
        WebElement element = waitVisibilityOfElementLocated(locator, timeOut);
        return element.getText();
    }

    public String getText(By locator) {
        return getText(locator, TimeoutConstant.DEFAULT_TIMEOUT);
    }

    public WebElement waitVisibilityOfElement(WebElement element, long timeout) {
        WebDriverWait wait = getWebDriverWait(timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isDisplayed(WebElement element, long timeout) {
        try {
            WebElement elementHandle = waitVisibilityOfElement(element, timeout);
            return elementHandle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
