package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverView {
    private WebDriver driver;
    public CheckoutOverView(WebDriver driver){
        this.driver = driver;
    }
    private By cancelButton = By.id("cancel");
    private By finishButton = By.id("finish");
    private By title = By.xpath("//span[@class='title']");

    public ProductsPage clickCancelButton(){
        driver.findElement(cancelButton).click();
        return new ProductsPage(driver);
    }
    public CheckoutComplete clickFinishButton(){
        driver.findElement(finishButton).click();
        return new CheckoutComplete(driver);
    }
    public String getTitle(){
        return driver.findElement(title).getText();
    }

}
