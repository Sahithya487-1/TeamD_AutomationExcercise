package TestCase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;
import page_Repository.HomePage;

public class Testcase_07 extends BaseConfig{
	@Test
    public void Verify_Test_Cases_Page() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to Automation Exercise website");
        
// 3. Verify home page is visible
        String homePageTitle = driver.getTitle();
        if(homePageTitle.equals("Automation Exercise")) {
            System.out.println("Home page is visible successfully");
        } else {
            System.out.println("Home page verification failed");
        }
        
// 4. Click on 'Test Cases' button
        HomePage hPage = new HomePage(driver);
        
        hPage.clickTestcase();
        System.out.println("Clicked on Test Cases button");
        
// 5. Verify navigation to test cases page
        String testCasesPageTitle = driver.getTitle();
        if(testCasesPageTitle.equals("Automation Practice Website for UI Testing - Test Cases")) {
            System.out.println("Successfully navigated to Test Cases page");
        } else {
            System.out.println("Test Cases page verification failed");
        }
        
// Close browser
        System.out.println("Browser closed - Test completed");
    }
}