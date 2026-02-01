package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import static org.testng.Assert.*;

public class LoginTests extends BaseTest {
    @Test(priority = 3)
    public void validLogin(){
        ProductsPage productsPage =
                loginPage.login("standard_user", "secret_sauce");

        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
    @Test(priority = 1)
    public void inValidLogin(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("doha", "123");

        assertTrue(loginPage.getErrorMessage()
                        .contains("Username and password do not match"),
                "Error message is not displayed correctly");
    }
    @Test(priority = 2)
    public void LoginEithoutPass(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.clickLogin();

        assertTrue(loginPage.getErrorMessage()
                        .contains("Password is required"),
                "Password required error message not displayed");
    }
}
