package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.models.NewCustomer;
import pl.testeroprogramowania.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {

        NewCustomer newCustomer = new NewCustomer();
        WebElement dashboardMessage = new HomePage(driver)
                .openRegisterPage()
                .fillRegisterDetails(newCustomer)
                .DashboardTextCheck();
        Assert.assertEquals(dashboardMessage.getText(),"My Account");



    }
}
