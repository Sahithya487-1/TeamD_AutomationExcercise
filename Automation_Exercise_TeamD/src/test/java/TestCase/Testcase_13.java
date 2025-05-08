package TestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;

public class Testcase_13 extends BaseConfig{
	@Test
    public void Verify_Product_quantity_in_Cart() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to website");

// 3. Verify home page is visible
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page verified");
        }

// 4. Click 'View Product' for first product
        driver.findElement(By.xpath("(//a[text()='View Product'])[1]")).click();
        System.out.println("Clicked View Product");

// 5. Verify product detail page opened
        if (driver.getCurrentUrl().contains("product_details")) {
            System.out.println("Product detail page opened");
        }

// 6. Increase quantity to 4
        WebElement quantityInput = driver.findElement(By.id("quantity"));
        quantityInput.clear();
        quantityInput.sendKeys("4");
        System.out.println("Quantity increased to 4");

// 7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[contains(@class,'cart')]")).click();
        System.out.println("Added to cart");

// 8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        System.out.println("Clicked View Cart");

// 9. Verify product quantity in cart
        WebElement cartQuantity = driver.findElement(By.xpath("//button[contains(@class,'disabled')]"));
        if (cartQuantity.getText().equals("4")) {
            System.out.println("Verified quantity is 4 in cart");
        } else {
            System.out.println("Quantity verification failed");
        }

// Close browser
        System.out.println("Test completed");
    }
}
