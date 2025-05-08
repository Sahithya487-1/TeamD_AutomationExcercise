package page_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueTop {
//	We get this page after clicking on view product option
	public BlueTop(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	Blue top product page 
	@FindBy (xpath="//h2[text()='Blue Top']")
	private WebElement blueTop;
	
	public boolean getBlueTop() {
		return blueTop.isDisplayed();
	}
	
//	Category 
	@FindBy (xpath="//p[text()='Category: Women > Tops']")
	private WebElement proCategory;
	
	public boolean getCategory() {
		return proCategory.isDisplayed();
	}
	
//	Price
	@FindBy (xpath="//span[text()='Rs. 500']")
	private WebElement proPrice;
	
	public boolean getPrice() {
		return proPrice.isDisplayed();
	}
	
//	Availability of the product
	@FindBy (xpath="//p[text()=' In Stock']")
	private WebElement proStock;
	
	public boolean getStock() {
		return proStock.isDisplayed();
	}
//	Condition of the product
	@FindBy (xpath="//p[text()=' New']")
	private WebElement proCondition;
	
	public boolean getCondition() {
		return proCondition.isDisplayed();
	}
	
//	Product brand
	@FindBy (xpath="//p[text()=' Polo']")
	private WebElement proBrand;
	
	public boolean getBrand() {
		return proBrand.isDisplayed();
	}
	
//	Quantity modification
	@FindBy (id="quantity")
	private WebElement quantity;
	
	public void getQuantity(String s) {
		quantity.sendKeys(s);
	}
//	Add to cart button
	@FindBy (xpath="(//button[@type='button']) [1]")
	private WebElement addToCart;
	
	public void getAddToCart() {
		addToCart.click();
	}
//	'write your review' section confirmation
	@FindBy (xpath="//a[text()='Write Your Review']")
	private WebElement wyReview;
	
	public void getwyReview() {
		wyReview.isDisplayed();
	}
//	Enter your name is review section
	@FindBy (id="name")
	private WebElement enterName;
	
	public void getEnterName(String s) {
		enterName.sendKeys(s);
	}
//	Enter email in review section
	@FindBy (id="email")
	private WebElement enterEmail;
	
	public void getEnterEmail(String s) {
		enterEmail.sendKeys(s);
	}
//	Add review here
	@FindBy (id="review")
	private WebElement enterReview;
	
	public void getEnterReview(String s) {
		enterReview.sendKeys(s);
	}
//	Click submit button
	@FindBy (id="button-review")
	private WebElement clickSubmitButton;
	
	public void getEnterSubmitButton() {
		clickSubmitButton.click();
	}
//	Subscription text
	@FindBy (xpath = "//h2[text()='Subscription']")
	private WebElement enterSubscription;
	
	public void getEnterSubscrption() {
		enterSubscription.isDisplayed();
	}
//	Enter email id
	@FindBy (id = "susbscribe_email")
	private WebElement enterEmailID;
	
	public void getEnterEmailID() {
		enterEmailID.isDisplayed();
	}
//	Click on subscribe button
	@FindBy (id = "subscribe")
	private WebElement enterSuscribeBut;
	
	public void getEnterSuscribeBut() {
		enterSuscribeBut.isDisplayed();
	}
//	Scroll to top button
	@FindBy (id  = "scrollUp")
	private WebElement enterScrollUp;
	
	public void getScrollUp() {
		enterScrollUp.click();
	}
	
	
}
