package base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Step("Clicking element: {locator}")
    protected void click(By locator) {
        waitForVisibility(locator);
        driver.findElement(locator).click();
    }

    @Step("Typing '{text}' into element: {locator}")
    protected void type(By locator, String text) {
        waitForVisibility(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    @Step("Getting text from element: {locator}")
    protected String getText(By locator) {
        waitForVisibility(locator);
        return driver.findElement(locator).getText();
    }
}
