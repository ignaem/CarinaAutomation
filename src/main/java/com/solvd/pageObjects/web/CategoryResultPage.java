package com.solvd.pageObjects.web;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.pageObjects.common.CategoryResultPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CategoryResultPageBase.class)
public class CategoryResultPage extends CategoryResultPageBase {

    @FindBy(css = ".b-visualnav__title")
    List<ExtendedWebElement> resultList;
    @FindBy(css = ".srp-main--isLarge")
    ExtendedWebElement pageMainContainer;
    @FindBy(css = ".b-promobanner__info-btn")
    ExtendedWebElement seeAllButton;

    public CategoryResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickFirstResult() {
        resultList.get(0).click();
    }

    public boolean isCategoryResultPageDisplayed() {
        return pageMainContainer.isElementPresent();
    }

    public void clickSeeAllButton() {
        seeAllButton.click();
    }
}
