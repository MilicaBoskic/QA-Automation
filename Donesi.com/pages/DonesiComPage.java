package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DonesiComPage extends BaseHelper {

    @FindBy(className="address-form-component-search-input")
    WebElement addressField;
    @FindBy(className="address-form-component-list-item")
    WebElement dropDownAddress;
    @FindBy(className="btn-lg")
    WebElement orderNowButton;
    @FindBy(className="button-map-submit")
    WebElement continueButton;

    public String allRestaurants;
    public String italianRestaurants;

    WebDriver driver;
    public DonesiComPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void navigateToPage(){
        driver.get("https://www.donesi.com/");
    }
    private void insertDirection(String address){
        addressField.sendKeys(address);
//        addressField.sendKeys("Kneza Mihaila 1, Stari grad Beograd, 11000");
    }
    private void confirmAddress(){
        wdWait.until(ExpectedConditions.visibilityOf(dropDownAddress));
//        List<WebElement> addresses = dropDownAddress.findElements(By.tagName("li"));
//        WebElement address = addresses.get(0);
//        System.out.println("Izabrana adresa je:"+address.getText());
//        address.getText();
        dropDownAddress.click();
    }
    private void orderNowButton(){
        orderNowButton.click();
    }
    private void continueButtonBox(){
        wdWait.until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();
    }
    public void orderPage(String address){
        navigateToPage();
        insertDirection(address);
        confirmAddress();
        orderNowButton();
        continueButtonBox();
    }

}