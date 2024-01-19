package com.solvd.pageObjects.common;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SearchResultsPageBase extends AbstractPage {
    public SearchResultsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract int getAmountOfProducts();

    public abstract List<ExtendedWebElement> getProductTitlesList();

    public abstract String getFirstProductTitle();

    public abstract void clickFirstProduct(boolean switchToMostRecentTab);
}
