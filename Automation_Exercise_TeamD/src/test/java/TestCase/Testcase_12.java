package TestCase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;

public class Testcase_12 extends BaseConfig{
	@Test
    public void Add_Products_in_Cart() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Actions actions = new Actions(driver);

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to website");

// 3. Verify home page
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page is visible");
        }

// 4. Click 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        System.out.println("Clicked Products button");

// 5. Hover and add first product
        WebElement product1 = driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[1]"));
        actions.moveToElement(product1).perform();
        driver.findElement(By.xpath("(//a[contains(@class,'add-to-cart')])[1]")).click();
        System.out.println("Added first product");

// 6. Continue shopping
        driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
        System.out.println("Continued shopping");

// 7. Hover and add second product
        WebElement product2 = driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[2]"));
        actions.moveToElement(product2).perform();
        driver.findElement(By.xpath("(//a[text()='Add to cart'])[3]")).click();
        System.out.println("Added second product");

// 8. View cart
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        System.out.println("Viewed cart");

// 9. Verify both products
        List<WebElement> items = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("Products in cart: " + items.size());

// 10. Verify details
        System.out.println("Product Details:");
        for (WebElement item : items) {
            String name = item.findElement(By.xpath(".//td[@class='cart_description']/h4/a")).getText();
            String price = item.findElement(By.xpath(".//td[@class='cart_price']/p")).getText();
            String quantity = item.findElement(By.xpath(".//td[@class='cart_quantity']/button")).getText();
            String total = item.findElement(By.xpath(".//td[@class='cart_total']/p")).getText();

            System.out.println("Name: " + name);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total: " + total);
            System.out.println("-----");
        }

// Close browser
        System.out.println("Test completed");
    }
}

