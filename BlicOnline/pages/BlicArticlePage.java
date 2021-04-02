package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlicArticlePage extends BaseHelper {

    @FindBy(className = "article-item")
    WebElement articleItem;

    public String titleText;

    WebDriver driver;

    public BlicArticlePage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void articleTitle()
    {
        wdWait.until(ExpectedConditions.visibilityOf(articleItem));
        WebElement title = articleItem.findElement(By.tagName("h1"));
        titleText =  title.getText();
    }
}