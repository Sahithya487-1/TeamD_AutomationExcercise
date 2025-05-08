package TestCase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;

import java.time.Duration;

public class TestCase_21 extends BaseConfig{
	@Test
    public void Add_review_on_product() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");

// 3. Click Products button
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();

// 4. Verify user is navigated to ALL PRODUCTS page successfully
        if (driver.findElement(By.xpath("//h2[contains(text(),'All Products')]")).isDisplayed()) {
            System.out.println("On products page");
        }

// 5. Click on 'View Product' button
        driver.findElement(By.xpath("(//a[text()='View Product'])[1]")).click();

// 6. Verify 'Write Your Review' is visible
        if (driver.findElement(By.xpath("//a[text()='Write Your Review']")).isDisplayed()) {
            System.out.println("Review section available");
        }

// 7. Enter name, email and review
        driver.findElement(By.id("name")).sendKeys("Test User");
        driver.findElement(By.id("email")).sendKeys("testuser" + System.currentTimeMillis() + "@example.com");
        driver.findElement(By.id("review")).sendKeys("Great product quality!");
        
// 8. Click submit button
        driver.findElement(By.id("button-review")).click();

// 8. Verify success message 'Thank you for your review.'
        if (driver.findElement(By.xpath("//span[contains(text(),'Thank you for your review.')]")).isDisplayed()) {
            System.out.println("Review submitted successfully");
        }

// Close browser
    }
}