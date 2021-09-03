package pageObject;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class demoShopMyCart extends demoShopHomePage{

    private final By myCartLink = By.xpath("//*[@data-tooltip='Cart']");

    public demoShopMyCart(WebDriver driver) {
        super(driver);
    }

    public void iAmAbleToVerifyTheItemInMyCart(String minPrice) throws InterruptedException {
        driver.findElement(myCartLink).click();
        Thread.sleep(2000);
        String expVal = driver.findElement(By.xpath("//td[@class='product-price']")).getText().replace("£", "");
        System.out.println("I Verify that the item with minimum price from WishList got moved to the Cart");
        Assert.assertEquals(expVal, minPrice);
    }
}
