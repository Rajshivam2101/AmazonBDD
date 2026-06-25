package stepDefinitions;


import hooks.Hooks;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.SearchResultsPage;

public class SearchResultsSteps {


    WebDriver driver;
    SearchResultsPage searchResultsPage;

    public SearchResultsSteps() {
        this.driver = Hooks.getDriver();
        searchResultsPage = new SearchResultsPage(driver);
    }


    @And("user searches for the product {string}")
    public void userSearchesForTheProduct(String productName) {
        searchResultsPage.clickSearchButton(productName);

    }


}
