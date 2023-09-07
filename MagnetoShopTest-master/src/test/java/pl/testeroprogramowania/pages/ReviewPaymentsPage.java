package pl.testeroprogramowania.pages;

import io.netty.util.concurrent.SucceededFuture;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.utils.SeleniumHelper;

public class ReviewPaymentsPage {

    @FindBy(xpath = "//span[@class='price' and @data-bind='text: getValue()']")
    private WebElement totalPrice;

    @FindBy(xpath = "//span[contains(@data-bind,'Place Order')]")
            private WebElement placeOrderButton;
    WebDriver driver;
    public ReviewPaymentsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public WebElement getTotalPrice() {
        return totalPrice;
    }
    public SuccesPage orderButtonClick() throws InterruptedException {
        Thread.sleep(3000);
        placeOrderButton.click();
        return new SuccesPage(driver);
    }


}
