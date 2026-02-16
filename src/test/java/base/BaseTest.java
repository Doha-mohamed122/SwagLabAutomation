package base;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;


    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    public void switchToNewWindow(String mainWindow){
        for(String window : driver.getWindowHandles()){
            if(!window.equals(mainWindow)){
                driver.switchTo().window(window);
            }
        }
    }


    @AfterMethod
    public void takeScreenshot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()){
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            Files.move(
                    screenshot.toPath(),
                    new File("resources/screenshots/" + result.getName() + ".png").toPath()
            );
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
