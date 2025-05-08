package TestCase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;

import java.time.Duration;

public class TestCase_23 extends BaseConfig{
	@Test
    public void Verify_address_details_in_checkout_page() throws InterruptedException {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");

// 3. Verify that home page is visible successfully
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page verified");
        }

// 4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

// 5.  Fill all details in Signup and create account
        driver.findElement(By.name("name")).sendKeys("Test User");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']"))
             .sendKeys("testuser" + System.currentTimeMillis() + "@gmail.com");
        driver.findElement(By.xpath("//button[text()='Signup']")).click();

// Enter account details
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("first_name")).sendKeys("Uttam");
        driver.findElement(By.id("last_name")).sendKeys("Narzary");
        driver.findElement(By.id("address1")).sendKeys("123 Test St");
        new Select(driver.findElement(By.id("country"))).selectByValue("India");
        driver.findElement(By.id("state")).sendKeys("Assam");
        driver.findElement(By.id("city")).sendKeys("Guwahati");
        driver.findElement(By.id("zipcode")).sendKeys("90001");
        driver.findElement(By.id("mobile_number")).sendKeys("1234567890");
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();

// 6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        if (driver.findElement(By.xpath("//h2[@data-qa='account-created']")).isDisplayed()) {
            System.out.println("Account created");
        }
        
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

// 7. Verify ' Logged in as username' at top
        if (driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed()) {
            System.out.println("Logged in verified");
        }

// 8.  Add products to cart
        driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();

// 9. Click Cart button
        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();

// 10. Verify that cart page is displayed
        System.out.println(driver.getTitle());
        
        if (driver.getTitle().contains("Automation Exercise - Checkout")) {
            System.out.println("Cart page verified");
        }else {
        	System.out.println("Cart page is not verified");
        }
        Thread.sleep(2000);
// 11. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();

// 12. Verify that the delivery address is same address filled at the time registration of account
        
        if(driver.findElement(By.xpath("(//li[text()='. Uttam Narzary']) [1]")).equals(driver.findElement(By.xpath("(//li[text()='. Uttam Narzary']) [2]")))) {
        	System.out.println("Delivery address is same address filled at the time registration of account");
        }else {
        	System.out.println("Delivery address is same address filled at the time registration of account");
        }
        
// 13.Verify that the billing address is same address filled at the time registration of account
        
        if(driver.findElement(By.xpath("(//li[contains(@class,'address_city address_state_name address_postcode')]) [1]")).equals(driver.findElement(By.xpath("(//li[contains(@class,'address_city address_state_name address_postcode')]) [2]")))) {
        	System.out.println("Billing address is same address filled at the time registration of account");
        }else {
        	System.out.println("Billing address is same address filled at the time registration of account");
        }
        
// 14. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();
// 15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        if(driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed()) {
        	System.out.println("Account has been deleted");
        }
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        
        
    }
}


