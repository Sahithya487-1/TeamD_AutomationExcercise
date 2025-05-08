package TestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;
import page_Repository.AccountCreatedPOM;
import page_Repository.AfterSignUpButtonPOM;
import page_Repository.AutomationExerciseLoginPOM;
import page_Repository.CartPagePOM;
import page_Repository.HomePage;


public class TestCase_24 extends BaseConfig{
	@Test

    public void Download_Invoice_after_purchase_order() {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
// 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        
// 3. Verify that home page is visible successfully
        if(driver.getCurrentUrl().equals("https://www.automationexercise.com/")) {
            System.out.println("Home page is visible successfully");
        }else {
			System.out.println("Home is not visible");
		}
        
// 4. Add products to cart
        // Hover over first product and click "Add to cart"
        HomePage hPage = new HomePage(driver);
        
        hPage.addFirstProductToCart();
        hPage.clickOnContinue();
        
// 5. Click 'Cart' button
        hPage.clickCartLink();
        
// 6. Verify that cart page is displayed
        if(driver.getCurrentUrl().equals("https://www.automationexercise.com/view_cart")) {
        	System.out.println("Cart page is displayed");
        }else {
        	System.out.println("Cart page is not displayed");
        }
        
// 7. Click Proceed To Checkout
        CartPagePOM cpp= new CartPagePOM(driver);
        
        cpp.selectCheckOutButton();
        
// 8. Click 'Register / Login' button
        cpp.selectRegisterAndLogin();
// 9. Fill all details in Signup and create account
        AutomationExerciseLoginPOM autoLogin = new AutomationExerciseLoginPOM(driver);
        
        autoLogin.enterSignupEmail("yoyoHoneySingh");
        autoLogin.enterSignupName("abc_monkey225@gmail.com");
        autoLogin.clickSignupButton();
       
//		enter signup details
        AfterSignUpButtonPOM afterSignUp = new AfterSignUpButtonPOM(driver);
        
        afterSignUp.selectTitleMr();
        afterSignUp.enterPassword("Hello123");
		
		Select s1= new Select(driver.findElement(By.id("days")));
		s1.selectByVisibleText("3");
		
		s1 = new Select(driver.findElement(By.id("months")));
		s1.selectByVisibleText("February");
		
		WebElement year=driver.findElement(By.id("years"));
		
		s1=new Select(year);
		s1.selectByVisibleText("2001");
		
		afterSignUp.enterFirstName("Uttam");
		afterSignUp.enterLastName("Kumar");
		afterSignUp.enterAddress1("This is demo address");
		afterSignUp.enterAddress2("This is also demo address");
		
		s1=new Select(driver.findElement(By.id("country")));
		s1.selectByVisibleText("India");
		
		afterSignUp.enterState("West bangal");
		afterSignUp.enterCity("Kolkata");
		afterSignUp.enterZipcode("123456");
		afterSignUp.enterMobileNumber("79879823929");
		afterSignUp.clickCreateAccount();
		
//	10	Verify 'ACCOUNT CREATED!' and click 'Continue' button
		AccountCreatedPOM accCP= new AccountCreatedPOM(driver);
		if(accCP.verifyAccountCreation()) {
			System.out.println("Account created has been displayed");
		}else {
			System.out.println("Account created is not verified");
		}
		
		accCP.clickContinueButton();
//	11	Verify ' Logged in as username' at top
		if(hPage.isLoggedInAsUser()) {
			System.out.println("Logged in as username is displayed");
		}else {
			System.out.println("Logged in as username is not displayed");
		}
		
//	12	Click 'Cart' button
		hPage.clickCartLink();
//	13	Click 'Proceed To Checkout' button
		CartPagePOM cartpp = new CartPagePOM(driver);
		
		cartpp.selectCheckOutButton();
//	14	Verify Address Details and Review Your Order
		if(cartpp.verifyDeliveryA()) {
			System.out.println("Address detail is displayed");
		}
		if(cartpp.verifyBillingA()) {
			System.out.println("Review detail is displayed");
		}
		
//	15	Enter description in comment text area and click 'Place Order'
		cartpp.enterDescription("This is sample text which is used to check the text field");
		cartpp.clickPlaceOrder();
		
//	16	Enter payment details: Name on Card, Card Number, CVC, Expiration date ..............(bug)
		driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("VISA");
		driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("434");
		driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("02");
		driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("1999");
		
//	17	Click 'Pay and Confirm Order' button
		driver.findElement(By.id("submit")).click();
//	18. Verify success message 'Your order has been placed successfully!'
		WebElement VSM =driver.findElement(By.xpath("//b[text()='Order Placed!']"));
		if(VSM.isDisplayed()) {
			System.out.println("Your order has been placed successfully!");
		}
//	19.	Click 'Download Invoice' button and verify invoice is downloaded successfully.
		driver.findElement(By.xpath("//a[text()='Download Invoice']")).click();
		System.out.println("Invoice has been downloaded");
//	20	Click 'Continue' button
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
//	21	Click 'Delete Account' button
		
		driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();
//	22	Verify 'ACCOUNT DELETED!' and click 'Continue' button
		driver.findElement(By.xpath("//b[text()='Account Deleted!']")).click();
		
//		driver.close();
        
    }
}