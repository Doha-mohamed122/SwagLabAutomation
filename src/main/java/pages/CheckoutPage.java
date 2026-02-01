package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }
    private By fnameField = By.id("first-name");
    private By LnameField = By.id("last-name");
    private By zipField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");
    private By title = By.xpath("//span[@class='title']");

    public void setFnameField(String fname){
        driver.findElement(fnameField).sendKeys(fname);
    }
    public void setLnameField(String lname){
        driver.findElement(LnameField).sendKeys(lname);
    }
    public void setZipField(String zip){
        driver.findElement(zipField).sendKeys(zip);
    }
    public String getTitle(){
        return driver.findElement(title).getText();
    }
    public CartPage clickCancelButton(){
        driver.findElement(cancelButton).click();
        return new CartPage(driver);
    }
    public CheckoutOverView clickContinueButton(){
        driver.findElement(continueButton).click();
        return new CheckoutOverView(driver);
    }


}
