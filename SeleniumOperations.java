package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gsirp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        
        // Step 2: Use above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();
        
        System.out.println("Driver info: " + driver);
        
        sleep(2);
    
        // Load a webpage in chromium browser.
        driver.get(url);
        
        // Find and populate input fields
        driver.findElement(By.id("firstname")).sendKeys("Girish");
        driver.findElement(By.id("lastname")).sendKeys("Sirpali");
        driver.findElement(By.id("email")).sendKeys("girishsirpali@example.com");
        driver.findElement(By.id("password")).sendKeys("Test@123");
        driver.findElement(By.id("confirmPassword")).sendKeys("Test@123");
        driver.findElement(By.id("phoneNumber")).sendKeys("0412345678");
        
     // Identify button 'Create account' and click to submit using Selenium API.
        WebElement createAccountBtn = driver.findElement(By.xpath("//button[contains(text(),'Create account')]") );
        createAccountBtn.click();
        
        // Take screenshot using selenium API.
        takeScreenshot(driver, "C:\\Users\\gsirp\\Downloads\\officeworks_registration.png");
        
        // Sleep a while
        sleep(2);
        
        // Close chrome driver
        driver.close();    
    }
    
    public static void takeScreenshot(WebDriver driver, String fileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot.toPath(), Paths.get("C:\\Users\\gsirp\\Downloads\\officeworks_registration.png"));
            System.out.println("Screenshot saved: C:\\Users\\gsirp\\Downloads\\officeworks_registration.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
