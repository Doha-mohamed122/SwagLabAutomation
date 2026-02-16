package checkOutComplete;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutCompleteTests extends BaseTest {

    @Test
    public void verifyOrderCompletedSuccessfully() {

        ProductsPage productsPage =
                loginPage.login("standard_user", "secret_sauce");

        productsPage.addProductToCart("Sauce Labs Backpack");

        CartPage cartPage = productsPage.openCart();

        CheckoutPage checkoutPage = cartPage.clickCheckout();

        checkoutPage.setFnameField("Doha");
        checkoutPage.setLnameField("Mohamed");
        checkoutPage.setZipField("668787");

        CheckoutOverView overviewPage = checkoutPage.clickContinueButton();

        CheckoutComplete completePage = overviewPage.clickFinishButton();

        assertEquals(
                completePage.getMessage(),
                "Thank you for your order!"
        );

        ProductsPage backToProducts =
                completePage.clickBackButton();

        assertTrue(backToProducts.isProductsPageDisplayed());
    }
}
