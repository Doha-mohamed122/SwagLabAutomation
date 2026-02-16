package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    private By fnameField = By.id("first-name");
    private By lnameField = By.id("last-name");
    private By zipField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");
    private By title = By.className("title");

    public void setFnameField(String fname){
        driver.findElement(fnameField).sendKeys(fname);
    }

    public void setLnameField(String lname){
        driver.findElement(lnameField).sendKeys(lname);
    }

    public void setZipField(String zip){
        driver.findElement(zipField).sendKeys(zip);
    }

    public String getTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return driver.findElement(title).getText();
    }

    public CartPage clickCancelButton(){
        driver.findElement(cancelButton).click();
        return new CartPage(driver);
    }

    public CheckoutOverView clickContinueButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));

        driver.findElement(continueButton).click();
        return new CheckoutOverView(driver);
    }
}
