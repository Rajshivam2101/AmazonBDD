package pages;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

public class SearchResultsPage {

    WebDriver driver;


    public SearchResultsPage(WebDriver driver) {

        this.driver = Hooks.getDriver();
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement enterInputField;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement clickSubmitButton;

    public void clickSearchButton(String product) {

        enterInputField.click();
        enterInputField.sendKeys(product);
        clickSubmitButton.click();
    }
}
