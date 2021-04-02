package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.DonesiComPage;
import pages.DonesiRestaurantsPage;

public class DonesiComTest extends BaseTest {

    @Test
    public void checkRestaurantsNumber() throws InterruptedException {

        String address = "Kneza Mihaila 1, Stari grad Beograd, 11000";
        DonesiComPage donesiPage = new DonesiComPage(driver);
        donesiPage.orderPage(address);

//        donesiPage.orderPage("Kneza Mihaila 1, Stari grad Beograd, 11000");

        DonesiRestaurantsPage restaurantsPage = new DonesiRestaurantsPage(driver);
        restaurantsPage.compareNumbers();

        int allRestaurants = Integer.parseInt(restaurantsPage.allStores);
        int italianRestaurants = Integer.parseInt(restaurantsPage.italianStores);

        Assert.assertTrue("Message if condition is not fulfilled", italianRestaurants < allRestaurants);

        //ostavljen zbog vizuelne potvrde
        Thread.sleep(3000);
    }
}