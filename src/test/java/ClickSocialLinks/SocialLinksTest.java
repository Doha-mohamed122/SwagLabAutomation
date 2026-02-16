package ClickSocialLinks;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ProductsPage;
import static org.testng.Assert.*;

public class SocialLinksTest extends BaseTest {
    @Test
    public void verifySocialLinks(){
        ProductsPage productsPage =
                loginPage.login("standard_user","secret_sauce");

        String mainWindow = driver.getWindowHandle();

        productsPage.clickLinkedin();
        switchToNewWindow(mainWindow);
        assertTrue(driver.getCurrentUrl().contains("linkedin"));
        driver.close();
        driver.switchTo().window(mainWindow);

//        productsPage.clickFacebook();
//        switchToNewWindow(mainWindow);
//        assertTrue(driver.getCurrentUrl().contains("facebook"));
//        driver.close();
//        driver.switchTo().window(mainWindow);
//
//        productsPage.clickTwitter();
//        switchToNewWindow(mainWindow);
//        assertTrue(driver.getCurrentUrl().contains("x.com"));
//        driver.close();
//        driver.switchTo().window(mainWindow);
    }

}
