package TestCase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;

import java.time.Duration;

public class Testcase_14 extends BaseConfig{
	@Test
    public void Place_Order_Register_while_Checkout() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");

// 3. Verify that home page is visible successfully
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page verified");
        }

// 4. Add products to cart
        driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
//        driver.findElement(By.xpath("(//a[text()='Add to cart'])[2]")).click();

// 5. Click Cart button
        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();

// 6. Verify cart page
        if (driver.getTitle().contains("Automation Exercise - Checkout")) {
            System.out.println("Cart page verified");
        }

// 7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();

// 8. Click 'Register / Login' button
        driver.findElement(By.xpath("//u[text()='Register / Login']")).click();

// 9.  Fill all details in Signup and create account
        driver.findElement(By.name("name")).sendKeys("Test User");
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

// 10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        if (driver.findElement(By.xpath("//h2[@data-qa='account-created']")).isDisplayed()) {
            System.out.println("Account created");
        }
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

// 11. Verify ' Logged in as username' at top
        if (driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed()) {
            System.out.println("Logged in verified");
        }

// 12. Click cart button
        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();

// 13. Click Proceed to checkout button
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();

// 14. Verify Address Details and Review Your Order
        if (driver.findElement(By.id("address_delivery")).isDisplayed() && 
            driver.findElement(By.id("cart_info")).isDisplayed()) {
            System.out.println("Address and order verified");
        }

// 15.  Enter description in comment text area and click 'Place Order'
        driver.findElement(By.name("message")).sendKeys("This is sample message");
        driver.findElement(By.xpath("//a[text()='Place Order']")).click();

// 16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.name("name_on_card")).sendKeys("Visa");
        driver.findElement(By.name("card_number")).sendKeys("4111111111111111");
        driver.findElement(By.name("cvc")).sendKeys("123");
        driver.findElement(By.name("expiry_month")).sendKeys("12");
        driver.findElement(By.name("expiry_year")).sendKeys("2025");

// 17. Click 'Pay and Confirm Order' button
        driver.findElement(By.id("submit")).click();

// 18. Verify success message 'Your order has been placed successfully!'
        if (driver.findElement(By.xpath("//b[text()='Order Placed!']")).isDisplayed()) {
            System.out.println("Order success verified");
        }

// 19. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();

// 20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        if (driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).isDisplayed()) {
            System.out.println("Account deletion verified");
        }else {
        	System.out.println("Account is not deleted");
        }
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

// Close browser
        
    }
}
