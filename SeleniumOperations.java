package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gsirp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        try {
            // Set implicit wait (older style)
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            
            driver.get(url);
            
            // WebDriverWait with seconds (older constructor)
            WebDriverWait wait = new WebDriverWait(driver, 15);
            
            // Fill Officeworks form
            fillField(wait, By.id("firstname"), "Girish");
            fillField(wait, By.id("lastname"), "Sirpali");
            fillField(wait, By.id("phoneNumber"), "0412345678");
            fillField(wait, By.id("email"), "girish" + System.currentTimeMillis() + "@example.com");
            fillField(wait, By.id("password"), "Short@12345"); // Invalid password
            fillField(wait, By.id("confirmPassword"), "Short@12345"); // Invalid password
            
            clickElement(wait, By.xpath("//button[contains(text(),'Create account')]"));
            
            takeScreenshot(driver, "officeworks_registration_error.png");
            sleep(3);
        } finally {
            driver.quit();
        }
    }

    public static void registration_page(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gsirp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        try {
            // Set implicit wait (older style)
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            
            driver.get(url);
            
            // WebDriverWait with seconds (older constructor)
            WebDriverWait wait = new WebDriverWait(driver, 15);
            
            // Fill eBay form
            fillField(wait, By.id("firstname"), "Girish");
            fillField(wait, By.id("lastname"), "Sirpali");
            fillField(wait, By.id("Email"), "girish@gmail.com");
            fillField(wait, By.id("password"), "Short@2222"); // Invalid password
            
            clickElement(wait, By.id("EMAIL_REG_FORM_SUBMIT"));
            
            takeScreenshot(driver, "ebay_registration_error.png");
            sleep(3);
        } finally {
            driver.quit();
        }
    }

    // Helper methods
    private static void fillField(WebDriverWait wait, By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(value);
    }

    private static void clickElement(WebDriverWait wait, By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    private static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), 
                      Paths.get("C:\\Users\\gsirp\\Documents\\" + fileName), 
                      StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + fileName);
        } catch (IOException e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
        }
    }
}