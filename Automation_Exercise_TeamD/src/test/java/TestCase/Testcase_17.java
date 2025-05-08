package TestCase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;

import java.time.Duration;
import java.util.List;

public class Testcase_17 extends BaseConfig{
	@Test
    public void Remove_Products_From_Cart() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to website");

// 3. Verify home page is visible
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page is visible");
        }

// 4. Add products to cart
        driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        System.out.println("Added products to cart");

// 5. Click 'Cart' button
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        System.out.println("Clicked Cart button");

// 6. Verify that cart page is displayed
    
        if (driver.getCurrentUrl().contains("https://automationexercise.com/view_cart")) {
            System.out.println("Cart page is displayed");
        }

        
// 7. Click 'X' button corresponding to particular product
            driver.findElement(By.xpath("//i[contains(@class,'fa fa-times')]")).click();
            System.out.println("Clicked delete button for first product");


// 8. Verify that product is removed from the cart
          if(driver.findElement(By.xpath("//b[text()='Cart is empty!']")).isDisplayed()) {
        	  System.out.println("Product is not removed from cart");
          }else {
        	  System.out.println("Product is removed from cart");
          }

// Close browser
        System.out.println("Browser closed");
    }
}
