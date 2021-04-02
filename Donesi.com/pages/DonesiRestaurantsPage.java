package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DonesiRestaurantsPage extends BaseHelper {

    public String allStores;
    public String italianStores;

    @FindBy(className="shops-listing-counter")
    WebElement storeNumber;
    @FindBy(id="italijanska-hrana")
    WebElement clickOnItalianStore;


    WebDriver driver;
    public DonesiRestaurantsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void allRestaurants(){
        //sacekati da se skloni prazan string i da se pojavi string pod ovom klasom
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("shops-listing-counter"), ""));
        System.out.println("All restaurants number is:"+storeNumber.getText());
        //smestamo u string
        allStores = storeNumber.getText();
    }
    private void clickOnItalian(){
        js.executeScript("arguments[0].click();",clickOnItalianStore);
    }
    private void italianRestaurants(){
        //sacekati da se skloni prethodni broj od svih restorana
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("shops-listing-counter"),allStores));
        System.out.println("Italian restaurants number is:"+storeNumber.getText());
        //smestamo u string
        italianStores = storeNumber.getText();
    }

    public void compareNumbers(){
        allRestaurants();
        clickOnItalian();
        italianRestaurants();
    }

}