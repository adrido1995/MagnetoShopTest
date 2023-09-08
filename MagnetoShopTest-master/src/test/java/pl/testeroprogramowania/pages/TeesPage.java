package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeesPage {

    @FindBy(xpath = "//img[@alt='Gobi HeatTec® Tee']")
    private WebElement gobiHeatTecTee;
    private WebDriver driver;

    public TeesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public GobiHeatTecTeePage gobiHeatTecTeeClick() {

        gobiHeatTecTee.click();
        return new GobiHeatTecTeePage(driver);
    }
}
