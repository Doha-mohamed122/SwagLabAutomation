package product;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import static org.testng.Assert.*;

public class AddProduct extends BaseTest {
    @Test
    public void addProductToCart(){
        ProductsPage productsPage =
                loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getPageTitle(), "Products");

        productsPage.addProductToCart("Sauce Labs Backpack");
        CartPage cartPage = productsPage.openCart();

        assertTrue(driver.getCurrentUrl().contains("cart"));
    }

}
