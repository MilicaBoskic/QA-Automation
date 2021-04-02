package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlicHomePage extends BaseHelper {

    @FindBy(className = "fa-search")
    WebElement loupe;

    @FindBy(id = "search-field-head")
    WebElement searchBox;

    @FindBy(className ="fa-angle-double-right")
    WebElement button;


    WebDriver driver;

    public BlicHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void navigateToPage(){
        driver.get("https://www.blic.rs/");
    }
    private void loupeField(){
        loupe.click();
    }
    private void searchField(String term){
        WebElement until = wdWait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys(term);
    }
    private void buttonButton(){
        button.click();
    }
    public void searchingTerm(String term){
        navigateToPage();
        loupeField();
        searchField(term);
        buttonButton();
    }
}