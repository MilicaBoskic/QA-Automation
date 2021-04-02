package pages;

import helpers.BaseHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ApCartPage extends BaseHelper
{

    public String price;
    public String total;
    public String sum;

    @FindBy (className = "cart_quantity_input")
    WebElement quantityBox;
    @FindBy (id = "product_price_2_12_0")
    WebElement unitPrice;
    @FindBy (id = "total_product_price_2_12_0")
    WebElement totalPrice;

    WebDriver driver;
    public ApCartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void clickOnAddQuantity() {
        quantityBox.click();
    }

    private void addQuantity(String number) {
//        quantityBox.clear(); ako stavimo ovo ne treba nam gore klik
        quantityBox.sendKeys(number);
    }

    private void printPrice(){
        System.out.println("The price for 1 unit is: "+unitPrice.getText());
        price = unitPrice.getText();
    }

    private void printTotalPrice(){
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("total_product_price_2_12_0"), "$27.00"));
        System.out.println("Total price is: "+totalPrice.getText());
        total = totalPrice.getText();
    }

    public double summary(){
        double priceOfOneUnit = Integer.parseInt(price);
        double priceOfFourUnits = Integer.parseInt(total);
        double sum = priceOfOneUnit * priceOfFourUnits;
        return sum;
//        Assert.assertTrue("Price is incorrect",  );
    }

    public void addingQuantity(String number){
        clickOnAddQuantity();
        addQuantity(number);
        printPrice();
        printTotalPrice();
        summary();
    }
}