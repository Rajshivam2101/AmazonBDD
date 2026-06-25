package pages;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductDetailsPage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = Hooks.getDriver();
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[@class='a-link-normal s-line-clamp-2 puis-line-clamp-3-for-col-4-and-8 s-link-style a-text-normal']/h2")
    private List<WebElement> itemList;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;


    public void ItemList() {
        for (WebElement itemLists : itemList) {

//            WaitUtil.waitForClickable(driver, itemLists, 10);
//            itemLists.click();

            String itemName = itemLists.getText();
            System.out.println("Item Name: " + itemName);

//            WaitUtil.waitForClickable(driver, addToCartButton, 10);
//            addToCartButton.click();
        }

    }


}
