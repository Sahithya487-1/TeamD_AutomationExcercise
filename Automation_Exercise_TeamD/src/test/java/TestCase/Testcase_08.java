package TestCase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;
import page_Repository.BlueTop;
import page_Repository.HomePage;
import page_Repository.ProductsPOM;

public class Testcase_08 extends BaseConfig{
	@Test
	public void Verify_All_Products_and_product_detail_page() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to Automation Exercise website");

// 3. Verify home page is visible
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page is visible successfully");
        }

// 4. Click on 'Products' button
        HomePage hPage = new HomePage(driver);
        
        hPage.clickProductsLink();
        System.out.println("Clicked on Products button");

// 5. Verify navigation to ALL PRODUCTS page
        ProductsPOM pp= new ProductsPOM(driver);
        
        if(pp.getProductText()) {
        	System.out.println("Successfully navigated to ALL PRODUCTS page");
        }else {
        	System.out.println("navigation to ALL PRODUCTS page fail");
        }
        
// 6. The products list is visible
        List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'product-image-wrapper')]"));
        if (!products.isEmpty()) {
            System.out.println("Products list is visible with " + products.size() + " products");
        }
        
// 7. Click on 'View Product' of first product
        pp.getViewProduct();
        System.out.println("Clicked on first product's View Product button");

// 8. Verify landed on product detail page
        if (driver.getCurrentUrl().contains("https://www.automationexercise.com/product_details/1")) {
            System.out.println("Successfully landed on product detail page");
        }

// 9. Verify product details
        BlueTop blueT = new BlueTop(driver);
        
        if(blueT.getBlueTop()) {
        	System.out.println("Product name is visible");
        } else {
        	System.out.println("Product name is not visible");
        }
        
        if(blueT.getCategory()) {
        	System.out.println("Product category is verified");
        }else {
        	System.out.println("Product category is not verified");
        }
        
        if(blueT.getPrice()) {
        	System.out.println("Product price is correct");
        }else {
        	System.out.println("Product price is not correct");
        }
        
        if(blueT.getStock()) {
        	System.out.println("Product is in stock");
        }else {
        	System.out.println("Product is not in stock");
        }
        
        if(blueT.getCondition()) {
        	System.out.println("Product condition is new");
        }else {
        	System.out.println("Product condition is old");
        }
        
        if(blueT.getBrand()) {
        	System.out.println("Product brand is verified");
        }else {
        	System.out.println("Product brand is not verified");
        }
       
// Close browser
        System.out.println("Test completed successfully");
    }     

}
