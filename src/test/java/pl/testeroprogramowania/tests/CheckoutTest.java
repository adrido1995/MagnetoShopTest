package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.models.CustomerData;
import pl.testeroprogramowania.pages.CartPage;
import pl.testeroprogramowania.pages.HomePage;

import java.util.HashMap;
import java.util.List;

public class CheckoutTest extends BaseTest{
    @Test
    public void CheckoutTest() throws InterruptedException {

        CustomerData customerData = new CustomerData();

        List<String> productsName = new HomePage(driver)
                .LogIn()
                .fillLogInDetails("tester810@test.pl", "p@ssword456")
                .selectingABookmark()
                .openProductStudioDanceJacket()
                .AddToCartAndMoveToTees()
                .gobiHeatTecTeeClick()
                .AddProductToCart()
                .getProductCheckoutNameList();
        Assert.assertEquals(productsName.get(0),"Neve Studio Dance Jacket");
        Assert.assertEquals(productsName.get(1),"Gobi HeatTec® Tee");
            new CartPage(driver).fillCustomerDetails(customerData);

    }
}
