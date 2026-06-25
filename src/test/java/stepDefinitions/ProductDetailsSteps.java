package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ProductDetailsPage;

public class ProductDetailsSteps {


    WebDriver driver;
    ProductDetailsPage productDetailsPage;

    public ProductDetailsSteps() {
        this.driver = Hooks.getDriver();
        this.productDetailsPage = new ProductDetailsPage(driver);
    }


    @When("user get all the product names")
    public void userGetAllTheProductNames() {
        productDetailsPage.ItemList();
    }

}
