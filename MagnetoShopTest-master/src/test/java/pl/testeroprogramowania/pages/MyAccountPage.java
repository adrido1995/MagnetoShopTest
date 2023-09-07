package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.utils.SeleniumHelper;

public class MyAccountPage {

    @FindBy(xpath = "//span[@data-ui-id]")
    private WebElement DashboardText;
    @FindBy(xpath = "//span[contains(text(),'Women')]")
    private WebElement bookmarkWomen;
    @FindBy(xpath = "//span[contains(text(),'Tops')]")
    private WebElement bookmarkTops;
    @FindBy(xpath = "//span[contains(text(),'Jackets')]")
    private WebElement bookmarkJackets;
    private WebDriver driver;
    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public JacketsPage selectingABookmark() {
        Actions actions = new Actions(driver);
        WebElement Woman = bookmarkWomen;
        SeleniumHelper.waitForElementToBeVisible(driver, bookmarkWomen);
        actions.moveToElement(Woman).perform();
        WebElement Tops = bookmarkTops;
        SeleniumHelper.waitForElementToBeVisible(driver, bookmarkTops);
        actions.moveToElement(Tops).perform();
        WebElement Jackets = bookmarkJackets;
        SeleniumHelper.waitForElementToBeVisible(driver, bookmarkJackets);
        actions.moveToElement(Jackets).perform();
        SeleniumHelper.waitForElementToClickable(driver, Jackets);
        Jackets.click();
        return new JacketsPage(driver);
    }

    public WebElement DashboardTextCheck() {return DashboardText; }
}
