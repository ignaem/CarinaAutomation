package com.solvd.pageObjects.web;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.pageObjects.common.DealsResultPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = DealsResultPageBase.class)
public class DealsResultPage extends DealsResultPageBase {

    @FindBy(css = ".dne-itemtile")
    private List<ExtendedWebElement> productsList;

    @FindBy(css = ".dne-itemtile-title")
    private List<ExtendedWebElement> productTitles;

    public DealsResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickFirstProduct() {
        productTitles.get(0).click();
    }

    public String getFirstProductTitle() {
        return productTitles.get(0).getText();
    }
}
