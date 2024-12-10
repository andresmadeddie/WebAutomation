package com.solvd.carina.demo.gui.saucedemo;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckOutOverViewPage extends AbstractPage {

    @FindBy(xpath = "//span[contains(text(),'Checkout: Overview')]")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//button[@id='finish']")
    private ExtendedWebElement finishButton;

    protected CheckOutOverViewPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }

    public ThanksForYourOrderPage clickFinishButton() {
        finishButton.click();
        return new ThanksForYourOrderPage(driver);
    }
}
