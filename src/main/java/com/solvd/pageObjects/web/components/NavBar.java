package com.solvd.pageObjects.web.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.pageObjects.common.components.NavBarBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavBar extends NavBarBase {
    @FindBy(css = ".vl-flyout-nav__active")
    private ExtendedWebElement homeButton;
    @FindBy(css = ".saved")
    private ExtendedWebElement savedButton;
    @FindBy(css = ".vl-flyout-nav__js-tab.vl-flyout-nav__no-sub")
    private ExtendedWebElement dealsButton;
    @FindBy(xpath = "//*[@class = '.vl-flyout-nav__js-tab']")
    private List<ExtendedWebElement> navBarItems;

    public NavBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void hoverOnHomeButton() {
        homeButton.hover();
    }

    public void hoverOnSavedButton() {
        savedButton.hover();
    }

    public void hoverOnDealsButton() {
        dealsButton.hover();
    }

    public List<ExtendedWebElement> getNavBarItems() {
        return navBarItems;
    }

}
