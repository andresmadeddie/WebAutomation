package com.solvd.carina.demo.gui.saucedemo;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ThanksForYourOrderPage extends AbstractPage {
    @FindBy(xpath = "//h2[contains(text(),'Thank you for your order!')]")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//button[contains(text(),'Back Home')]")
    private ExtendedWebElement backHomeButton;

    protected ThanksForYourOrderPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }

    public ProductsPage clickBackHomeButton() {
        backHomeButton.click();
        return new ProductsPage(driver);
    }
}
