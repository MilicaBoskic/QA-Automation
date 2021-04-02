package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class APHomePage extends BaseHelper
{
    @FindBy (className="blockbestsellers")
    WebElement bestSellers;
    @FindBy (id="blockbestsellers")
    WebElement productsHolder;

    WebDriver driver;
    public APHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToAPHomePAge()
    {
        driver.get("http://automationpractice.com/index.php");
    }
    private void clickOnBestSellers()
    {
        bestSellers.click();
    }
    private void clickOnProduct()
    {
        wdWait.until(ExpectedConditions.visibilityOf(productsHolder));
        List<WebElement> products = productsHolder.findElements(By.tagName("li"));
        System.out.println("Bestsellers products found:"+products.size());
        WebElement thirdProduct = products.get(2);
        WebElement moreButton = thirdProduct.findElement(By.className("lnk_view"));
        js.executeScript("arguments[0].click();",moreButton);
    }

    public void chooseBestSellerProduct()
    {
        navigateToAPHomePAge();
        clickOnBestSellers();
        clickOnProduct();
    }

}
