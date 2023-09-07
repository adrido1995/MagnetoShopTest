package pl.testeroprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.testeroprogramowania.models.CustomerData;
import pl.testeroprogramowania.utils.SeleniumHelper;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage {

    @FindBy(xpath = "//input[@name='street[0]']")
            private WebElement streetAddressInput1;
    @FindBy(xpath = "//input[@name='street[1]']")
            private WebElement streetAddressInput2;
    @FindBy(xpath = "//input[@name='city']")
            private WebElement cityNameInput;
    @FindBy(xpath = "//select[@name='region_id']")
            private WebElement stateSelectField;
    @FindBy(xpath = "//input[@name='postcode']")
            private WebElement zipCodeInput;
    @FindBy(xpath = "//select[@name='country_id']")
            private WebElement countrySelectField;
    @FindBy(id = "//input[@name='telephone']")
            private WebElement phoneNumberInput;
    @FindBy(xpath = "//input[@value='flatrate_flatrate']")
            private WebElement flatRateRadioButton;
    @FindBy(xpath = "//button[@data-role='opc-continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//strong[@class='product-item-name']")
    private List<WebElement> productCheckoutList;
    WebDriver driver;
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public ReviewPaymentsPage fillCustomerDetails(CustomerData customerData) {
        streetAddressInput1.sendKeys(customerData.getStreetName());
        streetAddressInput2.sendKeys(customerData.getBuildingNumber());
        cityNameInput.sendKeys(customerData.getCityName());
        Select countrySelect = new Select(countrySelectField);
        countrySelect.selectByVisibleText(customerData.getCountryName());
        Select stateSelect = new Select(stateSelectField);
        stateSelect.selectByVisibleText(customerData.getStateName());
        zipCodeInput.sendKeys(customerData.getZipCode());
        String xpath = String.format("//input[@name='telephone']");
        SeleniumHelper.waitForElementToExist(driver, By.xpath(xpath));
        driver.findElement(By.xpath(xpath)).sendKeys(customerData.getPhoneNumber());
        flatRateRadioButton.click();
        continueButton.click();
        return new ReviewPaymentsPage(driver);
    }
        public List<String> getProductCheckoutNameList() {
        return productCheckoutList.stream()
                .map(el -> el.getAttribute("textContent"))
                .collect(Collectors.toList());
    }



}
