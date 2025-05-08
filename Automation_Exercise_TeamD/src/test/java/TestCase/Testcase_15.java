package TestCase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;

import java.time.Duration;

public class Testcase_15 extends BaseConfig{
	@Test
    public void Place_Order_Register_before_Checkout() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to website");

// 3. Verify that home page is visible successfully
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page verified");
        }

// 4. Click Signup/Login button
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        System.out.println("Clicked Signup/Login");

// 5. Fill all details in Signup and create account
        driver.findElement(By.name("name")).sendKeys("Uttam");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']"))
             .sendKeys("testuser" + System.currentTimeMillis() + "@example.com");
        driver.findElement(By.xpath("//button[text()='Signup']")).click();

        // Account details
        new Select(driver.findElement(By.id("days"))).selectByVisibleText("3");
        new Select(driver.findElement(By.id("months"))).selectByVisibleText("April");
        new Select(driver.findElement(By.id("years"))).selectByVisibleText("2019");
        
        
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("first_name")).sendKeys("Test");
        driver.findElement(By.id("last_name")).sendKeys("User");
        driver.findElement(By.id("address1")).sendKeys("123 Test St");
        new Select(driver.findElement(By.id("country"))).selectByValue("United States");
        driver.findElement(By.id("state")).sendKeys("California");
        driver.findElement(By.id("city")).sendKeys("Los Angeles");
        driver.findElement(By.id("zipcode")).sendKeys("90001");
        driver.findElement(By.id("mobile_number")).sendKeys("1234567890");
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();

// 6.  Verify 'ACCOUNT CREATED!' and click 'Continue' button
        if (driver.findElement(By.xpath("//h2[@data-qa='account-created']")).isDisplayed()) {
            System.out.println("Account created");
        }
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

// 7. Verify ' Logged in as username' at top
        if (driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed()) {
            System.out.println("Logged in verified");
        }

// 8. Add products to cart
        driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        System.out.println("Products added to cart");

// 9. Click Cart button
        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
        System.out.println("Clicked Cart");

// 10.  Verify that cart page is displayed
        if (driver.getTitle().contains("Automation Exercise - Checkout")) {
            System.out.println("Cart page verified");
        }

// 11. Proceed to checkout
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        System.out.println("Proceeded to checkout");

// 12. Verify address and order
        if (driver.findElement(By.id("address_delivery")).isDisplayed() && 
           driver.findElement(By.id("cart_info")).isDisplayed()) {
            System.out.println("Address and order verified");
        }

// 13. Add comment and place order
        driver.findElement(By.name("message")).sendKeys("Test order comment");
        driver.findElement(By.xpath("//a[text()='Place Order']")).click();
        System.out.println("Order placed");

// 14. Enter payment details
        driver.findElement(By.name("name_on_card")).sendKeys("Test Card");
        driver.findElement(By.name("card_number")).sendKeys("4111111111111111");
        driver.findElement(By.name("cvc")).sendKeys("123");
        driver.findElement(By.name("expiry_month")).sendKeys("12");
        driver.findElement(By.name("expiry_year")).sendKeys("2025");
        System.out.println("Payment details entered");

// 15. Pay and confirm
        driver.findElement(By.id("submit")).click();
        System.out.println("Payment submitted");

// 16. Verify success
        if (driver.findElement(By.xpath("//b[text()='Order Placed!']")).isDisplayed()) {
            System.out.println("Order success verified");
        }

// 17. Delete account
        driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();
        System.out.println("Account deletion requested");

// 18. Verify deletion
        if (driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).isDisplayed()) {
            System.out.println("Account deletion verified");
        }
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

// Close browser
        System.out.println("Test completed");
    }
}
