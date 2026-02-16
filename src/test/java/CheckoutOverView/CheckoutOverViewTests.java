package CheckoutOverView;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutOverView;
import pages.CheckoutPage;
import pages.ProductsPage;
import static org.testng.Assert.*;
public class CheckoutOverViewTests extends BaseTest {
    @Test
    public void OverViewTests(){
        ProductsPage productsPage =
                loginPage.login("standard_user","secret_sauce");

        productsPage.addProductToCart("Sauce Labs Backpack");
        CartPage cartPage = productsPage.openCart();

        CheckoutPage checkoutPage = cartPage.clickCheckout();
        checkoutPage.setFnameField("Doha");
        checkoutPage.setLnameField("Mohamed");
        checkoutPage.setZipField("12345");

        CheckoutOverView overViewPage = checkoutPage.clickContinueButton();

        assertEquals(overViewPage.getTitle(), "Checkout: Your Information");

    }
}
