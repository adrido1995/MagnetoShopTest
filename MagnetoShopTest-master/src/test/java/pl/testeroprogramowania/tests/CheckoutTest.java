package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.models.CustomerData;
import pl.testeroprogramowania.models.NewCustomer;
import pl.testeroprogramowania.pages.CartPage;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.MyAccountPage;
import pl.testeroprogramowania.pages.ReviewPaymentsPage;

import java.util.HashMap;
import java.util.List;

public class CheckoutTest extends BaseTest {
    @Test
    public void CheckoutTestWithNewAccount() throws InterruptedException {
        NewCustomer newCustomer = new NewCustomer();
        CustomerData customerData = new CustomerData();

        WebElement dashboardMessage = new HomePage(driver)
                .openRegisterPage()
                .fillRegisterDetails(newCustomer)
                .DashboardTextCheck();

        Assert.assertEquals(dashboardMessage.getText(), "My Account");

        List<String> productsName = new MyAccountPage(driver)
                .selectingABookmark()
                .openProductStudioDanceJacket()
                .AddToCartAndMoveToTees()
                .gobiHeatTecTeeClick()
                .AddProductToCart()
                .getProductCheckoutNameList();

        Assert.assertEquals(productsName.get(0), "Neve Studio Dance Jacket");
        Assert.assertEquals(productsName.get(1), "Gobi HeatTec® Tee");

        WebElement totalPriceCheck = new CartPage(driver)
                .fillCustomerDetails(customerData)
                .getTotalPrice();
        Assert.assertEquals(totalPriceCheck.getText(), "$142.00");
        new ReviewPaymentsPage(driver).orderButtonClick();


    }
}
