package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    @FindBy(id = "email")
    private WebElement emailLogInInput;
    @FindBy(id = "pass")
    private WebElement passwordLogInInput;
    @FindBy(id = "send2")
    private WebElement signInButton;
    private WebDriver driver;
    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public HomePage fillLogInDetails(String username, String password){
        emailLogInInput.sendKeys(username);
        passwordLogInInput.sendKeys(password);
        signInButton.click();
        return new HomePage(driver);

    }
}
