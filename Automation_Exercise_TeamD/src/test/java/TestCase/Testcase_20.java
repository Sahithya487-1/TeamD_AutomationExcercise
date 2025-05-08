package TestCase;

import org.openqa.selenium.*;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;

import java.time.Duration;
import java.util.List;

public class Testcase_20 extends BaseConfig{
	@Test
    public void Search_Products_and_Verify_Cart_After_Login() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to website");

// 3. Click 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        System.out.println("Clicked Products button");

// 4. Verify user is navigated to ALL PRODUCTS page successfully
        if (driver.findElement(By.xpath("//h2[text()='All Products']")).isDisplayed()) {
            System.out.println("On ALL PRODUCTS page");
        }

// 5. Enter product name in search input and click search button
        String searchTerm = "T-Shirt";
        driver.findElement(By.id("search_product")).sendKeys(searchTerm);
        driver.findElement(By.id("submit_search")).click();
        System.out.println("Searched for: " + searchTerm);

// 6. Verify 'SEARCHED PRODUCTS' is visible
        if (driver.findElement(By.xpath("//h2[text()='Searched Products']")).isDisplayed()) {
            System.out.println("Search results header visible");
        }

// 7.  Verify all the products related to search are visible
        List<WebElement> products = driver.findElements(By.className("productinfo"));
        System.out.println("Found " + products.size() + " products:");
        
        for (WebElement product : products) {
            String productName = product.findElement(By.tagName("p")).getText();
            System.out.println("- " + productName);
            if (!productName.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("Warning: Product doesn't match search term");
            }
        }

// 8. Add those products to cart
        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')]) [1]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')]) [3]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')]) [5]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();

// 9.  Click 'Cart' button and verify that products are visible in cart
        driver.findElement(By.xpath("//a[contains(text(),' Cart')]")).click();
        System.out.println("Clicked Cart button");
        
        List<WebElement> cartItems = driver.findElements(By.xpath("//tbody/tr"));
        if (cartItems.size() == products.size()) {
            System.out.println("All " + cartItems.size() + " products are in cart");
        } else {
            System.out.println("Mismatch: " + products.size() + " searched vs " + cartItems.size() + " in cart");
        }
// 10. Click 'Signup / Login' button and submit login details ------> add a valid login id
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("sfspalalala@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        
// 11. Again, go to Cart page
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        
// 12. Verify that those products are visible in cart after login as well
        List<WebElement> cartItem = driver.findElements(By.xpath("//tbody/tr"));
        if (cartItem.size() == products.size()) {
            System.out.println("All " + cartItem.size() + " products are in cart");
        } else {
            System.out.println("Mismatch: " + products.size() + " searched vs " + cartItem.size() + " in cart");
        }
        
// Close browser
        System.out.println("Test completed");
    }
}