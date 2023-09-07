package pl.testeroprogramowania.pages;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.utils.SeleniumHelper;

public class HomePage {

    @FindBy(linkText = "Create an Account")
    private WebElement createAccountLink;
    @FindBy(linkText = "Sign In")
    private WebElement signInLink;
    @FindBy(xpath = "//span[contains(text(),'Women')]")
    private WebElement bookmarkWomen;
    @FindBy(xpath = "//span[contains(text(),'Tops')]")
    private WebElement bookmarkTops;
    @FindBy(xpath = "//span[contains(text(),'Jackets')]")
    private WebElement bookmarkJackets;
private WebDriver driver;
public HomePage(WebDriver driver) {

    PageFactory.initElements(driver,this);
    this.driver = driver;
}

public CreateAnAccountPage openRegisterPage(){
    createAccountLink.click();
    return new CreateAnAccountPage(driver);
}
public LogInPage LogIn(){
    signInLink.click();
    return new LogInPage(driver);

}

public JacketsPage selectingABookmark(){
    Actions actions = new Actions(driver);
    WebElement Woman = bookmarkWomen;
    SeleniumHelper.waitForElementToBeVisible(driver,bookmarkWomen);
    actions.moveToElement(Woman).perform();
    WebElement Tops = bookmarkTops;
    SeleniumHelper.waitForElementToBeVisible(driver,bookmarkTops);
    actions.moveToElement(Tops).perform();
    WebElement Jackets = bookmarkJackets;
    SeleniumHelper.waitForElementToBeVisible(driver,bookmarkJackets);
    actions.moveToElement(Jackets).perform();
    SeleniumHelper.waitForElementToClickable(driver,Jackets);
    Jackets.click();
    return new JacketsPage(driver);

}

}
