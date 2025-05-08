package page_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPagePOM {
//	Proceed to checkout button
	 @FindBy(xpath = "//a[text()='Proceed To Checkout']")
	 private WebElement checkOutButton;
	 
//	 Register/login
	 @FindBy(xpath = "//u[text()='Register / Login']")
	 private WebElement registerAndLogin;
	 
//	 Continue on cart
	 @FindBy(xpath = "//button[text()='Continue On Cart']")
	 private WebElement cocButton;
	 
//	 Your delivery address
	 @FindBy(xpath = "//h3[text()='Your delivery address']")
	 private WebElement yourdeliveryAddress;
	 
//	 Your billing address
	 @FindBy(xpath = "//h3[text()='Your billing address']")
	 private WebElement yourBillingAddress;
	 
//	 
	 @FindBy(xpath = "//textarea[@class='form-control']")
	 private WebElement descriptionArea;
	 
	 @FindBy(xpath = "//a[text()='Place Order']")
	 private WebElement placeOrderButton;

	 public CartPagePOM(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	    
// Methods for interacting with elements
	    
	 public void selectCheckOutButton() {
		 checkOutButton.click();
	 }
	 
	 public void selectRegisterAndLogin() {
		 registerAndLogin.click();
	 }
	 
	 public void selectCOCButton() {
		 cocButton.click();
	 }
	 
	 public boolean verifyDeliveryA() {
		 return yourdeliveryAddress.isDisplayed();
	 }
	 
	 public boolean verifyBillingA() {
		 return yourBillingAddress.isDisplayed();
	 }
	 
	 public void enterDescription(String s) {
		 descriptionArea.sendKeys(s);
	 }
	 
	 public void clickPlaceOrder() {
		 placeOrderButton.click();
	 }

}
