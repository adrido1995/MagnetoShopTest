package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JacketsPage {

    @FindBy(xpath = "//img[@alt='Neve Studio Dance Jacket']")
    private WebElement neveStudioDanceJacket;
    private WebDriver driver;

    public JacketsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public NeveStudioDanceJacketPage openProductStudioDanceJacket() {
        neveStudioDanceJacket.click();
        return new NeveStudioDanceJacketPage(driver);
    }
}
