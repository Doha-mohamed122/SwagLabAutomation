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
    private By cartItems = By.className("cart_item");

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
    public int getItemsCount(){
        return driver.findElements(cartItems).size();
    }
    public void removeProduct(String productName){
        By removeButton = By.xpath(
                "//div[text()='"+productName+"']/ancestor::div[@class='cart_item']//button"
        );
        driver.findElement(removeButton).click();
    }

}
