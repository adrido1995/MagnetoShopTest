package pl.testeroprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.utils.SeleniumHelper;

public class GobiHeatTecTeePage {
    @FindBy(id = "option-label-size-143-item-167")
    private WebElement gobiHeatTecTeeSizeS;
    @FindBy(id = "option-label-color-93-item-56")
    private WebElement gobiHeatTecTeeColorOrange;

    @FindBy(id = "qty")
    private WebElement gobiHeatTecTeeQty;

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='action showcart']")
    private WebElement cartButton;
    @FindBy(id = "top-cart-btn-checkout")
    private WebElement proceedToCheckoutButton;

    private WebDriver driver;
    public GobiHeatTecTeePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public CartPage AddProductToCart() throws InterruptedException {
        gobiHeatTecTeeSizeS.click();
        gobiHeatTecTeeColorOrange.click();
        gobiHeatTecTeeQty.clear();
        gobiHeatTecTeeQty.sendKeys("2");
        addToCartButton.click();
        Thread.sleep(1000);
        cartButton.click();
        SeleniumHelper.waitForElementToBeVisible(driver,proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        return new CartPage(driver);

    }
}
