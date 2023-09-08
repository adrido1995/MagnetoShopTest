package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NeveStudioDanceJacketPage {
    @FindBy(id = "option-label-size-143-item-168")
    private WebElement studioDanceJacketSizeM;
    @FindBy(id = "option-label-color-93-item-50")
    private WebElement studioDanceJacketColorBlue;
    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartButton;
    @FindBy(id = "ui-id-5")
    private WebElement bookmarkMen;
    @FindBy(id = "ui-id-17")
    private WebElement bookmarkTops;
    @FindBy(id = "ui-id-21")
    private WebElement bookmarkTees;
    private WebDriver driver;

    public NeveStudioDanceJacketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public TeesPage AddToCartAndMoveToTees() {
        studioDanceJacketSizeM.click();
        studioDanceJacketColorBlue.click();
        addToCartButton.click();
        Actions actions = new Actions(driver);
        WebElement Woman = bookmarkMen;
        actions.moveToElement(Woman).perform();
        WebElement Tops = bookmarkTops;
        actions.moveToElement(Tops).perform();
        WebElement Tees = bookmarkTees;
        actions.moveToElement(Tees).perform();
        Tees.click();
        return new TeesPage(driver);
    }


}
