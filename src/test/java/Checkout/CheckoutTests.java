package Checkout;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductsPage;

import static org.testng.Assert.*;

public class CheckoutTests extends BaseTest {
    @Test
    public void checkoutTest(){
        ProductsPage productsPage =
                loginPage.login("standard_user","secret_sauce");

        productsPage.addProductToCart("Sauce Labs Backpack");

        CartPage cartPage = productsPage.openCart();

        CheckoutPage checkoutPage = cartPage.clickCheckout();

        checkoutPage.setFnameField("Doha");
        checkoutPage.setLnameField("Mohamed");
        checkoutPage.setZipField("12345");

        assertEquals(checkoutPage.getTitle(), "Checkout: Your Information");



    }

}
