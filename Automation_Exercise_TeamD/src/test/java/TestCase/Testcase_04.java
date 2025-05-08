package TestCase;

import java.time.Duration;

import org.testng.annotations.Test;

import generic_Repository.BaseConfig;
import page_Repository.AutomationExerciseLoginPOM;
import page_Repository.HomePage;

public class Testcase_04 extends BaseConfig{
	@Test
    public static void Logout_User() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to Automation Exercise website");
        
// 3. Verify home page is visible
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page is visible successfully");
        } else {
            System.out.println("Home page verification failed");
        }
        
// 4. Click on Signup/Login button
        HomePage hPage = new HomePage(driver);
        
        hPage.clickSignupLoginLink();
// 5. Verify login section is visible
        AutomationExerciseLoginPOM automationLogin = new AutomationExerciseLoginPOM(driver);
        
        if(automationLogin.isLoginSectionDisplayed()) {
        	System.out.println("Login section is visible");
        }else {
        	System.out.println("Login section is not visible");
        }
        
// 6. Enter credentials
        automationLogin.enterLoginEmail(""); //Enter valid credential
        automationLogin.enterLoginPassword("1234567890");
        
        System.out.println("Entered email and password");
        
// 7. Click login button
        automationLogin.clickLoginButton();
// 8. Verify logged in status
        if(hPage.isLoggedInAsUser()) {
        	System.out.println("'Logged in as username' is visible");
        }else {
        	 System.out.println("'Logged in as username' is not visible");
             driver.quit();
        }
        
// 9. Click logout button
        hPage.clickLogoutOption();
        System.out.println("Clicked logout button");
        
// 10. Verify navigation to login page
        if(driver.getCurrentUrl().equals("https://www.automationexercise.com/login")) {
        	System.out.println("Successfully navigated to login page after logout");
        }else {
        	System.out.println("Logout verification failed");
        }
        
// Close browser
       
        System.out.println("Browser closed - Test completed");
    }
}
