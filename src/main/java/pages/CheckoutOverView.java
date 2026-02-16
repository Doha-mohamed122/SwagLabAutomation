package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverView {

    private WebDriver driver;

    public CheckoutOverView(WebDriver driver){
        this.driver = driver;
    }

    private By cancelButton = By.id("cancel");
    private By finishButton = By.id("finish");
    private By title = By.className("title");

    public String getTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return driver.findElement(title).getText();
    }

    public ProductsPage clickCancelButton(){
        driver.findElement(cancelButton).click();
        return new ProductsPage(driver);
    }

    public CheckoutComplete clickFinishButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));

        driver.findElement(finishButton).click();
        return new CheckoutComplete(driver);
    }
}
