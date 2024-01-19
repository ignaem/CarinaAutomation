package com.solvd.pageObjects.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DealsResultPageBase extends AbstractPage {
    public DealsResultPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getFirstProductTitle();

    public abstract void clickFirstProduct();
}
