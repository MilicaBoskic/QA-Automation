package tests;

import org.junit.Test;
import pages.APHomePage;
import pages.APProductPage;

public class APTest extends BaseTest
{
    @Test
    public void examTest() throws InterruptedException
    {
        APHomePage homepage = new APHomePage(driver);
        homepage.chooseBestSellerProduct();

        APProductPage product = new APProductPage(driver);
        product.addProductToCart();

        Thread.sleep(3000);
    }
}
