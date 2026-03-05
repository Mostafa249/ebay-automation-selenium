package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By searchBox = By.id("gh-ac");
    private By searchButton = By.id("gh-search-btn");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Check if home page is loaded")
    public boolean isHomePageLoaded() {
        return driver.getTitle().contains("eBay");
    }

    @Step("Search for item: {item}")
    public void searchForItem(String item) {
        type(searchBox, item);
        click(searchButton);
    }
}