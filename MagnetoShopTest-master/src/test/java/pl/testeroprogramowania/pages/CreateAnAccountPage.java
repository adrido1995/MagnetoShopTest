package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.models.NewCustomer;

public class CreateAnAccountPage {

    @FindBy(id = "firstname")
    private WebElement firstNameInput;
    @FindBy(id = "lastname")
    private WebElement lastNameInput;
    @FindBy(id = "email_address")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "password-confirmation")
    private WebElement passwordConfirmationInput;
    @FindBy(xpath = "//button[@class='action submit primary']")
    private WebElement confirmButton;
    private WebDriver driver;

    public CreateAnAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MyAccountPage fillRegisterDetails(NewCustomer newCustomer) {
        firstNameInput.sendKeys(newCustomer.getFirstName());
        lastNameInput.sendKeys(newCustomer.getLastName());
        emailInput.sendKeys(newCustomer.getEmail());
        passwordInput.sendKeys(newCustomer.getPassword());
        passwordConfirmationInput.sendKeys(newCustomer.getPassword());
        confirmButton.click();
        return new MyAccountPage(driver);

    }
}
