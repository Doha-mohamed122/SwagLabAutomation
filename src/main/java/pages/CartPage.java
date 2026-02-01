package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    private By cartTitle = By.className("title");
    private By productName = By.className("inventory_item_name");
    private By checkoutButton = By.id("checkout");

    public String getCartTitle(){
        return driver.findElement(cartTitle).getText();
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }
    public CheckoutPage clickCheckout(){
        driver.findElement(checkoutButton).click();
        return new CheckoutPage(driver);
    }
}
