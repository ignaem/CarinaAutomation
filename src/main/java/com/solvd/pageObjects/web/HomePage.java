package com.solvd.pageObjects.web;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.pageObjects.common.HomePageBase;
import com.solvd.pageObjects.web.components.NavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(id = "vl-flyout-nav")
    private NavBar navBar;
    @FindBy(id = "gh-ac")
    private ExtendedWebElement searchBar;
    @FindBy(id = "gh-btn")
    private ExtendedWebElement searchButton;
    @FindBy(id = "gh-shop-a")
    private ExtendedWebElement shopByCategoryButton;
    @FindBy(xpath = "//*[contains(text(),'Tecnología')]")
    private ExtendedWebElement technologyCategoryButton;
    @FindBy(css = ".vl-popular-destinations--evo-v1__name")
    private List<ExtendedWebElement> cardItems;
    @FindBy(xpath = "//*[contains(text(), 'Ofertas de hoy')]")
    private ExtendedWebElement dailyDealsCardTitle;
    @FindBy(css = ".vlp-merch-item-title")
    private ExtendedWebElement dailyDealsProductTitles;
    @FindBy(xpath = "(//*[@class = 'vl-card-header align-end'])[2]")
    private ExtendedWebElement ourRecommendationsCardTitle;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public NavBar getNavBar() {
        return navBar;
    }

    public void typeInSearchBar(String input) {
        searchBar.type(input);
    }

    @Override
    public void tapSearchBar() {
        searchBar.click();
    }

    public void clickSearchBarButton() {
        searchButton.click();
    }

    public void clickShopByCategoryButton() {
        shopByCategoryButton.click();
    }

    public void clickTechnologyCategoryButton() {
        technologyCategoryButton.click();
    }

    public void clickTheseWillGetYourAttentionFifthItem() {
        cardItems.get(4).click();
    }

    public void scrollToDailyDealsCard() {
        dailyDealsCardTitle.scrollTo();
    }

    public void clickFirstProductFromDailyDeals() {
        dailyDealsProductTitles.click();
        //Switch to most recent opened tab
        String currentTab = driver.getWindowHandle();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        tabs.remove(currentTab);
        driver.switchTo().window(tabs.get(0));
    }

    public String getTextFromFirstProductFromDailyDeals() {
        return dailyDealsProductTitles.getText();
    }

    public void scrollToOurRecommendationsCard() {
        ourRecommendationsCardTitle.scrollTo();
    }

    public void clickOurRecommendationsCardFirstItem() {
        cardItems.get(7).click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
