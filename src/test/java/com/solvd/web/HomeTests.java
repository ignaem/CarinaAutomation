package com.solvd.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.pageObjects.common.HomePageBase;
import com.solvd.pageObjects.common.components.NavBarBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTests implements IAbstractTest {

    @Test
    @TestLabel(name = "HM1", value = {"web"})
    public void validateNavigationBarHover() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        NavBarBase navBar = homePage.getNavBar();
        navBar.hoverOnHomeButton();
        navBar.hoverOnDealsButton();
        navBar.hoverOnSavedButton();
        List<ExtendedWebElement> navBarItems = navBar.getNavBarItems();
        for (ExtendedWebElement navBarItem : navBarItems) {
            navBarItem.hover();
        }
    }
}
