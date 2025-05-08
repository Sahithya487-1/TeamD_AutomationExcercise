package TestCase;

import java.time.Duration;

import org.testng.annotations.Test;

import generic_Repository.BaseConfig;
import page_Repository.AutomationExerciseLoginPOM;
import page_Repository.DeleteAccountPOM;
import page_Repository.HomePage;

public class Testcase_02 extends BaseConfig{
	@Test
    public void Login_User_with_correct_email_and_password() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
// 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        
// 3. Verify that home page is visible successfully
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page is visible");
        }
        
// 4. Click on 'Signup / Login' button
        HomePage hPage = new HomePage(driver);
        
        hPage.clickSignupLoginLink();
        
// 5. Verify 'Login to your account' is visible
        AutomationExerciseLoginPOM automationLogin = new AutomationExerciseLoginPOM(driver);
        
        if(automationLogin.isLoginSectionDisplayed()) {
        	System.out.println("Login section is visible");
        }else {
        	System.out.println("Login section is not visible");
        }
        
// 6. Enter correct email address and password
        automationLogin.enterLoginEmail("supermanofPunee@gmail.com");
        automationLogin.enterLoginPassword("1234567890");
        
// 7. Click 'login' button
        automationLogin.clickLoginButton();
        
// 8. Verify that 'Logged in as username' is visible
        if(hPage.isLoggedInAsUser()) {
        	System.out.println("'Logged in as username' is visible");
        }else {
        	 System.out.println("'Logged in as username' is not visible");
             driver.quit();
        }
// 9. Click 'Delete Account' button
        hPage.clickOnDeleteAccount();
        
// 10. Verify that 'ACCOUNT DELETED!' is visible
        DeleteAccountPOM deleteAP = new DeleteAccountPOM(driver);
        
        if(deleteAP.verifyAccountDeletion()) {
        	System.out.println("'ACCOUNT DELETED!' is visible");
        } else {
        	System.out.println("'ACCOUNT DELETED!' is not visible");
            driver.quit();
		}
        
// Close browser
    }
}
