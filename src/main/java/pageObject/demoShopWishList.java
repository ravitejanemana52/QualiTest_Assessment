package pageObject;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demoShopWishList extends demoShopHomePage{

    public String minPrice;
    public String actSuccessMsg;

    private final By wishListLink = By.xpath("(//*[@data-tooltip='Wishlist'])[1]");
    private final By wishListHeading = By.xpath("//*[h2='My wishlist']");
    private final By wishListCount = By.xpath("//*[@title='Remove this product']");
    private final By wishListSuccessMsg = By.xpath("//div[@class='woocommerce-message']");



    public demoShopWishList(WebDriver driver) {
        super(driver);
    }

    public void iViewMyWishlistTable() throws InterruptedException {
        driver.findElement(wishListLink).click();
        String assertText = driver.findElement(wishListHeading).getText();
        System.out.println("I View the Items in my WishList");
        Assert.assertEquals("My wishlist", assertText);
    }

    public void iFindTotalFourSelectedItemsInMyWishlist() {
        List<WebElement> numOfItems = driver.findElements(wishListCount);
        int expNum = numOfItems.size();
        Assert.assertEquals(4, expNum);
    }

    public String iSearchForLowestPriceProduct() throws InterruptedException {
        List<String> list = new ArrayList<String>();
        List<String> newList = new ArrayList<String>();

        String regexp = "\\d+\\.\\d+";
        for (int i = 1; i < 5; i++) {
            String items = driver.findElement(By.xpath("(//td[@class='product-price'])[" + i + "]")).getText();
            list.add(items);
        }
        for (String string : list) {
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                newList.add(matcher.group());
            }
        }
        System.out.println("Entire Price list" +newList);
        minPrice = Collections.min(newList);
        return minPrice;
    }

    public void iAmAbleToAddTheLowestPriceItemToMyCart() throws InterruptedException {
        try {
            driver.findElement(By.xpath("//*[contains(text()," + minPrice + ")]/ancestor::td[1]/following-sibling::td[2]/a")).click();Thread.sleep(3000);
            System.out.println("The Item with lowest price i.e " + minPrice + " got added to the cart");
            actSuccessMsg = driver.findElement(wishListSuccessMsg).getText();
        } catch (Exception e) {
            System.out.println("A new page is displayed and hence cannot add the item to the cart");
            driver.quit();
        }
        Assert.assertEquals("Success message text did not match","Product added to cart successfully", actSuccessMsg);
    }
}
