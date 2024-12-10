package com.solvd.carina.demo.gui.saucedemo;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CartPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[text()='Your Cart'][@class='title']")
    private ExtendedWebElement pageTitleLabel;

    @FindBy(xpath = "//div[@class='inventory_item_name'][text()='%s']")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = "//button[@data-test='checkout']")
    private ExtendedWebElement checkOutButton;

    protected CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitleLabel);
    }

    public boolean isProductDisplayed(String productName) {
        LOGGER.info("Will verify if product with title: " + productName + " is displayed");
        return productTitle.format(productName).isElementPresent();
    }

    public CheckOutYourInformationPage clickCheckOutButton() {
        checkOutButton.click();
        return new CheckOutYourInformationPage(driver);
    }
}
