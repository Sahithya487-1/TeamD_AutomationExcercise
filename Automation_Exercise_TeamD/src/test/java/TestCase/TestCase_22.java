package TestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;

public class TestCase_22 extends BaseConfig{
	@Test

    public void Add_to_cart_from_Recommended_items() throws InterruptedException {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
// 2. Navigate to url
        driver.get("https://www.automationexercise.com/");
        
// 3. Scroll to bottom of page
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("window.scrollBy(0,8500)");
        Thread.sleep(1000); // Adding small wait for scroll to complete
        
// 4. Verify 'RECOMMENDED ITEMS' are visible
        WebElement recommendedHeader = driver.findElement(By.xpath("//h2[text()='recommended items']"));
        if(recommendedHeader.isDisplayed()) {
            System.out.println("Recommended items section is visible");
        }
        
// 5. Click 'Add To Cart' on first recommended product
        WebElement firstRecommendedItem = driver.findElement(
            By.xpath("(//div[@class='recommended_items']//a[text()='Add to cart'])[1]"));
        firstRecommendedItem.click();
        
// 6. Click 'View Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        
// 7. Verify product is in cart
        if(driver.findElement(By.xpath("//table[@id='cart_info_table']")).isDisplayed()) {
            System.out.println("Product successfully added to cart");
        }

    }
}
