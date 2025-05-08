package TestCase;

import java.time.Duration;

import org.testng.annotations.Test;

import generic_Repository.BaseConfig;
import page_Repository.AutomationExerciseLoginPOM;
import page_Repository.HomePage;

public class Testcase_03 extends BaseConfig{
	@Test
    public static void Login_User_with_incorrect_email_and_password() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");

// 3. Verify home page is visible
        String pageTitle = driver.getTitle();
        if (pageTitle.equals("Automation Exercise")) {
            System.out.println("Home page is visible successfully");
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

// 6. Enter incorrect email and password
        automationLogin.enterLoginEmail("supermanof@gmail.com");
        automationLogin.enterLoginPassword("123456789xyz");
        
// 7. Click 'login' button
        automationLogin.clickLoginButton();

// 8. Verify error 'Your email or password is incorrect!' is visible
        if(automationLogin.isInvalidLoginErrorDisplayed()) {
        	System.out.println("Your email or password is incorrect: as expected");
        }else {
        	System.out.println("Your email or password is correct: which is not expected");
        }
        
// Close browser
    }
}
