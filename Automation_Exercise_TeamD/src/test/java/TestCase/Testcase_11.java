package TestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;
import page_Repository.HomePage;

public class Testcase_11 extends BaseConfig{
	@Test
    public void Verify_Subscription_in_Cart_page() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// Initialize Page Objects
        HomePage homePage = new HomePage(driver);

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to website");

// 3. Verify home page is visible
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page is visible");
        }

// 4. Click 'Cart' button - Using HomePage POM
        homePage.clickCartLink();
        System.out.println("Clicked Cart button");

// 5. Scroll down to footer
        WebElement footer = driver.findElement(By.tagName("footer"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", footer);
        System.out.println("Scrolled to footer");

// 6. Verify text 'SUBSCRIPTION' - Using HomePage POM
        if (homePage.isSubscriptionSectionDisplayed()) {
            System.out.println("'SUBSCRIPTION' text is visible");
        }

// 7. Enter email and subscribe - Using HomePage POM
        homePage.enterSubscriptionEmail("demoemail@gmail.com");
        homePage.clickSubscribeButton();
        System.out.println("Entered email and subscribed");

// 8. Verify success message
        WebElement successMsg = driver.findElement(By.id("success-subscribe"));
        if (successMsg.getText().contains("You have been successfully subscribed!")) {
            System.out.println("Success message is visible");
        }

// Close browser
        System.out.println("Test completed");
    }
}