package com.solvd.carina.demo.gui.saucedemo.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CatalogProductItem extends AbstractUIObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = ".//div[@class='inventory_item_name']")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = ".//button[contains(@id, 'add-to-cart')]")
    private ExtendedWebElement addToCartButton;

    public CatalogProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getProductTitle() {
        return productTitle.getText();
    }
}