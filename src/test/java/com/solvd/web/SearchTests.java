package com.solvd.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.pageObjects.common.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests implements IAbstractTest {
    private final String SEARCH_STRING = R.TESTDATA.get("SEARCH_STRING");
    @Test
    public void mockTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SearchResultsPageBase searchResultsPage = initPage(getDriver(), SearchResultsPageBase.class);
        homePage.open();
        homePage.typeInSearchBar(SEARCH_STRING);
        homePage.clickSearchButton();
        int amountOfProducts = searchResultsPage.getAmountOfProducts();
        Assert.assertTrue(amountOfProducts > 5, "Error: 'Search result page' should display at least 5 products. Actual: " + amountOfProducts);
    }

    @Test
    public void mockTestTheSecond() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SearchResultsPageBase searchResultsPage = initPage(getDriver(), SearchResultsPageBase.class);
        homePage.open();
        homePage.typeInSearchBar(SEARCH_STRING);
        homePage.clickSearchButton();
        int amountOfProducts = searchResultsPage.getAmountOfProducts();
        Assert.assertTrue(amountOfProducts > 5, "Error: 'Search result page' should display at least 5 products. Actual: " + amountOfProducts);
    }

    @Test
    @TestLabel(name = "SR1", value = {"web"})
    public void searchProductByName() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SearchResultsPageBase searchResultsPage = initPage(getDriver(), SearchResultsPageBase.class);
        ProductPageBase productPage = initPage(getDriver(), ProductPageBase.class);
        homePage.open();
        homePage.typeInSearchBar(SEARCH_STRING);
        homePage.clickSearchButton();
        List<ExtendedWebElement> productTitlesList = searchResultsPage.getProductTitlesList();
        //Need to start index in 1 because first product title element is used as a header of the full products list and does not contain any text.
        for (int i = 1; i < productTitlesList.size(); i++) {
            String productTitle = productTitlesList.get(i).getText().toLowerCase();
            Assert.assertTrue(productTitle.contains("iphone"), "Error: product title '" + productTitle + "' does not contain search string: iphone");
        }
        String firstProductTitle = searchResultsPage.getFirstProductTitle();
        searchResultsPage.clickFirstProduct(true);
        Assert.assertTrue(productPage.getProductTitle().contains(firstProductTitle));
    }

    @Test
    @TestLabel(name = "SR2", value = {"web"})
    public void searchProductByCategory() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        CategoryResultPageBase categoryResultPage = initPage(getDriver(), CategoryResultPageBase.class);
        DealsResultPageBase dealsResultPage = initPage(getDriver(), DealsResultPageBase.class);
        ProductPageBase productPage = initPage(getDriver(), ProductPageBase.class);
        homePage.open();
        homePage.clickShopByCategoryButton();
        homePage.clickTechnologyCategoryButton();
        Assert.assertTrue(categoryResultPage.isCategoryResultPageDisplayed(),
                "Error: After selecting a category from the drop down category result page should be displayed");
        categoryResultPage.clickFirstResult();
        String firstProductTitle = dealsResultPage.getFirstProductTitle();
        dealsResultPage.clickFirstProduct();
        Assert.assertTrue(productPage.getProductTitle().contains(firstProductTitle));
    }

    @Test
    @TestLabel(name = "SR3", value = {"web"})
    public void searchProductByTheseWillGetYourAttentionCard() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        CategoryResultPageBase categoryResultPage = initPage(getDriver(), CategoryResultPageBase.class);
        SearchResultsPageBase searchResultsPage = initPage(getDriver(), SearchResultsPageBase.class);
        ProductPageBase productPage = initPage(getDriver(), ProductPageBase.class);
        homePage.open();
        homePage.clickTheseWillGetYourAttentionFifthItem();
        categoryResultPage.clickSeeAllButton();
        String firstProductTitle = searchResultsPage.getFirstProductTitle();
        searchResultsPage.clickFirstProduct(false);
        Assert.assertTrue(productPage.getProductTitle().contains(firstProductTitle));
    }

    @Test
    @TestLabel(name = "SR4", value = {"web"})
    public void searchProductByDailyDealsCard() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        ProductPageBase productPage = initPage(getDriver(), ProductPageBase.class);
        homePage.open();
        homePage.scrollToDailyDealsCard();
        String dailyDealsFirstProductTitle = homePage.getTextFromFirstProductFromDailyDeals();
        homePage.clickFirstProductFromDailyDeals();
        Assert.assertTrue(productPage.getProductTitle().contains(dailyDealsFirstProductTitle));
    }

    @Test
    @TestLabel(name = "SR5", value = {"web"})
    public void searchProductByOurRecommendationsCard() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SearchResultsPageBase searchResultsPage = initPage(getDriver(), SearchResultsPageBase.class);
        ProductPageBase productPage = initPage(getDriver(), ProductPageBase.class);
        homePage.open();
        homePage.scrollToOurRecommendationsCard();
        homePage.clickOurRecommendationsCardFirstItem();
        String firstProductTitle = searchResultsPage.getFirstProductTitle();
        searchResultsPage.clickFirstProduct(true);
        Assert.assertTrue(productPage.getProductTitle().contains(firstProductTitle));
    }
}

