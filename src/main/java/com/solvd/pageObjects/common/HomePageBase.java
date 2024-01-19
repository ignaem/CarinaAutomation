package com.solvd.pageObjects.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.pageObjects.common.components.NavBarBase;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract NavBarBase getNavBar();

    public abstract void typeInSearchBar(String searchString);

    public abstract void tapSearchBar();

    public abstract void clickSearchButton();

    public abstract void clickShopByCategoryButton();

    public abstract void clickTechnologyCategoryButton();

    public abstract void clickTheseWillGetYourAttentionFifthItem();

    public abstract void scrollToDailyDealsCard();

    public abstract String getTextFromFirstProductFromDailyDeals();

    public abstract void clickFirstProductFromDailyDeals();

    public abstract void clickOurRecommendationsCardFirstItem();

    public abstract void scrollToOurRecommendationsCard();
}
