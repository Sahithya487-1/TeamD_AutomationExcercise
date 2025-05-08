package TestCase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;

import java.time.Duration;

public class Testcase_18 extends BaseConfig{
	@Test
    public void View_Category_Products() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to website");

// 3. Verify that categories are visible on left side bar
        WebElement categories = driver.findElement(By.xpath("//h2[text()='Category']"));
        if (categories.isDisplayed()) {
            System.out.println("Categories section is visible");
        }

// 4. Click 'Women' category
        driver.findElement(By.xpath("//a[contains(@href,'#Women')]")).click();
        System.out.println("Clicked Women category");

// 5. Click 'Dress' subcategory
        driver.findElement(By.xpath("(//a[text()='Dress '])[1]")).click();
        System.out.println("Clicked Dress subcategory");

// 6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        
        if(driver.getCurrentUrl().equals("https://automationexercise.com/category_products/1")) {
        	System.out.println("Category is displayed");
        }else {
        	System.out.println("Catefory is not displayed");
        }
        

// 7. On left side bar, click on any sub-category link of 'Men' category
        driver.findElement(By.xpath("//a[contains(@href,'#Men')]")).click();
        driver.findElement(By.xpath("//a[text()='Tshirts ']")).click();
        System.out.println("Clicked Men's Tshirts subcategory");

// 8. Verify men's category page
        if (driver.findElement(By.xpath("//h2[text()='Men - Tshirts Products']")).isDisplayed()) {
            System.out.println("Men's category page verified");
        }

// Close browser
        System.out.println("Test completed");
    }
}