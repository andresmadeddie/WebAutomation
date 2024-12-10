package com.solvd.carina.demo.gui.saucedemo;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckOutYourInformationPage extends AbstractPage {

    @FindBy(xpath = "//span[contains(text(),'Checkout: Your Information')]")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private ExtendedWebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//input[@placeholder='Zip/Postal Code']")
    private ExtendedWebElement postalCodeField;

    @FindBy(xpath = "//input[@id='continue']")
    private ExtendedWebElement continueButton;

    protected CheckOutYourInformationPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }

    public void typeFirstName(String firstName) {
        firstNameField.type(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameField.type(lastName);
    }

    public void typeZipcode(String zipCode) {
        postalCodeField.type(zipCode);
    }

    public CheckOutOverViewPage clickContinueButton() {
        continueButton.click();
        return new CheckOutOverViewPage(driver);
    }
}
