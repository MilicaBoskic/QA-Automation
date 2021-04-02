package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BlicSearchResultsPage extends BaseHelper
{
    @FindBy (className="search__results")
    WebElement results;

    public String titleText;

    WebDriver driver;
    public BlicSearchResultsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnArticle(int artNumber)
    {
        wdWait.until(ExpectedConditions.visibilityOf(results));
        List<WebElement> articles = results.findElements(By.tagName("article"));
        WebElement chosenArticle = articles.get(artNumber-1);
        WebElement chosenArticleTitle = chosenArticle.findElement(By.tagName("h3"));
        titleText = chosenArticleTitle.getText();
        chosenArticleTitle.click();
    }
}