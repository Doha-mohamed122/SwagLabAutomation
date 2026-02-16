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
    private By twitterIcon = By.cssSelector("a[href*='twitter']");
    private By facebookIcon = By.cssSelector("a[href*='facebook']");
    private By linkedinIcon = By.cssSelector("a[href*='linkedin']");


    public boolean isProductsPageDisplayed(){
        return driver.findElement(productsTitle).isDisplayed();
    }

    public String getPageTitle(){
        return driver.findElement(productsTitle).getText();
    }

    public void addProductToCart(String productName){
        By addButton = By.xpath("//div[text()='"+productName+"']/ancestor::div[@class='inventory_item']//button");
        driver.findElement(addButton).click();
    }
    public String getButtonText(String productName){
        By button = By.xpath(
                "//div[text()='"+productName+"']/ancestor::div[@class='inventory_item']//button"
        );
        return driver.findElement(button).getText();
    }

    public int getProductsCount(){
        return driver.findElements(productsList).size();
    }
    public CartPage openCart(){
        driver.findElement(cartIcon).click();
        return new CartPage(driver);
    }
    public void clickTwitter(){
        driver.findElement(twitterIcon).click();
    }

    public void clickFacebook(){
        driver.findElement(facebookIcon).click();
    }

    public void clickLinkedin(){
        driver.findElement(linkedinIcon).click();
    }



}
