package com.solvd.carina.demo.gui.saucedemo;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LoginPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//input[@id='user-name']")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private ExtendedWebElement passwordField;

    @FindBy(css = ".submit-button")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(loginButton);
        setPageAbsoluteURL(R.CONFIG.get("url"));
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isElementPresent();
    }

    public void typeUsername(String username) {
        usernameField.type(username);
    }

    public void typePassword(String password) {
        passwordField.type(password);
    }

    public ProductsPage clickLoginButton() {
        loginButton.click();
        return new ProductsPage(driver);
    }
}
