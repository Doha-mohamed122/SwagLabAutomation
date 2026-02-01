package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;
    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    private By productsTitle = By.className("title");
    private By cartIcon = By.className("shopping_cart_link");
   // private By addBackpackToCart = By.id("add-to-cart-sauce-labs-backpack");
   private By productsList = By.className("inventory_item");

    public String getPageTitle(){
        return driver.findElement(productsTitle).getText();
    }

    public void addProductToCart(String productName){
        By addButton = By.xpath("//div[text()='"+productName+"']/ancestor::div[@class='inventory_item']//button");
        driver.findElement(addButton).click();
    }
    public int getProductsCount(){
        return driver.findElements(productsList).size();
    }
    public CartPage openCart(){
        driver.findElement(cartIcon).click();
        return new CartPage(driver);
    }


}
