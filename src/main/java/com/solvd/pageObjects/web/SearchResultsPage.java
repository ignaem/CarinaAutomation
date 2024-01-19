package com.solvd.pageObjects.web;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.pageObjects.common.SearchResultsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchResultsPageBase.class)
public class SearchResultsPage extends SearchResultsPageBase {
    @FindBy(css = ".s-item__wrapper")
    private List<ExtendedWebElement> productsList;
    @FindBy(css = ".s-item__title")
    private List<ExtendedWebElement> productTitlesList;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getAmountOfProducts() {
        return productsList.size();
    }

    public void clickFirstProduct(boolean switchToMostRecentOpenedTab) {
        productTitlesList.get(1).click();
        //Switch to most recent opened tab
        if (switchToMostRecentOpenedTab) {
            String currentTab = driver.getWindowHandle();
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            tabs.remove(currentTab);
            driver.switchTo().window(tabs.get(0));
        }
    }

    public String getFirstProductTitle() {
        return productTitlesList.get(1).getText();
    }
    public List<ExtendedWebElement> getProductTitlesList() {
        return productTitlesList;
    }
}
