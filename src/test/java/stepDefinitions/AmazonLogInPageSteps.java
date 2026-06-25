package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AmazonLogInPage;
import utils.DriverManager;

public class AmazonLogInPageSteps {

    WebDriver driver;
    AmazonLogInPage amazonLogInPage;

    public AmazonLogInPageSteps() {
        this.driver = Hooks.getDriver();
        this.amazonLogInPage = new AmazonLogInPage(driver);
    }

    @Given("user land to amazon website")
    public void userLandToAmazonWebsite() {
        DriverManager.applicationOpen();
        //Assert.assertEquals("Amazon Pay", amazonLogInPage.TitleName());
        amazonLogInPage.LogInPage();

    }


    @And("user land to amazon login web web site enter username {string}")
    public void userLandToAmazonLoginWebWebSiteEnterUsername(String username) {
        amazonLogInPage.enterUserName(username);
        amazonLogInPage.clickSignInButton();

    }

    @And("user land to amazon login web web site enter password{string}")
    public void userLandToAmazonLoginWebWebSiteEnterPassword(String password) {
        amazonLogInPage.enterPassword(password);
        amazonLogInPage.clickSignInButton();
    }


}
