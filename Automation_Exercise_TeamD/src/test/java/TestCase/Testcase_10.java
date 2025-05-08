package TestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;
import page_Repository.HomePage;

public class Testcase_10 extends BaseConfig{
	@Test
    public void Verify_Subscription_in_home_page() {
// Test Data
        String email = "testuser" + System.currentTimeMillis() + "@example.com";
        
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Step 2: Navigated to website");

// 3. Verify that home page is visible successfully
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Step 3: Home page is visible");
        }

        
        HomePage hPage = new HomePage(driver);
// 4. Scroll down to footer
        WebElement footer = driver.findElement(By.tagName("footer"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", footer);
        System.out.println("Step 4: Scrolled to footer");

// 5. Verify text 'SUBSCRIPTION'
        if(hPage.isSubscriptionSectionDisplayed()) {
        	System.out.println("Step 5: 'SUBSCRIPTION' text is visible");
        }else {
        	System.out.println("Step 5: 'SUBSCRIPTION' text is not visible");
        }
        
// 6. Enter email address in input and click arrow button
        hPage.enterSubscriptionEmail(email);
        hPage.clickSubscribeButton();
        
        System.out.println("Step 6: Entered email and clicked subscribe");
        

// 7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement successMessage = driver.findElement(By.id("success-subscribe"));
        if (successMessage.getText().equals("You have been successfully subscribed!")) {
            System.out.println("Step 7: Success message is visible");
        }

// Close browser
        System.out.println("Test completed");
    }
}

