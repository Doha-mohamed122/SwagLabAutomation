package cart;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import static org.testng.Assert.*;

public class CartProducts extends BaseTest {
    @Test
    public void verifyProductInCart(){
        ProductsPage productsPage =
                loginPage.login("standard_user","secret_sauce");

        productsPage.addProductToCart("Sauce Labs Backpack");
        CartPage cartPage = productsPage.openCart();

        assertEquals(cartPage.getCartTitle(), "Your Cart");
        assertEquals(cartPage.getProductName(), "Sauce Labs Backpack");
    }

}
