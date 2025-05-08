package TestCase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;
import page_Repository.HomePage;
import page_Repository.ProductsPOM;

public class Testcase_09 extends BaseConfig{
	
	@Test
    public void Search_Product() {
    	
// 1. Launch browser
     

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Step 2: Navigated to Automation Exercise website");

// 3. Verify home page is visible
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Step 3: Home page is visible successfully");
        }

// 4. Click on 'Products' button
        HomePage hPage = new HomePage(driver);
        hPage.clickProductsLink();
        
        System.out.println("Step 4: Clicked on Products button");

// 5. Verify navigation to ALL PRODUCTS page
        ProductsPOM pp= new ProductsPOM(driver);
        
        if(pp.getProductText()) {
        	System.out.println("Step 5: Successfully navigated to ALL PRODUCTS page");
        }else {
        	System.out.println("Step 5: Failed to navigated to ALL PRODUCTS page");
        }
        
// 6. Enter product name in search input and click search button
        pp.addProductName("dress");
        pp.clickProductButton();
		
// 7. Verify 'SEARCHED PRODUCTS' is visible
		
        if(pp.verifySearched()) {
        	System.out.println("'SEARCHED PRODUCTS' is visible");
        }else {
        	System.out.println("'SEARCHED PRODUCTS' is not visible");
        }
// 8. Verify all the products related to search are visible
        List<WebElement> products=driver.findElements(By.xpath("//div[@class='productinfo text-center']"));
        boolean allMatch = true;
        
        System.out.println("Step 8: Found " + products.size() + " products:");

        if (allMatch) {
            System.out.println("All products match search term");
        } else {
            System.out.println("Some products don't match search term");
        }
        
//      Close browser  
        

    }
}
