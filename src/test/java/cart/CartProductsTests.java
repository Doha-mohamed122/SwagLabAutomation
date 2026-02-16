package cart;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import static org.testng.Assert.*;

public class CartProductsTests extends BaseTest {
    @Test
    public void verifyProductInCart(){
        ProductsPage productsPage =
                loginPage.login("standard_user","secret_sauce");

        productsPage.addProductToCart("Sauce Labs Backpack");
        CartPage cartPage = productsPage.openCart();

        assertEquals(cartPage.getCartTitle(), "Your Cart");
        assertEquals(cartPage.getProductName(), "Sauce Labs Backpack");
    }
    @Test
    public void verifyCartIsEmpty(){
        ProductsPage productsPage =
                loginPage.login("standard_user","secret_sauce");

        CartPage cartPage = productsPage.openCart();

        assertEquals(cartPage.getItemsCount(), 0);
    }

    @Test
    public void removeOneProduct(){

        ProductsPage productsPage =
                loginPage.login("standard_user","secret_sauce");

        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addProductToCart("Sauce Labs Onesie");

        CartPage cartPage = productsPage.openCart();

        cartPage.removeProduct("Sauce Labs Bolt T-Shirt");

        driver.navigate().back();

        assertEquals(
                productsPage.getButtonText("Sauce Labs Bolt T-Shirt"),
                "Add to cart"
        );

        assertEquals(
                productsPage.getButtonText("Sauce Labs Backpack"),
                "Remove"
        );

        assertEquals(
                productsPage.getButtonText("Sauce Labs Onesie"),
                "Remove"
        );
    }



}
