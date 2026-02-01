package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutComplete {
    private WebDriver driver;
    public CheckoutComplete(WebDriver driver){
        this.driver = driver;
    }
    private By message = By.xpath("//h2[text()='Thank you for your order!']");
    private By backButton = By.id("back-to-products");

    public String getMessage(){
        return  driver.findElement(message).getText();
    }
    public ProductsPage clickBackButton(){
        driver.findElement(backButton);
        return new ProductsPage(driver);
    }
}
