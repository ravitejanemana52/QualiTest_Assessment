package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.demoShopHomePage;
import pageObject.demoShopMyCart;
import pageObject.demoShopWishList;

public class baseStepDefinition {

	WebDriver driver;
	String minPrice;
	String os = System.getProperty("os.name").toLowerCase();
	String url = "https://testscriptdemo.com/";

	private final By loginPopUp = By.xpath("//*[text()='Accept all']");

	demoShopHomePage obj1;
	demoShopWishList obj2;
	demoShopMyCart obj3;

	@Before
	public void launchBrowser() throws InterruptedException {
		if(os.contains("windows")){
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(os.contains("mac")){
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Browser opened and the URL is launched");
		Thread.sleep(3000);
		driver.findElement(loginPopUp).click();
	}

	@Given("^I add four different products to my wishlist$")
	public void iAddFourDifferentProductsToMyWishlist() throws InterruptedException {
		obj1 = new demoShopHomePage(driver);
		obj1.iAddFourDifferentProductsToMyWishlist();
	}

	@When("^I view my wishlist table$")
	public void iViewMyWishlistTable() throws InterruptedException {
		obj2 = new demoShopWishList(driver);
		obj2.iViewMyWishlistTable();
	}

	@Then("^I find total four selected items in my Wishlist$")
	public void iFindTotalFourSelectedItemsInMyWishlist() {
		obj2.iFindTotalFourSelectedItemsInMyWishlist();
	}

	@When("^I search for lowest price product$")
	public void iSearchForLowestPriceProduct() throws InterruptedException {
		minPrice = obj2.iSearchForLowestPriceProduct();
	}

	@And("^I am able to add the lowest price item to my cart$")
	public void iAmAbleToAddTheLowestPriceItemToMyCart() throws InterruptedException {
		obj2.iAmAbleToAddTheLowestPriceItemToMyCart();
	}

	@Then("^I am able to verify the item in my cart$")
	public void iAmAbleToVerifyTheItemInMyCart() throws InterruptedException {
		obj3 = new demoShopMyCart(driver);
		obj3.iAmAbleToVerifyTheItemInMyCart(minPrice);
	}
	@After
	public void iCloseTheBrowser() throws InterruptedException {
		driver.close();
	}
}