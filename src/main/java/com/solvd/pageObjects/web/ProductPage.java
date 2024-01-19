package com.solvd.pageObjects.web;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.pageObjects.common.ProductPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {
    @FindBy(css = ".x-item-title__mainTitle")
    private ExtendedWebElement productTitle;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }
}
