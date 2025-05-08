package TestCase;

import java.time.Duration;

import org.testng.annotations.Test;

import generic_Repository.BaseConfig;
import page_Repository.AfterSignUpButtonPOM;
import page_Repository.AutomationExerciseLoginPOM;
import page_Repository.DeleteAccountPOM;
import page_Repository.HomePage;

public class Testcase_01 extends BaseConfig {
@Test
	public void Register_User() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String pageTitle = driver.getTitle();
        if(pageTitle.equalsIgnoreCase("Automation Exercise")) {
            System.out.println("Home page is visible successfully");
        } else {
            System.out.println("Home page is not visible");
            return;
        }
        
// 4. Click on 'Signup / Login' button
        HomePage hPage = new HomePage(driver);
        
        hPage.clickSignupLoginLink();
        
// 5. Verify 'New User Signup!' is visible
        AutomationExerciseLoginPOM automationExercise= new AutomationExerciseLoginPOM(driver);
        
        if(automationExercise.isSignupSectionDisplayed()) {
        	 System.out.println("'New User Signup!' is visible");
        } else {
        	System.out.println("'New User Signup!' is not visible");
        	return;
		}
        
// 6. Enter name and email address
        automationExercise.enterSignupName("Saktimaan");
        automationExercise.enterSignupEmail("saaktimaan@gmail.com");
// 7. Click 'Signup' button
        automationExercise.clickSignupButton();
// 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        AfterSignUpButtonPOM asuB = new AfterSignUpButtonPOM(driver);
        
        if(asuB.accountInfoDisplay()) {
        	System.out.println("'Enter Account Information' is visible");
        } else {
        	System.out.println("'Enter Account Information' is not visible");
        	driver.quit();
		}
// 9. Fill details: Title, Name, Email, Password, Date of birth
       // Select Title (Mr)
        asuB.selectTitleMr();
       // Password
        asuB.enterPassword("Test@123");
       // Date of birth
        asuB.selectDay("3");
        asuB.selectMonth("May");
        asuB.selectYear("1999");
      
// 10. Select checkbox 'Sign up for our newsletter!'
        asuB.checkNewsletter();
       
// 11. Select checkbox 'Receive special offers from our partners!'
        asuB.checkSpecialOffers();
       
// 12. Fill address information
        asuB.enterFirstName("Honey");
        asuB.enterLastName("Singh");
        asuB.enterCompany("Demo Company private limited");
        asuB.enterAddress1("123 test street");
        asuB.enterAddress2("Apt 4B Hyd");
       
       // Country
        asuB.selectCountry("India");
       
        asuB.enterState("West bangal");
        asuB.enterCity("Los Angeles");
        asuB.enterZipcode("123456");
        asuB.enterMobileNumber("1234567890");
       
// 13. Click 'Create Account' button
        asuB.clickCreateAccount();
// 14. Verify that 'ACCOUNT CREATED!' is visible
        if(asuB.verifyAccountCreation()) {
        	System.out.println("'ACCOUNT CREATED!' is visible");
        }else {
        	 System.out.println("'ACCOUNT CREATED!' is not visible");
             driver.quit();
        }
// 15. Click 'Continue' button
        asuB.clickContinueButton();
       
// 16. Verify that 'Logged in as username' is visible
        if(hPage.isLoggedInAsUser()) {
        	System.out.println("'Logged in as username' is visible");
        }else {
        	 System.out.println("'Logged in as username' is not visible");
             driver.quit();
        }
       
// 17. Click 'Delete Account' button
        hPage.clickOnDeleteAccount();
// 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        DeleteAccountPOM deleteAP = new DeleteAccountPOM(driver);
        
        if(deleteAP.verifyAccountDeletion()) {
        	System.out.println("'ACCOUNT DELETED!' is visible");
        } else {
        	System.out.println("'ACCOUNT DELETED!' is not visible");
            driver.quit();
		}
       
        // Click Continue button after account deletion
        deleteAP.clickDeleteButton();
        System.out.println("Complete signup and account deletion flow executed successfully");
       
// Close the browser

	}

}
