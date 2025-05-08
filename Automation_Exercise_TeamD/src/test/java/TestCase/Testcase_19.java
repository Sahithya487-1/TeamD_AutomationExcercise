package TestCase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;

import java.time.Duration;
import java.util.List;

public class Testcase_19 extends BaseConfig{
	@Test
    public void  View_and_Cart_Brand_Products() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to website");

// 3. Click 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        System.out.println("Clicked Products button");

// 4. Verify that Brands are visible on left side bar
        WebElement brandsSection = driver.findElement(By.xpath("//h2[text()='Brands']"));
        if (brandsSection.isDisplayed()) {
            System.out.println("Brands section is visible");
        }

// 5. Click on any brand name
        driver.findElement(By.xpath("//a[text()='Polo']")).click();
        System.out.println("Clicked Polo brand");

// 6. Verify that user is navigated to brand page and brand products are displayed
        if (driver.getCurrentUrl().contains("https://automationexercise.com/brand_products/Polo")) {
            System.out.println("Navigated to Polo brand page");
        }
 
        if(driver.findElement(By.xpath("//h2[text()='Brand - Polo Products']")).isDisplayed()) {
        	System.out.println("Able to see Polo product");
        }

// 7. On left side bar, click on any other brand link
        driver.findElement(By.xpath("//a[text()='H&M']")).click();
        System.out.println("Clicked H&M brand");

// 8.  Verify that user is navigated to that brand page and can see products
        
        if (driver.getCurrentUrl().contains("https://automationexercise.com/brand_products/H&M")) {
            System.out.println("Navigated to H&M brand page");
        }
        
       if(driver.findElement(By.xpath("//h2[text()='Brand - H&M Products']")).isDisplayed()) {
    	   System.out.println("Able to see H & M product");
       }

 // Close browser
        System.out.println("Test completed");
    }
}
