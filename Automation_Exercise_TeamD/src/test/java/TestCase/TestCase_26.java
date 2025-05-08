package TestCase;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;
import page_Repository.HomePage;

public class TestCase_26 extends BaseConfig{
	@Test

    public void Verify_Scroll_Up_without_Arrow_button_and_Scroll_Down_functionality() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
// 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        
// 3. Verify that home page is visible successfully
        if(driver.getCurrentUrl().equals("https://www.automationexercise.com/")) {
            System.out.println("Home page is visible successfully");
        }else {
        	System.out.println("Home page is not visible");
        }
        
// Create Actions class instance
        Actions actions = new Actions(driver);
        
// 4. Scroll down page to bottom using Actions
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).perform();
        
// 5. Verify 'SUBSCRIPTION' is visible
        HomePage hPage = new HomePage(driver);
        
        if(hPage.isSubscriptionSectionDisplayed()) {
            System.out.println("SUBSCRIPTION is visible");
        }else {
        	System.out.println("SUBSCRIPTION is not visible");
        }
        
// 6. Scroll up page to top using Actions
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).keyUp(Keys.CONTROL).perform();
        
// 7. Verify that page is scrolled up and text is visible
        if(hPage.isFeaturedItemsSectionDisplayed()) {
            System.out.println("Page is scrolled up and text is visible");
        }else {
        	System.out.println("Page did not scrolled up");
        }
        
    }
}
