package page_Repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPOM {
	@FindBy (id="search_product")
	private WebElement enterProductName;
	
	@FindBy (id="submit_search")
	private WebElement clickProduct;
	
	@FindBy (xpath ="//h2[text()='Searched Products']")
	private WebElement searchProductElement;
	
	@FindBy (xpath="//h2[text()='All Products']")
	private WebElement allProductText;
	
	@FindBy (xpath="(//a[text()='Add to cart'])[1]")
	private WebElement addToCart;
	
	@FindBy (xpath="(//a[text()='View Product'])[1]")
	private WebElement viewProduct;
	
	@FindBy (xpath="(//a[contains(@data-parent,'#accordian')]) [1]")
	private WebElement womenCatagory;
	
	@FindBy (xpath="(//a[text()='Dress '])[1]")
	private WebElement womenDress;
	
	@FindBy (xpath="(//a[text()='Tops '])[1]")
	private WebElement womenTop;
	
	@FindBy (xpath="(//a[contains(@data-parent,'#accordian')]) [2]")
	private WebElement menCatagory;
	
	@FindBy (xpath="//a[text()='Tshirts ']")
	private WebElement menTshirt;
	
	@FindBy (xpath="//a[text()='Jeans ']")
	private WebElement menJeans;
	
	@FindBy (xpath="//h2[text()='Brands']")
	private WebElement brandHeader;
	
	@FindBy (xpath="//a[text()='Polo']")
	private WebElement poloBrand;
	
	@FindBy (xpath="H&M")
	private WebElement hAndM;
	
	@FindBy (xpath="//h2[text()='Subscription']")
	private WebElement subscribeText;
	
	@FindBy (xpath="//input[@type='email']")
	private WebElement emailBoxField;
	
	@FindBy (xpath="//i[@class='fa fa-arrow-circle-o-right']")
	private WebElement emailButton;
	
	@FindBy (xpath="//div[contains(@class,'product-image-wrapper')]")
	private WebElement productImage;
	
	
//...........................	Constructed .....................................
	public ProductsPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySearched() {
		return searchProductElement.isDisplayed();
	}
	
	public void addProductName(String s) {
		enterProductName.sendKeys(s);
	}
	
	public void clickProductButton() {
		clickProduct.click();
	}
	
	public boolean getProductText() {
		return allProductText.isDisplayed();
	}
	
	public void addProductToCart() {
		addToCart.click();
	}
	
	
//	view product in first product
	public void getViewProduct() {
		viewProduct.click();
	}
//	Women catagory
	public void womenCatagory() {
		womenCatagory.click();
	}
	
	public void womenDress() {
		womenDress.click();
	}
	
	public void womenTops() {
		womenTop.click();
	}
	
//	Men catagory
	public void menCatagory() {
		menCatagory.click();
	}
	
	public void menTshirt() {
		menTshirt.click();
	}
	
	public void menJeans() {
		menJeans.click();
	}
	
//	Brand header
	public void brandHeader() {
		brandHeader.isDisplayed();
	}
	
	public void poloBrand() {
		poloBrand.click();
	}
	
	public void hAndMBrand() {
		hAndM.click();
	}
//	Footer
	public void subscribe() {
		subscribeText.isDisplayed();
	}
	
	public void emailField(String s) {
		emailBoxField.sendKeys(s);
	}
	
	public void emailButton() {
		emailButton.click();
	}
	
	public void productImageView() {
		productImage.isDisplayed();
	}
	
}
