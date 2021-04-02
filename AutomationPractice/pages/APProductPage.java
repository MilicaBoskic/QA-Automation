package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class APProductPage extends BaseHelper
{
    @FindBy (id="color_8")
    WebElement whiteColor;
    @FindBy (id="group_1")
    WebElement sizeSelector;
    @FindBy(id="add_to_cart")
    WebElement addToCartButton;

    WebDriver driver;
    public APProductPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void chooseLSize()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("group_1")));
        Select selector = new Select(sizeSelector);
        selector.selectByValue("3");
    }
    private void choseWhiteColor()
    {
        whiteColor.click();
    }
    private void clickOnAddToCartButton()
    {
        addToCartButton.click();
    }
    private void clickOnProceedToCheckoutButton()
    {
        wdWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/h2"),
                "Product successfully added to your shopping cart"));
        WebElement proceedToCheckoutButton = driver.findElement(By.className("button-medium"));
        js.executeScript("arguments[0].click();",proceedToCheckoutButton);
    }

    public void addProductToCart()
    {
        chooseLSize();
        choseWhiteColor();
        clickOnAddToCartButton();
        clickOnProceedToCheckoutButton();
    }

}
