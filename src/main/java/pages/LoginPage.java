package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton   = By.id("login-button");
    private By errorMessage  = By.cssSelector("h3[data-test='error']");

    public void enterUsername(String username){
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public ProductsPage login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new ProductsPage(driver);
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
}
