package com.solvd.pageObjects.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CategoryResultPageBase extends AbstractPage {
    public CategoryResultPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCategoryResultPageDisplayed();

    public abstract void clickFirstResult();

    public abstract void clickSeeAllButton();
}
