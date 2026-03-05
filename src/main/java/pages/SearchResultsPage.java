package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage extends BasePage {

    private By results = By.cssSelector("ul.srp-results li.s-card");
    private By titles = By.cssSelector(".s-card__title .su-styled-text.primary.default");
    private By transmissionManualCheckbox = By.xpath("//li[@name='Transmission']//span[text()='Manual']/ancestor::a");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get total search results")
    public int getResultsCount() {

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(results));

        List<WebElement> cards = driver.findElements(results);

        return cards.size();
    }

    @Step("Validate that search results contain keyword: {keyword}")
    public boolean resultsContainKeyword(String keyword) {

        List<WebElement> titlesList = driver.findElements(titles);

        for (WebElement title : titlesList) {

            String text = title.getText().toLowerCase();

            if (text.isEmpty()) continue;

            if (!text.contains(keyword.toLowerCase())) {
                return false;
            }
        }

        return true;
    }

    @Step("Apply Transmission filter → Manual")
    public void applyManualTransmissionFilter() {

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(transmissionManualCheckbox));

        driver.findElement(transmissionManualCheckbox).click();

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(results));
    }
}