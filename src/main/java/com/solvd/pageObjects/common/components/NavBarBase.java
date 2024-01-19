package com.solvd.pageObjects.common.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class NavBarBase extends AbstractUIObject {

    public NavBarBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void hoverOnHomeButton();

    public abstract void hoverOnDealsButton();

    public abstract void hoverOnSavedButton();

    public abstract List<ExtendedWebElement> getNavBarItems();
}
