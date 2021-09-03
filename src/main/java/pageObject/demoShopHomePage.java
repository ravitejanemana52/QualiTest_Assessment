package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class demoShopHomePage {

    WebDriver driver;

    private final By addToWishList = By.xpath("//*[@data-title='Add to wishlist']");

    public demoShopHomePage(WebDriver driver){
        this.driver=driver;
    }

    public void iAddFourDifferentProductsToMyWishlist() throws InterruptedException {
        for (int i = 1; i <= 4; i++) {
            driver.findElement(addToWishList).click();
            Thread.sleep(3000);
        }
        System.out.println("I added four items to my WishList");
    }
}
