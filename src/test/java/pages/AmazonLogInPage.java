package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ActionUtil;
import utils.WaitUtil;

public class AmazonLogInPage {

    WebDriver driver;

    public AmazonLogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='nav-link-accountList']")
    private WebElement accountList;

    @FindBy(xpath = "//div[@id='nav-flyout-ya-signin']//a//span")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@id='ap_email_login']")
    private WebElement usernameInput;

    @FindBy(xpath = "//div//input[@id='ap_password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//span[@class='a-button-inner']//input")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='nav-div']//a[contains(text(),'Amazon Pay')]")
    private WebElement pageTitle;

    public String TitleName() {
        WaitUtil.waitForVisibility(driver, pageTitle, 5);
        String titleName = pageTitle.getText();
        System.out.println("Title: " + titleName);
        return titleName;
    }

    public void LogInPage() {

        WaitUtil.waitForVisibility(driver, accountList, 10);
        ActionUtil.moveToElement(driver, accountList);

        WaitUtil.waitForClickable(driver, signInButton, 10);
        signInButton.click();
    }

    public void enterUserName(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSignInButton() {
//        WaitUtil.waitForVisibility(driver, submitButton, 10);
        submitButton.click();
    }
}
