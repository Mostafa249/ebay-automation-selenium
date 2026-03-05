import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;
import utils.JsonReader;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;

@Listeners({AllureTestNg.class})
public class SearchResultsTest extends BaseTest {

    @Test
    @Feature("Search Functionality")
    @Story("Search for Mazda MX-5")
    @Description("Verify that searching for 'Mazda MX-5' returns valid results and filter works")
    public void searchMazdaMX5() {

            String searchTerm = JsonReader.getValue("searchData.json", "searchItem");

            HomePage home = new HomePage(driver);

            Assert.assertTrue(home.isHomePageLoaded(), "Home page did not load correctly");

            home.searchForItem(searchTerm);

            SearchResultsPage resultsPage = new SearchResultsPage(driver);

            int resultsCount = resultsPage.getResultsCount();

            Assert.assertTrue(resultsCount > 0, "No search results found");

            System.out.println("all results count: "+resultsCount);

            Assert.assertTrue(resultsPage.resultsContainKeyword(searchTerm),
                    "Search results do not match the keyword");


            resultsPage.applyManualTransmissionFilter();
        }
    }