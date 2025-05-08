package TestCase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;
import page_Repository.ContactUsPOM;
import page_Repository.HomePage;

public class Testcase_06 extends BaseConfig{
	@Test
    public void Contact_Us_Form() throws InterruptedException, AWTException {
// 1. Launch browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to website");

// 3. Verify that home page is visible successfully
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page visible");
        }

// 4. Click on 'Contact Us' button
        HomePage hPage = new HomePage(driver);
        
        hPage.clickContactUsLink();
// 5. Verify 'GET IN TOUCH' is visible
        ContactUsPOM cup=new ContactUsPOM(driver);
        
        if(cup.isGetInTouchHeaderVisible()) {
        	System.out.println("Get In Touch visible");
        }else {
        	System.out.println("Get In Touch is not visible");
        }
     
// 6. Enter name, email, subject and message
        cup.enterName("Devil may cry");
        cup.enterEmail("devilmaycry@gmail.com");
        cup.enterSubject("Test Inquiry");
        cup.enterMessage("This is a test message for contact form verification.");
     
// 7. Upload file
        
        StringSelection filePathSelection = new StringSelection("D:\\Uttam's\\Documents\\Steps to download Apache POI.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);  //Copy the path into clipboard then we can use robot class to paste
        
        WebElement fileUp= driver.findElement(By.xpath("//input[@name='upload_file']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", fileUp);
        
        Thread.sleep(3000);
        
        Robot rb= new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        
        Thread.sleep(3000);
        
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        
        
        System.out.println("File uploaded");

// 8. Click Submit button
        cup.clickSubmit();
        System.out.println("Submitted form");

//// 9. Handle alert
        driver.switchTo().alert().accept();
        System.out.println("Accepted alert");

// 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        if(cup.isSuccessMessageDisplayed()) {
        	System.out.println("Success message verified");
        }else {
        	System.out.println("Success message not verified");
		}
// 11. Click 'Home' button and verify that landed to home page successfully
        hPage.clickHomeLink();
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Returned to home page");
        }else {
			System.out.println("Did not return to homepage");
		}

// Close browser
        System.out.println("Test completed");
    }
}
