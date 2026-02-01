package product;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import static org.testng.Assert.*;

public class AddProductTests extends BaseTest {
    @Test(priority = 2)
    public void addProductToCart(){
        ProductsPage productsPage =
                loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getPageTitle(), "Products");

        productsPage.addProductToCart("Sauce Labs Backpack");
        CartPage cartPage = productsPage.openCart();

        assertTrue(driver.getCurrentUrl().contains("cart"));
    }
    @Test(priority = 1)
    public void numOfProducts(){
        ProductsPage productsPage =
                loginPage.login("standard_user","secret_sauce");
        int actualProductsCount = productsPage.getProductsCount();
        assertEquals( actualProductsCount, 6,
                "Products count is not equal 6 !");
    }

}
