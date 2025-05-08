package page_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPOM {
	
	@FindBy(xpath = "//b[text()='Account Created!']")
    private WebElement accCreatedText;
	
	@FindBy(xpath = "//a[text()='Continue']")
    private WebElement clickContinueButton;
	
	public AccountCreatedPOM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
        
	public boolean verifyAccountCreation() {
    	return accCreatedText.isDisplayed();
    }
	
	public void clickContinueButton() {
    	clickContinueButton.click();
    }
}
