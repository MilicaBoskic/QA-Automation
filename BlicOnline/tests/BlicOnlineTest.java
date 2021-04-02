package tests;

        import org.junit.Assert;
        import org.junit.Test;
        import pages.BlicArticlePage;
        import pages.BlicHomePage;
        import pages.BlicSearchResultsPage;

public class BlicOnlineTest extends BaseTest {

    @Test
    public void checkBlicArticle() throws InterruptedException {

        String searchTerm = "comtrade";

        BlicHomePage homePage = new BlicHomePage(driver);
        homePage.searchingTerm(searchTerm);

        int articleNumber = 3;
        BlicSearchResultsPage results = new BlicSearchResultsPage(driver);
        results.clickOnArticle(articleNumber);
        String clickedArticle = results.titleText;

        BlicArticlePage article = new BlicArticlePage(driver);
        article.articleTitle();
        String articleTitle = article.titleText;

        System.out.println("Clicked article:"+clickedArticle);
        System.out.println("Article title:"+articleTitle);

        Assert.assertEquals("Titles are not equal",clickedArticle,articleTitle);
        Thread.sleep(3000);
    }

}